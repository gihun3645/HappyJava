package 네트워크;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpAddressExam {
    public static void main(String[] args) {
        try {
            InetAddress ia = InetAddress.getLocalHost(); // 내 컴퓨터의 IP 정보
            System.out.println(ia.getHostAddress());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }



        try {
            // 웹사이트 아이피주소 알아내기
            InetAddress[] iaArray = InetAddress.getAllByName("www.google.com");
            for (InetAddress ia : iaArray) {
                System.out.println(ia.getHostAddress());
            }
        } catch (UnknownHostException uhe) {
            uhe.printStackTrace();
        }
    }
}