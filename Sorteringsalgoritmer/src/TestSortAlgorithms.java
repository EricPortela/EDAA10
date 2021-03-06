import java.util.ArrayList;

public class TestSortAlgorithms {

	public static void main(String[] args) {
		
		
		//Selection sort with ArrayList<Int>
		
		SelectionSort ss = new SelectionSort(); //Create object
		
		ArrayList<Integer> unsortedArray1 = ss.generateRandomInt(20, 1, 50); //Generate random ArrayList
				
		ArrayList<Integer> sortedArray1 = ss.selectionSortInt(unsortedArray1, true); //Sort in descending order
		
		System.out.println(sortedArray1);

		
		
		
		//Insertion sort with ArrayList<Int> 
		
		InsertionSort is = new InsertionSort(); //Create object
		
		ArrayList<Integer> unsortedArray2 = is.generateRandomInt(10, 1, 50); //Generate random ArrayList
		
		ArrayList<Integer> sortedArray2 = is.InsertionSortInt(unsortedArray2, false); //Sort in ascending order
		
		System.out.println(sortedArray2);
		
	}

}
