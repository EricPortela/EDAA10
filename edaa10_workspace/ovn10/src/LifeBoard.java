public class LifeBoard {
	
	private boolean[][] board;
	private int rows;
	private int cols;
	
	private int gen;

	/** Skapar en spelplan med rows rader och cols kolonner. Spelplanen är från
	    början tom, dvs alla rutorna är tomma och generationsnumret är 1. */	
	public LifeBoard(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		gen = 1;
		board = new boolean[rows][cols];
		
		for (int r = 0; r<rows; r++) {
			for (int c = 0; c<cols; c++) {
				board[r][c] = false;
			}
		}
	}
	
	/** Ger true om det finns en individ i rutan med index row, col, false annars. 
	    Om index row, col är utanför spelplanen returneras false */
	public boolean get(int row, int col) {
		if (row > -1 && row < this.rows && col > -1 && col < this.cols) {
			return (board[row][col]);
		}
		return false;
	}
	
	/** Lagrar värdet val i rutan med index row, col */
	public void put(int row, int col, boolean val) {
		board[row][col] = val;
	}

	/** Tar reda på antalet rader */
	public int getRows() {
		return board.length;
	}

 	/** Tar reda på antalet kolonner */
	public int getCols() {
		return board[0].length;
	}

	/** Tar reda på aktuellt generationsnummer */
	public int getGeneration() {
		return gen;
	}
	
	/** Ökar generationsnumret med ett */
	public void increaseGeneration() {
		gen ++;
	}
}