/*
 * UserController.java
 * Copyright(C) 2015 杭州天翼智慧城市科技有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-05 Created
 */
package com.hesc.demo.controller;

import java.util.GregorianCalendar;

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

import com.hesc.demo.pojo.Log;
import com.hesc.demo.pojo.User;
import com.hesc.demo.service.AlbumService;
import com.hesc.demo.service.LogService;
import com.hesc.demo.service.UserService;
/**
 * 
 * @author huawangxin
 * @see 用户的 controller
 *
 */
@Controller
@RequestMapping("/demo/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Resource(name="albumService")
    private AlbumService albumService;
    @Resource(name="logService")
    private LogService logService;
    /**
	 * @param 登录
	 * @param model 用户名
	 * @return 返回用户登录页面
	 */
    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String login(Model model,HttpSession session){
    	//session.invalidate();
    	model.addAttribute("user", new User());
        return "/demo/user/login";
    }
    /**
	 * @param 登录
     * @param name 用户名
     * @param password 密码
	 * @param model 用户
     * @throws Exception
	 * @return 返回用户登录页面
	 */
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String login(@Valid String name,String password,Model model,HttpSession session,HttpServletRequest req) throws Exception{
    	User user=new User();
    	user=userService.selectByName(name);
    	if(user!=null){
    		//判断是否密码一致
    		if(password.equals(user.getPassword())){
    			//添加用户登录日志
    			Log log=new Log();
    			log.setName(user.getName());
    			log.setOperation("登录成功");
    			logService.insert(log);
    			//System.out.println("111"+user.getName());
    			model.addAttribute("user", user);
    			session.setAttribute("user", user);
    			//name=new String(name.getBytes("gb2312"),"ISO-8859-1");
    			return "redirect:/demo/album_photo/list";
    		}
    	}
    	req.setAttribute("error", "用户名或密码错误 !");
    	model.addAttribute("user", new User());
    	return "/demo/user/login";
    }
    /**
	 * @param 新增用户
	 * @param model 用户名
	 * @return 返回用户新增页面
	 */
    @RequestMapping(value="/add", method=RequestMethod.GET)
    public String add(Model model){
          model.addAttribute("user", new User());
          return "/demo/user/add";
    }
    /**
	 * @param 新增用户
	 * @param user 用户实体
	 * @return 返回用户相册列表页面
	 */
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public String add(@Valid User user,Model model, BindingResult result,HttpSession session,HttpServletRequest req){
          if(result.hasErrors()){
                return "/demo/user/add";
          }
          /**
           * 判断用户名是否重复
           */
          String name=user.getName();
          User user_0=userService.selectByName(name);
          if(user_0!=null){
        	  //用户名重复
        	  req.setAttribute("error", "用户名已被占用!");
        	  //session.setAttribute("error", "用户名已被占用!");
        	  return "/demo/user/add";
          }
          userService.insert(user);
          //添加用户新增日志
          Log log=new Log();
		  log.setName(user.getName());
		  log.setOperation("注册成功");
		  logService.insert(log);
//		  //添加用户登录日志
//		  log.setOperation("登录成功");
//		  logService.insert(log);
		  model.addAttribute("user", user);
		  session.setAttribute("user", user);
		  return "redirect:/demo/album_photo/list";
    }

    /**
	 * @param 删除用户
	 * @param id 用户实体id
	 * @return 
	 */
    @RequestMapping(value="/{id}/delete", method=RequestMethod.GET)
    public String delete(@PathVariable String id){
    	  //添加用户删除日志
    	  User user=userService.selectById(id);
          Log log=new Log();
		  log.setName(user.getName());
		  log.setOperation("注册成功");
          userService.deleteById(id);
		  logService.insert(log);
          return "redirect:/demo/user/list";
    }

    /**
	 * @param 修改用户
	 * @param id 用户实体id
	 * @return 返回用户修改页面
	 */
    @RequestMapping(value="/{id}/update", method=RequestMethod.GET)
    public String update(@PathVariable String id, Model model,HttpSession session){
    	User user=userService.selectById(id);
    	session.setAttribute("user", user);
        model.addAttribute(userService.selectById(id));
        return "/demo/user/update";
    }
    /**
	 * @param 修改用户
	 * @param user 用户实体
	 * @return 返回用户修改页面
	 */
    @RequestMapping(value="/{id}/update", method=RequestMethod.POST)
    public String update(@Valid User user, BindingResult result,HttpSession session){
          if(result.hasErrors()){
                return "/demo/user/update";
          }
          userService.update(user);
          //添加用户新增日志
          Log log=new Log();
		  log.setName(user.getName());
		  log.setOperation("个人信息修改成功");
		  logService.insert(log);
          session.setAttribute("user", user);
          return "redirect:/demo/album_photo/list";
    }

    /**
	 * @param 查看列表
	 * @param user 用户实体
	 * @return 返回用户列表页面
	 */
    @RequestMapping(value="/list", method=RequestMethod.GET)
    public String list(Model model,User user){
    	//获取用户对象
        model.addAttribute("user", user);System.out.println(user.getName());
        //获取相册集合
        model.addAttribute("albumlist", albumService.selectList());
        return "/demo/user/list";
    }

    /**
	 * @param 查看列表
	 * @param id 用户实体id
	 * @return 返回用户修改页面
	 */
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public String show(@PathVariable String id, Model model){
          User user = (User)userService.selectById(id);
          model.addAttribute("user",user);
          return "/demo/user/show";
    }


}