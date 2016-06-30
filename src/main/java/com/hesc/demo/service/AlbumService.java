/*
 * AlbumService.java
 * Copyright(C) 2015 杭州天翼智慧城市科技有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-05 Created
 */
package com.hesc.demo.service;

import java.util.List;

import com.hesc.demo.pojo.Album;
import com.hesc.trundle.db.service.BaseService;
/**
 * @author huawangxin
 * @see 照片的实现接口类
 */
public interface AlbumService extends BaseService<Album> {
	/**
	 * @param 查询某用户的某相册内图片
     * @param album_id 相册Id
     * @return List<Album> 根据相册id查找的某相册的照片集合
     */
	public List<Album> selectByAlbum_id(String album_id);
}