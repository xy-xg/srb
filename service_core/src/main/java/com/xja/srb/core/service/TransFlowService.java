package com.xja.srb.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xja.srb.core.pojo.bo.TransFlowBO;
import com.xja.srb.core.pojo.entity.TransFlow;

import java.util.List;

/**
 * <p>
 * 交易流水表 服务类
 * </p>
 *
 * @author xiaoYan
 * @since 2023-01-03
 */
public interface TransFlowService extends IService<TransFlow> {
    /**
    * @return void
    * @author xiaoYan
    * @params [transFlowBO]
    * @date 2023/1/23 12:04
     * 保存流水记录
    */

    void saveTransFlow(TransFlowBO transFlowBO);


    /**
    * @return boolean
    * @author xiaoYan
    * @params [agentBillNo]
    * @date 2023/1/22 12:03
     * 查看是否存在流水了
    */

    boolean isSaveTransFlow(String agentBillNo);

    
    /**
    * @return java.util.List<com.xja.srb.core.pojo.entity.TransFlow>
    * @author xiaoYan
    * @params [userId]
    * @date 2023/1/23 21:43
     * 资金记录
    */
    
    List<TransFlow> selectByUserId(Long userId);
}
