package ovn7;
import se.lth.cs.window.SimpleWindow;

public class testMyTurtle {

	public static void main(String[] args) {
		
		SimpleWindow w = new SimpleWindow(600, 600, "My Turtle Test");
		
		Turtle t = new Turtle(w, 300, 300);
		
		t.penDown();
		t.forward(100);
		t.left(-90);
		t.forward(50);
		
		System.out.println(t.getY());
	}
}
