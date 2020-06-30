package com.yyk.entity;
/**
 * 用于封装查询条件
 * */
public class SpuVo extends Spu{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int pageNum=1;//起始页
	private int pageSize=5;//每页显示多少

	//查询的关键字 只要name 或者 caption 当中有一个字段匹配即可
	private String key;
	// 排序方式
	private String orderType = "ASC";
	//排序的字段名称
	private String orderColumn="";
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public String getOrderColumn() {
		return orderColumn;
	}
	public void setOrderColumn(String orderColumn) {
		this.orderColumn = orderColumn;
	}
	@Override
	public String toString() {
		return "SpuVo [pageNum=" + pageNum + ", pageSize=" + pageSize + ", key=" + key + ", orderType=" + orderType
				+ ", orderColumn=" + orderColumn + "]";
	}
	public SpuVo(Integer id, String goodsName, int isMarketable, String caption, String smallPic, int categoryId,
			int brandId, CateGory category, Brand brand, int pageNum, int pageSize, String key, String orderType,
			String orderColumn) {
		super(id, goodsName, isMarketable, caption, smallPic, categoryId, brandId, category, brand);
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.key = key;
		this.orderType = orderType;
		this.orderColumn = orderColumn;
	}
	public SpuVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SpuVo(Integer id, String goodsName, int isMarketable, String caption, String smallPic, int categoryId,
			int brandId, CateGory category, Brand brand) {
		super(id, goodsName, isMarketable, caption, smallPic, categoryId, brandId, category, brand);
		// TODO Auto-generated constructor stub
	}
	
	
	
}
