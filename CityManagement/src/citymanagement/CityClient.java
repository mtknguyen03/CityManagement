package citymanagement;

import java.net.*;
import java.lang.*;
import java.util.*;
import java.io.*;

public class CityClient implements Serializable{
  public static void main( String args[]) {
    try (DatagramSocket socket = new DatagramSocket();
    	Scanner sc = new Scanner(System.in))
    {
    	InetAddress address = InetAddress.getByName("localhost");
    	while (true)
    	{
    		Message message = null;
    		
    		System.out.println("Choose city to edit: ");
    		String choice1 = sc.nextLine();
    		
    		Set<City> list = new HashSet<>();
    		for (City cityName : list)
    		{
    			if(cityName.getName().equals(choice1))
    			{
    				System.out.println("1. Add Inhabitant" + 
							"\n" + "2. Print all Birthdats" + 
							"\n" + "3. Get Marital Status");
					int choice2 = sc.nextInt();
					
					
					
					switch(choice2) {
						case 1:
							System.out.println("Enter name: ");
			                String name = sc.nextLine();
			                System.out.println("Enter date of birth: ");
			                String DoB = sc.nextLine();
			                System.out.println("Enter marital status: ");
			                String MS = sc.nextLine();
			                
			                Object[] parameter1 = {name, DoB, MS};
			
			                message = new Message("addInhabitant", parameter1);
					    break;
					    
						case 2:
							String birthdate = null;
							Object[] parameter2 = {birthdate};
							message = new Message("getAllBirthDate", parameter2);
					    break;
					    
						case 3:
							System.out.println("Enter name: ");
			                String specificName = sc.nextLine();
			                Object[] parameter3 = {specificName};
			                message = new Message("getMaritalStatus", parameter3);
					    
					    
						default:
							System.out.println("Invalid choice");
					}
    			}
    		}
    		
    		ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(message);
            byte[] sendData = baos.toByteArray();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, address, 12345);
            socket.send(sendPacket);

            //handle byte a
            byte[] buffer = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
            socket.receive(receivePacket);

            ByteArrayInputStream bais = new ByteArrayInputStream(receivePacket.getData());
            ObjectInputStream ois = new ObjectInputStream(bais);
            Object response = ois.readObject();

            if (response instanceof Set) {
                Set<String> dobs = (Set<String>) response;
                System.out.println("Dates of Birth: " + dobs);
            } else {
                System.out.println("Response: " + response);
            }
    		
    	}
    	
    }
    catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    }

  }
} 
