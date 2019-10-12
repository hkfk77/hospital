package com.zhiyou100.model;

public class Education {
	private int id;
	private String e_name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getE_name() {
		return e_name;
	}
	@Override
	public String toString() {
		return "Education [id=" + id + ", e_name=" + e_name + "]";
	}
	public void setE_name(String e_name) {
		this.e_name = e_name;
	}
	
}
