package ovn2;
import java.util.*;


import java.util.concurrent.ThreadLocalRandom;
import se.lth.cs.window.SimpleWindow;
import se.lth.cs.p.ovn.turtle.Turtle;


public class Calculator {
	
	public static void main(String[] args) {
		
		
		//D2-5
		double nbr1, nbr2, sum, dif, prod, div;
		System.out.println("Skriv två tal");
		Scanner scan = new Scanner(System.in);
		nbr1 = scan.nextDouble();
		nbr2 = scan.nextDouble();
		sum = nbr1+nbr2;
		dif = nbr1 - nbr2;
		prod = nbr1*nbr2;
		div = nbr1/nbr2;
		
		System.out.println("Summan av talen är " + sum);
		System.out.println("Skillnaden mellan talen är " + dif);
		System.out.println("Produkten av talen är " + prod);
		System.out.println("Kvoten av talen är " + div);
		
		
		/*
		//############## P1-3 (D2-6) ##############
		SimpleWindow w = new SimpleWindow(1000,1000,"Turtle window"); // ett objekt w av klassen SimpleWindow skapas
		Turtle t = new Turtle(w,500,500); // ett objekt t av klassen Turtle skapas, dvs sköldpaddan t skapas
		// sköldpaddan t befinner sig nu mitt i fönstret w, är riktad norrut och har lyft pennan
				
		t.penDown();
		for (int k = 0; k <= 5; k ++) {
			t.forward(100); //som standard satt till 90 grader
			t.left(120); //enligt dokumentationen adderar .left() argumentets antal grader till alfa ==> 210
			t.forward(100);
			
			if (k == 2) {
				t.penUp();
				t.forward(110);
				t.penDown();
				t.forward(100);
			}
		}
		*/
		
		
		/*
		//############## P1-4 (D2-6) ##############
		int dptH, dptM, trlH, trlM, arrH, arrM;
		
		Scanner scan = new Scanner(System.in);
		
		//Departure Time Input
		System.out.print("Ange avgångstid: ");
		dptH = scan.nextInt();
		dptM = scan.nextInt();
		
		//Travel Time Input
		System.out.print("Ange körtid: ");
		trlH = scan.nextInt();
		trlM = scan.nextInt();
		
		//Arrival Time (Hour, Minute)
		arrH = dptH + trlH;
		arrM = dptM + trlM;
		
		//if-statement for arrival time calculation
		if (arrH >= 24) { //Travel time overlapping another day
			arrM = arrM%60;
			int extraH = arrM/60;
			int newH = arrH%24 + extraH;
			
			System.out.println("Ankomstid (Nästa dag): " + newH + ":" + arrM);
			
			
		} else if (arrM % 60 >= 0) { //Travel time not overlapping another day, but arrM > 60
			int extraH = arrM/60;
			arrM = arrM%60;
			
			arrH = arrH + extraH;
			System.out.printf("Ankomstid: " + arrH + ":" + arrM);
		} else {
			System.out.printf("Ankomstid: " + arrH + ":" + arrM);
		}
		*/
		
		
		/*
		//############## P1-5 (D2-6) ##############
		Scanner scan = new Scanner(System.in);
		
		int big = 0;
		int nextBig = 0;
		int nbr = 0;
		
		for (int k = 0; k<=5; k++) {
			nbr = scan.nextInt();
			if (nbr > big) {
				nextBig = big;
				big = nbr;
			}
			
			else if (nbr > nextBig) { 
				nextBig = nbr;
			}
		}
		
		System.out.println(big);
		System.out.println(nextBig);
	}
	*/
		
	}
	
}