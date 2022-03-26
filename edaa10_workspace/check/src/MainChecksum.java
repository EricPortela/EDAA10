public class MainChecksum {
	

	public static void main(String[] args) {

//		CRC packet = new CRC(4);                     
//		packet.printPacket();                        
//		System.out.println(packet.packetAccepted());  
//		packet.toggleBits(1);                        
//		System.out.println(packet.packetAccepted()); 
// 		
//		int falseAccepted = 0;
//		
//		System.out.println("Antal felaktiga som accepteras: " + falseAccepted);
//		
		
		// H�r ska kod l�ggas in som "tillverkar" 100 000 paket, l�gger in fel i dem och r�knar 
		// hur m�nga av de felaktiga paketen som mottagaren tror �r r�tt. Ett tips: en for-sats
		// �r bra till detta. falseAccepted kan anv�ndas f�r att r�kna antalet paket som 
		// accepteras av mottagaren fast�n alla 100 000 paketen inneh�ller fel.
				
		int maxPackets = 100000;
		int nbrErrorBits = 40; //2, 5, 10, 20 40
		int notAcceptedCount = 0;
		
//		Uppgift 4

		CRC crc;
		
		for (int i=0; i<maxPackets; i++) {
			crc = new CRC(9);
			crc.toggleBits(nbrErrorBits);
			
			if (!crc.packetAccepted()) {
				notAcceptedCount += 1;
			}
		}
		
//		Uppgift 3
//		Checksum cs;
//		
//		for (int i=0; i<maxPackets; i++) {
//			cs = new Checksum(9);
//			cs.toggleBits(nbrErrorBits);
//			
//			if (!cs.packetAccepted()) {
//				notAcceptedCount += 1;
//			}
//		}
		

//		Uppgift 2
//		Paritybits pb;
//		
//		for (int i=0; i<maxPackets; i++) {
//			pb = new Paritybits(9);
//			pb.toggleBits(nbrErrorBits);
//			
//			if (!pb.packetAccepted()) {
//				notAcceptedCount += 1;
//			}
//		}
		
		System.out.println("Antal accepterade paket: " + (maxPackets - notAcceptedCount));
		
	}

}
