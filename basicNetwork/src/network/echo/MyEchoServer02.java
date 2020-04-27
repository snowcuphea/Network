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

public class MyEchoServer02 {
	public static void main(String[] args) {
		Socket client = null;
		BufferedReader in = null;//input용으로 쓴다.
		PrintWriter out = null; //output용으로 쓴다.
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
				
				//******통신시작 ******
				//클라이언트가 보내오는 메세지를 다시 클라이언트에게 전송
				//클라이언트가 보내오는 데이터를 저장
				String resMsg = "";
				Date today = new Date();
				SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");
				
				//1. 서버 -> 클라이언트
				out.println("안녕하세요 클라이언트님?");
				while(true) {
					//2.서버 <- 클라이언트
					resMsg = in.readLine();
					//3.서버 -> 클라이언트
					if(resMsg.equals("안녕하세요") |
							resMsg.equals("하이")) {
						
						out.println(clientinfo.getHostAddress()+"님 반가워요");
					}else if(resMsg.equals("오늘날짜는")) {
						out.println(new Date().toString());
					}else {
						out.println(clientinfo.getHostAddress()+"님 어여 가");
					}				
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
}
