
public class Contact implements Comparable<Contact> {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String streetAddress;
    private String city;
    private String state;

    public Contact(String firstName, String lastName, String phoneNumber,
            String streetAddress, String city, String state) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
    }

    public Contact(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public void update(String firstName, String lastName, String phoneNumber,
            String streetAddress, String city, String state) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Contact) {
            Contact contact = (Contact) obj;
            return this.firstName.equals(contact.firstName)
                    && this.lastName.equals(contact.lastName);
        }
        return false;
    }

    @Override
    public String toString() {
        String base = String.format("%s %s\tPhone number: %s", firstName,
                lastName, phoneNumber);
        String addr = "";
        if (streetAddress != null) {
            addr = String.format("\n%s\n%s, %s", streetAddress, city, state);
        }
        return base + addr;
    }

    @Override
    public int compareTo(Contact o) {
        int result = this.lastName.compareTo(o.lastName);
        if (result == 0) {
            result = this.firstName.compareTo(o.firstName);
        }
        return result;
    }

    public static void main(String[] args) {
        Contact contact1 = new Contact("Ari", "Mermelstein", "(718) 111-1111");
        System.out.println(contact1);
        Contact contact2 = new Contact("Ari", "Mermelstein", "(718) 111-1111",
                "2900 Beford Avenue", "Brooklyn", "NY");
        Contact contact3 = new Contact("Jim", "Mermelstein", "(718) 111-1111");
        System.out.println(contact1.equals(contact2));
        System.out.println(contact1.equals(contact3));
        System.out.println(contact1.compareTo(contact2));
        System.out.println(contact1.compareTo(contact3));
        System.out.println(contact2);
    }
}
