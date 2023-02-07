package com.xja.srb.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xja.srb.core.pojo.entity.LendReturn;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 还款记录表 服务类
 * </p>
 *
 * @author xiaoYan
 * @since 2023-01-03
 */
public interface LendReturnService extends IService<LendReturn> {


    /**
    * @return java.util.List<com.xja.srb.core.pojo.entity.LendReturn>
    * @author xiaoYan
    * @params [lendId]
    * @date 2023/1/23 19:55
     * 还款记录表
    */

    List<LendReturn> selectByLendId(Long lendId);


    /**
    * @return java.lang.String
    * @author xiaoYan
    * @params [lendReturnId, userId]
    * @date 2023/1/23 20:55
     * 还款计划id
    */

    String commitReturn(Long lendReturnId, Long userId);


    /**
    * @return void
    * @author xiaoYan
    * @params [paramMap]
    * @date 2023/1/23 20:58
     * 回调
    */


    void notify(Map<String, Object> paramMap);

    /**
    * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
    * @author xiaoYan
    * @params [lendReturnId]
    * @date 2023/1/23 21:15
     * 根据还款id获取回款列表
    */
    
    List<Map<String, Object>> addReturnDetail(Long lendReturnId);

}
