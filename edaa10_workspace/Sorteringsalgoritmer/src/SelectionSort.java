import java.util.ArrayList;
import java.util.Random;

public class SelectionSort {

	private ArrayList<Integer> sortedInt;
	

	public SelectionSort() {
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
	
	/** Selection Sort for ArrayList containing objects of type Integer */
	public ArrayList<Integer> selectionSortInt(ArrayList<Integer> unsortedArrayList, boolean isDescending) {
		sortedInt = new ArrayList<Integer>(unsortedArrayList);
		
		if (isDescending) { //Stigande ordning 
			for (int i=0; i<sortedInt.size()-1; i++) {
				if (!isDescending) {
					
				}
				int max = Integer.MIN_VALUE;
				int minIndex = -1;
				for (int k=i; k<sortedInt.size(); k++) {
					if (sortedInt.get(k) > max) { // >
						max = sortedInt.get(k);
						minIndex = k;
					}
				}
				int temp = sortedInt.get(i);
				sortedInt.remove(minIndex);
				sortedInt.add(minIndex,temp);
				sortedInt.remove(i);
				sortedInt.add(i, max);
			}
		} else {
			for (int i=0; i<sortedInt.size()-1; i++) {
				if (!isDescending) {
					
				}
				int min = Integer.MAX_VALUE;
				int minIndex = -1;
				for (int k=i; k<sortedInt.size(); k++) {
					if (sortedInt.get(k) < min) { // <
						min = sortedInt.get(k);
						minIndex = k;
					}
				}
				int temp = sortedInt.get(i);
				sortedInt.remove(minIndex);
				sortedInt.add(minIndex,temp);
				sortedInt.remove(i);
				sortedInt.add(i, min);
			}
		}
		return sortedInt;
	}	
}
