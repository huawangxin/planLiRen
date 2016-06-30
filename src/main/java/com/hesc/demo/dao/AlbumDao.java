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

import com.hesc.demo.pojo.Album;
import com.hesc.trundle.db.dao.BaseDao;
/**
 * @author huawangxin
 * @see 照片的dao
 */
@Repository
public interface AlbumDao extends BaseDao<Album> {
	/**
     * @param 查询某用户的某相册内图片
     * @param album_id 相册Id
     * @return List<Album> 根据相册id查找的某相册的照片集合
     */
	public List<Album> selectByAlbum_id(String album_id);
}