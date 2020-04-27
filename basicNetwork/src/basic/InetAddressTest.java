package basic;

import java.net.InetAddress;
import java.net.UnknownHostException;

//InetAddress - IP를 표현하기 위한 객체 
public class InetAddressTest {
	public static void main(String[] args) {
		try {
			InetAddress ia = InetAddress.getByName(args[0]);
			System.out.println("ia.getHostName()=>"+ia.getHostName());
			System.out.println("ia.getHostAddress()=>"+ia.getHostAddress());
			//로컬호스트.getLocalHost()는 static에서 클래스명으로 접근
			System.out.println("InetAddress.getLocalHost()=>"+InetAddress.getLocalHost());
			
			InetAddress[] ialist = InetAddress.getAllByName(args[0]);
			for(int i=0;i<ialist.length;i++) {
				System.out.println("ialist.getHostName()=>"+ialist[i].getHostName());
				System.out.println("ialist.getHostAddress()=>"+ialist[i].getHostAddress());
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
