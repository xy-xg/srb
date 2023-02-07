package com.xja.common;

import com.xja.common.exception.Assert;
import com.xja.common.result.ResponseEnum;
import org.junit.Test;

/**
 * @Author xiaoYan
 * @Data 2023/1/3 19:22
 * 时间不早了  注意休息
 */
public class AssertTest {

    @Test
    public void ok(){
        Object o = null;
        //用断言替代if
        Assert.notNull(o, ResponseEnum.PARAMETER_METHOD_ERROR);
    }
}
