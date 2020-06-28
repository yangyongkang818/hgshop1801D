package com.yyk.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.yyk.dao.CategoryDao;
import com.yyk.entity.CateGory;
import com.yyk.service.BrandService;
import com.yyk.service.CategoryService;
@Service(interfaceClass=CategoryService.class)
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao catDao;
	
	@Override
	public int add(CateGory category) {
		// TODO Auto-generated method stub
		return catDao.add(category);
	}

	@Override
	public int update(CateGory category) {
		// TODO Auto-generated method stub
		return catDao.update(category);
	}

	@Override
	public int del(int id) {
		// TODO Auto-generated method stub
		return catDao.del(id);
	}

	@Override
	public  List<CateGory>  list(int parentId) {
		// TODO Auto-generated method stub
		return catDao.list(parentId);
	}

}
