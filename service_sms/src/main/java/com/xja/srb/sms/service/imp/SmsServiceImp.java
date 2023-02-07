package com.xja.srb.sms.service.imp;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;
import com.xja.common.exception.Assert;
import com.xja.common.exception.BusinessException;
import com.xja.common.result.ResponseEnum;
import com.xja.srb.sms.service.SmsService;
import com.xja.srb.sms.utils.SmsProperties;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author xiaoYan
 * @Data 2023/1/6 19:56
 * 时间不早了  注意休息
 */
@Service
public class SmsServiceImp implements SmsService {
    @Override
    public void send(String mobile, String templateCode, Map<String, Object> param) {
        //整合阿里云短信服务
        //设置相关参数
        DefaultProfile profile = DefaultProfile.
                getProfile(SmsProperties.REGION_Id,
                        SmsProperties.ACCESS_KEY_ID,
                        SmsProperties.SECRECT);
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");

        request.putQueryParameter("RegionId", SmsProperties.REGION_Id);
        //手机号
        request.putQueryParameter("PhoneNumbers", mobile);
        //签名名字
        request.putQueryParameter("SignName", SmsProperties.SIGN_NAME);
        //模板code
        request.putQueryParameter("TemplateCode", SmsProperties.TEMPLATE_CODE);

        Gson gson = new Gson();
        String json = gson.toJson(param);
        request.putQueryParameter("TemplateParam", json);

        //使用客户端对象携带请求对象发送请求并得到响应结果
        CommonResponse response = null;
        try {
            response = client.getCommonResponse(request);
            boolean success = response.getHttpResponse().isSuccess();
            //ALIYUN_RESPONSE_FAIL(-501, "阿里云响应失败"),
            Assert.isTrue(success, ResponseEnum.ALIYUN_RESPONSE_FAIL);

            String data = response.getData();
            HashMap<String, String> resultMap = gson.fromJson(data, HashMap.class);
            String code = resultMap.get("Code");
            String message = resultMap.get("Message");

            //ALIYUN_SMS_LIMIT_CONTROL_ERROR(-502, "短信发送过于频繁"),//业务限流
            Assert.notEquals("isv.BUSINESS_LIMIT_CONTROL", code, ResponseEnum.ALIYUN_SMS_LIMIT_CONTROL_ERROR);

            //ALIYUN_SMS_ERROR(-503, "短信发送失败"),//其他失败
            Assert.equals("OK", code, ResponseEnum.ALIYUN_SMS_ERROR);
        } catch (ClientException e) {
            throw new BusinessException(ResponseEnum.ALIYUN_SMS_ERROR , e);
        }

    }
}
