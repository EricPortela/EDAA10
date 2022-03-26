import java.util.Random;

public class Checksum {
	
	Random rnd = new Random();
	int numberOctets;
	int[] packet;
	
	Checksum(int numberOctets){
		this.numberOctets = numberOctets;
		packet = new int[(numberOctets + 1)*8];
		for (int i = 0; i < 8; i++) {  /* Lägger in 0:or i position 0 - 7 där checksumman ska ligga */
			packet[i] = 0; 
		}
		for (int i = 8; i < packet.length; i++) {
			packet[i] = rnd.nextInt(2); /* Lägger in 0:or och 1:or slumpmässigt i resten av paketet */
		}
		checksum(); 
	}
	
	private void checksum() {
		int[] result = {0, 0, 0, 0, 0, 0, 0, 0};
		for (int i = 1; i <= numberOctets; i++) {
			int[] x = new int[8];
			for (int j = 8*i; j < 8*i + 8; j++) {
				x[j - 8*i] = packet[j];
			}
			result = sum(result, x);
		}
		for (int i = 0; i < 8; i++) {
			if (result[i] == 0) {
				packet[i] = 1;
			}
			else {
				packet[i] = 0;
			}
		}
	}
	
	
	private int[] sum(int[] x, int[] y) {
		int[] result = new int[x.length];
		int minne = 0;
		for (int i = 0; i < x.length; i++) {
			int summa = x[i] + y[i] + minne;
			if (summa == 0) {
				result[i] = 0;
				minne = 0;
			}
			else if (summa == 1) {
				result[i] = 1;
				minne = 0;
			}
			else if (summa == 2) {
				result[i] = 0;
				minne = 1;
			}
			else {
				result[i] = 1;
				minne = 1;
			}
		}
		if (minne == 1) {
			int[] oneLast = new int[x.length];
			for (int i = 0; i < x.length; i++) {
				oneLast[i] = 0;
			}
			oneLast[0] = 1;
			result = sum(result, oneLast);
		}
		return result;
	}
	
	
	void printPacket() {
		String str = "";
		for (int i = packet.length - 1; i >= 0; i--) {
			str = str + packet[i];
			if (i % 8 == 0 && i != 0) {
				System.out.println(str + " Data");
				str = "";
			}
			else if (i == 0){
				System.out.println(str + " Checksum");
			}
		}
	}
	

	
	void toggleBits(int k) {
		int[] changed = new int[packet.length];
		for (int i = 0; i < packet.length; i++) {
			changed[i] = 0;
		}
		int numberChanged = 0;
		while (numberChanged < k) {
			int bit = rnd.nextInt(packet.length);
			if (changed[bit] == 0) {
				changed[bit] = 1;
				if (packet[bit] == 1) {
					packet[bit] = 0;
				}
				else {
					packet[bit] = 1;
				}
				numberChanged++;
			}
		}
	}
	
	boolean packetAccepted() {
		int[] result = {0, 0, 0, 0, 0, 0, 0, 0};
		for (int i = 0; i <= numberOctets; i++) {
			int[] x = new int[8];
			for (int j = 8*i; j < 8*i + 8; j++) {
				x[j - 8*i] = packet[j];
			}
			result = sum(result, x);
		}
		for (int i = 0; i < 8; i++) {
			if (result[i] == 0) {
				return false;
			}
		}
		return true;
	}

	

}
