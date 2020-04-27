package network.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
//바이너리데이터를 읽고 쓰지 않는 경우 - 문자열 
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyEchoServer03 {
	public static void main(String[] args) {
		Socket client = null;
		BufferedReader in = null;//input용으로 쓴다.
		PrintWriter out = null; //output용으로 쓴다.
		BufferedReader keyin = null;
		try {
			ServerSocket server = new ServerSocket(12345);
			System.out.println("서버접속완료...");
			while(true) {
				client = server.accept();
				InetAddress clientinfo = client.getInetAddress();
				System.out.println("접속한클라 : "+clientinfo.getHostAddress());
				in = new BufferedReader(new InputStreamReader(
						client.getInputStream()));
				out = new PrintWriter(client.getOutputStream(),true);
				keyin = new BufferedReader(new InputStreamReader(System.in));
				
				//******통신시작 ******				
				String resMsg = "";
				String sendMsg = "";
				out.println("안녕하세요 클라이언트님?");
				while(true) {
					//1.서버 <- 클라이언트
					resMsg = in.readLine();
					System.out.println("클라이언트>>"+resMsg);
					if(resMsg==null) {
						break;
					}
					//2. 서버 -> 클라이언트 (키보드로 입력한 데이터)
					sendMsg = keyin.readLine();
					out.println(sendMsg);
				
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
}
