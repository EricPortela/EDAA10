import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Register {
	
	private ArrayList<CD> reg; // registret skall lagras i en ArrayList 
	private Scanner scan = null;
	
	/** Läser registret från filen med namn fileName. */
	public Register() {
		reg = new ArrayList<CD>();
		//readFromFile(fileName);
	}
	
	/** Sätter in ny skiva */ 
	public void insertCD(String artist, String title) {
		//System.out.println("Insert " + artist);
		CD cd = new CD(artist, title);
		char firstLetter = artist.charAt(0);
		
		if (reg.size() > 0) {
			
			int pos = 0;
			CD cdCompare = reg.get(pos);
			String artistCompare = cdCompare.getArtist();
			char firstLetterCompare = artistCompare.charAt(0);
			
			//Find correct position to insert the new CD
			while (firstLetter > firstLetterCompare && ( pos < reg.size()) ) {
				cdCompare = reg.get(pos);
				artistCompare = cdCompare.getArtist();
				firstLetterCompare = artistCompare.charAt(0);
				pos++;
			}
			
			//Subtract by one, since it previously added one, which it did not need
			if (pos!= 0) {
				pos --;
			}
			
			//1. If the two artist begin with the same letter/s keep iterating through their name till letters are different
			if (firstLetterCompare == firstLetter && artist != artistCompare) { //Eg Adam, ABBA ==> d != B ==> STOP
				
				int next = 1;
				char nextLetter = artist.charAt(next);
				char nextLetterCompare = artistCompare.charAt(next);
				
				while (nextLetter == nextLetterCompare && (next<artist.length() || next<artistCompare.length() ) ) {
					
					
					nextLetter = artist.charAt(next);
					nextLetterCompare = artistCompare.charAt(next);
					next ++;
				}
				
				if (nextLetter > nextLetterCompare) { //Ex. ABBA > AAPL ==> AAPL, ABBA
					reg.add(pos+1, cd);
				} else { // AAPL NOT GREATER THAN ABBA ==> AAPL, ABBA
					reg.add(pos, cd);
				}
				
			} else if (firstLetterCompare > firstLetter){ 
				reg.add(pos, cd);
				
			} else if (artist == artistCompare) {
				reg.add(pos, cd);
			}
			
			else { //firstLetterCompare < firstLetter
				reg.add(reg.size(), cd);
			}
			
		} else { //Inga element i registret
			reg.add(cd);
		}
		
		//System.out.println(reg);
	}
	
	
	/** Tar bort CD skiva i registret med en viss artist */ 
	public void removeCD(String artist) {
		for (int i= 0; i<reg.size(); i++) {
			String currentArtist = reg.get(i).getArtist().toLowerCase();
			artist = artist.toLowerCase();
			
			if (currentArtist.equals(artist)) {
				reg.remove(i);
			}
		}
		//System.out.println(reg);
	}
	
	
	/* Söker upp alla skivor som gäller för en viss artist. Räcker med att ange en del av artistens namn. */
	public String searchByArtist(String searchArtist) {
		String searchResult = "";
		
		searchArtist = searchArtist.toLowerCase();
		
		for (int i=0; i<reg.size(); i++) {
			String currentArtist = reg.get(i).getArtist().toLowerCase();
			
			if (currentArtist.indexOf(searchArtist) != -1) {
				CD cd = reg.get(i);
				//System.out.println(cd.toString());
				searchResult += cd.toString() + "\n";
			}
		}
		//System.out.println("Search Results");
		//System.out.println(searchResult);
		return searchResult;
	}
	
	/* Söker upp den eller de skivor som har en viss titel. Skivorna skall presenteras med både artist och titel. */
	public String searchByTitle(String searchTitle) {
		String searchResult = "";
		
		searchTitle = searchTitle.toLowerCase();
		
		for (int i=0; i<reg.size(); i++) {
			String currentTitle = reg.get(i).getTitle().toLowerCase();
			
			if (currentTitle.indexOf(searchTitle) != -1) {
				CD cd = reg.get(i);
				searchResult += cd.toString() + "\n";
			}
		}
		//System.out.println("Search Results");
		//System.out.println(searchResult);
		return searchResult;
	}
	
	
	/* Presentera alla skivor sorterade efter artist. */
	public String sortByArtist() {
		String result = "";
		
		for (int i=0; i<reg.size(); i++) {
			String artist = reg.get(i).getArtist();
			String title = reg.get(i).getTitle();
			
			result += "\n" + artist + "\t" + title;
		}
		
		return result;
	}
	
	/* Presentera alla skivor sorterade efter titel. */
	public String sortByTitle() {
		ArrayList<CD> regHelp = reg;
		
		for (int i=0; i < regHelp.size()-1; i++) { //Går igenom varje element i taget
			//System.out.println("Iteration " + i);
			
			for (int k=i; k<regHelp.size(); k++) { //Går igenom varje efterliggande element
				CD cd = regHelp.get(i);
				String title = cd.getTitle();
				
				CD comparingCD = regHelp.get(k);
				String nextTitle = comparingCD.getTitle();
				
				int comparison = title.compareTo(nextTitle);

				//System.out.println("Comparing " + title + " vs. " + nextTitle);
				
				if (comparison > 0) { //title greater than nextTitle ==> CHANGE THEIR PLACE
					//System.out.println("Changing place...");
					
					regHelp.remove(i);
					regHelp.add(i, comparingCD);
					
					regHelp.remove(k);
					regHelp.add(k, cd);
				}
				//System.out.println(regHelp);
				//System.out.println("");
			}
		}
		
		String result = "";
		
		for (int i=0; i<reg.size(); i++) {
			String artist = reg.get(i).getArtist();
			String title = reg.get(i).getTitle();
			
			result += "\n" + artist + "\t" + title;
		}
		
		return result;
	}
	
	/** Läser registret från filen med namn fileName. */ 
	public void readFromFile(String fileName) {		
		String artist = "";
		String title = "";
		CD cd;
		
		try {
			scan = new Scanner(new File(fileName));
			
			int count = 0;
			
			while (scan.hasNextLine()) {
				artist = scan.nextLine();
				title = scan.nextLine();
				
				insertCD(artist, title);
			}
			
		} catch (FileNotFoundException e){
			System.out.println("File could not be opened! Path is incorrect.");
			System.exit(1);
		}
		//System.out.println(reg);
	}
	
	/** Sparar registret på fil med namnet fileName. */ 
	public void writeToFile(String fileName) {
		PrintWriter out = null;
		try {
			out = new PrintWriter(new File(fileName));
			
			for (int i=0; i<reg.size(); i++) {
				CD cd = reg.get(i);
				out.println(cd.getArtist()+"\n"+cd.getTitle());
			}

		} catch (FileNotFoundException e) {
			System.err.println("Filen kunde inte öppnas");
			System.exit(1); 
		}
		//... utskrifter med out.print hamnar nu på filen
		out.close(); // stänger filen
	}
	
	
	
	
	/*
	public void sortByArtist() {
		String a1;
		String a2;
		
		System.out.println("SORT");
		
		for (int repeat=0; repeat<2; repeat++) {
			
			if (repeat == 0) { //First iteration ==> Only sorting by first letter
				
				for (int x=0; x<reg.size(); x++) { //Iterate through each element of ArrayList
					for (int i=0; i<reg.size(); i++) { //Iterate through each element of ArrayList
						if (i<reg.size()-1) {
							a1 = reg.get(i).getArtist();
							a2 = reg.get(i+1).getArtist();
							
							if (a1.charAt(0) > a2.charAt(0)) { // Eg. B>A ==> TRUE ==> FLYTTA
								CD helpCD = reg.get(i);
								CD superiorCD = reg.get(i+1);
								
								reg.remove(i);
								reg.add(i, superiorCD);
								
								reg.remove(i+1);
								reg.add(i+1, helpCD);
							} else {
								
							}
						}
					}
				}
			} 
			
			else { 
				//Second iteration ==> Is executed after upper sorting, where the arraylist has been sorted by tge first letter only
				//Here we start sorting artists, where their name starts with the same sequence and thus we start checking the other letters and sort them thereafter
				//Eg. ABBA vs AAPL ==> AAPL, ABBA
				for (int x=0; x<reg.size(); x++) {
					for (int i=0; i<reg.size(); i++) { //Iterate through each element of ArrayList
						if(i<reg.size()-1) {
							
							a1 = reg.get(i).getArtist();
							a2 = reg.get(i+1).getArtist();
							
							
							if (a1.charAt(0) == a2.charAt(0)) {
								int c = 1;
								char a1_next = a1.charAt(c);
								char a2_next = a2.charAt(c);
								
								while (a1_next > a2_next && (c<a1.length() || c<a2.length())){
									c++;
								}
								
								
								if (a1_next > a2_next) {
									System.out.println(a1_next);
									System.out.println(a2_next);

									CD helpCD = reg.get(i);
									CD superiorCD = reg.get(i+1);
									
									reg.remove(i);
									reg.add(i, superiorCD);
									
									reg.remove(i+1);
									reg.add(i+1, helpCD);
								} else {
									
								}
							}	
						}
					}
				}
			}	
			System.out.println(reg);
		}	
	}
	*/
}
