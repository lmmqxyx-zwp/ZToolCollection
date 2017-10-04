package com.by.ztc.t.model;

import java.util.Date;

/**
 * Created by byvai on 2017/10/4.
 *
 * 与数据库相关的所有的实体的父类
 *
 * @author zwp
 *
 */
public class DBBaseEntity extends BaseEntity {
    // 主键
    private Integer id;
    // 创建时间
    private Date createDate;
    // 更新时间
    private Date updateDate;
    // 版本
    private String version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
