package main.java.Chat.Client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClientWriter extends Thread {

    private Socket clientSocket;
    private PrintWriter output;
    private String message;

    public ChatClientWriter(Socket clientSocket, String message) throws IOException {
        this.clientSocket = clientSocket;
        this.output = new PrintWriter(this.clientSocket.getOutputStream(), true);
        this.message = message;
    }

    public void run(){
        output.println(message);
    }
}
