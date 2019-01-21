package BoardController.Client;

import main.java.BoardController.Server.BoardServer;
import main.java.BoardController.Server.ServerSettingsDAO;
import main.java.BoardController.Server.Settings;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class BoardServerTests {
    public Settings settingsSettings = ServerSettingsDAO.getInstance().getSettingConnectionFromXMLFile("serverConfig.xml");

    @Test
    public void checkIfServerReadConfig(){
        assertNotNull(settingsSettings);
    }

    @Test
    public void checkServerPort() {
        assertEquals(7777, settingsSettings.getPort());
    }

    @Test
    public void checkServerIP(){
        assertEquals("127.0.0.1", settingsSettings.getIp());
    }
}
