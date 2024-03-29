package network.echo;

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
public class MyEchoClient03 {

	public static void main(String[] args) {
		Socket socket = null;
		BufferedReader in = null;//input용으로 쓴다.
		BufferedReader keyin = null; //키보드 입력용 
		PrintWriter out = null; //output용으로 쓴다.
			try {
				socket = new Socket("70.12.115.53", 12345); //=> 생성하는게 접속
				System.out.println("서버접속완료..."+socket);
				
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = new PrintWriter(socket.getOutputStream(),true);
				//키보드로 입력한 데이터를 읽기 위한 스트림생성
				keyin = new BufferedReader(new InputStreamReader(
						System.in));	
				//***통신시작*****
				//키보드로 입력한 데이터를 서버로 지속적으로 전송 
				//서버가 다시 보내오는 데이터를 콘솔에 출력
				String sendMsg = ""; //서버로 보낼 메세지
				String resMsg = ""; //서버에서 받는 메세지
				String newMsg= ""; //서버가 나에게 준 에코답변메세지
				resMsg = in.readLine();
				
				System.out.println("서버가 보내 온 메세지>>"+resMsg);
				while((sendMsg=keyin.readLine())!=null) { //sndMsg가 null이 아니면 계속 작업
					//1.클라이언트 -> 서버(키보드로 입력하는 데이터를 서버로 전송)
					out.println(sendMsg);
					//2.클라이언트 <- 서버
					newMsg = in.readLine();
					System.out.println("서버가 보내 온 메세지>>"+newMsg);
				}
					
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
