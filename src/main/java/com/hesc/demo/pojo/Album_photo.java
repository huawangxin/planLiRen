/*
 * Demo.java
 * Copyright(C) 2015 杭州天翼智慧城市科技有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2015-10-12 Created
 */
package com.hesc.demo.pojo;

import com.hesc.trundle.db.pojo.Identifiable;


/**
 * @author huawangxin
 * @see 相册的 实体类
 * @version 1.0 2015-10-12
 */
public class Album_photo implements Identifiable {
	/**
     *	id
     */
    private String id;
    /**
     * 相册名
     */
    private String album_name;
    /**
     * 用户名
     */
    private String name;
    /**
     * 上传时间
     */
    private Long createTime;
    /**
     * 描述
     */
    private String description;
    /**
     * 状态
     */
    private String state;
    /**
     * 排序，000--999
     */
    private String sort;
    

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
	public String getAlbum_name() {
		return album_name;
	}
	public void setAlbum_name(String album_name) {
		this.album_name = album_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
	
	
    
}