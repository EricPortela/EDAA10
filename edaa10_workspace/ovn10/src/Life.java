
public class Life {
	
	LifeBoard board;

	/** Skapar ett Life-spel med spelplanen board */ 
	public Life(LifeBoard board) {
		this.board = board;
	}
	
	/*  Tar reda på antal grannar till ruta row,col i rutnätet board */ 
	private int getNeighbours(LifeBoard board, int row, int col) {
		int count = 0;
		
		if (row-1 > 0) { 
			if (board.get(row-1, col)==true) { //NEIGHBOUR UP
				count ++;
			}
			if (col+1 < board.getCols() && board.get(row-1, col+1)==true) { //NEIGHBOUR UP/RIGHT (DIAGONAL)
				count ++;
			}
			if (col-1 > 0 && board.get(row-1, col-1)==true) { //NEIGHBOUR UP/LEFT (DIAGONAL)
				count ++;
			}
		}
		if (row + 1 < board.getRows()) {
			if (board.get(row+1, col)==true) { //NEIGHBOUR DOWN
				count ++;
			}
			if (col+1 < board.getCols() && board.get(row+1, col+1)==true) { //NEIGHBOUR DOWN/RIGHT (DIAGONAL)
				count ++;
			}
			if (col-1 > 0 && board.get(row+1, col-1)==true) { //NEIGHBOUR DOWN/LEFT (DIAGONAL)
				count ++;
			}
		}
		if (col - 1 > 0) {
			if (board.get(row, col-1)==true) { //NEIGHBOUR LEFT
				count ++;
			}
		}
		if (col + 1 < board.getCols()) {
			if (board.get(row, col+1)==true) { //NEIGHBOUR RIGHT
				count ++;
			}
		}
		return count;
	}  
	
	/*
	Tänk  på  att  i  operationen  newGeneration  skall  alla  förändringar  vid  en 
	generationsväxling  utföras  samtidigt  över  hela  spelplanen.  Enklast  åstad-
	kommer du detta genom att deklarera en hjälpmatris där du lagrar den nya 
	spelplanen. Vid slutet av metoden kopierar du hjälpmatrisen till den riktiga 
	spelplanen  (ditt  attribut  som  refererar  till  LifeBoard-objektet).  Alternativt 
	kan  du  använda  ett  hjälpbräde  (ett  annat  LifeBoard-objekt)  där  du  lagrar 
	den  nya  spelplanen.  Även  i  detta  fall  måste  du  avsluta  med  att  kopiera 
	hjälpbrädet till den riktiga spelplanen. 
	 */
	
	/** Skapar en ny generation */ 
	public void newGeneration() {
		board.increaseGeneration();
		
		boolean[][]helpMatrix = new boolean[board.getRows()][board.getCols()];
		
		//Populate helpMatrix
		for (int r=0; r<board.getRows(); r++) {
			for(int c=0; c<board.getCols(); c++) {
				int neighbours = getNeighbours(board, r, c);
				//System.out.println(neighbours);
				
				boolean currentSquare = board.get(r, c);
				if(neighbours>1) { //Om en individ har MINST 2 grannar
					
					//1. Fortlevnad
					if ((neighbours==2 && currentSquare==true)||(neighbours ==3 && currentSquare==true)) {
						helpMatrix[r][c] = true;
					}
					
					//2. Dödsfall
					else if (neighbours>=4 && currentSquare == true) {
						helpMatrix[r][c] = false;
					}
					
					//3. Födelse
					else if(neighbours==3 && currentSquare == false) {
						helpMatrix[r][c] = true;
					}
					
				} else { //Om en individ har EN eller NOLL grannar
					helpMatrix[r][c] = false;
				}
			}
		}
		
		//Iterate through helpMatrix and use method .put(row, col, val) 
		//to "upload" the copy to LifeBoard object
		for (int r=0; r<helpMatrix.length; r++) {
			for (int c=0; c<helpMatrix[0].length; c++) {
				boolean val = helpMatrix[r][c];
				board.put(r, c, val);
			}
		}
	}
	
	/** Ändrar innehållet i rutan med index row, col från individ till tom eller tvärtom */ 
	public void flip(int row, int col) {
		if (board.get(row, col)==true) {
			board.put(row, col, false);
		} else {
			board.put(row, col, true);
		}
	}
}
