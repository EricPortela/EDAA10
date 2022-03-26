package ovn8;
import se.lth.cs.window.SimpleWindow; 

public class TurtleRace {

	public static void main(String[] args) {
		
		SimpleWindow w = new SimpleWindow(500, 500, "TurtleRace");
		
		RaceTrack rt = new RaceTrack(400, 20, w);
		
		int x1 = rt.getX1();
		int x2 = rt.getX2();
		
		int yStart = rt.getYStart();
		
		Turtle t1 = new Turtle(w, x1, yStart);
		Turtle t2 = new Turtle(w, x2, yStart);

		
		RacingEvent re = new RacingEvent(rt, t1, t2);
		
		
		//Rita RaceTrack
		rt.draw(w);

		//Racing event
		re.executeRace(w);
		
	}

}
