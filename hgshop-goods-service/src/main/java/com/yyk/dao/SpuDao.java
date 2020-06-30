package com.yyk.dao;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.yyk.entity.Spu;
import com.yyk.entity.SpuVo;

public interface SpuDao {
	
	
	int add(Spu spu);//添加
	int update(Spu spu);//修改
	int delete(int[] ids);//删除
	List<Spu> list(SpuVo spuvo);//分页
	Spu findById(int id);//根据id回显数据

}
