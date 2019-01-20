package main.java.Chat.Server;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ChatUsersList {
    private final Collection<PrintWriter> users = Collections.synchronizedCollection(new ArrayList<>());
    private int gameType;

    public ChatUsersList(){
        this.gameType = 0;
    }

    public int getGameType() {
        return gameType;
    }

    public void setGameType(int gameType) {
        this.gameType = gameType;
    }

    public void notifyUsers(String message){
        for (PrintWriter printWriter : users){
            printWriter.println(message);
        }
    }

    public void addUser(PrintWriter user){
        users.add(user);
    }
}
