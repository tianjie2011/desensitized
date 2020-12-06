package com.example.desensitized.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.example.desensitized.annotation.Desensitized;
import com.example.desensitized.annotation.DesensitizedAnnotationFormatterFactory;
import com.example.desensitized.filter.ValueDesensitizeFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Slf4j
public class WebConfigurer implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        log.info("启用自定义注解！！！");
      registry.addFormatterForFieldAnnotation(new DesensitizedAnnotationFormatterFactory());

    }

    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters(){
        // 1. 定义一个converters 转换消息的对象
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();

        //2.1 添加fastjson 的配置信息，比如： 是否需要格式化返回的json
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        //2.2. 添加自己写的拦截器
        fastJsonConfig.setSerializeFilters(new ValueDesensitizeFilter());

        //3. 在converter中添加配置信息
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);

        //4. 将converter 赋值给HttpMessageConverter
        HttpMessageConverter<?> converter = fastJsonHttpMessageConverter;
        //5. 返回HttpMessageConverters
        return new HttpMessageConverters(converter);


    }
}
