package com.xja.srb.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xja.srb.core.pojo.entity.UserAccount;

import java.math.BigDecimal;
import java.util.Map;

/**
 * <p>
 * 用户账户 服务类
 * </p>
 *
 * @author xiaoYan
 * @since 2023-01-03
 */
public interface UserAccountService extends IService<UserAccount> {


    /**
    * @return java.lang.String
    * @author xiaoYan
    * @params [chargeAmt, userId]
    * @date 2023/1/22 17:05
     * 充值
    */

    String commitCharge(BigDecimal chargeAmt, Long userId);


    /**
    * @return java.lang.String
    * @author xiaoYan
    * @params [paramMap]
    * @date 2023/1/22 17:37
     * 充值完成后 回调函数
    */

    String notify(Map<String, Object> paramMap);
    /**
    * @return java.math.BigDecimal
    * @author xiaoYan
    * @params [userId]
    * @date 2023/1/23 12:01
     * 查询账户余额信息
    */

    BigDecimal getAccount(Long userId);
    
    /**
    * @return java.lang.String
    * @author xiaoYan
    * @params [fetchAmt, userId]
    * @date 2023/1/23 20:30
     * 提现
    */
    
    String commitWithdraw(BigDecimal fetchAmt, Long userId);

    /**
    * @return void
    * @author xiaoYan
    * @params [paramMap]
    * @date 2023/1/23 20:33\
     * 提现回调函数
    */

    void notifyWithdraw(Map<String, Object> paramMap);
}
