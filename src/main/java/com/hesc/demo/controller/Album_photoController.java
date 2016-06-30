/*
 * AlbumController.java
 * Copyright(C) 2015 杭州天翼智慧城市科技有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-05 Created
 */
package com.hesc.demo.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hesc.demo.pojo.Album_photo;
import com.hesc.demo.pojo.Log;
import com.hesc.demo.pojo.ToAlbum_photo;
import com.hesc.demo.pojo.ToLog;
import com.hesc.demo.pojo.User;
import com.hesc.demo.service.Album_photoService;
import com.hesc.demo.service.LogService;
import com.hesc.demo.service.UserService;
/**
 * @author huawangxin
 * @see 相册的 controller
 */
@Controller
@RequestMapping("/demo/album_photo")
public class Album_photoController {

    @Autowired
    private Album_photoService album_photoService;
    @Resource(name="userService")
    private UserService userService;
    @Resource(name="logService")
    private LogService logService;
    /**
     * @param 新增相册
     * @param model 相册实体类
     * @return 新增相册页面
     * @throws Exception 
    */
    @RequestMapping(value="/add", method=RequestMethod.GET)
    public String add(Model model,HttpServletRequest req,HttpSession session) throws Exception{
    	  User user = (User) session.getAttribute("user");
    	  String name=user.getName();
    	  //String name=new String(req.getParameter("name").getBytes("ISO-8859-1"),"utf-8");
    	  model.addAttribute("name", name);
    	  model.addAttribute("album_photolist", new Album_photo());
          return "/demo/album_photo/add";
    }
    /**
     * @param 新增相册返回
     * @param album_photo 相册实体类
     * @return 相册列表页面
     * @throws Exception 
    */
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public String add(@Valid Album_photo album_photo,HttpSession session, BindingResult result) throws Exception{
          if(result.hasErrors()){
                return "/demo/album_photo/add";
          }
          User user = (User) session.getAttribute("user");
          String name = user.getName();
          album_photo.setName(name);
          album_photoService.insert(album_photo);
          //添加用户新增相册日志
          Log log=new Log();
		  log.setName(user.getName());
		  log.setOperation(album_photo.getAlbum_name()+"相册添加成功");
		  logService.insert(log);
    	  return "redirect:/demo/album_photo/list";
    }

    /**
     * @param 删除相册
     * @param id 相册ID
     * @return 相册列表页面
     * @throws Exception 
    */
    @RequestMapping(value="/{id}/delete", method=RequestMethod.GET)
    public String delete(@PathVariable String id,HttpSession session){
          //添加用户删除相册日志
          User user = (User) session.getAttribute("user");
          Album_photo album_photo=album_photoService.selectById(id);
          Log log=new Log();
		  log.setName(user.getName());
		  log.setOperation(album_photo.getAlbum_name()+"相册删除成功");
          album_photoService.deleteById(id);
		  logService.insert(log);
          return "redirect:/demo/album_photo/list";
    }

    /**
     * @param 更新相册
     * @param id 相册ID
     * @param model 相册实体类
     * @return 相册列表页面
     * @throws Exception 
    */
    @RequestMapping(value="/{id}/update", method=RequestMethod.GET)
    public String update(@PathVariable String id, Model model){
         model.addAttribute("album_photolist",album_photoService.selectById(id));
         return "/demo/album_photo/update";
    }
    /**
     * @param 更新相册
     * @param album_photo 相册实体类
     * @return 相册列表页面
     * @throws Exception 
     */
    @RequestMapping(value="/{id}/update", method=RequestMethod.POST)
    public String update(@Valid Album_photo album_photo, BindingResult result,HttpSession session){
          if(result.hasErrors()){
                return "/demo/album/update";
          }
          album_photoService.update(album_photo);
          //修改相册日志
          Log log=new Log();
          User user = (User) session.getAttribute("user");
		  log.setName(user.getName());
		  log.setOperation(album_photo.getAlbum_name()+"相册修改成功");
		  logService.insert(log);
          return "redirect:/demo/album_photo/list";
    }

    /**
     * @param 用户登陆后查看列表
     * @param model 相册实体类
     * @return 相册列表页面
     * @throws Exception 
     */
    @RequestMapping(value="/list", method=RequestMethod.GET)
    public String list(Model model,HttpServletRequest req,HttpSession session) throws Exception{
    	  User user = (User) session.getAttribute("user");
    	  model.addAttribute("user", user);
    	  /**
    	   * 获取当前用户的相册集合
    	   */
    	  List<Album_photo> list=album_photoService.selectByName(user.getName());
    	  
    	  List<ToAlbum_photo> list_1=logService.changeTime_1(list);
    	  model.addAttribute("album_photolist_1", list_1);
    	  
          model.addAttribute("album_photolist", list);
          return "/demo/album_photo/list";
    }

    /**
     * @param 查看详情
     * @param id 相册id
     * @param model 相册实体类
     * @return 某相册页面
     * @throws Exception 
     */
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public String show(@PathVariable String id, Model model,HttpSession session){
          Album_photo album_photo = (Album_photo)album_photoService.selectById(id);
          session.setAttribute("album_photo", album_photo);
          model.addAttribute("album_photo",album_photo);
          return "redirect:/demo/album/list";
    }


}