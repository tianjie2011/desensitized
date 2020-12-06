package com.example.desensitized.annotation;

import com.example.desensitized.enums.SensitiveTypeEnum;

import java.lang.annotation.*;

/**
 * 自定义脱敏规则
 */

@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Desensitized {

    SensitiveTypeEnum type();
}
