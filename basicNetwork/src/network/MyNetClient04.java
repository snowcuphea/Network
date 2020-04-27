package network;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
public class MyNetClient04 {

	public static void main(String[] args) {
		Socket socket = null;
		BufferedReader in = null;//input용으로 쓴다.
		PrintWriter out = null; //output용으로 쓴다.
	
			try {
				socket = new Socket("70.12.115.53", 12345); //=> 생성하는게 접속
				System.out.println("서버접속완료..."+socket);
				
				in = new BufferedReader(new InputStreamReader(
						socket.getInputStream()));
				out = new PrintWriter(socket.getOutputStream(),true);
				
				//***통신시작*****
				//1.클라이언트 <- 서버
				String msg = in.readLine();
				System.out.println("서버가 보내온 메세지:"+msg);
				
				//2. 클라이언트 -> 서버
				out.println("Hello Server! I'm Client");
				//out.flush();
					
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
