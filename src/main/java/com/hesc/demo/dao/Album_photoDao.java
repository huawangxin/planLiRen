/*
 * AlbumDao.java
 * Copyright(C) 2015 杭州天翼智慧城市科技有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-05 Created
 */
package com.hesc.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hesc.demo.pojo.Album_photo;
import com.hesc.trundle.db.dao.BaseDao;
/**
 * @author huawangxin
 * @see 相册的 dao
 */
@Repository
public interface Album_photoDao extends BaseDao<Album_photo> {
	/**
	 * @param 根据用户名获取相册集合
	 * @param userName 用户名
	 * @return List<Album_photo> 相册集合
	 */
	public List<Album_photo> selectByName(String userName);
}