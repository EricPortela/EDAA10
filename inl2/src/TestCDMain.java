import java.util.*;

public class TestCDMain {

	public static void main(String[] args) {
		Register r = new Register();
		Dialog d = new Dialog();
		
//		r.insertCD("DARTIST", "DSONG");
//		r.insertCD("Beatles", "Abbey Road");
//		r.insertCD("Beatles", "Ringo");
//		r.insertCD("Beatles", "BLA BLA");
//
//		r.insertCD("ABBA", "Waterloo");
//		r.insertCD("AAB", "AABCSONG");
//		r.insertCD("AAPL", "AAPLSONG");
//		r.insertCD("CARTIST", "CSONG");
//		r.searchByArtist("BEATLES");
//		r.writeToFile("/Users/ericportela/Desktop/CDRegister.txt");
//		r.readFromFile("/Users/ericportela/Desktop/CDRegister.txt");
//		r.sortByTitle(); 
		
		
		String menuItems = "Meny" + "\n" 
							+ "1: Sätt in en ny skiva" 
							+ "\n" + "2: Tag bort en artists skivor" 
							+ "\n" + "3: Sök skivor från artistnamn/del av artistnamn"
							+ "\n" + "4: Sök skivor från sångtitel/del av sångtitel"
							+ "\n" + "5: Presentera alla skivor sorterade efter artist"
							+ "\n" + "6: Presentera alla skivor sorterade efter titel"
							+ "\n" + "7: Spara registret på en fil"
							+ "\n" + "8: Hämta uppgifterna till registret från en fil";
		
		while (true) {
			int command = d.readInt(menuItems); 
			String fileName = "/Users/ericportela/Desktop/CDRegister.txt";
			
			switch (command) {
				case 1:
					System.out.println("HEY");
					String artistdAdd = d.readString("Skriv in artistens namn"); //Fråga efter artist
					String titleAd = d.readString("Skriv in titeln"); //Fråga efter titel
					r.insertCD(artistdAdd, titleAd); //Sätt in skivan i registret
					break; //Möjliggör att man går tillbaka till huvudmenyn
	            case 2:
	            	String artistRemove = d.readString("Skriv in artistens namn"); //Fråga efter artist
					r.removeCD(artistRemove);; //Tar bort skiva av en viss artist i registret
					break;
	            case 3:
	            	String artistSearch = d.readString("Skriv in artistens namn/del av artistens namn");
	            	String searchByArtist = r.searchByArtist(artistSearch);
	            	d.printString(searchByArtist);
	            	break;
	            case 4:
	            	String titleSearch = d.readString("Skriv in titel/del av titel");
	            	String searchByTitle = r.searchByTitle(titleSearch);
	            	d.printString(searchByTitle);
	            	break;
	            case 5:
	            	String sortByArtist = r.sortByArtist();
	            	d.printString(sortByArtist);
	            	break;
	            case 6:
	            	String sortByTitle = r.sortByTitle();
	            	d.printString(sortByTitle);
	            	break;
	            case 7:
	            	r.writeToFile(fileName);
	            	d.printString("Registret sparat!");
	            	break;
	            case 8:
	            	r.readFromFile(fileName);
	            	d.printString("Registret har kopierats/avlästs!");
	            	break;	            	
	            default:
	            	System.exit(1);	
			}
		}
	}
}
