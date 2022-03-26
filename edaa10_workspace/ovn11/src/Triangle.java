import se.lth.cs.window.SimpleWindow;

public class Triangle extends Shape {
	
	int side;
	
	public Triangle(int x, int y, int side) {
		super(x,y); // koordinaterna x och y anger nedre vänstra hörnet på en triangel
		this.side = side;
	}
	
	public void draw(SimpleWindow w) {
		w.moveTo(x, y);
		
		double c2 = Math.pow(side, 2.0);
		double a2 = Math.pow(side/2, 2.0);
		
		double height = Math.sqrt(c2-a2);
		double topY = y - height;
		
		w.lineTo(x + side/2 , (int)topY);
		
		w.lineTo(x+side, y);
		
		w.lineTo(x, y);
	}
}
