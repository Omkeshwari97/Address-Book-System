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
			List<Contact> contactListByCity = entry.getValue().getContacts()
												.stream()
												.filter(c -> c.getCity().equals(city) && c.getFirstName().equals(personNameString))
												.collect(Collectors.toList());
							
			contactListByCity.stream().forEach(lobj ->
							System.out.println("--------------------------------"+
										"\nFirst Name: "+lobj.getFirstName()+
										"\nLast Name: "+lobj.getLastName()+
										"\nAddress: "+lobj.getAddress()+
										"\nCity: "+lobj.getCity()+
										"\nState: "+lobj.getState()+
										"\nZip: "+lobj.getZip()+
										"\nPhone Number: "+lobj.getPhoneNumber()+
										"\nEmail: "+lobj.getEmail()+
										"\n--------------------------------")
							);
			
		}	
	}
	
	void searchPersonByState(String state, String personNameString)
	{
		System.out.println("State : " + state);
						
		for(Map.Entry<String, AddressBook> entry : addressBookNameMap.entrySet())
		{					
			List<Contact> contactListByState = entry.getValue().getContacts()
												.stream()
												.filter(s -> s.getState().equals(state) && s.getFirstName().equals(personNameString))
												.collect(Collectors.toList());

			contactListByState.stream().forEach(lobj ->
										System.out.println("--------------------------------"+
										"\nFirst Name: "+lobj.getFirstName()+
										"\nLast Name: "+lobj.getLastName()+
										"\nAddress: "+lobj.getAddress()+
										"\nCity: "+lobj.getCity()+
										"\nState: "+lobj.getState()+
										"\nZip: "+lobj.getZip()+
										"\nPhone Number: "+lobj.getPhoneNumber()+
										"\nEmail: "+lobj.getEmail()+
										"\n--------------------------------")
					);
		}	
	}
	
	void viewPersonsByCity(String city)
	{
		System.out.println("City : " + city);
		int count = 0;
		
	
		for(Map.Entry<String, AddressBook> entry : addressBookNameMap.entrySet())
		{		
			List<Contact> contactListByCity = entry.getValue().getContacts()
												.stream()
												.filter(c -> c.getCity().equals(city))
												.collect(Collectors.toList());
						
			contactListByCity.stream().forEach(lobj ->
					System.out.println("--------------------------------"+
										"\nFirst Name: "+lobj.getFirstName()+
										"\nLast Name: "+lobj.getLastName()+
										"\nAddress: "+lobj.getAddress()+
										"\nCity: "+lobj.getCity()+
										"\nState: "+lobj.getState()+
										"\nZip: "+lobj.getZip()+
										"\nPhone Number: "+lobj.getPhoneNumber()+
										"\nEmail: "+lobj.getEmail()+
										"\n--------------------------------")
					);
		}	
		
		//System.out.println("Count of persons in " + city + ": " + count);
		
	}
	
	void viewPersonsByState(String state)
	{
		System.out.println("State : " + state);
		int count = 0;
						
		for(Map.Entry<String, AddressBook> entry : addressBookNameMap.entrySet())
		{					
			List<Contact> contactListByState = entry.getValue().getContacts()
												.stream()
												.filter(s -> s.getState().equals(state))
												.collect(Collectors.toList());
			
			contactListByState.stream().forEach(lobj ->
					System.out.println("--------------------------------"+
							"\nFirst Name: "+lobj.getFirstName()+
							"\nLast Name: "+lobj.getLastName()+
							"\nAddress: "+lobj.getAddress()+
							"\nCity: "+lobj.getCity()+
							"\nState: "+lobj.getState()+
							"\nZip: "+lobj.getZip()+
							"\nPhone Number: "+lobj.getPhoneNumber()+
							"\nEmail: "+lobj.getEmail()+
							"\n--------------------------------")
					);
		}
		
		//System.out.println("Count of persons in " + state + ": " + count);
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
        
       /* System.out.println("Enter city to view persons:");
        String cityNameString = scanner.next();
        objAddressBookMain.viewPersonsByCity(cityNameString);
        
        System.out.println("Enter state to view persons:");
        String stateNameString = scanner.next();
        objAddressBookMain.viewPersonsByState(stateNameString);*/
                
    }
}