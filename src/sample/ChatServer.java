package sample;

import java.io.IOException;
import java.net.ServerSocket;

public class ChatServer {
    public static void main(String[] args)throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        ChatUsersList chatUsersList = new ChatUsersList();
        try {
            while (true) {
                new ChatServerHandler(serverSocket.accept(), chatUsersList).start();
            }
        }finally {
            serverSocket.close();
        }
    }
}
