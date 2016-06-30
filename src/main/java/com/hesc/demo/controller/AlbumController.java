/*
 * AlbumController.java
 * Copyright(C) 2015 杭州天翼智慧城市科技有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-05 Created
 */
package com.hesc.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import net.sf.json.JSONArray;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hesc.demo.pojo.Album;
import com.hesc.demo.pojo.Album_photo;
import com.hesc.demo.pojo.Log;
import com.hesc.demo.pojo.ToAlbum;
import com.hesc.demo.pojo.ToLog;
import com.hesc.demo.pojo.User;
import com.hesc.demo.service.AlbumService;
import com.hesc.demo.service.Album_photoService;
import com.hesc.demo.service.LogService;
import com.hesc.demo.service.UserService;
/**
 * @author huawangxin
 * @see 照片的 controller
 */
@Controller
@RequestMapping("/demo/album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;
    @Resource(name="album_photoService")
    private Album_photoService album_photoService;
    @Resource(name="userService")
    private UserService userService;
    @Resource(name="logService")
    private LogService logService;
    //上传图片路径
    public  String fileDir =
        	"D:/tomcat/apache-tomcat-7.0.54/webapps/project-base/images/load/";
    private String uploadPath = "D:/tomcat/apache-tomcat-7.0.54/webapps/project-base/images/load/"; // 上传文件的目录
    //临时路径
    private String tempPath = "D:/tomcat/apache-tomcat-7.0.54/webapps/project-base/images/temp/"; // 临时文件目录
    //上传图片类型
    private String[] fileType = new String[]{".jpg",".gif",".bmp",".png",".jpeg",".ico"};
    /**
     * @param 新增
     * @param model
     * @return 新增照片页面
    */
    @RequestMapping(value="/add", method=RequestMethod.GET)
    public String add(Model model,HttpSession session){
    	Album_photo album_photo = (Album_photo)session.getAttribute("album_photo");
    	Album album=new Album();
    	album.setName(album_photo.getName());
    	album.setAlbum_id(album_photo.getId());
    	album.setAlbum_name(album_photo.getAlbum_name());
    	model.addAttribute("album", album);
    	return "/demo/album/add";
    }
    /**
     * @param 新增
     * @param model
     * @return 照片列表页面
    */
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public String add(@Valid Album album, BindingResult result,HttpSession session){
          if(result.hasErrors()){
                return "/demo/album/add";
          }
          albumService.insert(album);
          //添加照片日志
          Log log=new Log();
          User user = (User) session.getAttribute("user");
		  log.setName(user.getName());
		  log.setOperation(album.getPicture_name()+"照片添加成功");
		  logService.insert(log);
          return "redirect:/demo/album/list";
    }
    
    /**
     * @param 上传图片
     * @throws  ServletException, IOException 
     * @return 返回添加照片页面
     */
    @RequestMapping(value="/addImage", method=RequestMethod.POST)
    @ResponseBody
    public void addImage(HttpServletRequest request, HttpServletResponse response,HttpSession session)  
            throws ServletException, IOException {  
        response.setContentType("text/html");     
        response.setCharacterEncoding("UTF-8");
        List<String> list=new ArrayList<>();
        try {  
        //判断路径是否存在，不存在则创建  
        	uploadPath = request.getSession().getServletContext().getRealPath("/")+"images/load/";
        	//备份文件地址
        	String basedir="D:/Workspace/project-base/src/main/webapp/images/load/";
        if(!new File(uploadPath).isDirectory()){
			new File(uploadPath).mkdirs();
		}
		if(!new File(tempPath).isDirectory()){
			new File(tempPath).mkdirs();
		}
        
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(5*1024); //最大缓存
		factory.setRepository(new File(tempPath));//临时文件目录
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(3*1024*1024);//文件最大上限
		
		String filePath = null;
		try {
			List<FileItem> items = upload.parseRequest(request);//获取所有文件列表
			for (FileItem item : items) {
				//获得文件名，这个文件名包括路径
				if(!item.isFormField()){
					//文件名
					String fileName = item.getName().toLowerCase();
					
					if(fileName.endsWith(fileType[0])||fileName.endsWith(fileType[1])||fileName.endsWith(fileType[2])||fileName.endsWith(fileType[3])||fileName.endsWith(fileType[4])||fileName.endsWith(fileType[5])){
						String uuid = UUID.randomUUID().toString();
						filePath = uploadPath+uuid+fileName.substring(fileName.lastIndexOf("."));
						item.write(new File(filePath));
						String urls=uuid+fileName.substring(fileName.lastIndexOf("."));//文件名加后缀
						//workspace中备份
						basedir=basedir+uuid+fileName.substring(fileName.lastIndexOf("."));
						//item.write(new File(basedir));
						//System.out.println("urls:-------------"+urls);
						list.add(urls);
			            JSONArray js = JSONArray.fromObject(list);
			            //System.out.println(js.toString());
			            response.getWriter().print(js.toString());
			            response.getWriter().close();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}}catch(Exception ee) { 
            ee.printStackTrace();  
        } 
    }
    /**
     * @param 删除
     * @param id 照片id
     * @throws  ServletException, IOException 
     * @return 返回照片列表页面
     */
    @RequestMapping(value="/{id}/delete", method=RequestMethod.GET)
    public String delete(@PathVariable String id,HttpSession session){
          //删除照片日志
          Log log=new Log();
          Album album=albumService.selectById(id);
          User user = (User) session.getAttribute("user");
		  log.setName(user.getName());
		  log.setOperation(album.getPicture_name()+"照片删除成功");
          albumService.deleteById(id);
		  logService.insert(log);
          return "redirect:/demo/album/list";
    }

     /**
     * @param 修改
     * @param id 照片id
     * @throws  ServletException, IOException 
     * @return 返回修改照片页面
     */
    @RequestMapping(value="/{id}/update", method=RequestMethod.GET)
    public String update(@PathVariable String id, Model model){
    	 model.addAttribute("album",albumService.selectById(id));
         return "/demo/album/update";
    }
    /**
     * @param 修改
     * @param album 照片实体类
     * @throws  ServletException, IOException 
     * @return 返回照片列表页面
     */
    @RequestMapping(value="/{id}/update", method=RequestMethod.POST)
    public String update(@Valid Album album, BindingResult result,HttpSession session){
          if(result.hasErrors()){
                return "/demo/album/update";
          }
          albumService.update(album);
          //修改照片日志
          Log log=new Log();
          User user = (User) session.getAttribute("user");
		  log.setName(user.getName());
		  log.setOperation(album.getPicture_name()+"照片修改成功");
		  logService.insert(log);
          return "redirect:/demo/album/list";
    }

    /**
     * @param 查看列表
     * @param model 照片实体类
     * @throws  ServletException, IOException 
     * @return 返回照片列表页面
     */
    @RequestMapping(value="/list", method=RequestMethod.GET)
    public String list(Model model,HttpServletRequest req,HttpSession session){
    	  Album_photo album_photo = (Album_photo)session.getAttribute("album_photo");
    	  String album_id=album_photo.getId();
    	  List<Album> albumlist=albumService.selectByAlbum_id(album_id);
    	  
    	  List<ToAlbum> list_1=logService.changeTime_2(albumlist);
    	  model.addAttribute("albumlist_1", list_1);
    	  
          model.addAttribute("albumlist",albumlist );
          return "/demo/album/list";
    }


}