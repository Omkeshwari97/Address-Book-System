import java.util.*;

public class AddressBook
{
    public String bookName;

    List<Contact> contactList = new ArrayList<Contact>();
    
    public AddressBook(String bookName)
    {
        this.bookName = bookName;
    }

    public String getAddressBookName()
    {
        return bookName;
    }
    
    public List<Contact> getContacts()
    {
    	return contactList;
    }

    public void addContacts()
    {
        Scanner sc = new Scanner(System.in);

        String firstName, lastName, address, city, state, zip, phoneNumber, email;

            System.out.println("Enter First Name:");
            firstName = sc.next();

            System.out.println("Enter Last Name:");
            lastName = sc.next();
            
            System.out.println("Enter Address:");
            address = sc.next();

            System.out.println("Enter City:");
            city = sc.next();

            System.out.println("Enter State:");
            state = sc.next();

            System.out.println("Enter Zip:");
            zip = sc.next();

            System.out.println("Enter Phone Number:");
            phoneNumber = sc.next();

            System.out.println("Enter Email:");
            email = sc.next();

            Contact contact1 = new Contact(firstName,lastName,address,city,state,zip,phoneNumber,email);

            for(int i=0; i<contactList.size() ;i++)
            {
                if(contactList.get(i).equals(contact1))
                {
                    System.out.println("Duplicate Entry");
                    return;
                }
            }
            
            contactList.add(contact1);
    }

    public void displayContacts(AddressBook addressBook)
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

    public void editContacts(String existingName)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter choice to edit:");
        int choice = scanner.nextInt();

        for(Contact lobj:contactList)
        {
            if(lobj.getFirstName().equals(existingName))
            {

                switch(choice)
                {
                    case 1: System.out.println("Enter first name to be edited");
                            lobj.setFirstName(scanner.next());
                            break;
                    
                    case 2: System.out.println("Enter last name to be edited");
                            lobj.setLastName(scanner.next());
                            break;
                    
                    case 3: System.out.println("Enter address to be edited");
                            lobj.setAddress(scanner.next());
                            break;
                    
                    case 4: System.out.println("Enter city to be edited");
                            lobj.setCity(scanner.next());
                            break;
                    
                    case 5: System.out.println("Enter state to be edited");
                            lobj.setState(scanner.next());
                            break;        
                          
                    case 6: System.out.println("Enter zip to be edited");
                            lobj.setZip(scanner.next());
                            break;
                            
                    case 7: System.out.println("Enter phone number to be edited");
                            lobj.setPhoneNumber(scanner.next());
                            break;
                    
                    case 8: System.out.println("Enter email to be edited");
                            lobj.setEmail(scanner.next());
                            break;       
                    
                    default: break;
                }
            }
        }
    }

    public void deleteContact(String deleteName)
    {
        for(Contact lobj:contactList)
        {
            if(lobj.getFirstName().equals(deleteName))
            {
                contactList.remove(lobj);
            }
        }
    }
}