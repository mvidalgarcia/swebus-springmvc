package com.miw.model;

public class City {
	public City(Integer id, String name, String uri) {
		this.id = id;
		this.name = name;
		this.uri = uri;
	}
	private Integer id;
	private String name;
	private String uri;
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
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", uri=" + uri + "]";
	}
	
	

}
