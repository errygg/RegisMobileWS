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

    @Context private UriInfo uriInfo;
    @Context private Request request;
    
    private String id; 
    private School contact;
    
    public SchoolResource(String id) {
        this.id = id;
        contact = SchoolDb.getInstance().findById(id);
    }

    /**
     * Get a specific contact object represented by the ID passed in the constructor.
     *
     * @return the Contact object that corresponds to the constructor ID.
     */
    @GET
    @Produces({"application/xml","application/json"})
    public School getContact() {
    	return contact;
    }

    /**
     * Update an existing Contact object. Note that the ID in the contact object passed
     * as args must be the same as that which was passed as args in the URL.
     *
     * To create a Contact object, you must use the POST method in the ContactsResource
     * class since creation must be idempotent.
     *
     * @param contact the contact object to create.
     * @return the updated Contact object.
     */
    @PUT
    @Consumes({"application/xml","application/json"})
    public JAXBElement<School> putContact(JAXBElement<School> contact) {
        SchoolDb.getInstance().updateSchool(id, contact.getValue());
        return contact;
    }

    /**
     * Remove a contact from the database.
     */
    @DELETE
    public void deleteContact() {
        SchoolDb.getInstance().deleteSchool(id);
    }
}
