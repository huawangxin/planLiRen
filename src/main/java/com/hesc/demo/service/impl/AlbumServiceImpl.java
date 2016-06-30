/*
 * AlbumServiceImpl.java
 * Copyright(C) 2015 杭州天翼智慧城市科技有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-05 Created
 */
package com.hesc.demo.service.impl;

import java.util.List;

import com.hesc.demo.dao.AlbumDao;
import com.hesc.demo.pojo.Album;
import com.hesc.demo.service.AlbumService;
import com.hesc.trundle.db.dao.BaseDao;
import com.hesc.trundle.db.service.impl.BaseServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @author huawangxin
 * @see 照片的实现方法类
 */
@Service("albumService")
public class AlbumServiceImpl extends BaseServiceImpl<Album> implements AlbumService {

    @Autowired
    private AlbumDao albumDao;

    @SuppressWarnings("unchecked")
    @Override
    protected BaseDao<Album> getBaseDao() {
        return (BaseDao<Album>) albumDao;
    }
    /**
     * @param 查询某用户的某相册内图片
     * @param album_id 相册Id
     * @return List<Album> 根据相册id查找的某相册的照片集合
     */
	@Override
	public List<Album> selectByAlbum_id(String album_id) {
		List<Album> albums=albumDao.selectByAlbum_id(album_id);
		return albums;
	}
}