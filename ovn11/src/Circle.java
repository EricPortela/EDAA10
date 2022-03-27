import se.lth.cs.window.SimpleWindow;

public class Circle extends Shape {
	private int radius;
	
	public Circle(int x, int y, int radius) {
		super(x, y); // koordinaterna x och y anger medelpunkten på en cirkel
		this.radius = radius;
	}
	
	public void draw(SimpleWindow w) {
		
		w.moveTo(x, y); //Move to starting point ==> Middle of circle
		
		w.moveTo(x, y-radius); //Move to top, middle of circle and then start drawing
				
		//w.lineTo(x+radius,  w.getY());
		
		//createCurvedLine(w, x-radius, y+radius, radius);
		for (int i=1; i<361; i++) {
						
			int a = (int) Math.round((Math.cos(Math.toRadians(i)) * (double) radius));
			int b = (int) Math.round((Math.sin(Math.toRadians(i)) * (double) radius));
			
			w.lineTo(w.getX()+a, w.getY()+b);	
		}
	}
	
	
	
	
	
	
	
	
	
	private int[] getPointBySides(int nSides, int radius) {
		double alfaDeg = (360/nSides)/2;
		double betaDeg = 180-90-alfaDeg;
		double betaRad = Math.toRadians(betaDeg);
		double hypotenus = Math.sqrt(radius);
				
		int x2 = (int) (Math.cos(betaRad) * hypotenus);
		int y2 = (int) (Math.sin(betaRad) * hypotenus);
		
		int[] arr = new int[2];
		arr[0] = x2;
		arr[1] = y2;
		
		return arr;
	}

	
	private void createCurvedLine(SimpleWindow w, int xToReach, int yToReach, int radius) {
		
		int currentX = w.getX();
		int currentY = w.getY();
		
		int centerX = x ;
		int centerY =  y + radius;
		
		int[] arr = getPointBySides(8, radius); 
		int x2 = arr[0];
		int y2 = arr[1];
		
		
		for (int i=0; i<360; i++) {
			
			int x = (int) (Math.round(Math.cos(Math.toRadians(i)) * radius));
			int y = (int) (Math.round(Math.sin(Math.toRadians(i)) * radius));
			
			w.lineTo(x, y);
		}
		
		w.lineTo(currentX + x2, currentY + y2);
//		w.lineTo(w.getX() + y2, w.getY() + x2);

//		w.lineTo(w.getX() + y2, w.getY() - x2);
//		w.lineTo(w.getX() - y2, w.getY() + x2);
//		
//		w.lineTo(w.getX() - x2, w.getY() - y2);
//		w.lineTo(w.getX() - y2, w.getY() - x2);
//
//		w.lineTo(w.getX() - y2, w.getY() + x2);
//		w.lineTo(w.getX() + y2, w.getY() - x2);



		
//		while (currentX != xToReach && currentY != yToReach) {
//			
//			w.lineTo(currentX+10, currentY+10);
//			
//			currentX = currentX + 10;
//			currentY = currentY + 10;
//		}
	}
}