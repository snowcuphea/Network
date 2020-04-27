package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
//바이너리데이터를 읽고 쓰지 않는 경우 - 문자열 

public class MyNetServer04 {
	
	
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
				System.out.println("접속한클라 : "+clientinfo.getHostAddress());;
				in = new BufferedReader(new InputStreamReader(
						client.getInputStream()));
				out = new PrintWriter(client.getOutputStream());
				//******통신시작 ******
				out.println("클라이언트님 접속 성공"); //반드시 ln해야함
				//출력하기 위한 데이터를 출력버퍼에 임시로 쌓았다가 스트림으로 출력되기 위해서
				//버퍼에 쌓여있는 데이터를 내보내는 작업
				out.flush(); //flush는 버퍼를 비우는 명령어
				
				String msg = in.readLine();
				System.out.println("클라이언트가 전송한메시지"+msg);

			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
}
