
import java.util.*;
import se.lth.cs.window.SimpleWindow;

public class TwoRandomTurtles {

	public static void main(String[] args) {
		
		SimpleWindow w = new SimpleWindow(600, 600, "Two Random Turtles");
		Random rand = new Random();
		
		Turtle t1 = new Turtle(w, 250, 250);
		Turtle t2 = new Turtle(w, 350, 350);
		
		double distance = 100, a, b, aSquared, bSquared;
		
		int steps;
		int angle;
		t1.penDown();
		t2.penDown();
		
		int count = 0;
		
		while (distance >= 50) {
			steps =  1 + rand.nextInt(10);
			angle = -179 + rand.nextInt(180);
			
			t1.forward(steps);
			t1.left(angle);
			
			steps = 1 + rand.nextInt(10);
			angle = -179 + rand.nextInt(180);
			
			t2.forward(steps);
			t2.left(angle);	
			
			a = Math.abs((t1.getY() - t2.getY()));
			b = Math.abs((t1.getX() - t2.getX()));
			
			aSquared = Math.pow(a, 2);
			bSquared = Math.pow(b, 2);
			
			distance = Math.sqrt(aSquared + bSquared);
						
			w.delay(10);
			count += 1;
		}
		
		System.out.println("FINISHED! " + count);
	}
}
