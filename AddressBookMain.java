import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class AddressBookMain
{	
	public static Map<String,AddressBook> addressBookNameMap;
	
	public AddressBookMain()
	{
		addressBookNameMap = new HashMap<String,AddressBook>();
	}
	
	void searchPersonByCity(String city, String personNameString)
	{
		System.out.println("City : " + city);
						
		for(Map.Entry<String, AddressBook> entry : addressBookNameMap.entrySet())
		{					
			for(Contact listContact : entry.getValue().getContacts())
			{
				if(listContact.getCity().equals(city) && listContact.getFirstName().equals(personNameString))
				{
					System.out.println("--------------------------------");
	                System.out.println("First Name: "+listContact.getFirstName());
	                System.out.println("Last Name: "+listContact.getLastName());
	                System.out.println("Address: "+listContact.getAddress());
	                System.out.println("City: "+listContact.getCity());
	                System.out.println("State: "+listContact.getState());
	                System.out.println("Zip: "+listContact.getZip());
	                System.out.println("Phone Number: "+listContact.getPhoneNumber());
	                System.out.println("Email: "+listContact.getEmail());
	                System.out.println("--------------------------------");			
				}
			}
		}	
	}
	
	void searchPersonByState(String state, String personNameString)
	{
		System.out.println("State : " + state);
						
		for(Map.Entry<String, AddressBook> entry : addressBookNameMap.entrySet())
		{					
			for(Contact listContact : entry.getValue().getContacts())
			{
				if(listContact.getState().equals(state) && listContact.getFirstName().equals(personNameString))
				{
					System.out.println("--------------------------------");
	                System.out.println("First Name: "+listContact.getFirstName());
	                System.out.println("Last Name: "+listContact.getLastName());
	                System.out.println("Address: "+listContact.getAddress());
	                System.out.println("City: "+listContact.getCity());
	                System.out.println("State: "+listContact.getState());
	                System.out.println("Zip: "+listContact.getZip());
	                System.out.println("Phone Number: "+listContact.getPhoneNumber());
	                System.out.println("Email: "+listContact.getEmail());
	                System.out.println("--------------------------------");			
				}
			}
		}	
	}
	
	void viewPersonsByCity(String city)
	{
		System.out.println("City : " + city);
						
		for(Map.Entry<String, AddressBook> entry : addressBookNameMap.entrySet())
		{					
			for(Contact listContact : entry.getValue().getContacts())
			{
				if(listContact.getCity().equals(city))
				{
					System.out.println("--------------------------------");
	                System.out.println("First Name: "+listContact.getFirstName());
	                System.out.println("Last Name: "+listContact.getLastName());
	                System.out.println("Address: "+listContact.getAddress());
	                System.out.println("City: "+listContact.getCity());
	                System.out.println("State: "+listContact.getState());
	                System.out.println("Zip: "+listContact.getZip());
	                System.out.println("Phone Number: "+listContact.getPhoneNumber());
	                System.out.println("Email: "+listContact.getEmail());
	                System.out.println("--------------------------------");			
				}
			}
		}	
	}
	
	void viewPersonsByState(String state)
	{
		System.out.println("State : " + state);
						
		for(Map.Entry<String, AddressBook> entry : addressBookNameMap.entrySet())
		{					
			for(Contact listContact : entry.getValue().getContacts())
			{
				if(listContact.getState().equals(state))
				{
					System.out.println("--------------------------------");
	                System.out.println("First Name: "+listContact.getFirstName());
	                System.out.println("Last Name: "+listContact.getLastName());
	                System.out.println("Address: "+listContact.getAddress());
	                System.out.println("City: "+listContact.getCity());
	                System.out.println("State: "+listContact.getState());
	                System.out.println("Zip: "+listContact.getZip());
	                System.out.println("Phone Number: "+listContact.getPhoneNumber());
	                System.out.println("Email: "+listContact.getEmail());
	                System.out.println("--------------------------------");			
				}
			}
		}	
	}
	
	
    public static void main(String[] args) 
    {    
    	AddressBookMain objAddressBookMain = new AddressBookMain();
        Scanner scanner = new Scanner(System.in);
        int choice;
        AddressBook addressBook = null;

        do
        {
            System.out.println("0.Create Address Book");
            System.out.println("1.Add Contact");
            System.out.println("2.Display Contact");
            System.out.println("3.Edit Contact");
            System.out.println("4.Delete Contact");
            System.out.println("Enter choice:");
            choice = scanner.nextInt();
            
            switch (choice) 
            {
                case 0: System.out.println("Enter Address Book Name:");
                        String bookName = scanner.next();
                        addressBook = new AddressBook(bookName);
                        addressBookNameMap.put(bookName, addressBook);
                        break;
                case 1: addressBook.addContacts();
                        break;
                case 2: addressBook.displayContacts(addressBook);
                        break;
                case 3: System.out.println("Enter first name to edit:");
                        String fnameEdit = scanner.next();
                        addressBook.editContacts(fnameEdit);
                        addressBook.displayContacts(addressBook);
                        break;
                case 4: System.out.println("Enter first name to be deleted");
                        String fnameDelete = scanner.next();
                        addressBook.deleteContact(fnameDelete);
                        break;
                default:break;
            }
        }while(choice>=0 && choice<=4);
    
        System.out.println("Enter city to search person:");
        String cityString = scanner.next();
        System.out.println("Enter first name:");
        String personNameString = scanner.next();
        objAddressBookMain.searchPersonByCity(cityString, personNameString);
        

        System.out.println("Enter state to search person:");
        String stateString = scanner.next();
        System.out.println("Enter first name:");
        String nameString = scanner.next();
        objAddressBookMain.searchPersonByState(stateString,nameString);
        
        System.out.println("Enter city to view persons:");
        String cityNameString = scanner.next();
        objAddressBookMain.viewPersonsByCity(cityNameString);
        
        System.out.println("Enter state to view persons:");
        String stateNameString = scanner.next();
        objAddressBookMain.viewPersonsByState(stateNameString);
    }
}