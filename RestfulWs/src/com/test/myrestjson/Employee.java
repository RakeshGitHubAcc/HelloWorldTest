package com.test.myrestjson;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "employee")
public class Employee{
	
	@XmlAttribute(name = "id")
	private String id;
	
	@XmlElement(name = "name")
	private String name;
	
	@XmlElement(name = "company")
	private String company;
	
	public Employee(){
		
	}
	public Employee(String id,String name,String company){
	this.id=id;
	this.name=name;
	this.company=company;
	}
	/*public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}*/
}
