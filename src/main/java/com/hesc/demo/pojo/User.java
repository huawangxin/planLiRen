/*
 * User.java
 * Copyright(C) 2015 杭州天翼智慧城市科技有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2015-10-12 Created
 */
package com.hesc.demo.pojo;

import com.hesc.trundle.db.pojo.Identifiable;

/**
 * @author huawangxin
 * @see 用户的 实体类
 * @version 1.0 2015-10-12
 */
public class User implements Identifiable  {
	/**
     * id
     */
	private String id;
	/**
     * 姓名
     */
    private String name;

    /**
     * 密码
     */
    private String password;
    /**
     * 性别
     */
    private String gender;
    /**
     * 年龄
     */
    private int age;
    /**
     * 电话
     */
    private String tel;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 状态
     */
    private String state;
    /**
     * 排序，000-999
     */
    private String sort;
    /**
     * 创建时间
     */
    private Long createTime;

    

    public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
    public Long getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}