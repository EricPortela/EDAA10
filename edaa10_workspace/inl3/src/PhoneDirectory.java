
import java.util.ArrayList;

public class PhoneDirectory {
	private ArrayList<Person> persons; // personerna i katalogen
	
	/** Skapar en tom telefonkatalog. */
	public PhoneDirectory() {
		persons = new ArrayList<Person>();
	}
	
	public void addPerson(String name, String nbr) {
		persons.add(new Person(name, nbr));
	}
	
    /**Returnerar en ny lista, sorterad stigande med avseende på namn*/		
	public ArrayList<Person> getSortedPersonList(){
		
		ArrayList<Person> sortedPersons = new ArrayList<Person>(persons);
		
		/*
		for (int i=0; i<persons.size(); i++) {
		    Person p = persons.get(i);
		    sortedPersons.add(p);
		}
		*/
		
		for (int i=0; i<persons.size()-1; i++) {
		        
		    for (int k=i; k<persons.size(); k++) {
    		    Person currentPerson = sortedPersons.get(i);
    		    String currentPersonStr = currentPerson.getName();
		        
		        Person comparingPerson = sortedPersons.get(k);
		        String comparingPersonStr = comparingPerson.getName();
		        int comparison = currentPersonStr.compareTo(comparingPersonStr);
		        
		        if (comparison > 0) { //Mindre
		        	System.out.println("COMPARISON");
		        	System.out.println(currentPersonStr);
		        	System.out.println(comparingPersonStr);

		            sortedPersons.remove(i);
		            sortedPersons.add(i, comparingPerson);
		            
		            sortedPersons.remove(k);
		            sortedPersons.add(k, currentPerson);
		        }
		    }
		}
		
		return sortedPersons;
	}
	
	/** Returnerar personlistan som en sträng enligt formatet för ArrayLists
            toString()-metod*/
        public String toString() {
            //OBS ändra inte denna
	    	return persons.toString();
	    }
        
        
        
        
}
