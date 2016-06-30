/*
 * UserService.java
 * Copyright(C) 2015 杭州天翼智慧城市科技有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-05 Created
 */
package com.hesc.demo.service;

import com.hesc.demo.pojo.User;
import com.hesc.trundle.db.service.BaseService;
/**
 * 
 * @author huawangxin
 * @see 用户的方法实现接口类
 *
 */
public interface UserService extends BaseService<User> {
	/**
	 * @param 根据用户名查找用户信息
	 * @param userName 用户名
	 * @return User 返回用户实体类User
	 */
	public User selectByName(String userName);
}