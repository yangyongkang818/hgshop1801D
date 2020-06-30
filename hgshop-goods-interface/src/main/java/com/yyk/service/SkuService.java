package com.yyk.service;

import com.github.pagehelper.PageInfo;
import com.yyk.entity.Sku;
import com.yyk.entity.SkuVo;

public interface SkuService {
	
	int add(Sku sku);
	int update(Sku sku);
	int delete(int[] ids);

	PageInfo<Sku> list(SkuVo skuvo);

	Sku getById(int id);

}
