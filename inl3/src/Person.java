
public class Person {
	
	private String name;
	private String phoneNbr;
	
	public Person(String name, String phoneNbr) {
		this.name = name;
		this.phoneNbr = phoneNbr;
	}
	
	/** Tar reda på personens namn. */
	String getName() {
		return name;
	}

	/** Tar reda på personens telefonnummer. */
	String getPhoneNbr() {
		return phoneNbr;
	}
	
	
}
