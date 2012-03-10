package edu.regis.ws.rest;

import edu.regis.namespaces.contacts.Contact;
import edu.regis.namespaces.contacts.Contacts;
import edu.regis.ws.db.ContactDb;

import java.net.URI;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

@Path("contacts")
public class ContactsResource {

    @Context private UriInfo uriInfo;

    /**
     * Get a list of the contacts registered in the system.
     *
     * @return a list of Contacts
     */
	@GET
    @Produces({"application/xml","application/json"})
    public Contacts getAll() {
        Contacts contacts = new Contacts();
        contacts.getContacts().addAll(ContactDb.getInstance().getContacts());
    	System.out.println("Contacts: " + contacts.getContacts());
        return contacts;
    }

    /**
     * Create a new Contact in the system. This is a POST request since it is not
     * idempotent. We return the URL to the contact that was created.
     *
     * @param contact the contact to create
     * @return a response that contains the URL of the contact created. 
     */
    @POST
    @Consumes({"application/xml","application/json"})
    public Response createNewContact(JAXBElement<Contact> contact) {
        ContactDb.getInstance().addContact(contact.getValue());
        URI contactUri = uriInfo.getAbsolutePathBuilder().
                path(contact.getValue().getId().toString()).
                build();
        return Response.created(contactUri).build();
    }


    /**
     * Do something with a contact that exists in the system. We expect the ID
     * to be supplied on the path. Delegate processing to the ContactResource object.
     * 
     * @param contactid the ID of the Contact
     * @return a ContactResource object that processes the request
     */
    @Path("{contactid}/")
    public ContactResource getContact(@PathParam("contactid") String contactid) {
        return new ContactResource(contactid);
    }
}
