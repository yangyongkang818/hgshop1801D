package com.yyk.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.yyk.entity.Brand;

/**
 * 品牌的管理
 * 
 * */
public interface BrandService {

	int add(Brand brand);
	int update(Brand brand);
	int delete(int[] ids);
	PageInfo<Brand> pageList(Brand brand);
	List<Brand> list();
	Brand getById(int id);
	
	
}
