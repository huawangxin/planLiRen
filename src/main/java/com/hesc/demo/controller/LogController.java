/*
 * LogController.java
 * Copyright(C) 2015 杭州天翼智慧城市科技有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-05 Created
 */
package com.hesc.demo.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import com.hesc.demo.pojo.Log;
import com.hesc.demo.pojo.ToLog;
import com.hesc.demo.service.LogService;
import com.hesc.trundle.db.page.Page;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * 
 * @author huawangxin
 * @see 日志 controller
 *
 */
@Controller
@RequestMapping("/demo/log")
public class LogController {

    @Autowired
    private LogService logService;

    /**
	 * @param 新增
	 * @param model 日志
	 * @return 返回添加日志页面
	 */
    @RequestMapping(value="/add", method=RequestMethod.GET)
    public String add(Model model){
          model.addAttribute("log", new Log());
          return "/demo/log/add";
    }
    /**
	 * @param 新增
	 * @param log 日志
	 * @return 返回日志列表页面
	 */
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public String add(@Valid Log log, BindingResult result){
          if(result.hasErrors()){
                return "/demo/log/add";
          }
          logService.insert(log);
          return "redirect:/demo/log/list";
    }

    /**
	 * @param 删除
	 * @param id 日志id
	 * @return 返回日志列表页面
	 */
    @RequestMapping(value="/{id}/delete", method=RequestMethod.GET)
    public String delete(@PathVariable String id){
          logService.deleteById(id);
          return "redirect:/demo/log/list";
    }

    /**
	 * @param 修改
	 * @param model 日志
	 * @return 返回日志修改页面
	 */
    @RequestMapping(value="/{id}/update", method=RequestMethod.GET)
    public String update(@PathVariable String id, Model model){
         model.addAttribute(logService.selectById(id));
         return "/demo/log/update";
    }
    /**
	 * @param 修改
	 * @param log 日志
	 * @return 返回日志列表页面
	 */
    @RequestMapping(value="/{id}/update", method=RequestMethod.POST)
    public String update(@Valid Log log, BindingResult result){
          if(result.hasErrors()){
                return "/demo/log/update";
          }
          logService.update(log);
          return "redirect:/demo/log/list";
    }

    /**
	 * @param 查看列表
	 * @param model 日志
	 * @return 返回日志列表页面
	 */
    @RequestMapping(value="/list", method=RequestMethod.GET)
    public String list(Model model){
    	  Page<Log> pages=new Page<Log>(); 
    	  List<Log> list=logService.selectPageList(pages).getQueryList();
    	  List<ToLog> list_1=logService.changeTime(list);
    	  System.out.println(logService.selectPageList(pages));
    	  model.addAttribute("list_1", list_1);
          model.addAttribute("page", logService.selectPageList(pages));
          model.addAttribute("list", logService.selectPageList(pages).getQueryList());
          return "/demo/log/list";
    }
    /**
     * 下一页 和  尾页
     * @param model
     * @param req
     * @return
     */
    @RequestMapping(value="/listnext", method=RequestMethod.GET)
    public String listNext(Model model,HttpServletRequest req){
    	  int curPage=Integer.parseInt(req.getParameter("curPage"));
	      int pageCount=Integer.parseInt(req.getParameter("pageCount"));
    	  Page<Log> pages=new Page<Log>();
	      if(curPage<pageCount){
	    	 pages.setCurPage(++curPage);
	      }else{
	    	 pages.setCurPage(curPage);
	      }
	      List<Log> list=logService.selectPageList(pages).getQueryList();
    	  List<ToLog> list_1=logService.changeTime(list);
    	  model.addAttribute("list_1", list_1);
    	  System.out.println(logService.selectPageList(pages));
          model.addAttribute("page", logService.selectPageList(pages));
          model.addAttribute("list", logService.selectPageList(pages).getQueryList());
          return "/demo/log/list";
    }
    /**
     * 上一页 和  首页
     * @param model
     * @param req
     * @return
     */
    @RequestMapping(value="/listbefore", method=RequestMethod.GET)
    public String listBefore(Model model,HttpServletRequest req){
    	  int curPage=Integer.parseInt(req.getParameter("curPage"));
	      int pageCount=Integer.parseInt(req.getParameter("pageCount"));
    	  Page<Log> pages=new Page<Log>();
	      if(curPage>1){
	    	 pages.setCurPage(--curPage);
	      }else{
	    	 pages.setCurPage(curPage);
	      } 
	      List<Log> list=logService.selectPageList(pages).getQueryList();
    	  List<ToLog> list_1=logService.changeTime(list);
    	  model.addAttribute("list_1", list_1);
    	  System.out.println(logService.selectPageList(pages));
          model.addAttribute("page", logService.selectPageList(pages));
          model.addAttribute("list", logService.selectPageList(pages).getQueryList());
          return "/demo/log/list";
    }
    /**
	 * @param 模糊查询关键字
	 * @param key 关键字
	 * @throws UnsupportedEncodingException 
	 * @return 返回日志列表页面
	 */
    @RequestMapping(value="/search", method=RequestMethod.GET)
    public String search(String key,Model model,HttpServletRequest req) throws UnsupportedEncodingException{
    	key=new String(key.getBytes("ISO-8859-1"),"utf-8");
    	List<Log> list=logService.searchList('%'+key+'%');
        Page<Log> pages=new Page<Log>();
  	  	pages.setCurPage(1);
  	  	pages.setPageCount(1);
  	  	pages.setPageSize(list.size());
  	  	pages.setQueryList(list);
  	  	List<ToLog> list_1=logService.changeTime(list);
  	  	model.addAttribute("list_1", list_1);
        model.addAttribute("page", pages);
        model.addAttribute("list", pages.getQueryList());
        return "/demo/log/list";
    }
    /**
   	 * @param 查看详情
   	 * @param id 日志id 
   	 * @return 返回日志列表页面
   	 */
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public String show(@PathVariable String id, Model model){
          Log log = (Log)logService.selectById(id);
          model.addAttribute("log",log);
          return "/demo/log/show";
    }
    

}