package com.by.ztc.common;

import com.by.ztc.common.template.j.JavaSourceCode;

import java.util.Properties;
import java.util.Set;

/**
 * Created by byvai on 2017/9/27.
 *
 * 系统函数
 *
 * @author zwp
 *
 */
public class ZTC$SystemFunction {

    /**
     * 获取JVM相关参数 {@link 代码生成 }
     */
    public static void _systemPropertys() {

        Properties sysProperties = System.getProperties();
        Set<Object> keys = sysProperties.keySet();
        int count = 0;
        System.out.println(ZTC$Constant.ZTC_PARTING_LINE);
        for (Object key: keys
             ) {
            System.out.println(JavaSourceCode.getPublicStaticFinalString() + key.toString().toUpperCase().replace('.', '_') + " = " + "\"" + key.toString() + "\";");
            count ++;
        }
        System.out.println("数量 ： - " + count);
        System.out.println(ZTC$Constant.ZTC_PARTING_LINE);

    }


}
