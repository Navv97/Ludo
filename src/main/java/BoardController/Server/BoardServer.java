package main.java.BoardController.Server;

import java.io.IOException;
import java.net.ServerSocket;

public class BoardServer {
    public static void main(String[] args) throws IOException {
        Settings settingsSettings = ServerSettingsDAO.getInstance().getSettingConnectionFromXMLFile("serverConfig.xml");
        ServerSocket serverSocket = new ServerSocket(settingsSettings.getPort(), settingsSettings.getMaxPlayers());
        System.out.println(settingsSettings.toString());
        Players players = new Players();
        try {
            while (true) {
                new BoardServerHandler(serverSocket.accept(),players).start();
                if(players.getAmoutOfPlayers()== settingsSettings.getMaxPlayers()) {
                    break;
                }
            }
        }catch (Exception e){
            System.out.println(e.toString());
        } finally {
            serverSocket.close();
        }
    }
}
