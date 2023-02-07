package com.xja.srb.sms.client;

import com.xja.srb.sms.client.fillback.CoreUserInfoClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author xiaoYan
 * @Data 2023/1/19 19:03
 * 时间不早了  注意休息
 */

@FeignClient(value = "service-core" ,fallback = CoreUserInfoClientFallback.class)
public interface CoreUserInfoClient {

    @GetMapping("/api/core/userInfo/checkMobile/{mobile}")
    boolean checkMobile(@PathVariable String mobile);
}
