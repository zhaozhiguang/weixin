package com.zhaozhiguang.component.weixin.util;

import java.util.List;

/**
 * 参数验证工具类
 * @author zhiguang
 */
public class ArgsCheckUtils {

    public static void notNull(Object arg){
        if(arg==null)
            throw new IllegalArgumentException("参数为空");
    }

    public static void notEmptyByList(List list){
        if(list==null || list.isEmpty())
            throw new IllegalArgumentException("参数为空");
    }
}
