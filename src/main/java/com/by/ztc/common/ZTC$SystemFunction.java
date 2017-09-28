package com.by.ztc.common;

import com.by.ztc.common.exception.ZTC$JVMException;
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
     * 函数性质： 代码生成
     *
     * 获取JVM相关参数 {@link ZTC$Constant }
     * 显示初始JVM properties文件中的Key值
     */
    public static void _systemPropertysKey() {

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

    /**
     * 函数性质： 显示信息
     *
     * 控制台打印出JVM中的Properties中的Key=Value
     *
     */
    public static void _systemPropertysInfo() {
        Properties sysProperties = getJVMSystemProperties();
        Set<Object> keys = sysProperties.keySet();
        System.out.println(ZTC$Constant.ZTC_PARTING_LINE);
        for (Object key: keys
             ) {
            _consoleOut(key + " = " + sysProperties.get(key));
        }
        System.out.println(ZTC$Constant.ZTC_PARTING_LINE);
    }

    /**
     * 获取JVM properties文件对象
     *
     * @return
     */
    private static Properties getJVMSystemProperties() {
        return System.getProperties();
    }

    /**
     * 函数性质：根据键获取值
     *
     * 获取JVM properties文件对象特定值 TODO
     *
     * @param key 键
     * @return 值
     * @throws ZTC$JVMException
     */
    public static Object _getJVMSystemPropertiesValue(String key) throws ZTC$JVMException{
        Object o = getJVMSystemProperties().get(key);
        if (o == null) {
            throw new ZTC$JVMException();
        }
        return o;
    }

    /**
     * 控制台输出函数
     *
     * @param o
     */
    public static void _consoleOut(Object o) {
        System.out.println(o.toString());
    }

}
