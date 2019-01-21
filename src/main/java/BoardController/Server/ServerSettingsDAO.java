package main.java.BoardController.Server;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ServerSettingsDAO {
    private static ServerSettingsDAO instance;

    protected ServerSettingsDAO(){}

    public static ServerSettingsDAO getInstance(){
        if(instance == null){
            synchronized (ServerSettingsDAO.class) {
                if(instance == null) {
                    instance = new ServerSettingsDAO();
                }
            }
        }
        return instance;
    }

    public Settings getSettingConnectionFromXMLFile(String url){
        try {
            File file = new File(url);
            JAXBContext jaxbContext = JAXBContext.newInstance(Settings.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (Settings) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.getMessage();
        }
        return null;
    }
}
