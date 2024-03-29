package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class MyNetServer03 {

	public static void main(String[] args) {
		Socket client = null;
		InputStream is = null; //클라이언트와 input할 수 있는 스트림
		DataInputStream dis = null; //최종적으로 클라이언트와 DataInputStream을 이용해서
									//크라이언트로부터 전송되는 데이터를 읽기
		OutputStream os = null; //클라이언트와 output할 수 있는 스트림
		DataOutputStream dos = null;
		
		// 클라이언트와 통신할 수 있도록 준비
		try {
			// 클라이언트와 통신할 수 있도록 준비
			ServerSocket server = new ServerSocket(12345);
			System.out.println("서버준비완료... 클라이언트의 접속을 기다림");

			// 여러클라이언트에게 서비스를 하기 위해서 무한루프
			while (true) {
				// 클라이언트가 접속할 때까지 대기
				// accept메소드는 클라이언트가 접속하면 접속한 클라이언트의 소켓객체를 리턴
				 client = server.accept();
				InetAddress clientInfo = client.getInetAddress();
				System.out.println("접속한 클라이언트:" + clientInfo.getHostAddress());
				//클라이언트와 통신하기 위한 Input/output Stream객체를 소켓으로부터 구한다.
				//InputStream얻기
				is = client.getInputStream();
				dis = new DataInputStream(is);
				
				//OutputStream 얻기
				os = client.getOutputStream(); //통로를 얻는다.
				dos = new DataOutputStream(os);
				
				Random rand = new Random();
				int result = rand.nextInt(9)+1;
				
				//1.서버 -> 클라이언트로 내보내는 작업(output)
				// (순서가 중요..output을 연속으로 2 번)
				dos.writeUTF("안녕하세요 클라이언트님. ");
				dos.writeInt(result);
				
				//2,서버 <- 클라이언트
				String data = dis.readUTF();
				System.out.println("클라이언트가보낸메시지 : "+data);
			}
		} catch (IOException e) {// 패킷단위 통신이라 IOException해준다.
			e.printStackTrace();
		} // port번호

	}

}
