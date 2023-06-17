package 네트워크;

import javax.swing.*;
import java.awt.print.PrinterException;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
    public static void main(String[] args) throws Exception {
        // 클라이언트가 접속할 때 까지 대기할 때 필요한 객체가 ServerSocket
        ServerSocket serverSocket = new ServerSocket(10000);
        System.out.println("1");

        // 대기한다. 클라이언트가 접속하면 클라이언트와 통신하는 Socket이 반환된다.
        // 대기와 응답이 반복해야 서버가 죽지않음
        try {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("2");

                // clientSocket 을 가지고 별도로 동작
                ClientThread ct = new ClientThread(clientSocket);
                ct.start();
            }
        } finally {
            serverSocket.close();
        }
    }
}

class ClientThread extends Thread {
    private Socket clientSocket;
    public ClientThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {
        try {
            InputStream inputStream = clientSocket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

            // 써주기 위한 소켓을 만든다

            OutputStream outputStream = clientSocket.getOutputStream();
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(outputStream));

            // localhost:10000/hello
            // GET /hello HTTP/1.1
            String firstLine = br.readLine();
            String msg = "";
            if (firstLine.indexOf("/hello") >= 0)
                msg = "hello";
            else if (firstLine.indexOf("/hi") >= 0)
                msg = "hi";
            System.out.println(firstLine);

            // Header 정보를 읽는다.
            String line = null;
            while (!(line = br.readLine()).equals("")) {
                System.out.println(line);
            } // 빈줄까지 읽으면 끝

            System.out.println("3 - 응답을 한다.");

            pw.println("HTTP/1.1 200 OK"); // 응답
            pw.println("name : kim");
            pw.println("email : urstory@gmail.com");
            pw.println();
            pw.flush(); // 서버에 전송

            // GET /hello HTTP/1.1 의 요청이 왔을 때 /hello 에 대한 파일을 읽어서 출력한다.
            pw.println("<html>"); // body 부분
//            pw.println(msg + " world!");
            pw.println(firstLine+"!!!!!");
            pw.println("</html>");

            pw.flush(); // 서버에 전송
            br.close();
            pw.close();
            clientSocket.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
