package citymanagement;

import java.util.*;

public class City{
	private String name;
	private Set<Inhabitant> inhabitant;
	
	
	public City(String name, Set<Inhabitant> inhabitant)
	{
		this.name = name;
		this.inhabitant = inhabitant;
		
	}
	
	public Inhabitant searchInhabitant(String name)
	{
		for (Inhabitant citizen : inhabitant)
		{
			if(citizen.getName().equals(name))
			{
				return citizen;
			}
		}
		return null;
	}
	
	public Inhabitant addInhabitant(String name, String birthdate, String marital)
	{
		Inhabitant citizen = new Inhabitant(name, birthdate, marital);
		inhabitant.add(citizen);
		return citizen;
	}
	
	public void allInhabitant(Set<Inhabitant> list)
	{
		for(Inhabitant person : list)
		{
			System.out.println("Name: " + person.getName() + "\n" +"Birthdate: " + person.getBirthDate() + "\n" + "Marital Status: " + person.getMarital());
			System.out.println();
		}
		
	}
	
	public Set<String> allBirthdate() {
        Set<String> dobs = new HashSet<>();
        for (Inhabitant citizen : inhabitant) {
            dobs.add(citizen.getBirthDate());
            System.out.println("Name: " + citizen.getName() + "\n" +"Birthdate: " + citizen.getBirthDate());
    		System.out.println();
        }
        return dobs;
    }

	public String getName()
	{
		return name;
	}
	
	public void setName(String newName)
	{
		this.name = newName;
	}
	
	public void printName()
	{
		System.out.println("City name: " + name);
	}
	
	
}


//public Object allBirthdate(Set<Inhabitant> list)
//{
//	for(Inhabitant person : list)
//	{
//		System.out.println("Name: " + person.getName() + "\n" +"Birthdate: " + person.getBirthDate());
//		System.out.println();
//	}
//	
//	return null;
//
//}
