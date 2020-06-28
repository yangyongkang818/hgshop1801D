package com.yyk.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yyk.entity.CateGory;
import com.yyk.service.CategoryService;
@Controller
@RequestMapping("cat")
public class CateGoryController {
	
	@Reference
	private CategoryService catService;

	/**
	 * 跳转到jsp 页面进行渲染
	 * @return
	 */
	@RequestMapping("index")
	public String index() {
		return "cat/index";
	}
	
	/**
	 * 
	 * @param requrt
	 * @param cat
	 * @return
	 */
	@RequestMapping("add")
	@ResponseBody
	public String add(HttpServletRequest requrt,CateGory cat) {
		return catService.add(cat)>0?"ok":"failed";
	}
	
	
	/**
	 * 修改
	 * @param requrt
	 * @param cat
	 * @return
	 */
	@RequestMapping("update")
	@ResponseBody
	public String update(HttpServletRequest requrt,CateGory cat) {
		return catService.update(cat)>0?"ok":"failed";
	}
	
	/**
	 * 删除
	 * @param requrt
	 * @param id
	 * @return
	 */
	@RequestMapping("delete")
	@ResponseBody
	public String delete(HttpServletRequest requrt,int id) {
		return catService.del(id)>0?"ok":"failed";
	}
	
	
	
	@RequestMapping("data")
	@ResponseBody
	public List<CateGory> getData(){
		// 获取到所有分类的数据
		 List<CateGory> categories = catService.list(0);
		 return categories;
		
	}
	
	
}
