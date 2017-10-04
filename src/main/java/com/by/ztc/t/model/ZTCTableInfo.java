package com.by.ztc.t.model;

import java.util.List;

/**
 * 数据表的实体
 *
 * 1、作用：当ZTC完成之后、表结构的展现（开发需要）
 *
 * @author zwp
 */
public class ZTCTableInfo extends DBBaseEntity {

    // 表名
    private String tableName;
    // 描述
    private String description;
    // 对应类名
    private String className;
    // 备注
    private String remarks;
    // 字表
    private List<ZTCTableInfo> childTables;
    // 父表
    private List<ZTCTableInfo> parentTables;
    // 外键
    private String foreignKey;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public List<ZTCTableInfo> getChildTables() {
        return childTables;
    }

    public void setChildTables(List<ZTCTableInfo> childTables) {
        this.childTables = childTables;
    }

    public List<ZTCTableInfo> getParentTables() {
        return parentTables;
    }

    public void setParentTables(List<ZTCTableInfo> parentTables) {
        this.parentTables = parentTables;
    }

    public String getForeignKey() {
        return foreignKey;
    }

    public void setForeignKey(String foreignKey) {
        this.foreignKey = foreignKey;
    }
}
