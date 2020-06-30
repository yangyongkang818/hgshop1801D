package com.yyk.service;

import com.github.pagehelper.PageInfo;
import com.yyk.entity.Spu;
import com.yyk.entity.SpuVo;
/**
 * Spu管理
 * */
public interface SpuService {
	
	int add(Spu spu);//添加
	int update(Spu spu);//修改
	int delete(int[] ids);//删除
	PageInfo<Spu> list(SpuVo spuvo);//分页
	Spu getById(int id);//根据id回显数据

}
