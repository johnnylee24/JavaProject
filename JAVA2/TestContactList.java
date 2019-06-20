import java.util.Iterator;



 
public class TestContactList {
  
  // Main method for program execution
  public static void main(String[] args) {
    System.out.println("TEST PROGRAM FOR ContactList CLASS");
    System.out.println("");
    System.out.println("new ContactList()");
    ContactList contactList = new ContactList();
    System.out.println("contactList.addContact(new Contact(\"Ari\", \"Mermelstein\", \"(718) 111-1111\", \"2900 Beford Avenue\", \"Brooklyn\", \"NY\"))");
    contactList.addContact(new Contact("Ari", "Mermelstein", "(718) 111-1111", "2900 Beford Avenue", "Brooklyn", "NY"));
    System.out.println("contactList.addContact(new Contact(\"Bob\", \"Winklevoss\", \"(339) 222-2222\", \"1800 Concord Drive\", \"Columbus\", \"OH\"))");
    contactList.addContact(new Contact("Bob", "Winklevoss", "(339) 222-2222", "1800 Concord Drive", "Columbus", "OH"));
    System.out.println("contactList.addContact(new Contact(\"Carol\", \"Wilkommen\", \"(281) 333-3333\", \"3400 Davis Street\", \"Brooklyn\", \"NY\"))");
    contactList.addContact(new Contact("Carol", "Wilkommen", "(281) 333-3333", "3400 Davis Street", "Brooklyn", "NY"));
    System.out.println("contactList.addContact(new Contact(\"Steve\", \"Jobs\", \"(555) 444-4444\", \"2101 Waverley Street\", \"Palo Alto\", \"CA\"))");
    contactList.addContact(new Contact("Steve", "Jobs", "(555) 444-4444", "2101 Waverley Street", "Palo Alto", "CA"));
    System.out.println("");
    System.out.println("contactList.getSize()");
    System.out.println(contactList.getSize());
    System.out.println("");
    System.out.println("contactList.toString()");
    System.out.println(contactList.toString());
    System.out.println("");
    System.out.println("contactList.findContactByLastName(\"Winklevoss\")");
    System.out.println(contactList.findContactByLastName("Winklevoss"));
    System.out.println("");
    System.out.println("contactList.findContactByPhoneNumber(\"(281) 333-3333\")");
    System.out.println(contactList.findContactByPhoneNumber("(281) 333-3333"));
    System.out.println("");
    System.out.println("contactList.getContactsWithLastNameStartingWithCharacter(\'W\')");
    System.out.println(contactList.getContactsWithLastNameStartingWithCharacter('W'));
    System.out.println("");
    System.out.println("contactList.getContactsLivingInCity(\"Brooklyn\")");
    System.out.println(contactList.getContactsLivingInCity("Brooklyn"));
    System.out.println("");
    System.out.println("contactList.removeContact(new Contact(\"Steve\", \"Jobs\", \"(555) 444-4444\", \"2101 Waverley Street\", \"Palo Alto\", \"CA\"))");
    contactList.removeContact(new Contact("Steve", "Jobs", "(555) 444-4444", "2101 Waverley Street", "Palo Alto", "CA"));
    System.out.println("");
    System.out.println("contactList.getSize()");
    System.out.println(contactList.getSize());
    System.out.println("");
    System.out.println("contactList.toString()");
    System.out.println(contactList.toString());
    System.out.println("");
    System.out.println("contactList.getContact(0)");
    System.out.println(contactList.getContact(0));
    System.out.println("contactList.getContact(1)");
    System.out.println(contactList.getContact(1));
    System.out.println("contactList.getContact(2)");
    System.out.println(contactList.getContact(2));
    System.out.println("");
    System.out.println("contactList.equals(contactList)");
    System.out.println(contactList.equals(contactList));
    System.out.println("");
    System.out.println("Using iterator() to print Contacts:");
    Iterator<Contact> iterator = contactList.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
  
}