package com.xja.srb.core.controller.admin;

import com.xja.common.exception.Assert;
import com.xja.common.result.ResponseEnum;
import com.xja.common.result.Result;
import com.xja.srb.core.pojo.entity.IntegralGrade;
import com.xja.srb.core.service.IntegralGradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author xiaoYan
 * @Data 2023/1/3 18:22
 * 时间不早了  注意休息
 */
@Api(tags = "积分等级管理")
@RestController
@RequestMapping("/admin/core/integralGrade")
public class AdminIntegralGradeController {


    @Autowired
    private IntegralGradeService integralGradeService;

    @ApiOperation("积分等级列表")
    @GetMapping("/list")
    public Result listAll(){
        List<IntegralGrade> list = integralGradeService.list();
        return Result.ok().data("list",list).message("成功");
    }

    @ApiOperation(value = "根据id删除积分等级", notes = "逻辑删除")
    @DeleteMapping("/remove/{id}")
    public Result removeById(
            @ApiParam(value = "数据id", required = true, example = "100")
            @PathVariable Long id){
        boolean b = integralGradeService.removeById(id);
        if (b){
            return Result.ok().message("删除成功");
        }else {
            return Result.error().message("删除失败");

        }
    }


    @ApiOperation("新增积分等级")
    @PostMapping("/save")
    public Result save(
            @ApiParam(value = "积分等级对象", required = true)
            @RequestBody IntegralGrade integralGrade){
        //代替if ==null 报自定义异常
        Assert.notNull(integralGrade.getBorrowAmount(), ResponseEnum.BORROW_AMOUNT_NULL_ERROR);
        boolean result = integralGradeService.save(integralGrade);
        if (result) {
            return Result.ok().message("保存成功");
        } else {
            return Result.error().message("保存失败");
        }
    }


    @ApiOperation("根据id获取积分等级")
    @GetMapping("/get/{id}")
    public Result getById(
            @ApiParam(value = "数据id", required = true, example = "1")
            @PathVariable Long id
    ){
        IntegralGrade integralGrade = integralGradeService.getById(id);
        if(integralGrade != null){
            return Result.ok().data("record", integralGrade);
        }else{
            return Result.error().message("数据不存在");
        }
    }

    @ApiOperation("更新积分等级")
    @PutMapping("/update")
    public Result updateById(
            @ApiParam(value = "积分等级对象", required = true)
            @RequestBody IntegralGrade integralGrade){
        boolean result = integralGradeService.updateById(integralGrade);
        if(result){
            return Result.ok().message("修改成功");
        }else{
            return Result.error().message("修改失败");
        }
    }



}
