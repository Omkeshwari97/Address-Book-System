import java.util.*;

public class AddressBookMain
{
    ArrayList<Contact> contactList=new ArrayList<Contact>();

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

    public void displayContacts(String firstName)
    {
        for(Contact lobj:contactList)
        {   
            if(lobj.getFirstName().equals(firstName))
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

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        AddressBookMain addressBook=new AddressBookMain();

        for(int i=0;i<2;i++)
        {
            addressBook.addContacts();
        }

        addressBook.displayContacts("Omkeshwari");
        addressBook.displayContacts("Madhuri");

        System.out.println("Enter existing person name to edit:");
        String existingName=sc.next();

        System.out.println("Enter new name:");
        String newName=sc.next();

        addressBook.editName(existingName,newName);

        addressBook.displayContacts(newName);
    }
}