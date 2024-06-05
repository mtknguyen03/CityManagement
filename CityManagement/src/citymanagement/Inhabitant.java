package citymanagement;

public class Inhabitant {
	private String name;
	private String birthdate;
	private String marital;
	
	public Inhabitant(String name, String birthdate, String marital)
	{
		this.name = name;
		this.birthdate = birthdate;
		this.marital = marital;
	}

	public String getName()
	{
		return name;
	}
	
	public String getBirthDate()
	{
		return birthdate;
	}
	
	public String getMarital()
	{
		return marital;
	}
	
	public void changeMarital(String newMarital)
	{
		this.marital = newMarital;
	}
	
	public void print()
	{
		System.out.println("Name: " + name + "\n" +"Birthdate: " + birthdate + "\n" + "Marital Status: " + marital);
		System.out.println("\n");
	}
	
	
}
