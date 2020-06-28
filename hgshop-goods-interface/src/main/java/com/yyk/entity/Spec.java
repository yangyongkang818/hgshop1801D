package com.yyk.entity;

import java.io.Serializable;
import java.util.List;
/**
 * 规格实体类
 * 
 * */
public class Spec implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Integer id;
	String specName;
	
	List<SpecOption> options;
	
	
	public List<SpecOption> getOptions() {
		return options;
	}
	public void setOptions(List<SpecOption> options) {
		this.options = options;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSpecName() {
		return specName;
	}
	public void setSpecName(String specName) {
		this.specName = specName;
	}
	
	public Spec(Integer id, String specName, List<SpecOption> options) {
		super();
		this.id = id;
		this.specName = specName;
		this.options = options;
	}
	@Override
	public String toString() {
		return "Spec [id=" + id + ", specName=" + specName + ", options=" + options + "]";
	}
	public Spec() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


}
