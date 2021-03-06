import java.util.ArrayList;
import java.util.Random;

public class InsertionSort {
	
	private ArrayList<Integer> sortedInt;
	
	
	public InsertionSort() {
		sortedInt = new ArrayList<Integer>();
	}
	
	/** Generate random number sequence of type Integer in ArrayList */
	public ArrayList<Integer> generateRandomInt(int length, int start, int end) {
		Random r = new Random();
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		//Genererar 10 st random siffror mellan 1-50 och lägger in i en ArrayList
		for (int i=0; i<length; i++) {
			numbers.add(start+r.nextInt(end));
		}
		return numbers;
	}
	
	public ArrayList<Integer> InsertionSortInt(ArrayList<Integer> unsortedArrayList, boolean isDescending) {
		
		
		for (int i=0; i<unsortedArrayList.size(); i++) {
			for (int k=i; k<unsortedArrayList.size(); k++) {
				int nbr = unsortedArrayList.get(i);
				int comparingNbr = unsortedArrayList.get(k);
				
				if (!isDescending) {
					if (comparingNbr<nbr) { //BYT TECKEN OM DU VILL HA FALLANDE ORDNING 
						unsortedArrayList.remove(i);
						unsortedArrayList.add(i,comparingNbr);
						unsortedArrayList.remove(k);
						unsortedArrayList.add(k,nbr);
					}
				} else {
					if (comparingNbr>nbr) { //BYT TECKEN OM DU VILL HA FALLANDE ORDNING 
						unsortedArrayList.remove(i);
						unsortedArrayList.add(i,comparingNbr);
						unsortedArrayList.remove(k);
						unsortedArrayList.add(k,nbr);
					}
				}
			}
		}
		
		
		return unsortedArrayList;
	}
}
