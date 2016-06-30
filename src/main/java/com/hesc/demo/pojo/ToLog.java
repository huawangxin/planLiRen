/*
 * Demo.java
 * Copyright(C) 2015 杭州天翼智慧城市科技有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2015-10-12 Created
 */
package com.hesc.demo.pojo;


/**
 * @author huawangxin
 * @see 日志的 实体类(用于页面上显示字符串格式)
 * @version 1.0 2015-10-12
 */
public class ToLog {
	/**
     * id
     */
    private String id;
    /**
     * 用户名
     */
    private String name;
    /**
     * 操作时间
     */
    private String createTime;
    /**
     * 操作类型
     */
    private String operation;
    /**
     * 状态
     */
    private String state;
    /**
     * 排序，000--999
     */
    private String sort;

    public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
    public String getSort() {
        return sort;
    }
    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
    public String getCreateTime() {
        return createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}