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
import com.yyk.entity.Sku;
import com.yyk.entity.SkuVo;
import com.yyk.entity.Spec;
import com.yyk.entity.SpecOption;
import com.yyk.entity.Spu;
import com.yyk.service.SkuService;
import com.yyk.service.SpecService;
import com.yyk.service.SpuService;

@Controller
@RequestMapping("sku")
public class SkuController {
	
	
	@Reference
	private SpuService spuService;
	
	@Reference
	private SkuService skuService;
	
	@Reference
	private SpecService specService;
	
	@Autowired
	private HgFileUtils fileUtils;
	
	@RequestMapping("list")
	public String list(Model m,SkuVo skuVo) {

		PageInfo<Sku> pageInfo = skuService.list(skuVo);

		m.addAttribute("pageInfo", pageInfo);
		m.addAttribute("skuVo", skuVo);
		
		return "sku/list";
	}
	/**
	 * 去添加
	 * */
	@RequestMapping("toAdd")
	public String toAdd(Model m,int spuId) {

		Spu spu = spuService.getById(spuId);
		m.addAttribute("spu", spu);

		List<Spec> specList = specService.listAll();
		m.addAttribute("specList", specList);

		return "sku/add";
	}
	
	/**
	 * 添加sku
	 * */
	@RequestMapping("add")
	@ResponseBody
	public String add(Model m,Sku sku,
			@RequestParam("imageFile") MultipartFile imageFile,
			@RequestParam("cartThumbnailFile") MultipartFile cartThumbnailFile ) {
		List<SpecOption> list = sku.getOptions();
		//数据清零一下
		 for (int i = list.size()-1; i >=0; i--) {
			SpecOption option = list.get(i);
			if(null == option.getSpecId() || 0==option.getSpecId()) {
				list.remove(i);
			}
		}
		// 处理图片
		 sku.setImage(fileUtils.upload(imageFile)); 
		 sku.setCartThumbnail(fileUtils.upload(cartThumbnailFile)); 

		return skuService.add(sku)>0?"ok":"failed";
	}
	
	
	/**
	 * 获取另一个下拉框的数据
	 * */
	@RequestMapping("getSpecOptions")
	@ResponseBody
	public List<SpecOption> getOptions(int specId){
		Spec spec = specService.getById(specId);
		if(spec==null)
			return null;
		return spec.getOptions();
	}
	
}
