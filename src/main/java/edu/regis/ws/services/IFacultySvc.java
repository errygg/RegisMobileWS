package edu.regis.ws.services;

import edu.regis.ws.models.Faculty;

public interface IFacultySvc {
	
	void save( Faculty faculty );
	void update( Faculty faculty );
	void delete( Faculty faculty );

}
