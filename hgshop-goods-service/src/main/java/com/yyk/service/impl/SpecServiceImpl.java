package com.yyk.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yyk.dao.SpecDao;
import com.yyk.entity.Spec;
import com.yyk.entity.SpecOption;
import com.yyk.service.SpecService;
@Service(interfaceClass=SpecService.class)
public class SpecServiceImpl implements SpecService {
	
	
	@Autowired
	private SpecDao specDao;

	/*@Override
	public int add(Spec spec) {
		//添加主表
		int result = specDao.addSpec(spec);//主键自动生成
		//插入子表
		List<Specoption> options = spec.getOptions();
		for (Specoption specoption : options) {
			//设置主键
			specoption.setSpecId(spec.getId());
			result+=specDao.addOption(specoption);
		}
			
		return result;
	}*/

	/*@Override
	public int delete(int[] ids) {
		//先删除子表
		int result = specDao.delOptions(ids);
		result+= specDao.delSpec(ids);
		
		
		return result;
	}*/

	/*@Override
	public int update(Spec spec) {
		//修改主表
		int result = specDao.update(spec);
		//删除子表,根据spec的id去删
		specDao.delOptions(spec.getId());
		//重新插入子表
		//插入子表
		List<Specoption> options = spec.getOptions();
		for (Specoption specoption : options) {
			//设置主键
			specoption.setSpecId(spec.getId());
			result+=specDao.addOption(specoption);
		}
		
		return result;
	}*/

	@Override
	public PageInfo<Spec> list(int pageNum, int pageSize, Spec spec) {
		PageHelper.startPage(pageNum, pageSize);
		return new PageInfo<Spec>(specDao.list(spec));
	}

	@Override
	public Spec getById(int id) {
		// TODO Auto-generated method stub
		return specDao.findById(id);
	}

	@Override
	public List<Spec> listAll() {
		// TODO Auto-generated method stub
		return specDao.listAll();
	}

}
