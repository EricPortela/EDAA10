
public class Mandelbrot {

	public static void main(String[] args) {
		MandelbrotGUI mb = new MandelbrotGUI();
		
		Generator gen = new Generator();
		boolean hasRendered = false;
		
		while (true) {
			
			int cmd = mb.getCommand();
			
			switch (cmd) {
				case 1: //Render
					gen.render(mb);
					hasRendered = true;
					break;
					
				case 2: //ZOOM
					if (hasRendered==true) {
						gen.render(mb);
					} else {
						mb.resetPlane();
						mb.clearPlane();
					}
					break;
				
				case 8: //RESET
					//System.out.println("Reset");
					mb.resetPlane();
					mb.clearPlane();
					hasRendered = false;
					break;
					
				case 16: //QUIT
					//System.out.println("Quit");
					System.exit(0);
					break;
					
				case 32: //BW
					break;
					
				case 64: //COLOR
					break;
					
				case 128: //VERY LOW RES
					break;
					
				case 256: //LOW RES
					break; 
					
				case 512: //MED RES
					break;
					
				case 1024: //HIGH RES
					break;
					
				case 2048: //VERY HIGH RES
					break;
					
				default:
					System.out.println("Nothing");
					break;
			}
		}
	}
}
