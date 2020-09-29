import java.util.*;

public class AddressBookMain
{
    public static void main(String[] args)
    {
        Contact contact1=new Contact("Omkeshwari","Pilare","Matunga","Mumbai","Maharashtra","400022","987654321","omp@gmail.com");
        
            System.out.println("--------------------------------");
            System.out.println("First Name: "+contact1.getFirstName());
            System.out.println("Last Name: "+contact1.getLastName());
            System.out.println("Address: "+contact1.getAddress());
            System.out.println("City: "+contact1.getCity());
            System.out.println("State: "+contact1.getState());
            System.out.println("Zip: "+contact1.getZip());
            System.out.println("Phone Number: "+contact1.getPhoneNumber());
            System.out.println("Email: "+contact1.getEmail());
            System.out.println("--------------------------------");
    }
}