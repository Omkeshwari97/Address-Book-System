import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
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

    public void sortContactsbyName(AddressBook addressBook)
    {
        System.out.println("Details of " +addressBook.getAddressBookName() + "sorted by name");
        //for(Contact lobj:contactList)
        
        contactList.stream()
        	.sorted((p1, p2)->p1.getFirstName().compareTo(p2.getFirstName()))
        	.forEach(lobj ->  
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
    
    public void sortContactsbyCity(AddressBook addressBook)
    {
        System.out.println("Details of "+addressBook.getAddressBookName() + "sorted by city");
        //for(Contact lobj:contactList)
        
        contactList.stream()
        	.sorted((p1, p2)->p1.getCity().compareTo(p2.getCity()))
        	.forEach(lobj ->  
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
    
    public void sortContactsbyState(AddressBook addressBook)
    {
        System.out.println("Details of "+addressBook.getAddressBookName() + "sorted by state");
        //for(Contact lobj:contactList)
        
        contactList.stream()
        	.sorted((p1, p2)->p1.getState().compareTo(p2.getState()))
        	.forEach(lobj ->  
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
    
    public void sortContactsbyZip(AddressBook addressBook)
    {
        System.out.println("Details of "+addressBook.getAddressBookName() + "sorted by zip");
        //for(Contact lobj:contactList)
        
        contactList.stream()
        	.sorted((p1, p2)->p1.getZip().compareTo(p2.getZip()))
        	.forEach(lobj ->  
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

    public void editContacts(String existingName)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter choice to edit:");
        int choice = scanner.nextInt();

        for(Contact lobj:contactList)
        {
            if(lobj.getFirstName().equals(existingName))
            {
                //lobj.setFirstName(newName);

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
    
    public void writeToFile() throws IOException
    {
    	FileWriter fileWriter = new FileWriter("AddressBookOutput.txt");
    	
    	for(Contact cobj : contactList)
    	{
    		fileWriter.write(cobj.getFirstName() + " " + cobj.getLastName()
    		 + " " + cobj.getAddress() + " " + cobj.getCity() + " " + 
    				cobj.getState() + " " + cobj.getZip() + " " + 
    		 cobj.getEmail() + " " + cobj.getPhoneNumber() + "\n");
    	}
    	
    	fileWriter.close();
    }
    
    public void readFromFile() throws IOException 
    {
    	FileReader fileReader = null;
    	int ch;
    	
    	try 
    	{
    		fileReader = new FileReader("AddressBookOutput.txt");
		} 
    	catch (FileNotFoundException e) 
    	{
    		System.out.println("File not fouund");
		}
    	
    	while((ch = fileReader.read()) != -1)
    	{
    		System.out.print((char)ch);
    	}
    	fileReader.close();
    }

	public void writeToCSV() throws IOException 
	{
		FileWriter csvWriter = new FileWriter("csvoutput.csv");
		csvWriter.append("First Name");
		csvWriter.append(",");
		csvWriter.append("Last Name");
		csvWriter.append(",");
		csvWriter.append("Address");
		csvWriter.append(",");
		csvWriter.append("City");
		csvWriter.append(",");
		csvWriter.append("State");
		csvWriter.append(",");
		csvWriter.append("Zip");
		csvWriter.append(",");
		csvWriter.append("Phone Number");
		csvWriter.append(",");
		csvWriter.append("Email");
		csvWriter.append("\n");
		
		for(Contact cobj : contactList)
		{
			csvWriter.append(cobj.getFirstName());
			csvWriter.append(",");
			csvWriter.append(cobj.getLastName());
			csvWriter.append(",");
			csvWriter.append(cobj.getAddress());
			csvWriter.append(",");
			csvWriter.append(cobj.getCity());
			csvWriter.append(",");
			csvWriter.append(cobj.getState());
			csvWriter.append(",");
			csvWriter.append(cobj.getZip());
			csvWriter.append(",");
			csvWriter.append(cobj.getPhoneNumber());
			csvWriter.append(",");
			csvWriter.append(cobj.getEmail());
			csvWriter.append("\n");
		}
		
		csvWriter.close();
	}

	public void readFromCSV() throws IOException 
	{
		String pathToCsv = "C:/Users/omkes/eclipse-workspace/AddressBookSystem/csvoutput.csv";
		
		BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv));
		String row;
			
		while ((row = csvReader.readLine()) != null) 
		{
		    String data[] = row.split(",");
			
		    System.out.println("--------------------------------" +
					"\nFirst Name: "+ data[0] +
					"\nLast Name: "+ data[1] +
					"\nAddress: "+ data[2] +
					"\nCity: "+ data[3] +
					"\nState: "+ data[4] +
					"\nZip: "+ data[5] +
					"\nPhone Number: "+ data[6] +
					"\nEmail: "+ data[7] +
					"\n--------------------------------");
		}
			
		csvReader.close();
	}
}