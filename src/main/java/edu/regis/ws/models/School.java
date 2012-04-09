package edu.regis.ws.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SchoolType")
@XmlRootElement(name = "School")
public class School {
	
	protected Integer id;
	protected String name;
	
	public Integer getId() {
		return id;
	}
	
	public void setId( Integer value ) {
		this.id = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName( String value ) {
		this.name = value;
	}

}
