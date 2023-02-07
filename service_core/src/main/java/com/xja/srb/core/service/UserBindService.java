package com.xja.srb.core.service;

import com.xja.srb.core.pojo.entity.UserBind;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xja.srb.core.pojo.vo.UserBindVO;

import java.util.Map;

/**
 * <p>
 * 用户绑定表 服务类
 * </p>
 *
 * @author xiaoYan
 * @since 2023-01-03
 */
public interface UserBindService extends IService<UserBind> {
    /**
    * @return java.lang.String
    * @author xiaoYan
    * @params [userBindVO, userId]
    * @date 2023/1/20 12:15
     * 根据登录账号绑定
    */

    String commitBindUser(UserBindVO userBindVO, Long userId);
    /**
    * @return void
    * @author xiaoYan
    * @params [paramMap]
    * @date 2023/1/20 12:15
     * 回调更新其他表 bindcode
    */

    void notify(Map<String, Object> paramMap);


    /**
    * @return java.lang.String
    * @author xiaoYan
    * @params [investUserId]
    * @date 2023/1/23 15:54
     * 获取绑定人
    */

    String getBindCodeByUserId(Long investUserId);
}
