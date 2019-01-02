package sample;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class PlayersList {
    private final List<PrintWriter> players = new ArrayList();

    private static PlayersList instance;

    private PlayersList(){

    }

    public static PlayersList getIstance(){
        if(instance == null){
            synchronized (PlayersList.class){
                instance = new PlayersList();
            }
        }
        return instance;
    }

    public void notifyPlayers(String message){
        for(int i = 0; i < players.size(); i++){
            players.get(i).println(message);
        }
    }

    public void addPlayer(PrintWriter player){
        players.add(player);
    }

}
