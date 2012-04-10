package edu.regis.ws.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SchoolType")
@XmlRootElement(name = "School")
public class Program {
	
	protected Integer id;
	protected String name;
	protected Integer schoolId;
	protected String type;
	
    public Integer getId() {
        return id;
    }

    public void setId(Integer value) {
        this.id = value;
    }
    
	public String getName() {
		return name;
	}
	
	public void setName( String value ) {
		this.name = value;
	}
	
    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer value) {
        this.schoolId = value;
    }
    
	public String getType() {
		return type;
	}
	
	public void setType( String value ) {
		this.type = value;
	}	

}
