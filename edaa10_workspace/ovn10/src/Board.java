import java.util.Arrays;
import java.util.*;

public class Board {
	
	private int[][] sq = new int[7][7];
	private int r;
	private int c;
	private int step;
	private Random rg;

	/** skapar ett rutnät av storlek 5*5 för slumpmässig promenad */ 
	public Board() {
		rg = new Random();
		r = 0;
		c = 0;
		step = 1;
		
		for (int row=r; row<sq.length; row++) {
			for (int col=c; col<sq.length; col ++) {
				if (row == 0 || row == 6) {
					sq[row][col] = -1;
				} else {
					if (col == 0 || col == 6) {
						sq[row][col] = -1;
					} else {
						sq[row][col] = 0;
					}
				}
			}
		}
		System.out.println(sq);
	}
	
	 
	 /** gör rutan row,col till aktuell ruta */ 
	 void setStartPosition(int row, int col) {
		 r = row;
		 c = col;
		 sq[r][c] = step;
	 }
	 
	 
	 /** kontrollerar om det är möjligt att gå till någon av de fyra grannrutorna, 
	   dvs ger true om någon av dessa rutor är obesökta, false annars */ 
	 boolean possibleToMove() {
		 		 
		 if (r - 1 > 0) { //up
			 //System.out.println("Inside range (UP)");
			 if (sq[r-1][c] == 0) { //not used
				 //System.out.println("UP");
				 return true;
			 }
		 } 
		 
		 if(r + 1 < 6) { //down
			 //System.out.println("Inside range (DOWN)");
			 if (sq[r+1][c] == 0) { //not used
				 //System.out.println("DOWN");
				 return true;
			 }
		 } 
		 
		 if(c - 1 > 0) { //left
			 //System.out.println("Inside range (LEFT)");
			 if (sq[r][c-1] == 0) {
				 //System.out.println("LEFT");
				 return true;
			 }
		 }  
		 
		 if(c + 1 < 6) { //right
			 //System.out.println("Inside range (RIGHT)");
			 if (sq[r][c+1] == 0) {
				 //System.out.println("RIGHT");
				 return true;
			 }
		 }
		return false;  
	 }
	 
	 
	 /** går till en slumpmässigt vald grannruta. Det förutsätts att det finns 
	   minst en grannruta som inte är besökt. */
	 public void makeOneStep() {
		 boolean found = false;
		 
		 while (!found) { 
			 int i = r; 
			 int k = c; 
			 int rand = 1 + rg.nextInt(4);  // Random rg attribut i klassen 
			 if (rand == 1) { 
				 k++;   // gå till höger 
			 } else if (rand == 2) {
				 k--;   // gå till vänster 
			 } else if (rand == 3) {
				 i++;   // gå nedåt
			 } else {
				 i--;   // gå uppåt 
			 }
			 
			 if (sq[i][k] == 0) { 
				 found = true;
				 r = i;
				 c = k;
				 step++;
				 sq[r][c] = step; 
			 }
		 }
	 }
	 
	 
	 /** skriver ut rutnätet */ 
	 void print() {
		 for (int i = 0; i<sq[0].length; i++) {
			 System.out.println(Arrays.toString(sq[i]));
		 }
		 System.out.println();
		 System.out.println();
	 }
}
