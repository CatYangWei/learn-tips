package com.yang.learn.mq.pojo;

import lombok.Data;

/**
 * @author coffezcat
 * @title: Message
 * @description: TODO
 * @date 2019/8/13 15:50
 */
@Data
public class Message {
    //活动编号
    String activityCode;
    //策略ID
    String policyId;
    //手机号码
    String msisdn;
    //手机imsi
    String imsi;
    //手机终端imei
    String imei;
    //小区LocationCode
    String lac;
    //小区Cell Identity
    String callId;
    //Service Area Code
    String sac;
    //网络接入类型
    String rat;
    //接入点
    String apn;
    //手机终端IP地址
    String ueIp;
    //日期
    String date;
    //备注
    String memo;
}
