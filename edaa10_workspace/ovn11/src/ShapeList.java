import java.util.*;
import se.lth.cs.window.SimpleWindow;;

public class ShapeList {
	
	private ArrayList<Shape> shapeList;

	/** Skapar en tom lista */  
	public ShapeList() {
		shapeList = new ArrayList<Shape>();
	}
	
	/** Lägger in figuren s i listan */  
	public void insert(Shape s) {
		shapeList.add(s);
	}
	
	/** Ritar upp figurerna i listan i fönstret w */  
	public void draw(SimpleWindow w) {
		
		for (int i=0; i<shapeList.size(); i++) {
			Shape s = shapeList.get(i);
			
			s.draw(w);
		}
	}
	
	/** Tar reda på en figur som ligger nära punkten xc,yc; ger null om  
	   ingen sådan figur finns i listan */ 
	public Shape findHit(int xc, int yc) {
		for (int i=0; i<shapeList.size(); i++) {
			Shape s = shapeList.get(i);
			
			if (s.near(xc, yc)) {
				return s;
			}
		}
		return null;
	}
}
