package com.by.ztc.t.model;

import java.io.Serializable;

/**
 * Entity 所有实体的父类
 *
 * @author zwp
 */
public class BaseEntity implements Serializable {

    // 也可以不存在、但是最好使用、参照 @link {serializable.uid.properties}
    private static final long serialVersionUID = 0X01; //Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的

}
