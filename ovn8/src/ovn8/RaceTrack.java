package ovn8;
import se.lth.cs.window.SimpleWindow; 

public class RaceTrack {
	
	private SimpleWindow w;
	
	private int yStart;
	private int yFinish;
	
	private int x1; //x koordinat för den första deltagaren, ex. turtle
	private int x2; //x koordinat för den andra deltagaren, ex. turtle
		

	/** Skapar en kapplöpningsbana. yStart och yFinish är y-koordinaterna för start-och mållinje. yStart alltid > yFinish*/
	
	public RaceTrack(int yStart, int yFinish, SimpleWindow w) {
		this.yStart = yStart;
		this.yFinish = yFinish;
		this.w = w;
		
		int width = w.getWidth();
		this.x1 = (int) (width*0.2);
		this.x2 = (int) (width - (x1));
	}
	
	/** Ritar kapplöpningsbanan i fönstret w */ 
		
	public void draw(SimpleWindow w) {
		int width = w.getWidth();
		
		int xStart = (int) (width*0.2); // vid x = (20% av bredden) börjar start/mållinje
		int xFinish = width - xStart; // vid x = (bredd - 20% av bredden) slutar start/mållinje
		
		w.moveTo(xStart, yStart);
		w.lineTo(xFinish, yStart);
		
		w.moveTo(xStart, yFinish);
		w.lineTo(xFinish, yFinish);
	}
	
	public int getYStart() {
		return this.yStart;
	}
	
	public int getYFinish() {
		return this.yFinish;
	}
	
	public int getX1() {
		return x1;
	}
	
	public int getX2() {
		return x2;
	}
	
}
