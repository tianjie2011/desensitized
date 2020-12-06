package com.example.desensitized.controller;

import com.example.desensitized.entity.Custermor;
import com.example.desensitized.service.CallRecordService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("hello")
@Slf4j
public class HelloController {

    @Autowired
    private CallRecordService callRecordService;


    @ApiOperation(value = "测试自定义注解")
    @PostMapping(value = {"index"})
    public Custermor test(Custermor custermor){
        log.info("custermor info");

        return custermor;
    }


//    @ApiOperation(value = "测试自定义注解数据库返回信息")
//    @PostMapping(value = {"ceshi"})
//    public List<Custermor> test2(Custermor custermor) {
//        List<Custermor> callRecordReportList = callRecordService.allCustermor(custermor);
//        return callRecordReportList;
//    }

}
