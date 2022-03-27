import java.util.Arrays;
import java.util.*;

public class Hemuppgift {

	public static void main(String[] args) {
		
		// Sätt startruta
		Board b = new Board();
		b.setStartPosition(1, 3);
		
		// Så länge det går att flytta 
		while(b.possibleToMove()==true) {
			// flytta 
			b.makeOneStep();
		}
		
		// Skriv ut matrisen 
		b.print();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		Random r = new Random();
		
		int [][] mat = new int [7][7];
		
		//Skapa en matris där samtliga element är noll
		for (int row=0; row<mat.length; row++) {
			for (int col=0; col<mat.length; col ++) {
				if (row == 0 || row == 6) {
					mat[row][col] = -1;
				} else {
					if (col == 0 || col == 6) {
						mat[row][col] = -1;
					} else {
						mat[row][col] = 0;
					}
				}
			}
			System.out.println(Arrays.toString(mat[row]));
		}
		
		//Spelet
		//1. Val av slumpmässig startruta
		//2. Besökt rutas värde (0) ska ersättas med stegets nummer
		//3. Varje ruta får besökas högst en gång, dvs kolla om värdet skiljt från noll
		//4. Gå sedan till en intilliggande ruta. Slumpen avgör riktningen (uppåt, nedåt, höger, vänster)
		
		System.out.println();
		
		//1. Val av slumässig startruta
		int randomRow = 1 + r.nextInt(5);
		int randomCol = 1 + r.nextInt(5);
		int randomCell;

		int count = 1;
		
		//Sparande av den valda startrutans intilligande rutor
		int upperCell = mat[randomRow-1][randomCol];
		int lowerCell = mat[randomRow+1][randomCol];
		int leftCell = mat[randomRow][randomCol-1];
		int rightCell = mat[randomRow][randomCol+1];

		
		while (upperCell == 0 || lowerCell == 0 || leftCell == 0 || rightCell == 0) {
			
			mat[randomRow][randomCol] = count;
			
			//2. Välj ny ruta (en som är intilliggande föregående och har värde 0)
			int direction = r.nextInt(4);
			
			randomCell = mat[randomRow][randomCol];
			int newRandomRow = randomRow;
			int newRandomCol = randomCol;
			
			if (direction == 0 && randomRow - 1 > 0) { //Uppåt
				newRandomRow = randomRow - 1;
				newRandomCol = randomCol;
			} else if (direction == 1 && randomRow + 1 < 7) { //Neråt
				newRandomRow = randomRow + 1;
				newRandomCol = randomCol;
			} else if (direction == 2 && randomCol - 1 > 0) { //Vänster
				newRandomCol = randomCol - 1;
				newRandomRow = randomRow;
			} else if (direction == 3 && randomRow + 1 < 7) { //Höger
				newRandomCol = randomCol + 1;
				newRandomRow = randomRow;
			}
			
						
			while(randomCell != 0) {
				direction = r.nextInt(4);
				
				if (direction == 0 && randomRow - 1 > 0) { //Uppåt
					newRandomRow = randomRow - 1;
					newRandomCol = randomCol;
				} else if (direction == 1 && randomRow + 1 < 7) { //Neråt
					newRandomRow = randomRow + 1;
					newRandomCol = randomCol;
				} else if (direction == 2 && randomCol - 1 > 0) { //Vänster
					newRandomCol = randomCol - 1;
					newRandomRow = randomRow;
				} else if (direction == 3 && randomRow + 1 < 7) { //Höger
					newRandomCol = randomCol + 1;
					newRandomRow = randomRow;
				}
								
				randomCell = mat[newRandomRow][newRandomCol];
			}
			
			randomRow = newRandomRow;
			randomCol = newRandomCol;

			
			upperCell = mat[randomRow-1][randomCol];
			lowerCell = mat[randomRow+1][randomCol];
			leftCell = mat[randomRow][randomCol-1];
			rightCell = mat[randomRow][randomCol+1];
			
			count += 1;
		}
		
		
		mat[randomRow][randomCol] = count;

		
		System.out.println();
		for (int i=0; i < mat.length; i++) {
			System.out.println(Arrays.toString(mat[i]));
		}
		System.out.println("STOP");
		*/
	}

}
