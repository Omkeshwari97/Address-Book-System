import java.util.*;

public class AddressBookMain
{
    public String addressBookName;

    ArrayList<Contact> contactList=new ArrayList<Contact>();
    
    public AddressBookMain(String addressBookName)
    {
        this.addressBookName=addressBookName;
    }

    public String getAddressBookName()
    {
        return addressBookName;
    }

    public void addContacts()
    {
        Scanner sc=new Scanner(System.in);

        String firstName, lastName, address, city, state, zip, phoneNumber, email;

            System.out.println("Enter First Name:");
            firstName=sc.next();

            System.out.println("Enter Last Name:");
            lastName=sc.next();
            
            System.out.println("Enter Address:");
            address=sc.next();

            System.out.println("Enter City:");
            city=sc.next();

            System.out.println("Enter State:");
            state=sc.next();

            System.out.println("Enter Zip:");
            zip=sc.next();

            System.out.println("Enter Phone Number:");
            phoneNumber=sc.next();

            System.out.println("Enter Email:");
            email=sc.next();

            Contact contact1=new Contact(firstName,lastName,address,city,state,zip,phoneNumber,email);
            contactList.add(contact1);
    }

    public void displayContacts(AddressBookMain addressBook)
    {
        System.out.println("Details of "+addressBook.getAddressBookName());
        for(Contact lobj:contactList)
        {   
                System.out.println("--------------------------------");
                System.out.println("First Name: "+lobj.getFirstName());
                System.out.println("Last Name: "+lobj.getLastName());
                System.out.println("Address: "+lobj.getAddress());
                System.out.println("City: "+lobj.getCity());
                System.out.println("State: "+lobj.getState());
                System.out.println("Zip: "+lobj.getZip());
                System.out.println("Phone Number: "+lobj.getPhoneNumber());
                System.out.println("Email: "+lobj.getEmail());
                System.out.println("--------------------------------");
        }
    }

    public void editName(String existingName,String newName)
    {
        for(Contact lobj:contactList)
        {
            if(lobj.getFirstName().equals(existingName))
            {
                lobj.setFirstName(newName);
            }
        }
    }

    public void deleteName(String deleteName)
    {
        for(Contact lobj:contactList)
        {
            if(lobj.getFirstName().equals(deleteName))
            {
                contactList.remove(lobj);
            }
        }
    }

    public static void main(String[] args)
    {
        HashMap<String,AddressBookMain> addressBookNameMap=new HashMap<String,AddressBookMain>();
        int n;

        Scanner sc=new Scanner(System.in);
        AddressBookMain addressBook=new AddressBookMain("Book1");
        addressBookNameMap.put("Book1",addressBook);

        System.out.println("Enter number of contacts to be added to Book1:");
        n=sc.nextInt();

        for(int i=0;i<n;i++)
        {
            addressBook.addContacts();
        }
        addressBook.displayContacts(addressBook);

        AddressBookMain addressBook2=new AddressBookMain("Book2");
        addressBookNameMap.put("Book2",addressBook2);

        System.out.println("Enter number of contacts to be added to Book2:");
        n=sc.nextInt();

        for(int i=0;i<n;i++)
        {
            addressBook2.addContacts();
        }
        addressBook2.displayContacts(addressBook2);

       /* System.out.println("Enter existing person name to edit:");
        String existingName=sc.next();

        System.out.println("Enter new name:");
        String newName=sc.next();

        addressBook.editName(existingName,newName);

        addressBook.displayContacts();
        */
        /*System.out.println("Enter existing name to be deleted:");
        String deleteName=sc.next();

        addressBook.deleteName(deleteName);

        addressBook.displayContacts();*/
    }
}