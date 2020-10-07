import java.util.*;

public class AddressBookMain
{
    public static void main(String[] args) 
    {
        Map<String,AddressBook> addressBookNameMap=new HashMap<String,AddressBook>();
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
                        String addressBookName = scanner.next();
                        addressBook = new AddressBook(addressBookName);
                        addressBookNameMap.put(addressBookName, addressBook);
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
                default:
                    break;
            }
        }while(choice>=0 && choice<=4);
    
    }
}