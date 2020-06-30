package com.yyk.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yyk.entity.Sku;
import com.yyk.entity.SkuVo;
import com.yyk.entity.SpecOption;

public interface SkuDao {
	
	
	int insert(Sku sku);
	int insertSpecOption(@Param("skuId")  int id, @Param("opt") SpecOption specOption);


	int delete(int[] ids);
	int deleteSpecOption(int ...id);

	int update(Sku sku);	

	Sku findById(int id);
	List<Sku> list(SkuVo skuvo);

}
