package edu.regis.ws.daos;

import edu.regis.ws.models.Faculty;

public interface FacultyDao {

	void save( Faculty faculty );
	void update( Faculty faculty );
	void delete( Faculty faculty );
	
}
