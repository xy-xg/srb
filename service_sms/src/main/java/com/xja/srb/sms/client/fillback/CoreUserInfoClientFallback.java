package com.xja.srb.sms.client.fillback;

import com.xja.srb.sms.client.CoreUserInfoClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author xiaoYan
 * @Data 2023/1/19 20:32
 * 时间不早了  注意休息
 * 防止雪崩 熔断作用 即便sms模块出问题 也不影响 x
 */
@Service
@Slf4j
public class CoreUserInfoClientFallback implements CoreUserInfoClient {
    @Override
    public boolean checkMobile(String mobile) {
        log.error("远程调用失败");
        //手机没验证成功
        return false;
    }
}
