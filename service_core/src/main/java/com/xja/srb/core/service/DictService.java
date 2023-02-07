package com.xja.srb.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xja.srb.core.pojo.dto.ExcelDictDTO;
import com.xja.srb.core.pojo.entity.Dict;

import java.io.InputStream;
import java.util.List;

/**
 * <p>
 * 数据字典 服务类
 * </p>
 *
 * @author xiaoYan
 * @since 2023-01-03
 */
public interface DictService extends IService<Dict> {

    /**
    * @return void
    * @author xiaoYan
    * @params [inputStream]
    * @date 2023/1/10 11:13
     * 字典导入
    */

    void importData(InputStream inputStream);
    /**
    * @return java.util.List<com.xja.srb.core.pojo.dto.ExcelDictDTO>
    * @author xiaoYan
    * @params []
    * @date 2023/1/10 11:12
     * 文件转换
    */

    List<ExcelDictDTO> listDictData();


    /**
    * @return java.util.List<com.xja.srb.core.pojo.entity.Dict>
    * @author xiaoYan
    * @params [parentId]
    * @date 2023/1/20 14:13
     * 根据父节点获取数据
    */

    List<Dict> listByParentId(Long parentId);

    /**
    * @return java.util.List<com.xja.srb.core.pojo.entity.Dict>
    * @author xiaoYan
    * @params [dictCode]
    * @date 2023/1/20 14:09
     * 根据dictcode获取下级节点
    */

    List<Dict> findByDictCode(String dictCode);

    /**
    * @return java.lang.String
    * @author xiaoYan
    * @params [education, education1]
    * @date 2023/1/20 18:19
     * 根据dictcode 查询信息 如果有就是code 没有就是'"
    */

    String getNameByParentDictCodeAndValue(String education, Integer education1);
}
