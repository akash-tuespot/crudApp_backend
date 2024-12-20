package com.example.demo.entity;

public class ProductDTO {
	private Integer id;
	private String name;
	private String descr;

	public ProductDTO(Integer id, String name, String desc) {
		super();
		this.id = id;
		this.name = name;
		this.descr = desc;
	}

	public ProductDTO() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}


}
