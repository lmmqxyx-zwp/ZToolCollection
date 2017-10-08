package com.by.ztc.common;

/**
 * Created by byvai on 2017/10/8.
 * ZTC 系统函数
 *
 * @author zwp
 */
public class ZTC$Function {

    /**
     * 判断对象是否为空
     *
     * @param object
     * @return 如果为null返回true | 非null为false
     */
    public static boolean isObjectNull(Object object) {
        return object == null;
    }

    /**
     * 系统信息显示
     */
    public static void ztcSystemInfo() {
        System.out.print("                              ====================================================================\n");
        System.out.print("                              ===========================欢迎使用ZTC系统==========================");
        System.out.print("\n                              ====================================================================\n");
    }

}
