package sample;

import java.io.IOException;
import java.net.Socket;

public class ServerHandler{
    private Socket serverSocket;
    private ServerReader serverReader;

    public ServerHandler(Socket serverSocket) throws IOException{
        this.serverSocket = serverSocket;
        this.serverReader = new ServerReader(serverSocket);
        serverReader.start();
    }

}
