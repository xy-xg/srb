package com.xja.srb.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xja.srb.core.mapper.BorrowerAttachMapper;
import com.xja.srb.core.pojo.entity.BorrowerAttach;
import com.xja.srb.core.pojo.vo.BorrowerAttachVO;
import com.xja.srb.core.service.BorrowerAttachService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 借款人上传资源表 服务实现类
 * </p>
 *
 * @author xiaoYan
 * @since 2023-01-03
 */
@Service
public class BorrowerAttachServiceImpl extends ServiceImpl<BorrowerAttachMapper, BorrowerAttach> implements BorrowerAttachService {



    @Override
    public List<BorrowerAttachVO> selectBorrowerAttachVOList(Long borrowerId) {

        QueryWrapper<BorrowerAttach> borrowerAttachQueryWrapper = new QueryWrapper<>();
        borrowerAttachQueryWrapper.eq("borrower_id", borrowerId);
        List<BorrowerAttach> borrowerAttachList = baseMapper.selectList(borrowerAttachQueryWrapper);

        List<BorrowerAttachVO> borrowerAttachVOList = new ArrayList<>();
        borrowerAttachList.forEach(borrowerAttach -> {
            BorrowerAttachVO borrowerAttachVO = new BorrowerAttachVO();
            borrowerAttachVO.setImageType(borrowerAttach.getImageType());
            borrowerAttachVO.setImageUrl(borrowerAttach.getImageUrl());
            borrowerAttachVOList.add(borrowerAttachVO);
        });

        return borrowerAttachVOList;
    }
}
