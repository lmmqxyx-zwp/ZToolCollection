package com.by.ztc;

import java.util.Map;
import java.util.Set;

public class Test {

    public static final String ZTC_PARTING_LINE = "ZTC $ --- $ --- $ --- $ --- $ --- $ --- $ CTZ";

    public static void main(String[] args) {
        systemEnv();

    }

    // System ENV
    // windows 下使用： set 变量名=变量值 是不行的，读取的还是环境变量中设置的值
    // TODO linux下 用export命令导入《未尝试》
    public static void systemEnv() {
        Map<String,String> m = System.getenv();
        Set<String> s = m.keySet();
        for (String k: s
             ) {
            System.out.println(k + " - " + m.get(k));
        }
        System.out.println("count - " + m.size());
        System.out.println(ZTC_PARTING_LINE);
    }

}
