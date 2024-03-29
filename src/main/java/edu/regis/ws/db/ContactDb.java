package edu.regis.ws.db;

import edu.regis.ws.models.Contact;

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
    	name1.setTitle("Dean");
    	name1.setEmail("jdoe@nowhere.com");
    	name1.setBusPhone("555-555-5555");
    	addContact(name1);
    	
    	Contact name2 = new Contact();
    	name2.setFirstName("Jane");
    	name2.setLastName("Doe");
    	name2.setTitle("President");
    	name2.setEmail("jdoe2@nowhere.com");
    	name2.setBusPhone("444-444-4444");
    	addContact(name2);

    }

    public List<Contact> getContacts() {
        return new ArrayList<Contact>(contacts.values());
    }

    public Contact findById(String id) {
        return contacts.get(id);
    }
    
    public List<Contact> findByFirstName( String name ) {
    	
    	List<Contact> contactList = new ArrayList<Contact>();
    	for( Map.Entry<String, Contact> entry : contacts.entrySet() ) {
    		Contact contact = entry.getValue();
    		if( name.equals(contact.getFirstName()) ) {
    			contactList.add(contact);
    		}
    	}

    	return contactList;
    }
    
    public List<Contact> findByLastName( String name ) {
    	
    	List<Contact> contactList = new ArrayList<Contact>();
    	for( Map.Entry<String, Contact> entry : contacts.entrySet() ) {
    		Contact contact = entry.getValue();
    		if( name.equals(contact.getLastName()) ) {
    			contactList.add(contact);
    		}
    	}

    	return contactList;
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
