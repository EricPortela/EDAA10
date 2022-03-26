import se.lth.cs.window.SimpleWindow;

public class ShapeListTest {
	public static void main(String[] args) {
	    	SimpleWindow w = new SimpleWindow(600, 600, "ShapeListTest");
	    	ShapeList shapes = new ShapeList();
	    	shapes.insert(new Square(100, 300, 100));
	    	shapes.insert(new Triangle(400, 200, 100));
	    	shapes.insert(new Circle(400, 400, 50));
	    	shapes.insert(new Square(450, 450, 50));
	    	shapes.insert(new Square(200, 200, 35));
	    	shapes.draw(w);
	    	
	    	
	    	while (true) { 
			// användaren klickar på en av figurerna 
	    		
	    		w.waitForMouseClick();
	    		
	    		int xc = w.getMouseX();
	    		int yc = w.getMouseY();
	    		
    			Shape selectedShape = shapes.findHit(xc, yc);
	    				
	    		if (selectedShape != null) {
	    			// användaren klickar på en ny position 
		    		w.waitForMouseClick();

	    			int newX = w.getMouseX();
	    			int newY = w.getMouseY();
	    			
	    			// figuren flyttas till den nya positionen 
	    			selectedShape.moveToAndDraw(w, newX, newY);
	    		}	
	    	} 
	}
}