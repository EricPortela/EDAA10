package ovn8;
import java.util.Random; 
import se.lth.cs.window.SimpleWindow; 

public class RacingEvent {
	
	RaceTrack track;
	Turtle t1;
	Turtle t2;
	Random r;
	
	int yStart;
	int yFinish;
	
	//private Turtle turtleArray[];

	public RacingEvent(RaceTrack track, Turtle t1, Turtle t2) {
		this.track = track;
		this.t1 = t1;
		this.t2 = t2;
		
		this.yStart = track.getYStart();
		this.yFinish = track.getYFinish();
		
		r = new Random();
		
		//turtleArray = new Turtle[2];
		//turtleArray[0] = t1;
		//turtleArray[1] = t2;
	}
	
	/** Placering av deltagarna på startlinjen och sedan simulering av tävlingen*/
	
	public void executeRace(SimpleWindow w) {
		w.waitForMouseClick();
		
		int randomSteps;
		
		//OM turtles inte ska randomizas
		t1.penDown();
		t2.penDown();
		
		int t1FromFinish = t1.getY() - yFinish;
		int t2FromFinish = t2.getY() - yFinish;
		
		//OM turtles ska randomizas
		/*
		Turtle t1 = turtleArray[0];
		Turtle t2 = turtleArray[1];
		
		t1.penDown();
		t2.penDown();
		
		int t1FromFinish = t1.getY() - yFinish;
		int t2FromFinish = t2.getY() - yFinish;
		*/
		
	
		while (t1FromFinish > 0 && t2FromFinish > 0) { //Varför funkade ej || ???
			
			//OM turtles ska randomizas
			/*
			int randomInt = r.nextInt(2);
			Turtle t = turtleArray[randomInt];
			randomSteps = r.nextInt(3);
			t.forward(randomSteps);
			w.delay(10);
			
			if (t == t1) {
				t1FromFinish = t1.getY() - yFinish;
			} else {
				t2FromFinish = t2.getY() - yFinish;
			}
			turtleArray[0] = t1;
			turtleArray[1] = t2;
			*/
			
						
			
			//OM turtles inte ska randomizas
			randomSteps = r.nextInt(3);
			t1.forward(randomSteps);
			t1FromFinish = t1.getY() - yFinish;
			
			
			w.delay(10);
			
			randomSteps = r.nextInt(3);
			t2.forward(randomSteps);
			t2FromFinish = t2.getY() - yFinish;
			
			
			
			w.delay(10);
			
		}
		
		int middleX = w.getHeight()/2;
		int middleY = w.getWidth()/2;
		
		if (t1FromFinish <= 0) {
			w.moveTo(middleX, middleY);
			w.writeText("Deltagare 1 är vinnare!");
		} else {
			w.moveTo(middleX, middleY);
			w.writeText("Deltagare 2 är vinnare!");
		}
		
		System.out.println("SLUT");

	}

}
