package com.xja.srb.core.mapper;

import com.xja.srb.core.pojo.dto.ExcelDictDTO;
import com.xja.srb.core.pojo.entity.Dict;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 数据字典 Mapper 接口
 * </p>
 *
 * @author xiaoYan
 * @since 2023-01-03
 */
public interface DictMapper extends BaseMapper<Dict> {

    void insertBatch(List<ExcelDictDTO> list);
}
