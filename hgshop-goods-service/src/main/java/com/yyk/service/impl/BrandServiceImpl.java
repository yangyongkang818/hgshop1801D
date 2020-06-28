package com.yyk.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageInfo;
import com.yyk.dao.BrandDao;
import com.yyk.entity.Brand;
import com.yyk.service.BrandService;
@Service(interfaceClass=BrandService.class)
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandDao brandDao;
	
	
	@Override
	public int add(Brand brand) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Brand brand) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageInfo<Brand> pageList(Brand brand) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Brand> list() {
		// TODO Auto-generated method stub
		return brandDao.selectAll();
	}

	@Override
	public Brand getById(int id) {
		// TODO Auto-generated method stub
		return brandDao.findById(id);
	}

}
