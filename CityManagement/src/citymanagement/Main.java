package citymanagement;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Set<Inhabitant> list = new HashSet<>();
		City city = new City("Frankfurt", list);
		city.addInhabitant("Nguyen", "26/11/2003", "Single");
		city.addInhabitant("Khoi", "6/1/2013", "Single");
		
		
		city.allInhabitant(list);
		city.allBirthdate();
		
		Inhabitant citizen1 = city.searchInhabitant("Khoi");
		citizen1.print();
		
		Inhabitant citizen2 = city.searchInhabitant("Nguyen");
		citizen2.changeMarital("Married");
		citizen2.print();
		
		
	}

}
