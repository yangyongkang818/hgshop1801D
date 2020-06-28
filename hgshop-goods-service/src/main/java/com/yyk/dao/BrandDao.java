package com.yyk.dao;

import java.util.List;

import com.yyk.entity.Brand;

public interface BrandDao {

	List<Brand> selectAll();

	Brand findById(int id);

}
