package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Controller {

    public AnchorPane boardLayout;
    public Button yellowPawn1;
    public Button yellowPawn3;
    public Button yellowPawn4;
    public Button yellowPawn2;
    public Button bluePawn3;
    public Button bluePawn4;
    public Button bluePawn1;
    public Button bluePawn2;
    public Button redPawn2;
    public Button redPawn4;
    public Button redPawn1;
    public Button redPawn3;
    public Button greenPawn1;
    public Button greenPawn2;
    public Button greenPawn3;
    public Button greenPawn4;

    Field blueSpawn1 = new Field(4,329,true);
    Field blueSpawn2 = new Field(40,329,true);
    Field blueSpawn3 = new Field(4,365,true);
    Field blueSpawn4 = new Field(40,365,true);

    Field blueFinish1 = new Field(185,330,false);
    Field blueFinish2 = new Field(185,293,false);
    Field blueFinish3 = new Field(185,258,false);
    Field blueFinish4 = new Field(185,221,false);

    Field yellowSpawn1 = new Field(4,3,true);
    Field yellowSpawn2 = new Field(40,3,true);
    Field yellowSpawn3 = new Field(4,39,true);
    Field yellowSpawn4 = new Field(39,39,true);

    Field yellowFinish1 = new Field(40,184,false);
    Field yellowFinish2 = new Field(76,184,false);
    Field yellowFinish3 = new Field(112,184,false);
    Field yellowFinish4 = new Field(149,184,false);

    Field greenSpawn1 = new Field(331,3,true);
    Field greenSpawn2 = new Field(366,3,true);
    Field greenSpawn3 = new Field(330,39,true);
    Field greenSpawn4 = new Field(366,39,true);

    Field greenFinish1 = new Field(185,40,false);
    Field greenFinish2 = new Field(185,76,false);
    Field greenFinish3 = new Field(185,112,false);
    Field greenFinish4 = new Field(185,148,false);

    Field redSpawn1 = new Field(330,330,true);
    Field redSpawn2 = new Field(366,330,true);
    Field redSpawn3 = new Field(330,366,true);
    Field redSpawn4 = new Field(367,366,true);

    Field redFinish1 = new Field(329,184,false);
    Field redFinish2 = new Field(293,184,false);
    Field redFinish3 = new Field(257,184,false);
    Field redFinish4 = new Field(221,184,false);

//  FIELDS ON THE BOARD
    Field blueStart = new Field(149,365,false);
    Field fieldOfPath1 = new Field(149,330,false);
    Field fieldOfPath2 = new Field(149,294,false);
    Field fieldOfPath3 = new Field(149,258,false);
    Field fieldOfPath4 = new Field(149,221,false);
    Field fieldOfPath5 = new Field(112,221,false);
    Field fieldOfPath6 = new Field(75,221,false);
    Field fieldOfPath7 = new Field(40,221,false);
    Field fieldOfPath8 = new Field(4,221,false);
    Field fieldOfPath9 = new Field(4,184,false);
    Field yellowStart = new Field(4,148,false);
    Field fieldOfPath10 = new Field(40,148,false);
    Field fieldOfPath11 = new Field(76,148,false);
    Field fieldOfPath12 = new Field(112,148,false);
    Field fieldOfPath13 = new Field(149,148,false);
    Field fieldOfPath14 = new Field(149,112,false);
    Field fieldOfPath15 = new Field(149,76,false);
    Field fieldOfPath16 = new Field(149,40,false);
    Field fieldOfPath17 = new Field(149,4,false);
    Field fieldOfPath18 = new Field(185,4,false);
    Field greenStart = new Field(221,4,false);
    Field fieldOfPath19 = new Field(221,40,false);
    Field fieldOfPath20 = new Field(221,76,false);
    Field fieldOfPath21 = new Field(221,112,false);
    Field fieldOfPath22 = new Field(221,148,false);
    Field fieldOfPath23 = new Field(257,148,false);
    Field fieldOfPath24 = new Field(293,148,false);
    Field fieldOfPath25 = new Field(329,148,false);
    Field fieldOfPath26 = new Field(365,148,false);
    Field fieldOfPath27 = new Field(365,184,false);
    Field redStart = new Field(365,221,false);
    Field fieldOfPath28 = new Field(329,221,false);
    Field fieldOfPath29 = new Field(293,221,false);
    Field fieldOfPath30 = new Field(257,221,false);
    Field fieldOfPath31 = new Field(221,221,false);
    Field fieldOfPath32 = new Field(221,258,false);
    Field fieldOfPath33 = new Field(221,293,false);
    Field fieldOfPath34 = new Field(221,330,false);
    Field fieldOfPath35 = new Field(221,365,false);
    Field fieldOfPath36 = new Field(185,365,false);

    ArrayList<Field> generalPath = new ArrayList<Field>();
    ArrayList<Field> bluePlayerPath = new ArrayList<Field>();
    ArrayList<Field> yellowPlayerPath = new ArrayList<Field>();
    ArrayList<Field> greenPlayerPath = new ArrayList<Field>();
    ArrayList<Field> redPlayerPath = new ArrayList<Field>();
    Pawn bluePawn;
    int i = 0;
    public void initialize() {
        bluePawn = new Pawn(bluePawn1, blueSpawn1.getPositionX(), blueSpawn1.getPositionY(), blueSpawn1.getPositionX(), blueSpawn1.getPositionY());
        //initialize path for all players
        generalPath.add(blueStart);
        generalPath.add(fieldOfPath1);
        generalPath.add(fieldOfPath2);
        generalPath.add(fieldOfPath3);
        generalPath.add(fieldOfPath4);
        generalPath.add(fieldOfPath5);
        generalPath.add(fieldOfPath6);
        generalPath.add(fieldOfPath7);
        generalPath.add(fieldOfPath8);
        generalPath.add(fieldOfPath9);
        generalPath.add(yellowStart);
        generalPath.add(fieldOfPath10);
        generalPath.add(fieldOfPath11);
        generalPath.add(fieldOfPath12);
        generalPath.add(fieldOfPath13);
        generalPath.add(fieldOfPath14);
        generalPath.add(fieldOfPath15);
        generalPath.add(fieldOfPath16);
        generalPath.add(fieldOfPath17);
        generalPath.add(fieldOfPath18);
        generalPath.add(greenStart);
        generalPath.add(fieldOfPath19);
        generalPath.add(fieldOfPath20);
        generalPath.add(fieldOfPath21);
        generalPath.add(fieldOfPath22);
        generalPath.add(fieldOfPath23);
        generalPath.add(fieldOfPath24);
        generalPath.add(fieldOfPath25);
        generalPath.add(fieldOfPath26);
        generalPath.add(fieldOfPath27);
        generalPath.add(redStart);
        generalPath.add(fieldOfPath28);
        generalPath.add(fieldOfPath29);
        generalPath.add(fieldOfPath30);
        generalPath.add(fieldOfPath31);
        generalPath.add(fieldOfPath32);
        generalPath.add(fieldOfPath33);
        generalPath.add(fieldOfPath34);
        generalPath.add(fieldOfPath35);
        generalPath.add(fieldOfPath36);

        //initalize path for blue player
        bluePlayerPath.addAll(generalPath);
        bluePlayerPath.add(blueFinish1);
        bluePlayerPath.add(blueFinish2);
        bluePlayerPath.add(blueFinish3);
        bluePlayerPath.add(blueFinish4);

        //initialize path for yellow player
        yellowPlayerPath.add(yellowStart);
        yellowPlayerPath.add(fieldOfPath10);
        yellowPlayerPath.add(fieldOfPath11);
        yellowPlayerPath.add(fieldOfPath12);
        yellowPlayerPath.add(fieldOfPath13);
        yellowPlayerPath.add(fieldOfPath14);
        yellowPlayerPath.add(fieldOfPath15);
        yellowPlayerPath.add(fieldOfPath16);
        yellowPlayerPath.add(fieldOfPath17);
        yellowPlayerPath.add(fieldOfPath18);
        yellowPlayerPath.add(greenStart);
        yellowPlayerPath.add(fieldOfPath19);
        yellowPlayerPath.add(fieldOfPath20);
        yellowPlayerPath.add(fieldOfPath21);
        yellowPlayerPath.add(fieldOfPath22);
        yellowPlayerPath.add(fieldOfPath23);
        yellowPlayerPath.add(fieldOfPath24);
        yellowPlayerPath.add(fieldOfPath25);
        yellowPlayerPath.add(fieldOfPath26);
        yellowPlayerPath.add(fieldOfPath27);
        yellowPlayerPath.add(redStart);
        yellowPlayerPath.add(fieldOfPath28);
        yellowPlayerPath.add(fieldOfPath29);
        yellowPlayerPath.add(fieldOfPath30);
        yellowPlayerPath.add(fieldOfPath31);
        yellowPlayerPath.add(fieldOfPath32);
        yellowPlayerPath.add(fieldOfPath33);
        yellowPlayerPath.add(fieldOfPath34);
        yellowPlayerPath.add(fieldOfPath35);
        yellowPlayerPath.add(fieldOfPath36);
        yellowPlayerPath.add(blueStart);
        yellowPlayerPath.add(fieldOfPath1);
        yellowPlayerPath.add(fieldOfPath2);
        yellowPlayerPath.add(fieldOfPath3);
        yellowPlayerPath.add(fieldOfPath4);
        yellowPlayerPath.add(fieldOfPath5);
        yellowPlayerPath.add(fieldOfPath6);
        yellowPlayerPath.add(fieldOfPath7);
        yellowPlayerPath.add(fieldOfPath8);
        yellowPlayerPath.add(fieldOfPath9);
        yellowPlayerPath.add(yellowFinish1);
        yellowPlayerPath.add(yellowFinish2);
        yellowPlayerPath.add(yellowFinish3);
        yellowPlayerPath.add(yellowFinish4);

        //initalize path for green player
        greenPlayerPath.add(greenStart);
        greenPlayerPath.add(fieldOfPath19);
        greenPlayerPath.add(fieldOfPath20);
        greenPlayerPath.add(fieldOfPath21);
        greenPlayerPath.add(fieldOfPath22);
        greenPlayerPath.add(fieldOfPath23);
        greenPlayerPath.add(fieldOfPath24);
        greenPlayerPath.add(fieldOfPath25);
        greenPlayerPath.add(fieldOfPath26);
        greenPlayerPath.add(fieldOfPath27);
        greenPlayerPath.add(redStart);
        greenPlayerPath.add(fieldOfPath28);
        greenPlayerPath.add(fieldOfPath29);
        greenPlayerPath.add(fieldOfPath30);
        greenPlayerPath.add(fieldOfPath31);
        greenPlayerPath.add(fieldOfPath32);
        greenPlayerPath.add(fieldOfPath33);
        greenPlayerPath.add(fieldOfPath34);
        greenPlayerPath.add(fieldOfPath35);
        greenPlayerPath.add(fieldOfPath36);
        greenPlayerPath.add(blueStart);
        greenPlayerPath.add(fieldOfPath1);
        greenPlayerPath.add(fieldOfPath2);
        greenPlayerPath.add(fieldOfPath3);
        greenPlayerPath.add(fieldOfPath4);
        greenPlayerPath.add(fieldOfPath5);
        greenPlayerPath.add(fieldOfPath6);
        greenPlayerPath.add(fieldOfPath7);
        greenPlayerPath.add(fieldOfPath8);
        greenPlayerPath.add(fieldOfPath9);
        greenPlayerPath.add(yellowStart);
        greenPlayerPath.add(fieldOfPath10);
        greenPlayerPath.add(fieldOfPath11);
        greenPlayerPath.add(fieldOfPath12);
        greenPlayerPath.add(fieldOfPath13);
        greenPlayerPath.add(fieldOfPath14);
        greenPlayerPath.add(fieldOfPath15);
        greenPlayerPath.add(fieldOfPath16);
        greenPlayerPath.add(fieldOfPath17);
        greenPlayerPath.add(fieldOfPath18);
        greenPlayerPath.add(greenFinish1);
        greenPlayerPath.add(greenFinish2);
        greenPlayerPath.add(greenFinish3);
        greenPlayerPath.add(greenFinish4);


        //initalize path for red player
        redPlayerPath.add(redStart);
        redPlayerPath.add(fieldOfPath28);
        redPlayerPath.add(fieldOfPath29);
        redPlayerPath.add(fieldOfPath30);
        redPlayerPath.add(fieldOfPath31);
        redPlayerPath.add(fieldOfPath32);
        redPlayerPath.add(fieldOfPath33);
        redPlayerPath.add(fieldOfPath34);
        redPlayerPath.add(fieldOfPath35);
        redPlayerPath.add(fieldOfPath36);
        redPlayerPath.add(blueStart);
        redPlayerPath.add(fieldOfPath1);
        redPlayerPath.add(fieldOfPath2);
        redPlayerPath.add(fieldOfPath3);
        redPlayerPath.add(fieldOfPath4);
        redPlayerPath.add(fieldOfPath5);
        redPlayerPath.add(fieldOfPath6);
        redPlayerPath.add(fieldOfPath7);
        redPlayerPath.add(fieldOfPath8);
        redPlayerPath.add(fieldOfPath9);
        redPlayerPath.add(yellowStart);
        redPlayerPath.add(fieldOfPath10);
        redPlayerPath.add(fieldOfPath11);
        redPlayerPath.add(fieldOfPath12);
        redPlayerPath.add(fieldOfPath13);
        redPlayerPath.add(fieldOfPath14);
        redPlayerPath.add(fieldOfPath15);
        redPlayerPath.add(fieldOfPath16);
        redPlayerPath.add(fieldOfPath17);
        redPlayerPath.add(fieldOfPath18);
        redPlayerPath.add(greenStart);
        redPlayerPath.add(fieldOfPath19);
        redPlayerPath.add(fieldOfPath20);
        redPlayerPath.add(fieldOfPath21);
        redPlayerPath.add(fieldOfPath22);
        redPlayerPath.add(fieldOfPath23);
        redPlayerPath.add(fieldOfPath24);
        redPlayerPath.add(fieldOfPath25);
        redPlayerPath.add(fieldOfPath26);
        redPlayerPath.add(fieldOfPath27);
        redPlayerPath.add(redFinish1);
        redPlayerPath.add(redFinish2);
        redPlayerPath.add(redFinish3);
        redPlayerPath.add(redFinish4);
        bluePawn.setCurrentPositionX(bluePlayerPath.get(i).getPositionX());
        bluePawn.setCurrentPositionY(bluePlayerPath.get(i).getPositionY());
        bluePawn1.setLayoutX(bluePlayerPath.get(i).getPositionX());
        bluePawn1.setLayoutY(bluePlayerPath.get(i).getPositionY());

    }
    public void movePawn(ActionEvent actionEvent) {
        int diceRoll = ThreadLocalRandom.current().nextInt(1, 6 + 1);
        i = i + diceRoll;
        bluePawn1.setLayoutX(bluePlayerPath.get(i).getPositionX());
        bluePawn1.setLayoutY(bluePlayerPath.get(i).getPositionY());
        bluePawn.setCurrentPositionX(bluePlayerPath.get(i).getPositionX());
        bluePawn.setCurrentPositionY(bluePlayerPath.get(i).getPositionY());

    }
}

