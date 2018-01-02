package com.zhaozhiguang.component.weixin.util;

/**
 * 参数验证工具类
 * @author zhiguang
 */
public class ArgsCheckUtils {

    public static void notNull(Object arg){
        if(arg==null)
            throw new IllegalArgumentException("参数为空");
    }
}
