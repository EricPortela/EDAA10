
public class Complex {
	
	private double re;
	private double im;
	
	/** Skapar en komplex variabel med realdelen re och imaginärdelen im */
	public Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}
	
	/** Tar reda på realdelen */
	public double getRe() {
		return re;
	}
	
	/** Tar reda på imaginärdelen */
	public double getIm() {
		return im;
	}
	
	/** Tar reda på talets absolutbelopp i kvadrat */
	public double getAbs2() {
		double reSq = Math.pow(re, 2);
		double imSq = Math.pow(im, 2);
		
		//double absVal = Math.sqrt(reSq + imSq);

		return reSq + imSq; //Math.pow(absVal, 2);
	}
	
	/** Adderar det komplexa talet c till detta tal */
	public void add(Complex c) {
		this.re = this.re + c.re;
		this.im = this.im + c.im;
	}
	
	/** Multiplicerar detta tal med det komplexa talet c */
	public void mul(Complex c) {
		double reHelp = (this.re*c.getRe()) - (this.im*c.getIm());
		double imHelp = (this.re*c.getIm()) + (this.im*c.getRe());
		
		this.re = reHelp;
		this.im = imHelp;
	}
}
