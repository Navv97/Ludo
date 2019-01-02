package sample;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientWriter extends Thread {

    private Socket clientSocket;
    private PrintWriter output;
    private String message;

    public ClientWriter(Socket clientSocket, String message) throws IOException {
        this.clientSocket = clientSocket;
        this.output = new PrintWriter(this.clientSocket.getOutputStream(), true);
        this.message = message;
    }

    public void run(){
        output.println(message);
    }
}
