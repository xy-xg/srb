package com.xja.srb.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xja.srb.core.pojo.entity.LendItem;
import com.xja.srb.core.pojo.vo.InvestVO;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 标的出借记录表 服务类
 * </p>
 *
 * @author xiaoYan
 * @since 2023-01-03
 */
public interface LendItemService extends IService<LendItem> {

    /**
    * @return java.lang.String
    * @author xiaoYan
    * @params [investVO]
    * @date 2023/1/23 15:53
     * 提交投资信息
    */

    String commitInvest(InvestVO investVO);

    
    /**
    * @return void
    * @author xiaoYan
    * @params [paramMap]
    * @date 2023/1/23 18:18
     * 回调业务 增加投资消费日志
    */
    
    void notify(Map<String, Object> paramMap);


    /**
    * @return java.util.List<com.xja.srb.core.pojo.entity.LendItem>
    * @author xiaoYan
    * @params [lendId, i]
    * @date 2023/1/23 19:00
     *
    */
    List<LendItem> selectByLendId(Long lendId, Integer status);


    /**
    * @return java.util.List<com.xja.srb.core.pojo.entity.LendItem>
    * @author xiaoYan
    * @params [lendId]
    * @date 2023/1/23 19:28
    */


    List<LendItem> selectByLendId(Long lendId);


}
