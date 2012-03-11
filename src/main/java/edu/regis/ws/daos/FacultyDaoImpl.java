package edu.regis.ws.daos;

import org.springframework.stereotype.Repository;

import edu.regis.ws.daos.FacultyDao;
import edu.regis.ws.models.Faculty;
import edu.regis.ws.utils.CustomHibernateDaoSupport;

@Repository("facultyDao")
public class FacultyDaoImpl extends CustomHibernateDaoSupport implements FacultyDao{
 
	public void save( Faculty faculty ) {
		getHibernateTemplate().save( faculty );
	}
 
	public void update( Faculty faculty ) {
		getHibernateTemplate().update( faculty );
	}
 
	public void delete( Faculty faculty ) {
		getHibernateTemplate().delete( faculty );
	}
 
}
