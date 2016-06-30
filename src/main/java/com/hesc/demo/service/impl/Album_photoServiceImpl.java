/*
 * AlbumService_photoImpl.java
 * Copyright(C) 2015 杭州天翼智慧城市科技有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-05 Created
 */
package com.hesc.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hesc.demo.dao.Album_photoDao;
import com.hesc.demo.pojo.Album_photo;
import com.hesc.demo.service.Album_photoService;
import com.hesc.trundle.db.dao.BaseDao;
import com.hesc.trundle.db.service.impl.BaseServiceImpl;
/**
 * @author huawangxin
 * @see 相册的 方法类
 */
@Service("album_photoService")
public class Album_photoServiceImpl extends BaseServiceImpl<Album_photo> implements Album_photoService {

    @Autowired
    private Album_photoDao album_photoDao;

    @SuppressWarnings("unchecked")
    @Override
    protected BaseDao<Album_photo> getBaseDao() {
        return (BaseDao<Album_photo>) album_photoDao;
    }
    /**
	 * @param 根据用户名获取相册集合
	 * @param userName 用户名
	 * @return List<Album_photo> 相册集合
	 */
	@Override
	public List<Album_photo> selectByName(String userName) {
		List<Album_photo> list=album_photoDao.selectByName(userName);
		return list;
	}
}