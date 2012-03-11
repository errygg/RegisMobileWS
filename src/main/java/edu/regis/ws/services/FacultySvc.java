package edu.regis.ws.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.regis.ws.services.IFacultySvc;
import edu.regis.ws.daos.FacultyDao;
import edu.regis.ws.models.Faculty;

@Service("ifacultysvc")
public class FacultySvc implements IFacultySvc {
	
	@Autowired
	FacultyDao facultyDao;
	
	public void setFacultyDao( FacultyDao facultyDao ) {
		this.facultyDao = facultyDao;
	}
	
	public void save( Faculty faculty ) {
		facultyDao.save(faculty);
	}
	
	public void update( Faculty faculty ) {
		facultyDao.update( faculty );
	}
	
	public void delete( Faculty faculty ) {
		facultyDao.delete( faculty );
	}

}
