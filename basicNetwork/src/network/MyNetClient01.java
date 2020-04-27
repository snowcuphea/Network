package network;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyNetClient01 {

	public static void main(String[] args) {
		//서버와 통신할 수 있는 소켓객체를 생성 Socket(host, port)에서 host는 ip이다.
		//port는 서버포트와 같게
		
			Socket socket;
			try {
				socket = new Socket("70.12.115.53", 12345);
				System.out.println("서버접속완료..."+socket);
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}
