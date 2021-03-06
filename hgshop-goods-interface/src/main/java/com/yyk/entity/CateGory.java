package com.yyk.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 分类
 * */
public class CateGory implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Integer id;
	Integer parentId;
	@JsonProperty("text")
	String name;
	String path;
	@JsonProperty("nodes")
	List<CateGory> children;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public List<CateGory> getChildren() {
		return children;
	}
	public void setChildren(List<CateGory> children) {
		this.children = children;
	}
	@Override
	public String toString() {
		return "CateGory [id=" + id + ", parentId=" + parentId + ", name=" + name + ", path=" + path + ", children="
				+ children + "]";
	}
	public CateGory(Integer id, Integer parentId, String name, String path, List<CateGory> children) {
		super();
		this.id = id;
		this.parentId = parentId;
		this.name = name;
		this.path = path;
		this.children = children;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((children == null) ? 0 : children.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((parentId == null) ? 0 : parentId.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CateGory other = (CateGory) obj;
		if (children == null) {
			if (other.children != null)
				return false;
		} else if (!children.equals(other.children))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (parentId == null) {
			if (other.parentId != null)
				return false;
		} else if (!parentId.equals(other.parentId))
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		return true;
	}
	public CateGory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
