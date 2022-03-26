package ovn8;

import java.util.Arrays;

public class Hemuppgift {
	
	private int [] v;
	private int n;
	private int lenghtArray;

	public Hemuppgift(int n) {
		this.n = n;
		this.v = new int[this.n];
		this.lenghtArray = v.length;
		
		v[0] = 2;
		v[1] = -5;
		v[2] = 14;
		v[3] = 21;
		v[4] = -7;
	}
	
	public void addNbr(int nbr, int k) {
		
		int help;
		
		if (k<lenghtArray) {
			for (int i = k; i<lenghtArray; i++) {
				help = v[i];
				v[i] = nbr;
				
				nbr = help;
			}
		}
		
		System.out.println(Arrays.toString(v));
	}
	
	public void removeNbr(int k) {
						
		for (int i = k; i<lenghtArray-1; i++) {
			v[i] = v[i+1];
			
		}
		
		System.out.println(Arrays.toString(v));
	}
	
	public boolean allElementsGreaterThanZero() {
		boolean greaterThanZero = true;
				
		for (int i = 0; i<lenghtArray; i++) {
			if (v[i] < 0) {
				greaterThanZero = false;
			}
		}
		
		return greaterThanZero;
	}
	
	

}
