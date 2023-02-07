package com.xja.srb.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xja.srb.core.pojo.entity.LendItemReturn;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 标的出借回款记录表 服务类
 * </p>
 *
 * @author xiaoYan
 * @since 2023-01-03
 */
public interface LendItemReturnService extends IService<LendItemReturn> {


    /**
    * @return java.util.List<com.xja.srb.core.pojo.entity.LendItemReturn>
    * @author xiaoYan
    * @params [lendId, userId]
    * @date 2023/1/23 20:12
     * 查看回款记录
    */

    List<LendItemReturn> selectByLendId(Long lendId, Long userId);


    /**
    * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
    * @author xiaoYan
    * @params [lendReturnId]
    * @date 2023/1/23 20:56
     *     根据还款id获取回款列表
    */

    List<Map<String, Object>> addReturnDetail(Long lendReturnId);
    
    /**
    * @return java.util.List<com.xja.srb.core.pojo.entity.LendItemReturn>
    * @author xiaoYan
    * @params [lendReturnId]
    * @date 2023/1/23 21:04
    */
    

    List<LendItemReturn> selectLendItemReturnList(Long lendReturnId);



}
