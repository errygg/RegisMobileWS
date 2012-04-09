package edu.regis.ws.rest;

import edu.regis.ws.models.Schools;
import edu.regis.ws.db.SchoolDb;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/schools")
public class SchoolsResource {

    /**
     * Get a list of the schools registered in the system.
     *
     * @return a list of Schools
     */
	@GET
    public Schools getAll() {
        Schools schools = new Schools();
        schools.getSchools().addAll(SchoolDb.getInstance().getSchools());
    	System.out.println("Schools: " + schools.getSchools());
        return schools;
    }
    
    /**
     * Do something with a school that exists in the system. We expect the ID
     * to be supplied on the path. Delegate processing to the SchoolResource object.
     * 
     * @param schoolid the ID of the School
     * @return a SchoolResource object that processes the request
     */
    @Path("/id/{id}/")
    public SchoolResource getSchool(@PathParam("id") String id) {
        return new SchoolResource(id);
    }
}
