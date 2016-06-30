/*
 * LogServiceImpl.java
 * Copyright(C) 2015 杭州天翼智慧城市科技有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-05 Created
 */
package com.hesc.demo.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.hesc.demo.dao.LogDao;
import com.hesc.demo.pojo.Album;
import com.hesc.demo.pojo.Album_photo;
import com.hesc.demo.pojo.Log;
import com.hesc.demo.pojo.ToAlbum;
import com.hesc.demo.pojo.ToAlbum_photo;
import com.hesc.demo.pojo.ToLog;
import com.hesc.demo.service.LogService;
import com.hesc.trundle.db.dao.BaseDao;
import com.hesc.trundle.db.service.impl.BaseServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 
 * @author huawangxin
 * @see 软件操作用户日志 方法实现类
 *
 */
@Service("logService")
public class LogServiceImpl extends BaseServiceImpl<Log> implements LogService {

    @Autowired
    private LogDao logDao;

    @SuppressWarnings("unchecked")
    @Override
    protected BaseDao<Log> getBaseDao() {
        return (BaseDao<Log>) logDao;
    }
    /**
	 * @param 关键字找信息
	 * @param key 要搜索的关键字
	 * @return List<Log> 返回关键字key所对应的日志记录log集合
	 */
	@Override
	public List<Log> searchList(String key) {
		List<Log> list=logDao.searchList(key);
		return list;
	}
	/**
	 * 将 毫秒数转换为 正常日期形式
	 * @param list
	 * @return 正常日期格式
	 */
	@Override
	public List<ToLog> changeTime(List<Log> list) {
		List<ToLog> list_1=new ArrayList();
		ToLog toLog=new ToLog();
		Date dat=new Date();
		GregorianCalendar gc = new GregorianCalendar();
		for(Log log:list){
			long sd=log.getCreateTime();
			dat=new Date(sd);
			gc.setTime(dat);
			java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String sb=format.format(gc.getTime());
			toLog.setCreateTime(sb);
			toLog.setId(log.getId());
			toLog.setName(log.getName());
			toLog.setOperation(log.getOperation());
			toLog.setSort(log.getSort());
			toLog.setState(log.getState());
			list_1.add(toLog);
		}
		return list_1;
	}
	/**
	 * 将 毫秒数转换为 正常日期形式
	 * @param 相册对象
	 * @return 正常日期格式
	 */
	@Override
	public List<ToAlbum_photo> changeTime_1(List<Album_photo> list) {
		List<ToAlbum_photo> list_1=new ArrayList();
		ToAlbum_photo toAlbum_photo=new ToAlbum_photo();
		Date dat=new Date();
		GregorianCalendar gc = new GregorianCalendar();
		for(Album_photo album_photo:list){
			long sd=album_photo.getCreateTime();
			dat=new Date(sd);
			gc.setTime(dat);
			java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String sb=format.format(gc.getTime());
			toAlbum_photo.setCreateTime(sb);
			toAlbum_photo.setId(album_photo.getId());
			toAlbum_photo.setAlbum_name(album_photo.getAlbum_name());
			toAlbum_photo.setDescription(album_photo.getDescription());
			toAlbum_photo.setName(album_photo.getName());
			toAlbum_photo.setSort(album_photo.getSort());
			toAlbum_photo.setState(album_photo.getState());
			list_1.add(toAlbum_photo);
		}
		return list_1;
	}
	/**
	 * 将 毫秒数转换为 正常日期形式
	 * @param 照片对象
	 * @return 正常日期格式
	 */
	@Override
	public List<ToAlbum> changeTime_2(List<Album> list) {
		List<ToAlbum> list_1=new ArrayList();
		ToAlbum toAlbum=new ToAlbum();
		Date dat=new Date();
		GregorianCalendar gc = new GregorianCalendar();
		for(Album album:list){
			long sd=album.getCreateTime();
			dat=new Date(sd);
			gc.setTime(dat);
			java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String sb=format.format(gc.getTime());
			toAlbum.setCreateTime(sb);
			toAlbum.setAlbum_id(album.getAlbum_id());
			toAlbum.setAlbum_name(album.getAlbum_name());
			toAlbum.setDescription(album.getDescription());
			toAlbum.setId(album.getId());
			toAlbum.setName(album.getName());
			toAlbum.setPicture_name(album.getPicture_name());
			toAlbum.setSort(album.getSort());
			toAlbum.setState(album.getState());
			toAlbum.setUrl(album.getUrl());
			list_1.add(toAlbum);
		}
		return list_1;
	}
}