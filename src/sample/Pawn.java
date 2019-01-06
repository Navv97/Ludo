package sample;

import javafx.scene.control.Button;

import java.io.Serializable;

public class Pawn implements Serializable{
    public Button pawnType;
    public int currentPosition;
    public int spawnPositionX;
    public int getSpawnPositionY;

    public Pawn(Button pawnType, int currentPosition, int spawnPositionX, int getSpawnPositionY) {
        this.pawnType = pawnType;
        this.currentPosition = currentPosition;
        this.spawnPositionX = spawnPositionX;
        this.getSpawnPositionY = getSpawnPositionY;
    }

    public Button getPawnType() {
        return pawnType;
    }

    public void setPawnType(Button pawnType) {
        this.pawnType = pawnType;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

}
