/*
 * UserServiceImpl.java
 * Copyright(C) 2015 杭州天翼智慧城市科技有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-05 Created
 */
package com.hesc.demo.service.impl;

import com.hesc.demo.dao.UserDao;
import com.hesc.demo.pojo.User;
import com.hesc.demo.service.UserService;
import com.hesc.trundle.db.dao.BaseDao;
import com.hesc.trundle.db.service.impl.BaseServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 
 * @author huawangxin
 * @see 用户的方法实现方法类
 *
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Autowired
    private UserDao userDao;

    @SuppressWarnings("unchecked")
    @Override
    protected BaseDao<User> getBaseDao() {
        return (BaseDao<User>) userDao;
    }
    /**
	 * @param 根据用户名查找用户信息
	 * @param userName 用户名
	 * @return User 返回用户实体类User
	 */
    @Override
	public User selectByName(String userName) {
		User user=userDao.selectByName(userName);
		return user;
	}
}