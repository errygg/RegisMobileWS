package edu.regis.service.db;

import edu.regis.namespaces.contacts.Contact;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactDb {

    // singleton instance
    private static final ContactDb instance = new ContactDb();

    private Map<String, Contact> contacts = new HashMap<String, Contact>();
	private int contactIdx = 0;

    public static ContactDb getInstance() {
        return instance;
    }
    
    private ContactDb() {

    	Contact name1 = new Contact();
    	name1.setFirstName("John");
    	name1.setLastName("Doe");
    	name1.setAddress("100 Nowhere Dr.");
    	name1.setCity("Nowheresville");
    	name1.setState("NW");
    	name1.setZip(00000);
    	name1.setCell("555-555-5555");

    }

    public List<Contact> getContacts() {
        return new ArrayList<Contact>(contacts.values());
    }

    public Contact findById(String id) {
        return contacts.get(id);
    }
    
    public synchronized void addContact(Contact contact) {
        int id = contactIdx++;
        contacts.put(Integer.toString(id), contact);
        contact.setId(id);
    }

    public synchronized void updateContact(String id, Contact contact) {
        contacts.put(id, contact);
    }

    public synchronized void deleteContact(String id) {
        contacts.remove(id);
    }
    
}
