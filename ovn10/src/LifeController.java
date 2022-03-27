
public class LifeController {

	public static void main(String[] args) {
		LifeBoard board = new LifeBoard(16, 16);
		LifeView window = new LifeView(board);
		Life life = new Life(board);
		
		window.drawBoard();
		
		/*
		 * 6x6
		board.put(1, 3, true);
		board.put(1, 4, true);
		board.put(2, 4, true);
		
		board.put(3, 1, true);
		board.put(4, 1, true);
		board.put(4, 2, true);
		*/
		
		
		while (true) {	
			
			//1 - Rutnät
			if (window.getCommand() == 1) {
				life.flip(window.getRow(), window.getCol());
				window.update();
			} 
			
			//2 - Nästa generation
			else if (window.getCommand() == 2) {
				life.newGeneration();
				window.update();
			}
			
			else {
				System.exit(0);
			}
		}
		
		
		
		/*
		if (board.get(0, 0) && !board.get(1, 1) && !board.get(-1, -1) && !board.get(3, 3)) {
			System.out.println("put och get ok");
		} else {
			System.out.println("Fel vid anrop av put eller get");
		}
		window.update();
		
		board.increaseGeneration();
		if (board.getGeneration() == 2 ) {
			System.out.println("getGeneration ok");
		} else {
			System.out.println("Fel vid anrop av getGeneration");
		}
		while (true) {	
			if (window.getCommand() == 3) {
				System.exit(0);
			}
		}
		*/
	}

}
