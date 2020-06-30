package com.yyk.controller;

import java.util.List;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.yyk.entity.Brand;
import com.yyk.entity.Spu;
import com.yyk.entity.SpuVo;
import com.yyk.service.BrandService;
import com.yyk.service.SpuService;

@Controller
@RequestMapping("spu")
public class SpuController {

	@Reference
	private SpuService spuService;
	
	@Reference
	private BrandService brandService;
	
	@Autowired
	private HgFileUtils hgFileUtils;
	
	@RequestMapping("list")
	public String list(Model m,SpuVo vo){
		
		vo.setPageSize(10);
		
		PageInfo<Spu> info = spuService.list(vo);
		m.addAttribute("info", info);
		
		List<Brand> brandList = brandService.list();
		m.addAttribute("brandList", brandList);
		
		m.addAttribute("vo", vo);
		
		return "spu/list";
	}
	
	@RequestMapping("toadd")
	public String toadd(Model m) {

		// 得到所有的品牌
		List<Brand> brandList = brandService.list();
		m.addAttribute("brandList", brandList);



		return "spu/add";
	}
	
	@RequestMapping("add")
	@ResponseBody
	public boolean add(Model m,Spu spu,
			@RequestParam("myFile") MultipartFile file) {

		String uploadPath = hgFileUtils.upload(file);
		spu.setSmallPic(uploadPath);

		return spuService.add(spu)>0;

	}
	
	/**
	 * 删除数据
	 * */
	@RequestMapping("del")
	@ResponseBody
	public boolean del(Model m,Spu spu,@RequestParam("ids[]")int[] ids) {

		

		return spuService.delete(ids)>0;

	}
	/**
	 * 去修改获取数据回显
	 * */
	@RequestMapping("toUpdate")
	public String toUpdate(Model m,int id) {
		
		Spu spu = spuService.getById(id);
		m.addAttribute("spu", spu);
		
		// 得到所有的品牌
		List<Brand> brandList = brandService.list();
		m.addAttribute("brandList", brandList);

		return "spu/update";
	}
	
	/**
	 * 修改数据
	 * */
	@ResponseBody
	@RequestMapping("update")
	public boolean update(Model m,Spu spu,@RequestParam("myFile") MultipartFile file) {

		String uploadPath = hgFileUtils.upload(file);
		spu.setSmallPic(uploadPath);

		return spuService.update(spu)>0;

	}
	
	
	
	
}
