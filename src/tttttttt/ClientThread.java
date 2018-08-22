package tttttttt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientThread extends Thread{
	
	private BufferedReader br;
	
	public ClientThread(Socket socket) {
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	@Override
	public void run() {
		while(true) {
			try {
				String readLine = br.readLine();
				System.out.println(readLine);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
