package com.xja.srb.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xja.srb.core.pojo.entity.BorrowInfo;
import com.xja.srb.core.pojo.vo.BorrowInfoApprovalVO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 借款信息表 服务类
 * </p>
 *
 * @author xiaoYan
 * @since 2023-01-03
 */
public interface BorrowInfoService extends IService<BorrowInfo> {
    /**
    * @return java.math.BigDecimal
    * @author xiaoYan
    * @params [userId]
    * @date 2023/1/21 21:02
     * 根据用户积分 换取额度
    */

    BigDecimal getBorrowAmount(Long userId);

    
    /**
    * @return void
    * @author xiaoYan
    * @params [borrowInfo, userId]
    * @date 2023/1/21 22:29
     * 借款人提交借款要判断借款人账户绑定状态与借款人信息审批状态，只有这两个状态都成立才能借款，这两个状态都在会员表中
    */
    void saveBorrowInfo(BorrowInfo borrowInfo, Long userId);


    /**
    * @return java.lang.Integer
    * @author xiaoYan
    * @params [userId]
    * @date 2023/1/21 23:05
     * 查询申请借贷的状态
    */

    Integer getStatusByUserId(Long userId);


    /**
    * @return java.util.List<com.xja.srb.core.pojo.entity.BorrowInfo>
    * @author xiaoYan
    * @params []
    * @date 2023/1/21 23:14
     * 查询借款提交审核列表
    */

    List<BorrowInfo> selectList();


    /**
    * @return Map<String,Object>
    * @author xiaoYan
    * @params [id]
    * @date 2023/1/21 23:22
     * 借款审批详情
    */

    Map<String,Object> getBorrowInfoDetail(Long id);


    /**
    * @return void
    * @author xiaoYan
    * @params [borrowInfoApprovalVO]
    * @date 2023/1/21 23:27
     * 借款审批
    */

    void approval(BorrowInfoApprovalVO borrowInfoApprovalVO);
}
