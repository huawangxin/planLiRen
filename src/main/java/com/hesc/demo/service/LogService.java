/*
 * LogService.java
 * Copyright(C) 2015 杭州天翼智慧城市科技有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-05 Created
 */
package com.hesc.demo.service;

import java.util.List;

import com.hesc.demo.pojo.Album;
import com.hesc.demo.pojo.Album_photo;
import com.hesc.demo.pojo.Log;
import com.hesc.demo.pojo.ToAlbum;
import com.hesc.demo.pojo.ToAlbum_photo;
import com.hesc.demo.pojo.ToLog;
import com.hesc.trundle.db.service.BaseService;

public interface LogService extends BaseService<Log> {
	/**
	 * 关键字找信息
	 * @param key
	 * @return
	 */
	public List<Log> searchList(String key);
	/**
	 * 将 毫秒数转换为 正常日期形式
	 * @param 日志对象
	 * @return 正常日期格式
	 */
	public List<ToLog> changeTime(List<Log> list);
	/**
	 * 将 毫秒数转换为 正常日期形式
	 * @param 相册对象
	 * @return 正常日期格式
	 */
	public List<ToAlbum_photo> changeTime_1(List<Album_photo> list);
	/**
	 * 将 毫秒数转换为 正常日期形式
	 * @param 照片对象
	 * @return 正常日期格式
	 */
	public List<ToAlbum> changeTime_2(List<Album> albumlist);
}