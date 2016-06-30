/*
 * AlbumService.java
 * Copyright(C) 2015 杭州天翼智慧城市科技有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-05 Created
 */
package com.hesc.demo.service;

import java.util.List;

import com.hesc.demo.pojo.Album_photo;
import com.hesc.trundle.db.service.BaseService;
/**
 * @author huawangxin
 * @see 相册的接口类
 */
public interface Album_photoService extends BaseService<Album_photo> {
	/**
	 * @param 根据用户名获取相册集合
	 * @param userName 用户名
	 * @return List<Album_photo> 相册集合
	 */
	public List<Album_photo> selectByName(String userName);
}