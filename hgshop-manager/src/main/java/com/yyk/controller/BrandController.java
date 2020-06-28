package com.yyk.controller;

import java.util.List;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yyk.entity.Brand;
import com.yyk.service.BrandService;

@Controller
@RequestMapping("brand")
public class BrandController {
	
	@Reference
	private BrandService brandService;
	
	@RequestMapping("/list")
	public String list(Model m){
		
		List<Brand> list = brandService.list();
		
		m.addAttribute("list", list);
		
		for (Brand brand : list) {
			System.out.println(brand);
		}
		
		return "brand/list";
	}

}
