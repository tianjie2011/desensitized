package com.example.desensitized.entity;

import com.example.desensitized.annotation.Desensitized;
import com.example.desensitized.enums.SensitiveTypeEnum;
import lombok.Data;

@Data
public class Custermor {
//    @Label("姓名")
//    String name;
//    @Label("出生日期")
//    @DateTimeFormat
//    Date born;
//    @Label("分数")
//    double score;
//    @BooleanFormat(trueTag = {"YES", "OK", "是", "不是"})
//    private boolean exists;
//    @TimestampFormat
//    private Timestamp startTime;

    @Desensitized(type = SensitiveTypeEnum.CHINESE_NAME)
    private String chinaName;
    @Desensitized(type = SensitiveTypeEnum.MOBILE_PHONE)
    private String moble_phone;
    @Desensitized(type = SensitiveTypeEnum.CARNUMBER)
    private String carNumber;
}
