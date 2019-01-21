package main.java.BoardController.Server;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Settings {
    private String ip;
    private int port;
    private int minPlayers;
    private int maxPlayers;
    private String color1;
    private String color2;
    private String color3;
    private String color4;

    public String getIp() {
        return ip;
    }

    @XmlElement
    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    @XmlElement
    public void setPort(int port) {
        this.port = port;
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    @XmlElement
    public void setMinPlayers(int minPlayers) {
        this.minPlayers = minPlayers;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    @XmlElement
    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public String getColor1() {
        return color1;
    }

    @XmlElement
    public void setColor1(String color1) {
        this.color1 = color1;
    }

    public String getColor2() {
        return color2;
    }

    @XmlElement
    public void setColor2(String color2) {
        this.color2 = color2;
    }

    public String getColor3() {
        return color3;
    }

    @XmlElement
    public void setColor3(String color3) {
        this.color3 = color3;
    }

    public String getColor4() {
        return color4;
    }

    @XmlElement
    public void setColor4(String color4) {
        this.color4 = color4;
    }

    @Override
    public String toString() {
        return "Settings{" +
                "ip='" + ip + '\'' +
                ", port=" + port +
                ", minPlayers=" + minPlayers +
                ", maxPlayers=" + maxPlayers +
                ", color1='" + color1 + '\'' +
                ", color2='" + color2 + '\'' +
                ", color3='" + color3 + '\'' +
                ", color4='" + color4 + '\'' +
                '}';
    }
}
