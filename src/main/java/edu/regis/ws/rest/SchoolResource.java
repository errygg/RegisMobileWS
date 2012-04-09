package edu.regis.ws.rest;

import edu.regis.ws.models.School;
import edu.regis.ws.db.SchoolDb;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class SchoolResource {
    
    private School school;
    
    public SchoolResource(String id) {
        school = SchoolDb.getInstance().findById(id);
    }

    /**
     * Get a specific school object represented by the ID passed in the constructor.
     *
     * @return the School object that corresponds to the constructor ID.
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public School getSchool() {
    	return school;
    }
}

