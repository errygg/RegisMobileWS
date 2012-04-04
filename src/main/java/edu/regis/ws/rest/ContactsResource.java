package edu.regis.ws.rest;

import edu.regis.namespaces.contacts.Contacts;
import edu.regis.ws.db.ContactDb;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/contacts")
public class ContactsResource {

    /**
     * Get a list of the contacts registered in the system.
     *
     * @return a list of all existing Contacts
     */
	@GET
    public synchronized Contacts getAll() {
        Contacts contacts = new Contacts();
        contacts.getContacts().addAll(ContactDb.getInstance().getContacts());
    	System.out.println("Contacts: " + contacts.getContacts());
        return contacts;
    }

    /**
     * Get a list of the contacts matching either a first name or
     * last name based on the query parameter.
     * 
     * @param firstName
     * @param lastName
     * @return a list of Contacts
     */
    @GET
    @Path("/search")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Contacts getContacts( @QueryParam("first_name") String firstName,
    		                     @QueryParam("last_name") String lastName ) {
    	Contacts contacts = new Contacts();
    	if( firstName != null ) {
    	    contacts.getContacts().addAll(ContactDb.getInstance().findByFirstName(firstName));
    	} else {
    		contacts.getContacts().addAll(ContactDb.getInstance().findByLastName(lastName));
    	}
    	return contacts;
    }
    
    /**
     * Do something with a contact that exists in the system. We expect the ID
     * to be supplied on the path. Delegate processing to the ContactResource object.
     * 
     * @param contactid the ID of the Contact
     * @return a ContactResource object that processes the request
     */
    @Path("/id/{id}/")
    public ContactResource getContact(@PathParam("id") String contactid) {
        return new ContactResource(contactid);
    }
}
