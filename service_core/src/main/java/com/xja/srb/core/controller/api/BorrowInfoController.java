package com.xja.srb.core.controller.api;

import com.baomidou.mybatisplus.extension.api.R;
import com.xja.common.result.Result;
import com.xja.srb.base.utils.JwtUtils;
import com.xja.srb.core.pojo.entity.BorrowInfo;
import com.xja.srb.core.service.BorrowInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

@Api(tags = "借款信息")
@RestController
@RequestMapping("/api/core/borrowInfo")
@Slf4j
public class BorrowInfoController {

    @Resource
    private BorrowInfoService borrowInfoService;

    @ApiOperation("获取借款额度")
    @GetMapping("/auth/getBorrowAmount")
    public Result getBorrowAmount(HttpServletRequest request) {
        String token = request.getHeader("token");
        Long userId = JwtUtils.getUserId(token);
        BigDecimal borrowAmount = borrowInfoService.getBorrowAmount(userId);
        return Result.ok().data("borrowAmount", borrowAmount);
    }


    /**
    * @return com.xja.common.result.Result
    * @author xiaoYan
    * @params [borrowInfo, request]
    * @date 2023/1/21 22:30
     * 防止跳过=前端验证 超出本身自己可以借贷的额度
    */

    @ApiOperation("提交借款申请")
    @PostMapping("/auth/save")
    public Result save(@RequestBody BorrowInfo borrowInfo, HttpServletRequest request) {

        String token = request.getHeader("token");
        Long userId = JwtUtils.getUserId(token);
        borrowInfoService.saveBorrowInfo(borrowInfo, userId);
        return Result.ok().message("提交成功");
    }

    @ApiOperation("获取借款申请审批状态")
    @GetMapping("/auth/getBorrowInfoStatus")
    public Result getBorrowerStatus(HttpServletRequest request){
        String token = request.getHeader("token");
        Long userId = JwtUtils.getUserId(token);
        Integer status = borrowInfoService.getStatusByUserId(userId);
        return Result.ok().data("borrowInfoStatus", status);
    }
}