package com.xja.srb.core.service;

import com.xja.srb.core.pojo.entity.BorrowerAttach;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xja.srb.core.pojo.vo.BorrowerAttachVO;

import java.util.List;

/**
 * <p>
 * 借款人上传资源表 服务类
 * </p>
 *
 * @author xiaoYan
 * @since 2023-01-03
 */
public interface BorrowerAttachService extends IService<BorrowerAttach> {



    /**
    * @return java.util.List<com.xja.srb.core.pojo.vo.BorrowerAttachVO>
    * @author xiaoYan
    * @params [id]
    * @date 2023/1/20 18:24
     * 附件集合 也就是身份证 那些照片
    */

    List<BorrowerAttachVO> selectBorrowerAttachVOList(Long id);
}
