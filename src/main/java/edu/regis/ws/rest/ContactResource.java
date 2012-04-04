package edu.regis.ws.rest;

import edu.regis.namespaces.contacts.Contact;
import edu.regis.ws.db.ContactDb;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class ContactResource {
    
    private Contact contact;
    
    public ContactResource(String id) {
        contact = ContactDb.getInstance().findById(id);
    }

    /**
     * Get a specific contact object represented by the ID passed in the constructor.
     *
     * @return the Contact object that corresponds to the constructor ID.
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public synchronized Contact getContact() {
    	return contact;
    }
}
