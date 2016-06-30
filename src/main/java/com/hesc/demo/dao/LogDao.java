/*
 * LogDao.java
 * Copyright(C) 2015 杭州天翼智慧城市科技有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-05 Created
 */
package com.hesc.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hesc.demo.pojo.Log;
import com.hesc.trundle.db.dao.BaseDao;
/**
 * 
 * @author huawangxin
 * @see 日志的 dao
 *
 */
@Repository
public interface LogDao extends BaseDao<Log> {
	/**
	 * @param 关键字找信息
	 * @param key 要搜索的关键字
	 * @return List<Log> 返回关键字key所对应的日志记录log集合
	 */
	public List<Log> searchList(String key);
}