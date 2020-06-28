package com.yyk.dao;

import java.util.List;

import com.yyk.entity.Spec;
import com.yyk.entity.SpecOption;

public interface SpecDao {

	//添加规格
	int addSpec(Spec spec);
	//添加规格子表
	int addOption(SpecOption specoption);
	//删除规格子表
	//int delOptions(int ...ids);
	//删除规格
	//int delSpec(int[] ids);
	//修改规格
	//int update(Spec spec);
	//查询规格
	List<Spec> list(Spec spec);
	//根据id查规格修改回显
	Spec findById(int id);

}
