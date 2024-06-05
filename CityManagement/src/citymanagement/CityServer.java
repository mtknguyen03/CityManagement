package citymanagement;

import java.net.*;
import java.util.*;
import java.io.*;

public class CityServer implements Serializable{
	public static void main( String args[]) {
		Set<Inhabitant> list_fra = new HashSet<>();
		 City city1 = new City("Frankfurt", list_fra);
			city1.addInhabitant("Nguyen", "26/11/2003", "Single");
			city1.addInhabitant("Khoi", "6/1/2013", "Single");
			
			
		Set<Inhabitant> list_ber = new HashSet<>();	
		City city2 = new City("Berlin", list_ber);
			city2.addInhabitant("Adam", "1/1/2000", "Married");
			city2.addInhabitant("Eve", "2/1/2001", "Single");
			city2.addInhabitant("Lilith", "3/1/2000", "Married");
			
		System.out.println("The Server is running");
		try(DatagramSocket aSocket = new DatagramSocket (6789))
		{

			byte[] buffer = new byte[1024];

			while(true)
			{
				DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                aSocket.receive(packet);
				//take client data
				ByteArrayInputStream bais = new ByteArrayInputStream(packet.getData());
				ObjectInputStream ois = new ObjectInputStream(bais);
				Message message = (Message) ois.readObject();
				
				//process message
				Message message1 = (Message) ois.readObject();;
				Object result = processMessage(city1, message1);
				
				//return the processed message to client
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(baos);
				oos.writeObject(result);
				
			}
		}
		catch (IOException | ClassNotFoundException e) {
            //print the stack trace of a throwable object
            //throwable is the superclass of all exceptions and errors in Java
            e.printStackTrace();
        }
}
		
		
		
		private static Object processMessage(City city, Message message) {
	        String methodName = message.getMethodName();
	        Object[] params = message.getParameters();
	        Set<Inhabitant> list = new HashSet<>();
	        
	        switch (methodName) {
            case "addInhabitant":
                String name = (String) params[0];
                String DoB = (String) params[1];
                String MS = (String) params[2];
                city.addInhabitant(name, DoB, MS);
                return "Inhabitant added successfully.";
                
            case "allBirthdate":
                return city.allBirthdate();
                
            case "getMaritalStatus":
                name = (String) params[0];
                Inhabitant citizen = city.searchInhabitant(name);
                return citizen.getMarital();
                
            default:
                return "Unknown method";
        }
		
	}
	}
	 
		