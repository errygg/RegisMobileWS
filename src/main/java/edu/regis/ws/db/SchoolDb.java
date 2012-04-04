package edu.regis.ws.db;

import edu.regis.namespaces.schools.School;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SchoolDb {
	
	private static final SchoolDb instance = new SchoolDb();
	
	private Map<String, School> schools = new HashMap<String, School>();
	private int schoolIdx = 0;
	
	public static SchoolDb getInstance() {
		return instance;
	}
	
	private SchoolDb() {
		
		School school1 = new School();
		school1.setName("School of Computer and Information Sciences");
		addSchool(school1);
		
	}
	
	public List<School> getSchools() {
		return new ArrayList<School>(schools.values());
	}
	
	public School findById( String id ) {
		return schools.get(id);
	}
	
	public synchronized void addSchool( School school ) {
		
		int id = schoolIdx++;
		schools.put( Integer.toString(id), school );
		school.setId(id);
	
	}
	
	public synchronized void updateSchool( String id, School school ) {
		schools.put( id, school );
	}
	
	public synchronized void deleteSchool( String id ) {
		schools.remove(id);
	}

}
