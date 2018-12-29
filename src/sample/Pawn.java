package sample;

import javafx.scene.control.Button;

public class Pawn {
    public Button pawnType;
    public int currentPositionX;
    public int currentPositionY;
    public int spawnPositionX;
    public int getSpawnPositionY;

    public Pawn(Button pawnType, int currentPositionX, int currentPositionY, int spawnPositionX, int getSpawnPositionY) {
        this.pawnType = pawnType;
        this.currentPositionX = currentPositionX;
        this.currentPositionY = currentPositionY;
        this.spawnPositionX = spawnPositionX;
        this.getSpawnPositionY = getSpawnPositionY;
    }

    public Button getPawnType() {
        return pawnType;
    }

    public void setPawnType(Button pawnType) {
        this.pawnType = pawnType;
    }

    public int getCurrentPositionX() {
        return currentPositionX;
    }

    public void setCurrentPositionX(int currentPositionX) {
        this.currentPositionX = currentPositionX;
    }

    public int getCurrentPositionY() {
        return currentPositionY;
    }

    public void setCurrentPositionY(int currentPositionY) {
        this.currentPositionY = currentPositionY;
    }
}
