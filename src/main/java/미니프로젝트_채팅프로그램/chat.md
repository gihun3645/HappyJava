## 미니 프로젝트 2 - 채팅 프로그램 만들기

간단한 채팅 프로그램을 만들어 보자 ~

## 1단계 채팅 프로그램

1) java 패키지명 ChatClient 닉네임 [enter]

- 서버에 접속을 한다.
- 클라이언트는 닉네임을 서버에게 전송한다.
- ex> 홍길동[enter]

2) 접속한 모든 사용자레게 “홍길동님이 접속하였습니다.”

3) 채팅을 입력한 후 [enter]를 입력하면 모든 사용자(나 포함)에게 내 메세지가 전달되면 좋겠다.

4) /quit 을 입력하면 연결이 끊어진다. 연결이 끊어질 때 모든 사용자에게 “홍길동님이 연결을 끊었습니다.”

5) 강제로 연결을 끊었을 때 (ex> 프로그램 강제 종료) 사용자에게 “홍길동님이 연결을 끊었습니다.”

## 서버 입장

- 사용자가 접속할 때 마다 Thread를 만든다. ChatThread를 만든다.
- ChatThread는 클라인트와 통신을 하는 용도. ex> 클라이언트가 10개면 ChatThread도 10개 생성
- 클라이언트 접속이 끊어지면 하나의 ChatThread도 종료된다.
- ChatThread는 사용자가 보내준 chat 메세지를 현제 접속한 모든 사용자에게 보낸다
- ChatThread는 현제 접속한 모든 사용자 연결정보 or 출력객체를 알아야한다.

## 구조

![구조.png](%EA%B5%AC%EC%A1%B0.png)

### 간단한 채팅 프로그램1

## 채팅 서버

```java
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
```

## 클라이언트

```java
package 미니프로젝트_채팅프로그램;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.Buffer;

// java ChatThread.java [이름]
public class ChatClient {
    public static void main(String[] args) throws Exception {
        String name = args[0];

        Socket socket = new Socket("127.0.0.1", 9999);

        PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        String line = null;
        InputThread inputThread = new InputThread(in);
        inputThread.start();

        while ((line = keyboard.readLine()) != null) {
            out.println(name + " : " + line);
            out.flush();
        }
    }
}

class InputThread extends Thread {
    BufferedReader in = null;

    public InputThread(BufferedReader in) {
        this.in = in;
    }

    @Override
    public void run() {
        try {
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
```

---

## 개선된 코드

![구조2.png](%EA%B5%AC%EC%A1%B02.png)

```java
package 미니프로젝트_채팅프로그램.chat2;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);

        List<ChatThread> list = Collections.synchronizedList(new ArrayList<>());
        while (true) {
            Socket socket = serverSocket.accept();  // 클라이언트가 접속한다.
            ChatThread chatThread = new ChatThread(socket, list);
            chatThread.start();
        } // while
    } // main
}
```

```java
package 미니프로젝트_채팅프로그램.chat2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatThread extends Thread {
    private String name;
    private BufferedReader br;
    private PrintWriter pw;
    private Socket socket;
    List<ChatThread> list;

    public ChatThread(Socket socket, List<ChatThread> list) throws Exception {
        this.socket = socket;
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        this.br = br;
        this.pw = pw;
        this.name = br.readLine();
        this.list = list;
        this.list.add(this);
    }

    public void sendMessage(String msg) {
        pw.println(msg);
        pw.flush();
    }

    @Override
    public void run() {
        // broadcast
        // ChatThread 는 사용자가 보낸 메시지를 읽어들여서
        // 접속된 모든 클라이언트에게 메세지를 보낸다.

        // 나를 제외한 모든 사용자에게 "00님이 연결되었습니다."
        // 현제 ChatThread를 제외하고 보낸다.
        try {
            broadcast(name + "님이 연결되었습니다.", false);

            String line = null;

            while ((line = br.readLine()) != null) {
                if ("/quit".equals(line)) {
                    break;
                }
                broadcast(name + " : " + line, true);
            }
        } catch (Exception ex) { // ChatThread가 연결이 끊어 졌다.

        } finally {
            broadcast(name + "님이 연결이 끊어졌습니다.", false);
            this.list.remove(this);
            try {
                br.close();
            } catch (Exception ex) {}

            try {
                pw.close();
            } catch (Exception ex) {}

            try {
                socket.close();
            } catch (Exception ex) {}
        }
    }

    private void broadcast(String msg, boolean includeMe) {
        List<ChatThread> chatThreads = new ArrayList<>();
        for (int i = 0; i < this.list.size(); i++) {
            chatThreads.add(list.get(i));
        }

        try {
            for (int i = 0; i < chatThreads.size(); i++) {
                ChatThread ct = chatThreads.get(i);
                if (!includeMe) { // 나를 포함하지 말아라
                    if (ct == this) {
                        continue;
                    }
                }
                ct.sendMessage(msg);
            }
        } catch (Exception ex) {
            System.out.println("///");
        }
    }
}
```

```java
package 미니프로젝트_채팅프로그램.chat2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("사용법 : ChatClient [닉네임]");
            return;
        }
        String name = args[0];
        Socket socket = new Socket("127.0.0.1", 8888);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        // 닉네임 전송
        pw.println(name);
        pw.flush();

        // 백그라운드로 서버가 보내준 메시지를 읽어들여서 화면에 출력한다.
        InputThread inputThread = new InputThread(br);
        inputThread.start();

        // 클라이언트는 읽어들인 메시지를 서버에게 전송한다.
        try {
            String line = null;
            while ((line = keyboard.readLine()) != null) {
                if ("/quit".equals(line)) {
                    // 서버에게 메세지를 보낸다.
                    pw.println("/quit");
                    pw.flush();
                    break; // while 문을 빠져나간다.
                }
                pw.println(line);
                pw.flush();
            }
        } catch (Exception ex) {
            System.out.println("....");
        }

        // close 작업을 해준다.
        try {
            br.close();
        } catch (Exception ex) {
        }

        try {
            pw.close();
        } catch (Exception ex) {
        }

        try {
            socket.close();
        } catch (Exception ex) {
        }

    }
}

class InputThread extends Thread {
    BufferedReader br;

    public InputThread(BufferedReader br) {
        this.br = br;
    }

    @Override
    public void run() {
        try {
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception ex) {
            System.out.println("....");
        }
    }
}
```