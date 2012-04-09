package edu.regis.ws.models;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "schools"
})
@XmlRootElement(name = "Schools")
public class Schools {

	protected List<School> schools;
	
	public List<School> getSchools() {
		if( schools == null ) {
			schools = new ArrayList<School>();
		}
		return this.schools;
	}
}
