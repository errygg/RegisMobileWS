package edu.regis.ws.rest;

import edu.regis.namespaces.schools.School;
import edu.regis.ws.db.SchoolDb;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

public class SchoolResource {
    
    private String id; 
    private School school;
    
    public SchoolResource(String id) {
        this.id = id;
        school = SchoolDb.getInstance().findById(id);
    }

    /**
     * Get a specific school object represented by the ID passed in the constructor.
     *
     * @return the School object that corresponds to the constructor ID.
     */
    @GET
    @Produces({"application/xml","application/json"})
    public School getSchool() {
    	return school;
    }

    /**
     * Update an existing School object. Note that the ID in the school object passed
     * as args must be the same as that which was passed as args in the URL.
     *
     * To create a School object, you must use the POST method in the SchoolsResource
     * class since creation must be idempotent.
     *
     * @param school the school object to create.
     * @return the updated School object.
     */
    @PUT
    @Consumes({"application/xml","application/json"})
    public JAXBElement<School> putSchool(JAXBElement<School> school) {
        SchoolDb.getInstance().updateSchool(id, school.getValue());
        return school;
    }

    /**
     * Remove a school from the database.
     */
    @DELETE
    public void deleteSchool() {
        SchoolDb.getInstance().deleteSchool(id);
    }
}

