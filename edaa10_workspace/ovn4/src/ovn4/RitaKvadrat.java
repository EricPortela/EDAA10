package ovn4;
import se.lth.cs.window.SimpleWindow;
import se.lth.cs.p.ovn.turtle.Turtle;

public class RitaKvadrat {
	
	public static void main(String[] args) {
		
		SimpleWindow w = new SimpleWindow(800, 800, "Window");
		
		int y = 0, x = 0;
		
		while (true) {
			w.waitForMouseClick();
			
			x = w.getMouseX();
			y = w.getMouseY();
			
			Turtle t = new Turtle(w, x, y);
			t.penDown();
			t.left(180);
			
			for (int k = 0; k <=3; k++) {
				t.forward(300);
				t.left(90);
			}
		}
	}
}
