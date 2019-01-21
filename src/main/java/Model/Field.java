package main.java.Model;

import java.io.Serializable;

public class Field implements Serializable {
    public int positionX;
    public int positionY;
    public boolean taken;

    public Field(int positionX, int positionY, boolean taken) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.taken = taken;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    @Override
    public String toString() {
        return "Field{" +
                "positionX=" + positionX +
                ", positionY=" + positionY +
                ", taken=" + taken +
                '}';
    }
}
