import java.io.IOException;
import java.util.*;
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
			
			count = count + contactListByCity.size();
		}	
		
		System.out.println("Count of persons in " + city + ": " + count);
		
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
			
			count = count + contactListByState.size();
		}
		
		System.out.println("Count of persons in " + state + ": " + count);
	}
	
	
	public static void main(String[] args) throws IOException 
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
			System.out.println("5.Write details to file and read it");
			System.out.println("6.Save details using csv");
			System.out.println("7.Save details using json");
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
				case 2: System.out.println("Enter choice for displaying details");
						System.out.println("1. Sort By Name");
						System.out.println("2. Sort By City");
						System.out.println("3. Sort By State");
						System.out.println("4. Sort By Zip");
						int key = scanner.nextInt();
						switch(key) 
						{
							case 1:	addressBook.sortContactsbyName(addressBook);						
									break;
							case 2:	addressBook.sortContactsbyCity(addressBook);						
									break;								
							case 3:	addressBook.sortContactsbyState(addressBook);						
									break;								
							case 4:	addressBook.sortContactsbyZip(addressBook);						
									break;			
							default:
									break;
						}
						break;
				case 3: System.out.println("Enter first name to edit:");
						String fnameEdit = scanner.next();
						addressBook.editContacts(fnameEdit);
						break;
				case 4: System.out.println("Enter first name to be deleted");
						String fnameDelete = scanner.next();
						addressBook.deleteContact(fnameDelete);
						break;
				case 5: addressBook.writeToFile();
						addressBook.readFromFile();
						break;
				case 6: addressBook.writeToCSV();
						addressBook.readFromCSV();
						break;
				case 7: addressBook.writeDataToJSON();
						addressBook.readDataFromJSON();
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