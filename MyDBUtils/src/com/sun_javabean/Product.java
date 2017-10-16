package com.sun_javabean;
/**
 * JavaBean规范:
 * 1.必须提供私有四段
 * 2.必须为私有字段提供setter和getter方法
 * 3.提供无参构造
 * 4.实现序列化接口
 * 		implements Serializable
 * 
 * @author Sun
 *
 */
public class Product implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7750979935208645635L;
	
	private String pid;
	private String pname;
	private String price;
	private String category_id;
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCategory_id() {
		return category_id;
	}
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", category_id=" + category_id + "]";
	}
	
	
}
