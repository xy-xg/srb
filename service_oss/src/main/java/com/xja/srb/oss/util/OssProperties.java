package com.xja.srb.oss.util;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OssProperties implements InitializingBean {

    @Value("${aliyun.oss.endpoint}")
    private String endpoint;

    @Value("${aliyun.oss.accessKeyId}")
    private String accessKeyId;

    @Value("${aliyun.oss.secret}")
    private String secret;


    @Value("${aliyun.oss.bucketName}")
    private String bucketName;

    public static String ENDPOINT;
    public static String ACCESS_KEY_ID;
    public static String SECRECT;

    public static String BUCKET_NAME;
    @Override
    public void afterPropertiesSet() throws Exception {
        ENDPOINT=endpoint;
        ACCESS_KEY_ID=accessKeyId;
        SECRECT=secret;
        BUCKET_NAME=bucketName;
    }
}
