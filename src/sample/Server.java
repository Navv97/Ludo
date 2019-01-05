package sample;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args)throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        PlayersList playersList = new PlayersList();
        try {
            while (true) {
                new ServerHandler(serverSocket.accept(),playersList).start();
            }
        }finally {
            serverSocket.close();
        }
    }
}
