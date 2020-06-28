package com.yyk.dao;

import java.util.List;

import com.yyk.entity.CateGory;

public interface CategoryDao {
	
	public int add(CateGory category);
	
	public int update(CateGory category);
	
	public int del(int id);
	
	public List<CateGory> list(int parentId);

}
