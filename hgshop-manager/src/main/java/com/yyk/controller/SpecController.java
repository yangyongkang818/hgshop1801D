package com.yyk.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.yyk.entity.Spec;
import com.yyk.service.SpecService;
@Controller
@RequestMapping("spec")
public class SpecController {
	
	@Reference
	private SpecService specService;
	
	@PostMapping("add")
	@ResponseBody
	public String add(Spec spec){
		
		return "";
	}
	
	/**
	 * 列表
	 * @param request
	 * @param name
	 * @param page
	 * @return
	 */
	@RequestMapping("list")
	public String list(Model m,@RequestParam(defaultValue = "") String name,@RequestParam(defaultValue = "1") int page) {
		Spec spec = new Spec();
		spec.setSpecName(name);
		PageInfo<Spec> info = specService.list(page, 5, spec);
		m.addAttribute("info", info);
		return "spec/list";
	}

}
