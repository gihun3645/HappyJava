package 미니프로젝트_채팅프로그램;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatServer {
    public static void main(String[] args) throws Exception {
        System.out.println(" Server is on..");
        ServerSocket serverSocket = new ServerSocket(9999);
        // 공유객체에서 쓰레드에 안전한 리스트를 만든다.
        List<PrintWriter> outList = Collections.synchronizedList(new ArrayList<>());
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("접속 : " + socket);

            ChatThread chatThread = new ChatThread(socket, outList);
            chatThread.start();
        }
    }
}

class ChatThread extends Thread {
    private Socket socket;
    private List<PrintWriter> outList;
    private PrintWriter out;
    private BufferedReader in;

    public ChatThread(Socket socket, List<PrintWriter> outList) {
        this.socket = socket;
        this.outList = outList;

        // 1. socket 으로 부터 읽어들일 수 있는 객체를 얻는다.
        // 2. socket 에게 쓰기 위한 객체를 얻는다. (현재 연결된 클라이언트에게 쓰는 객체)
        try {
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outList.add(out);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void run() {

        // 3. 클라이언트가 보낸 메세지를 읽는다.
        // 4. 접속된 모든 클라이언트에게 메세지를 보낸다. (현제 접속된 모든 클라이언트에게 쓸 수 있는 객체가 필요하다.)
        String line = null;
        // 오버라이딩 된 메소드는 try - catch 를 이용하여 예외처리
        try {
            while ((line = in.readLine()) != null) { // 접속한 모든 클라이언트에게 메세지를 전송한다.
                for (int i = 0; i < outList.size(); i++) {
                    PrintWriter o = outList.get(i);
                    o.println(line);
                    // 적용
                    o.flush();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally { // 접속이 끊어질 때
            try {
                outList.remove(out);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            // 접속 종료
            for (int i = 0; i < outList.size(); i++) { // 접속한 모든 클라이언트에게 메세지를 전송한다.
                PrintWriter o = outList.get(i);
                o.println("어떤 클라이언트가 접속이 끊어졌어요.");
                o.flush();
            }

            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
