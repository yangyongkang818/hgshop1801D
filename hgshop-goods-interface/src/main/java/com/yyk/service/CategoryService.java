package com.yyk.service;

import java.util.List;

import com.yyk.entity.CateGory;

public interface CategoryService {
	
	public int add(CateGory cat);
	
	public int update(CateGory category);
	
	public int del(int id);
	
	public List<CateGory> list(int parentId);

}
