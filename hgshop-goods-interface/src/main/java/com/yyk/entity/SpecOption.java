package com.yyk.entity;

import java.io.Serializable;

public class SpecOption implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Integer id;
	String optionName;
	Integer specId; 
	String specName;
	Integer orders;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOptionName() {
		return optionName;
	}
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}
	public Integer getSpecId() {
		return specId;
	}
	public void setSpecId(Integer specId) {
		this.specId = specId;
	}
	public String getSpecName() {
		return specName;
	}
	public void setSpecName(String specName) {
		this.specName = specName;
	}
	public Integer getOrders() {
		return orders;
	}
	public void setOrders(Integer orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "Specoption [id=" + id + ", optionName=" + optionName + ", specId=" + specId + ", specName=" + specName
				+ ", orders=" + orders + "]";
	}
	public SpecOption(Integer id, String optionName, Integer specId, String specName, Integer orders) {
		super();
		this.id = id;
		this.optionName = optionName;
		this.specId = specId;
		this.specName = specName;
		this.orders = orders;
	}
	public SpecOption() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

}
