import java.io.*;
import java.net.*;
public class KlientTwo {

	public static void main(String[] args) throws UnknownHostException, IOException {
		String sentence = "";
		String modifiedSentence;
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		
		while (!sentence.equals("stopp")){
			Socket clientSocket = new Socket("192.168.1.130", 6789); //192.168.1.130  127.0.0.1
			DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
			BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			
			sentence = inFromUser.readLine();
			if (!sentence.equals("stopp")) {
				outToServer.writeBytes(sentence + '\n');
				modifiedSentence = inFromServer.readLine();
				System.out.println(modifiedSentence);
			}
		}
		
		//clientSocket.close();
		
	}

}
