import java.util.*;
import java.lang.StringBuilder;

/*
 *  ContactList class
 *  - Implements the Iterable<Contact> interface
 */
public class ContactList implements Iterable<Contact> {
  
  //declaring an ArrayList of contacts. 
  private ArrayList<Contact> contact_list;  
  
  
  //-------CONSTRUCTORS------------
  
  // A constructor that creates an empty ContactList.
  public ContactList() {
    this.contact_list = new ArrayList<Contact>();
  }
  
  // A constructor that uses an array of Contacts in order to initialize the ContactList.
  public ContactList(Contact[] array) {
    this.contact_list = new ArrayList<Contact>();
    for (Contact contact: array) {
      this.contact_list.add(contact);
    }
  }
  
  //----------METHODS-------------
  
  // A method that searches for a particular contact by last name, and returns a reference
  // to the Contact. If there is no such Contact, a sentinel value should be returned
  public Contact findContactByLastName(String lastName) {
    for (Contact contact: this.contact_list) {
      if (contact.getLastName().equals(lastName))
        return contact;
    }
    return null;
  }
  
  // A method that searches for a Contact by phone number, and returns a reference to the
  // Contact. If there is no such Contact, a sentinel value should be returned.
  public Contact findContactByPhoneNumber(String phoneNumber) {
    for (Contact contact: this.contact_list) {
      if (contact.getPhoneNumber().equals(phoneNumber))
        return contact;
    }
    return null;
  }
  
  // A function that searches for and returns a ContactList containing all Contacts with a
  // last name starting with a particular letter. If there are no such Contacts,  should
  // return the empty ContactList.
  public ContactList getContactsWithLastNameStartingWithCharacter(char c) {
    ContactList result = new ContactList();
    for (Contact contact: this.contact_list) {
      if (contact.getLastName().toUpperCase().charAt(0) == c || contact.getLastName().toLowerCase().charAt(0) == c)
        result.addContact(contact);
    }
    return result;
  }
  
  // A method that searches for and returns a ContactList containing all Contacts that live
  // in a particular city. If there are no such Contacts, should return the empty
  // ContactList.
  public ContactList getContactsLivingInCity(String city) {
    ContactList result = new ContactList();
    for (Contact contact: this.contact_list) {
      if (contact.getCity().equals(city))
        result.addContact(contact);
    }
    return result;
  }
  
  // A method that allows to add a Contact to the ContactList.  should only add a
  // Contact to the list if it is not there already.
  public void addContact(Contact contact) {
    if (!this.contact_list.contains(contact))
      contact_list.add(contact);
  }
  
  // A method that returns the size of the ContactList.
  public int getSize() {
    return this.contact_list.size();
  }
  
  // A method that allows to remove a Contact from the ContactList.
  public boolean removeContact(Contact contact) {
    return this.contact_list.remove(contact);
  }
  
  // A method that allows the client to get a Contact from the ContactList by index. An
  // IndexOutOfBoundsException should be thrown if that index doesnt exist.
  public Contact getContact(int index) {
    if (index < 0 || index >= this.contact_list.size())
      throw new IndexOutOfBoundsException();
    return this.contact_list.get(index);
  }
  
  // An overridden equals() method. Lets define one ContactList being equal to another
  // if they contain the same Contacts (but not necessarily in the same order.) 
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof ContactList) {
      ContactList list = (ContactList) obj;
      if (this.getSize() != list.getSize())
        return false;
      for (int i = 0; i < list.getSize(); i++) {
        if (!this.contact_list.contains(list.getContact(i)))
          return false;
      }
      return true;
    }
    return false;
  }
  
  // An overridden toString() method that creates a representation for a ContactList. 

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Contact List:\n");
    for (Contact contact: this.contact_list) {
      sb.append("---\n");
      sb.append(contact.toString());
      sb.append("\n");
    }
    return sb.toString().trim();
  }
  
  // An iterator() method that allows  iterate through a ContactList. 
  // implement  the ArrayLists own iterator). 
  public Iterator<Contact> iterator() {
    return contact_list.iterator();
  }

}
