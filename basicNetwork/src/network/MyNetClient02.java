package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyNetClient02 {

	public static void main(String[] args) {
		Socket client = null;
		InputStream is = null; //클라이언트와 input할 수 있는 스트림
		DataInputStream dis = null; //최종적으로 클라이언트와 DataInputStream을 이용해서
									//크라이언트로부터 전송되는 데이터를 읽기
		OutputStream os = null; //클라이언트와 output할 수 있는 스트림
		DataOutputStream dos = null;
		
		//서버와 통신할 수 있는 소켓객체를 생성 Socket(host, port)에서 host는 ip이다.
		//port는 서버포트와 같게
		
			Socket socket;
			try {
				socket = new Socket("70.12.115.51", 12345); //=> 생성하는게 접속
				//생성자 내부에서 접속이 이루어진다.
				
				System.out.println("서버접속완료..."+socket);
				
				//클라이언트에서도 서버와 통신할 수 있는소켓객체로부터 input/output스트림을 구한다.
				//InputStream얻기
				is = socket.getInputStream();
				dis = new DataInputStream(is);
				
				//OutputStream 얻기
				os = socket.getOutputStream(); //통로를 얻는다.
				dos = new DataOutputStream(os);
				
				//1.클라이언트 <- 서버 (서버가 보내는 데이터를 읽기 - 2번 연속해서 읽기)
				String data = dis.readUTF();
				System.out.println("서버가 전송하는 메시지 1번:"+data);
				int intdata = dis.readInt();
				System.out.println("서버가 전송하는 메시지2번:"+intdata);
				
				//2. 클라이언트 -> 서버
				dos.writeUTF("안녕하세요 서버님 . 클라이언트입니다.");
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}
