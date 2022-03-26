import java.util.Arrays;
import java.awt.Color;

public class Generator {
	

	public Generator() {
	}
	
	/** Ritar en bild i fönstret i användargränssnittet gui */
	public void render(MandelbrotGUI gui) {
		gui.disableInput();
		
		double minRe = gui.getMinimumReal();
		double maxRe = gui.getMaximumReal();
		double minIm = gui.getMinimumImag();
		double maxIm = gui.getMaximumImag();
		int width = gui.getWidth();
		int height = gui.getHeight();
		
		Complex[][] complex = this.mesh(minRe, maxRe, minIm, maxIm, width, height);
		
		Color[][] picture = new Color[height][width];
		
		for (int r=0; r<height; r++) {
			for (int c=0; c<width; c++) {
				
				Complex com = complex[r][c];
				Complex z = new Complex(0, 0);
				int k = 0;
				
				while (k < 200) {
					
					if (Math.sqrt(z.getAbs2()) <= 2) {
						picture[r][c] = Color.BLACK;

					} else {
						picture[r][c] = Color.WHITE;
					}
							
					z.mul(z);
					z.add(com);
					
					
					k++;
				}
				
//				if (abs > 1) {
//					picture[r][c] = Color.WHITE;
//				} else if(re > 0 && im > 0) { //1a kvad
//					picture[r][c] = Color.RED;
//				} else if(re < 0 && im > 0) { //2a kvad
//					picture[r][c] = Color.BLUE;
//				} else if(re < 0 && im < 0) { //3e kvad
//					picture[r][c] = Color.YELLOW;
//				} else if(re > 0 && im < 0) { //4e kvad
//					picture[r][c] = Color.ORANGE;
//				}
			}
		}
		
		int pixelWidth = 1;
		int pixelHeight = 1;
		
		gui.putData(picture, pixelWidth, pixelHeight);
		gui.enableInput(); //Anropa till sist enableInput för att återställa funktionen hos användargränssnittets knappar.
	}
	
	/** Skapar en matris där varje element är ett komplext tal som 
	 * har rätt koordinater (se beskrivning nedan) */
	private Complex[][] mesh(double minRe, double maxRe, double minIm, double maxIm, int width, int height) {
		Complex[][] cMatrix = new Complex[height][width];
		
		
		double deltaRe = (-(minRe) + maxRe) / (double) (width-1);
		double deltaIm = (-(minIm) + maxIm) / (double) (height-1);
		double tempIm = maxIm;
		
		for (int r=0; r<height; r++) { //row
			
			double tempRe = minRe;

			for (int c=0; c<width; c++) { //colon
				
				tempRe = minRe + (deltaRe*c);
				cMatrix[r][c] = new Complex(tempRe, tempIm);
				
			}
			
			tempIm = maxIm - (deltaIm*r);
			
		}
		return cMatrix;
	}
}
