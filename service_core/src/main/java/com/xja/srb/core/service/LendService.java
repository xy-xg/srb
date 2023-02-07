package com.xja.srb.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xja.srb.core.pojo.entity.BorrowInfo;
import com.xja.srb.core.pojo.entity.Lend;
import com.xja.srb.core.pojo.vo.BorrowInfoApprovalVO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 标的准备表 服务类
 * </p>
 *
 * @author xiaoYan
 * @since 2023-01-03
 */
public interface LendService extends IService<Lend> {

    /**
    * @return void
    * @author xiaoYan
    * @params [borrowInfoApprovalVO, borrowInfo]
    * @date 2023/1/22 14:10
     * 创建标的
    */

    void createLend(BorrowInfoApprovalVO borrowInfoApprovalVO, BorrowInfo borrowInfo);


    /**
    * @return java.util.List<com.xja.srb.core.pojo.entity.Lend>
    * @author xiaoYan
    * @params []
    * @date 2023/1/22 14:53
     * 标的列表
    */

    List<Lend> selectList();


    /**
    * @return java.util.Map<java.lang.String,java.lang.Object>
    * @author xiaoYan
    * @params [id]
    * @date 2023/1/22 15:17
     * 根据id查看标的详情
    */

    Map<String, Object> getLendDetail(Long id);

    /**
    * @return java.math.BigDecimal
    * @author xiaoYan
    * @params [invest, yearRate, totalmonth, returnMethod]
    * @date 2023/1/23 13:28
     * 计算利息收益
    */

    BigDecimal getInterestCount(BigDecimal invest, BigDecimal yearRate, Integer totalmonth, Integer returnMethod);


    /**
    * @return void
    * @author xiaoYan
    * @params [id]
    * @date 2023/1/23 18:53
     * 放款
    */

    void makeLoan(Long id);



}
