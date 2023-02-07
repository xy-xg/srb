package com.xja.srb.core.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xja.srb.core.pojo.entity.UserInfo;
import com.xja.srb.core.pojo.query.UserInfoQuery;
import com.xja.srb.core.pojo.vo.LoginVO;
import com.xja.srb.core.pojo.vo.RegisterVO;
import com.xja.srb.core.pojo.vo.UserIndexVO;
import com.xja.srb.core.pojo.vo.UserInfoVO;

/**
 * <p>
 * 用户基本信息 服务类
 * </p>
 *
 * @author xiaoYan
 * @since 2023-01-03
 */
public interface UserInfoService extends IService<UserInfo> {



    /**
    * @return void
    * @author xiaoYan
    * @params [registerVO]
    * @date 2023/1/11 13:56
     * 注册用户
    */

    public void register (RegisterVO registerVO);
    /**
    * @return com.xja.srb.core.pojo.vo.UserInfoVO
    * @author xiaoYan
    * @params [loginVO, ip]
    * @date 2023/1/17 20:28
     * 用户登录
    */

    UserInfoVO login(LoginVO loginVO, String ip);


    /**
    * @return com.baomidou.mybatisplus.core.metadata.IPage<com.xja.srb.core.pojo.entity.UserInfo>
    * @author xiaoYan
    * @params [pageParam, userInfoQuery]
    * @date 2023/1/17 20:28
     * 用户列表
    */
    IPage<UserInfo> listPage(Page<UserInfo> pageParam, UserInfoQuery userInfoQuery);

    /**
    * @return void
    * @author xiaoYan
    * @params [id, status]
    * @date 2023/1/18 16:48
     * 锁定/解锁用户状态
    */
    void lock(Long id, Integer status);



    /**
    * @return boolean
    * @author xiaoYan
    * @params [mobile]
    * @date 2023/1/19 18:10
     * 校验注册是否已经存在该手机号
    */
    boolean checkMobile(String mobile);


    /**
    * @return com.xja.srb.core.pojo.vo.UserIndexVO
    * @author xiaoYan
    * @params [userId]
    * @date 2023/1/23 21:47
     * 个人信息
    */

    UserIndexVO getIndexUserInfo(Long userId);

}
