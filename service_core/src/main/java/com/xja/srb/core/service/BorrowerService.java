package com.xja.srb.core.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xja.srb.core.pojo.entity.Borrower;
import com.xja.srb.core.pojo.vo.BorrowerApprovalVO;
import com.xja.srb.core.pojo.vo.BorrowerDetailVO;
import com.xja.srb.core.pojo.vo.BorrowerVO;

/**
 * <p>
 * 借款人 服务类
 * </p>
 *
 * @author xiaoYan
 * @since 2023-01-03
 */
public interface BorrowerService extends IService<Borrower> {


    /**
    * @return void
    * @author xiaoYan
    * @params [borrowerVO, userId]
    * @date 2023/1/20 14:53
     * 保存
    */
    void saveBorrowerVOByUserId(BorrowerVO borrowerVO, Long userId);

    /**
    * @return java.lang.Integer
    * @author xiaoYan
    * @params [userId]
    * @date 2023/1/20 15:52
     * 根据id获取借款人
    */
    Integer getStatusByUserId(Long userId);


    /**
    * @return com.baomidou.mybatisplus.core.metadata.IPage<com.xja.srb.core.pojo.entity.Borrower>
    * @author xiaoYan
    * @params [pageParam, keyword]
    * @date 2023/1/20 16:10
     * 审核借款人列表
    */
    IPage<Borrower> listPage(Page<Borrower> pageParam, String keyword);


    /**
    * @return com.xja.srb.core.pojo.vo.BorrowerDetailVO
    * @author xiaoYan
    * @params [id]
    * @date 2023/1/20 17:02
     * 获取借款人信息
    */
    BorrowerDetailVO getBorrowerDetailVOById(Long id);



    /**
    * @return void
    * @author xiaoYan
    * @params [borrowerApprovalVO]
    * @date 2023/1/21 12:06
     * 审核页面数据
    */
    void approval(BorrowerApprovalVO borrowerApprovalVO);


}
