package edu.regis.ws.models;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "programs"
})
@XmlRootElement(name = "Programs")
public class Programs {

	protected List<Program> programs;
	
	public List<Program> getPrograms() {
		if( programs == null ) {
			programs = new ArrayList<Program>();
		}
		return this.programs;
	}
}