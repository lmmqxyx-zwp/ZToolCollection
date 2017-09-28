package com.by.ztc.common.template.j;

/**
 * Created by byvai on 2017/9/28.
 *
 * java模板
 *
 * @author zwp
 *
 */
public class JavaSourceCode {

    public static final String _CLASS = "class";
    public static final String _PUBLIC = "public";
    public static final String _PRIVATE = "private";
    public static final String _PROTECTED = "protected";
    public static final String _SPACE = " ";
    public static final String _STATIC = "static";
    public static final String _FINAL = "final";
    public static final String _STRING = "String";
    public static final String _INT = "int";

    /**
     * 常量定义 String
     *
     * 返回 例子： - public static final String
     *
     * @return
     */
    public static String getPublicStaticFinalString() {
        return _PUBLIC + _SPACE + _STATIC + _SPACE + _FINAL + _SPACE + _STRING + _SPACE;
    }

    /**
     * 常量定义 int
     *
     * 返回 例子： - public static final int
     *
     * @return
     */
    public static String getPublicStaticFinalInt() {
        return _PUBLIC + _SPACE + _STATIC + _SPACE + _FINAL + _SPACE + _INT + _SPACE;
    }

}
