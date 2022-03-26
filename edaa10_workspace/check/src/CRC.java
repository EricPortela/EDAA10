import java.util.Random;

public class CRC {
	
	Random rnd = new Random();
	int numberOctets;
	int[] packet;
	int[] divisor = {1, 0, 1, 0, 1, 0, 1, 1, 1};
	
	
	CRC(int numberOctets){
		this.numberOctets = numberOctets;
		packet = new int[(numberOctets + 1)*8];
		for (int i = 0; i < 8; i++) {  /* Lägger in 0:or i position 0 - 7 där checksumman ska ligga */
			packet[i] = 0; 
		}
		for (int i = 8; i < packet.length; i++) {
			packet[i] = rnd.nextInt(2); /* Lägger in 0:or och 1:or slumpmässigt i resten av paketet */
		}
		sumCRC(); 
	}

	
	private void sumCRC() {
		int[] dummy = new int[packet.length];
		for (int i = 0; i < packet.length; i++) {
			dummy[i] = packet[i];
		}
		for (int i = dummy.length - 1; i >= 8; i--) {
			if (dummy[i] == 1) {
				for (int j = i; j >= i - 8; j--) {
					dummy[j] = (dummy[j] + divisor[ 8 - i + j]) % 2;
				}
			}
		}
		for (int i = 0; i < 8; i++) {
			packet[i] = dummy[i];
		}
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
				System.out.println(str + " CRC");
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
		int[] dummy = new int[packet.length];
		for (int i = 0; i < packet.length; i++) {
			dummy[i] = packet[i];
		}
		for (int i = dummy.length - 1; i >= 8; i--) {
			if (dummy[i] == 1) {
				for (int j = i; j >= i - 8; j--) {
					dummy[j] = (dummy[j] + divisor[ 8 - i + j]) % 2;
				}
			}
		}
		for (int i = 0; i < 8; i++) {
			if (dummy[i] == 1) {
				return false;
			}
		}
		return true;
	}


}
