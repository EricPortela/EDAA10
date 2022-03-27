package ovn7;
import se.lth.cs.window.SimpleWindow;
import java.util.*;

public class Turtle {
	
	private double xHome;
	private double yHome;
	private int beta;
	private boolean penDown;
	
	SimpleWindow w;
 
  /** skapar en sköldpadda som ritar i ritfönstret w. 
      Från början befinner sig sköldpaddan i punkten xHome,yHome med pennan 
      lyft och huvudet pekande rakt uppåt i fönstret, dvs i negativ y-riktning  
  */
  public Turtle(SimpleWindow w, int xHome, int yHome) {
	  this.w = w;
	  this.xHome = xHome;
	  this.yHome = yHome;
	  this.beta = 90;
	  penDown = false;
	  
	  //w.moveTo(xHome, yHome);
  }

  /** sänker pennan */
  void penDown() {
	  penDown = true;
  }

  /** lyfter pennan */
  void penUp() {
	  penDown = false;
  }

  /** går rakt framåt n pixlar i huvudets riktning */
  void forward(int n) {
	  double alfa = Math.toRadians(this.beta);
	  	  
	  double xAdd = n*(Math.cos(alfa));
	  double yAdd = n*(Math.sin(alfa));
	  
	  double x1 = this.xHome + xAdd;
	  double y1 = this.yHome - yAdd;
	  
	  if (penDown == true) { //Om penna nere
		  this.w.moveTo((int)this.xHome, (int)this.yHome);
		  this.w.lineTo((int) Math.round(x1), (int) Math.round(y1));
	  }
	  
	  else { //Om penna uppe
		  this.w.moveTo((int) Math.round(x1), (int) Math.round(y1));
	  }
	  
	  //Ersätt startpunktens värde med de nya koordinaterna
	  this.xHome = x1;
	  this.yHome = y1;
  }

  /** vrider huvudet beta grader åt vänster */
  void left(int beta) {
	  this.beta += beta;
  }

  /** vrider hvudet beta grader åt höger */
  void right(int beta) {
	  this.beta -= beta;
  }

  /** går till punkten newX,newY utan att rita. 
      Pennans läge och huvudets riktning påverkas inte */
  void jumpTo(int newX, int newY) {
	  w.moveTo(newX, newY);
	  
	  this.xHome = newX;
	  this.yHome = newY;
  }

  /** återställer huvudets riktning till den ursprungliga */
  void turnNorth() {
	  this.beta = 90;
  }

  /** tar reda på sköldpaddans aktuella x-koordinat */
  int getX() {
	  int x = (int) this.xHome;
	  return x;
  }

  /** tar reda på sköldpaddans aktuella y-koordinat */
  int getY() {
	  int y = (int) this.yHome;
	  return y;
  }
}
