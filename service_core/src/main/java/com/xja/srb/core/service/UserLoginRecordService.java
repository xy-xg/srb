package com.xja.srb.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xja.srb.core.pojo.entity.UserLoginRecord;

import java.util.List;

/**
 * <p>
 * 用户登录记录表 服务类
 * </p>
 *
 * @author xiaoYan
 * @since 2023-01-03
 */
public interface UserLoginRecordService extends IService<UserLoginRecord> {


    /**
    * @return java.util.List<com.xja.srb.core.pojo.entity.UserLoginRecord>
    * @author xiaoYan
    * @params [userId]
    * @date 2023/1/18 16:55
     * 登录日志 展示前50次即可
    */

    List<UserLoginRecord> listTop50(Long userId);
}
