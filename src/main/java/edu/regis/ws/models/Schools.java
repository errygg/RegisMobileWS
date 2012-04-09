package edu.regis.ws.models;

import java.util.ArrayList;
import java.util.List;

public class Schools {

	protected List<School> schools;
	
	public List<School> getSchools() {
		if( schools == null ) {
			schools = new ArrayList<School>();
		}
		return this.schools;
	}
}
