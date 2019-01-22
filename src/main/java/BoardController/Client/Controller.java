package main.java.BoardController.Client;

import main.java.Chat.Client.ChatClientReader;
import main.java.Chat.Client.ChatClientWriter;
import main.java.Model.Field;
import main.java.Model.Pawn;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Controller{

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
    public Button blueDice;
    public Button yellowDice;
    public Button greenDice;
    public Button redDice;
    public TextArea textArea;
    public TextField inputBox;
    public Button sendMessage;
    public Button gameType1;
    public Button gameType2;
    public Button gameType3;

    private Field blueSpawn1 = new Field(4,329,true);
    private Field blueSpawn2 = new Field(40,329,true);
    private Field blueSpawn3 = new Field(4,365,true);
    private Field blueSpawn4 = new Field(40,365,true);

    private Field blueFinish1 = new Field(185,330,false);
    private Field blueFinish2 = new Field(185,293,false);
    private Field blueFinish3 = new Field(185,258,false);
    private Field blueFinish4 = new Field(185,221,false);

    private Field yellowSpawn1 = new Field(4,3,true);
    private Field yellowSpawn2 = new Field(40,3,true);
    private Field yellowSpawn3 = new Field(4,39,true);
    private Field yellowSpawn4 = new Field(39,39,true);

    private Field yellowFinish1 = new Field(40,184,false);
    private Field yellowFinish2 = new Field(76,184,false);
    private Field yellowFinish3 = new Field(112,184,false);
    private Field yellowFinish4 = new Field(149,184,false);

    private Field greenSpawn1 = new Field(331,3,true);
    private Field greenSpawn2 = new Field(366,3,true);
    private Field greenSpawn3 = new Field(330,39,true);
    private Field greenSpawn4 = new Field(366,39,true);

    private Field greenFinish1 = new Field(185,40,false);
    private Field greenFinish2 = new Field(185,76,false);
    private Field greenFinish3 = new Field(185,112,false);
    private Field greenFinish4 = new Field(185,148,false);

    private Field redSpawn1 = new Field(330,330,true);
    private Field redSpawn2 = new Field(366,330,true);
    private Field redSpawn3 = new Field(330,366,true);
    private Field redSpawn4 = new Field(367,366,true);

    private Field redFinish1 = new Field(329,184,false);
    private Field redFinish2 = new Field(293,184,false);
    private Field redFinish3 = new Field(257,184,false);
    private Field redFinish4 = new Field(221,184,false);

    //  FIELDS ON THE BOARD
    private Field blueStart = new Field(149,365,false);
    private Field fieldOfPath1 = new Field(149,330,false);
    private Field fieldOfPath2 = new Field(149,294,false);
    private Field fieldOfPath3 = new Field(149,258,false);
    private Field fieldOfPath4 = new Field(149,221,false);
    private Field fieldOfPath5 = new Field(112,221,false);
    private Field fieldOfPath6 = new Field(75,221,false);
    private Field fieldOfPath7 = new Field(40,221,false);
    private Field fieldOfPath8 = new Field(4,221,false);
    private Field fieldOfPath9 = new Field(4,184,false);
    private Field yellowStart = new Field(4,148,false);
    private Field fieldOfPath10 = new Field(40,148,false);
    private Field fieldOfPath11 = new Field(76,148,false);
    private Field fieldOfPath12 = new Field(112,148,false);
    private Field fieldOfPath13 = new Field(149,148,false);
    private Field fieldOfPath14 = new Field(149,112,false);
    private Field fieldOfPath15 = new Field(149,76,false);
    private Field fieldOfPath16 = new Field(149,40,false);
    private Field fieldOfPath17 = new Field(149,4,false);
    private Field fieldOfPath18 = new Field(185,4,false);
    private Field greenStart = new Field(221,4,false);
    private Field fieldOfPath19 = new Field(221,40,false);
    private Field fieldOfPath20 = new Field(221,76,false);
    private Field fieldOfPath21 = new Field(221,112,false);
    private Field fieldOfPath22 = new Field(221,148,false);
    private Field fieldOfPath23 = new Field(257,148,false);
    private Field fieldOfPath24 = new Field(293,148,false);
    private Field fieldOfPath25 = new Field(329,148,false);
    private Field fieldOfPath26 = new Field(365,148,false);
    private Field fieldOfPath27 = new Field(365,184,false);
    private Field redStart = new Field(365,221,false);
    private Field fieldOfPath28 = new Field(329,221,false);
    private Field fieldOfPath29 = new Field(293,221,false);
    private Field fieldOfPath30 = new Field(257,221,false);
    private Field fieldOfPath31 = new Field(221,221,false);
    private Field fieldOfPath32 = new Field(221,258,false);
    private Field fieldOfPath33 = new Field(221,293,false);
    private Field fieldOfPath34 = new Field(221,330,false);
    private Field fieldOfPath35 = new Field(221,365,false);
    private Field fieldOfPath36 = new Field(185,365,false);

    public ArrayList<Field> generalPath = new ArrayList<Field>();
    public ArrayList<Field> bluePlayerPath = new ArrayList<Field>();
    public ArrayList<Field> yellowPlayerPath = new ArrayList<Field>();
    public ArrayList<Field> greenPlayerPath = new ArrayList<Field>();
    public ArrayList<Field> redPlayerPath = new ArrayList<Field>();

    public Pawn bluePawn1Object;
    public Pawn bluePawn2Object;
    public Pawn bluePawn3Object;
    public Pawn bluePawn4Object;

    public Pawn yellowPawn1Object;
    public Pawn yellowPawn2Object;
    public Pawn yellowPawn3Object;
    public Pawn yellowPawn4Object;

    public Pawn greenPawn1Object;
    public Pawn greenPawn2Object;
    public Pawn greenPawn3Object;
    public Pawn greenPawn4Object;

    public Pawn redPawn1Object;
    public Pawn redPawn2Object;
    public Pawn redPawn3Object;
    public Pawn redPawn4Object;


    public Integer diceThrow;
    public Socket chatSocket;
    public Socket boardSocket;

    public ArrayList<Button> indexesOfPawns;
    public ArrayList<Pawn> indexesOfPawnsObject;
    public ArrayList<ArrayList <Field>> paths;
    public ArrayList<Boolean> playersTurns;
    public ArrayList<Button> indexesOfDices;

    public ArrayList<Button> bluePawns;
    public ArrayList<Button> yellowPawns;
    public ArrayList<Button> greenPawns;
    public ArrayList<Button> redPawns;
    public ArrayList<ArrayList<Button>> allButtons;

    public ArrayList<Pawn> bluePawnsObjects;
    public ArrayList<Pawn> yellowPawnsObjects;
    public ArrayList<Pawn> greenPawnsObjects;
    public ArrayList<Pawn> redPawnsObjects;
    public ArrayList<ArrayList<Pawn>> allPawnsObjects;

    public ArrayList<Field> blueSpawns;
    public ArrayList<Field> yellowSpawns;
    public ArrayList<Field> greenSpawns;
    public ArrayList<Field> redSpawns;
    public ArrayList<ArrayList<Field>> allSpawns;

    private BufferedReader input;
    private BufferedReader input2;
    private PrintWriter output;
    private PrintWriter output2;
    private int playerIndex;
    private int gameType;


    public void initialize() {
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

        indexesOfPawns = new ArrayList<>();
        indexesOfPawnsObject = new ArrayList<>();
        playersTurns = new ArrayList<>();
        indexesOfDices = new ArrayList<>();
        paths = new ArrayList<>();
        bluePawns = new ArrayList<>();
        yellowPawns = new ArrayList<>();
        greenPawns = new ArrayList<>();
        redPawns = new ArrayList<>();
        allButtons = new ArrayList<>();
        blueSpawns = new ArrayList<>();
        yellowSpawns = new ArrayList<>();
        greenSpawns = new ArrayList<>();
        redSpawns = new ArrayList<>();
        allSpawns = new ArrayList<>();

        bluePawnsObjects = new ArrayList<>();
        yellowPawnsObjects = new ArrayList<>();
        greenPawnsObjects = new ArrayList<>();
        redPawnsObjects = new ArrayList<>();
        allPawnsObjects = new ArrayList<>();

        blueSpawns.add(blueSpawn1);
        blueSpawns.add(blueSpawn2);
        blueSpawns.add(blueSpawn3);
        blueSpawns.add(blueSpawn4);

        yellowSpawns.add(yellowSpawn1);
        yellowSpawns.add(yellowSpawn2);
        yellowSpawns.add(yellowSpawn3);
        yellowSpawns.add(yellowSpawn4);

        greenSpawns.add(greenSpawn1);
        greenSpawns.add(greenSpawn2);
        greenSpawns.add(greenSpawn3);
        greenSpawns.add(greenSpawn4);

        redSpawns.add(redSpawn1);
        redSpawns.add(redSpawn2);
        redSpawns.add(redSpawn3);
        redSpawns.add(redSpawn4);

        allSpawns.add(blueSpawns);
        allSpawns.add(yellowSpawns);
        allSpawns.add(greenSpawns);
        allSpawns.add(redSpawns);

        try{
            this.boardSocket = new Socket("127.0.0.1", 7777);
            this.input = new BufferedReader(new InputStreamReader(this.boardSocket.getInputStream()));
            this.output = new PrintWriter(this.boardSocket.getOutputStream(), true);
            this.playerIndex = Integer.parseInt(input.readLine());
            new BoardController(boardSocket,indexesOfPawns,indexesOfPawnsObject,paths,playersTurns,indexesOfDices).start();
        }catch (IOException e){
            System.out.println(e.toString());
            System.exit(1);
        }

        try {
            this.chatSocket = new Socket("127.0.0.1", 8888);
            this.input2 = new BufferedReader(new InputStreamReader(this.chatSocket.getInputStream()));
            this.output2 = new PrintWriter(this.chatSocket.getOutputStream(), true);
            if(playerIndex != 1) {
                this.gameType = Integer.parseInt(input2.readLine());
            }
            new ChatClientReader(chatSocket,textArea).start();
        }catch (IOException e){
            System.out.println(e.toString());
        }


        if(gameType == 2 && playerIndex != 1){
            init2PlayersGame();
        }else if(gameType == 3 && playerIndex != 1){
            init3PlayersGame();
        }else if(gameType == 4 && playerIndex != 1){
            init4PlayersGame();
        }

        textArea.setEditable(false);

        bluePawn1.setDisable(true);
        bluePawn2.setDisable(true);
        bluePawn3.setDisable(true);
        bluePawn4.setDisable(true);

        yellowPawn1.setDisable(true);
        yellowPawn2.setDisable(true);
        yellowPawn3.setDisable(true);
        yellowPawn4.setDisable(true);

        greenPawn1.setDisable(true);
        greenPawn2.setDisable(true);
        greenPawn3.setDisable(true);
        greenPawn4.setDisable(true);

        redPawn1.setDisable(true);
        redPawn2.setDisable(true);
        redPawn3.setDisable(true);
        redPawn4.setDisable(true);

        if(this.playerIndex != 1){
            gameType1.setVisible(false);
            gameType2.setVisible(false);
            gameType3.setVisible(false);
        }
    }

    public boolean blueTurn = true;
    public boolean yellowTurn = false;
    public boolean greenTurn = false;
    public boolean redTurn = false;
    public int yellowTries = -1;
    public int blueTries = -1;
    public int greenTries = -1;
    public int redTries = -1;

    public void twoPlayersGame(ActionEvent actionEvent) {
        this.gameType = 2;
        output2.println(gameType);
        init2PlayersGame();
        gameType1.setVisible(false);
        gameType2.setVisible(false);
        gameType3.setVisible(false);
    }

    public void threePlayersGame(ActionEvent actionEvent) {
        this.gameType = 3;
        output2.println(gameType);
        init3PlayersGame();
        gameType1.setVisible(false);
        gameType2.setVisible(false);
        gameType3.setVisible(false);
    }

    public void fourPlayersGame(ActionEvent actionEvent) {
        this.gameType = 4;
        init4PlayersGame();
        output2.println(gameType);
        gameType1.setVisible(false);
        gameType2.setVisible(false);
        gameType3.setVisible(false);
    }

    public void init2PlayersGame(){
        bluePawn1Object = new Pawn(bluePawn1, -1, blueSpawn1.getPositionX(), blueSpawn1.getPositionY(),blueStart,blueSpawn1);
        bluePawn2Object = new Pawn(bluePawn2, -1, blueSpawn2.getPositionX(), blueSpawn2.getPositionY(),blueStart,blueSpawn2);
        bluePawn3Object = new Pawn(bluePawn3, -1, blueSpawn3.getPositionX(), blueSpawn3.getPositionY(),blueStart,blueSpawn3);
        bluePawn4Object = new Pawn(bluePawn4, -1, blueSpawn4.getPositionX(), blueSpawn4.getPositionY(),blueStart,blueSpawn4);
        yellowPawn1Object = new Pawn(yellowPawn1, -1, yellowSpawn1.getPositionX(), yellowSpawn1.positionY,yellowStart,yellowSpawn1);
        yellowPawn2Object = new Pawn(yellowPawn2,-1,yellowSpawn2.getPositionX(), yellowSpawn2.getPositionY(),yellowStart,yellowSpawn2);
        yellowPawn3Object = new Pawn(yellowPawn3,-1,yellowSpawn3.getPositionX(), yellowSpawn3.getPositionY(),yellowStart,yellowSpawn3);
        yellowPawn4Object = new Pawn(yellowPawn4,-1,yellowSpawn4.getPositionX(), yellowSpawn4.getPositionY(),yellowStart,yellowSpawn4);

        addBluePawns();
        addYellowPawns();
        allPawnsObjects.add(bluePawnsObjects);
        allPawnsObjects.add(yellowPawnsObjects);

        bluePawns.add(bluePawn1);
        bluePawns.add(bluePawn2);
        bluePawns.add(bluePawn3);
        bluePawns.add(bluePawn4);
        yellowPawns.add(yellowPawn1);
        yellowPawns.add(yellowPawn2);
        yellowPawns.add(yellowPawn3);
        yellowPawns.add(yellowPawn4);
        allButtons.add(bluePawns);
        allButtons.add(yellowPawns);

        indexesOfDices.add(blueDice);
        indexesOfDices.add(yellowDice);

        indexesOfPawns.add(bluePawn1);
        indexesOfPawns.add(bluePawn2);
        indexesOfPawns.add(bluePawn3);
        indexesOfPawns.add(bluePawn4);
        indexesOfPawns.add(yellowPawn1);
        indexesOfPawns.add(yellowPawn2);
        indexesOfPawns.add(yellowPawn3);
        indexesOfPawns.add(yellowPawn4);

        indexesOfPawnsObject.add(bluePawn1Object);
        indexesOfPawnsObject.add(bluePawn2Object);
        indexesOfPawnsObject.add(bluePawn3Object);
        indexesOfPawnsObject.add(bluePawn4Object);
        indexesOfPawnsObject.add(yellowPawn1Object);
        indexesOfPawnsObject.add(yellowPawn2Object);
        indexesOfPawnsObject.add(yellowPawn3Object);
        indexesOfPawnsObject.add(yellowPawn4Object);

        paths.add(bluePlayerPath);
        paths.add(yellowPlayerPath);

        playersTurns.add(blueTurn);
        playersTurns.add(yellowTurn);

        bluePawn1.setDisable(true);
        greenPawn1.setDisable(true);
        yellowPawn1.setDisable(true);

        greenDice.setDisable(true);
        redDice.setDisable(true);
        yellowDice.setDisable(true);
    }

    public void init3PlayersGame(){
        bluePawn1Object = new Pawn(bluePawn1, -1, blueSpawn1.getPositionX(), blueSpawn1.getPositionY(),blueStart,blueSpawn1);
        bluePawn2Object = new Pawn(bluePawn2, -1, blueSpawn2.getPositionX(), blueSpawn2.getPositionY(),blueStart,blueSpawn2);
        bluePawn3Object = new Pawn(bluePawn3, -1, blueSpawn3.getPositionX(), blueSpawn3.getPositionY(),blueStart,blueSpawn3);
        bluePawn4Object = new Pawn(bluePawn4, -1, blueSpawn4.getPositionX(), blueSpawn4.getPositionY(),blueStart,blueSpawn4);
        yellowPawn1Object = new Pawn(yellowPawn1, -1, yellowSpawn1.getPositionX(), yellowSpawn1.positionY,yellowStart,yellowSpawn1);
        yellowPawn2Object = new Pawn(yellowPawn2,-1,yellowSpawn2.getPositionX(), yellowSpawn2.getPositionY(),yellowStart,yellowSpawn2);
        yellowPawn3Object = new Pawn(yellowPawn3,-1,yellowSpawn3.getPositionX(), yellowSpawn3.getPositionY(),yellowStart,yellowSpawn3);
        yellowPawn4Object = new Pawn(yellowPawn4,-1,yellowSpawn4.getPositionX(), yellowSpawn4.getPositionY(),yellowStart,yellowSpawn4);
        greenPawn1Object = new Pawn(greenPawn1, -1, greenSpawn1.getPositionX(), greenSpawn1.positionY,greenStart,greenSpawn1);
        greenPawn2Object = new Pawn(greenPawn2,-1,greenSpawn2.getPositionX(),greenSpawn2.getPositionY(),greenStart,greenSpawn2);
        greenPawn3Object = new Pawn(greenPawn3,-1,greenSpawn3.getPositionX(),greenSpawn3.getPositionY(),greenStart,greenSpawn3);
        greenPawn4Object = new Pawn(greenPawn4,-1,greenSpawn4.getPositionX(),greenSpawn4.getPositionY(),greenStart,greenSpawn4);

        addBluePawns();
        addYellowPawns();
        addGreenPawns();
        allPawnsObjects.add(bluePawnsObjects);
        allPawnsObjects.add(yellowPawnsObjects);
        allPawnsObjects.add(greenPawnsObjects);

        bluePawns.add(bluePawn1);
        bluePawns.add(bluePawn2);
        bluePawns.add(bluePawn3);
        bluePawns.add(bluePawn4);
        yellowPawns.add(yellowPawn1);
        yellowPawns.add(yellowPawn2);
        yellowPawns.add(yellowPawn3);
        yellowPawns.add(yellowPawn4);
        greenPawns.add(greenPawn1);
        greenPawns.add(greenPawn2);
        greenPawns.add(greenPawn3);
        greenPawns.add(greenPawn4);
        allButtons.add(bluePawns);
        allButtons.add(yellowPawns);
        allButtons.add(greenPawns);

        indexesOfDices.add(blueDice);
        indexesOfDices.add(yellowDice);
        indexesOfDices.add(greenDice);

        indexesOfPawns.add(bluePawn1);
        indexesOfPawns.add(bluePawn2);
        indexesOfPawns.add(bluePawn3);
        indexesOfPawns.add(bluePawn4);

        indexesOfPawns.add(yellowPawn1);
        indexesOfPawns.add(yellowPawn2);
        indexesOfPawns.add(yellowPawn3);
        indexesOfPawns.add(yellowPawn4);

        indexesOfPawns.add(greenPawn1);
        indexesOfPawns.add(greenPawn2);
        indexesOfPawns.add(greenPawn3);
        indexesOfPawns.add(greenPawn4);

        indexesOfPawnsObject.add(bluePawn1Object);
        indexesOfPawnsObject.add(bluePawn2Object);
        indexesOfPawnsObject.add(bluePawn3Object);
        indexesOfPawnsObject.add(bluePawn4Object);
        indexesOfPawnsObject.add(yellowPawn1Object);
        indexesOfPawnsObject.add(yellowPawn2Object);
        indexesOfPawnsObject.add(yellowPawn3Object);
        indexesOfPawnsObject.add(yellowPawn4Object);
        indexesOfPawnsObject.add(greenPawn1Object);
        indexesOfPawnsObject.add(greenPawn2Object);
        indexesOfPawnsObject.add(greenPawn3Object);
        indexesOfPawnsObject.add(greenPawn4Object);

        paths.add(bluePlayerPath);
        paths.add(yellowPlayerPath);
        paths.add(greenPlayerPath);

        playersTurns.add(blueTurn);
        playersTurns.add(yellowTurn);
        playersTurns.add(greenTurn);

        bluePawn1.setDisable(true);
        yellowPawn1.setDisable(true);
        greenPawn1.setDisable(true);

        yellowDice.setDisable(true);
        greenDice.setDisable(true);
        redDice.setDisable(true);
    }

    public void addBluePawns(){
        bluePawnsObjects.add(bluePawn1Object);
        bluePawnsObjects.add(bluePawn2Object);
        bluePawnsObjects.add(bluePawn3Object);
        bluePawnsObjects.add(bluePawn4Object);
    }

    public void addYellowPawns(){
        yellowPawnsObjects.add(yellowPawn1Object);
        yellowPawnsObjects.add(yellowPawn2Object);
        yellowPawnsObjects.add(yellowPawn3Object);
        yellowPawnsObjects.add(yellowPawn4Object);
    }

    public void addGreenPawns(){
        greenPawnsObjects.add(greenPawn1Object);
        greenPawnsObjects.add(greenPawn2Object);
        greenPawnsObjects.add(greenPawn3Object);
        greenPawnsObjects.add(greenPawn4Object);
    }

    public void addRedPawns(){
        redPawnsObjects.add(redPawn1Object);
        redPawnsObjects.add(redPawn2Object);
        redPawnsObjects.add(redPawn3Object);
        redPawnsObjects.add(redPawn4Object);
    }

    public void init4PlayersGame(){
        bluePawn1Object = new Pawn(bluePawn1, -1, blueSpawn1.getPositionX(), blueSpawn1.getPositionY(),blueStart,blueSpawn1);
        bluePawn2Object = new Pawn(bluePawn2, -1, blueSpawn2.getPositionX(), blueSpawn2.getPositionY(),blueStart,blueSpawn2);
        bluePawn3Object = new Pawn(bluePawn3, -1, blueSpawn3.getPositionX(), blueSpawn3.getPositionY(),blueStart,blueSpawn3);
        bluePawn4Object = new Pawn(bluePawn4, -1, blueSpawn4.getPositionX(), blueSpawn4.getPositionY(),blueStart,blueSpawn4);
        yellowPawn1Object = new Pawn(yellowPawn1, -1, yellowSpawn1.getPositionX(), yellowSpawn1.positionY,yellowStart,yellowSpawn1);
        yellowPawn2Object = new Pawn(yellowPawn2,-1,yellowSpawn2.getPositionX(), yellowSpawn2.getPositionY(),yellowStart,yellowSpawn2);
        yellowPawn3Object = new Pawn(yellowPawn3,-1,yellowSpawn3.getPositionX(), yellowSpawn3.getPositionY(),yellowStart,yellowSpawn3);
        yellowPawn4Object = new Pawn(yellowPawn4,-1,yellowSpawn4.getPositionX(), yellowSpawn4.getPositionY(),yellowStart,yellowSpawn4);
        greenPawn1Object = new Pawn(greenPawn1, -1, greenSpawn1.getPositionX(), greenSpawn1.positionY,greenStart,greenSpawn1);
        greenPawn2Object = new Pawn(greenPawn2,-1,greenSpawn2.getPositionX(),greenSpawn2.getPositionY(),greenStart,greenSpawn2);
        greenPawn3Object = new Pawn(greenPawn3,-1,greenSpawn3.getPositionX(),greenSpawn3.getPositionY(),greenStart,greenSpawn3);
        greenPawn4Object = new Pawn(greenPawn4,-1,greenSpawn4.getPositionX(),greenSpawn4.getPositionY(),greenStart,greenSpawn4);
        redPawn1Object = new Pawn(redPawn1, -1, redSpawn1.getPositionX(), redSpawn1.positionY,redStart,redSpawn1);
        redPawn2Object = new Pawn(redPawn2,-1,redSpawn2.getPositionX(),redSpawn2.getPositionY(),redStart,redSpawn2);
        redPawn3Object = new Pawn(redPawn3,-1,redSpawn3.getPositionX(),redSpawn3.getPositionY(),redStart,redSpawn3);
        redPawn4Object = new Pawn(redPawn4,-1,redSpawn4.getPositionX(),redSpawn4.getPositionY(),redStart,redSpawn4);

        addBluePawns();
        addYellowPawns();
        addGreenPawns();
        addRedPawns();
        allPawnsObjects.add(bluePawnsObjects);
        allPawnsObjects.add(yellowPawnsObjects);
        allPawnsObjects.add(greenPawnsObjects);
        allPawnsObjects.add(redPawnsObjects);

        bluePawns.add(bluePawn1);
        bluePawns.add(bluePawn2);
        bluePawns.add(bluePawn3);
        bluePawns.add(bluePawn4);
        yellowPawns.add(yellowPawn1);
        yellowPawns.add(yellowPawn2);
        yellowPawns.add(yellowPawn3);
        yellowPawns.add(yellowPawn4);
        greenPawns.add(greenPawn1);
        greenPawns.add(greenPawn2);
        greenPawns.add(greenPawn3);
        greenPawns.add(greenPawn4);
        redPawns.add(redPawn1);
        redPawns.add(redPawn2);
        redPawns.add(redPawn3);
        redPawns.add(redPawn4);
        allButtons.add(bluePawns);
        allButtons.add(yellowPawns);
        allButtons.add(greenPawns);
        allButtons.add(redPawns);

        indexesOfDices.add(blueDice);
        indexesOfDices.add(yellowDice);
        indexesOfDices.add(greenDice);
        indexesOfDices.add(redDice);

        indexesOfPawns.add(bluePawn1);
        indexesOfPawns.add(bluePawn2);
        indexesOfPawns.add(bluePawn3);
        indexesOfPawns.add(bluePawn4);
        indexesOfPawns.add(yellowPawn1);
        indexesOfPawns.add(yellowPawn2);
        indexesOfPawns.add(yellowPawn3);
        indexesOfPawns.add(yellowPawn4);
        indexesOfPawns.add(greenPawn1);
        indexesOfPawns.add(greenPawn2);
        indexesOfPawns.add(greenPawn3);
        indexesOfPawns.add(greenPawn4);
        indexesOfPawns.add(redPawn1);
        indexesOfPawns.add(redPawn2);
        indexesOfPawns.add(redPawn3);
        indexesOfPawns.add(redPawn4);

        indexesOfPawnsObject.add(bluePawn1Object);
        indexesOfPawnsObject.add(bluePawn2Object);
        indexesOfPawnsObject.add(bluePawn3Object);
        indexesOfPawnsObject.add(bluePawn4Object);
        indexesOfPawnsObject.add(yellowPawn1Object);
        indexesOfPawnsObject.add(yellowPawn2Object);
        indexesOfPawnsObject.add(yellowPawn3Object);
        indexesOfPawnsObject.add(yellowPawn4Object);
        indexesOfPawnsObject.add(greenPawn1Object);
        indexesOfPawnsObject.add(greenPawn2Object);
        indexesOfPawnsObject.add(greenPawn3Object);
        indexesOfPawnsObject.add(greenPawn4Object);
        indexesOfPawnsObject.add(redPawn1Object);
        indexesOfPawnsObject.add(redPawn2Object);
        indexesOfPawnsObject.add(redPawn3Object);
        indexesOfPawnsObject.add(redPawn4Object);

        paths.add(bluePlayerPath);
        paths.add(yellowPlayerPath);
        paths.add(greenPlayerPath);
        paths.add(redPlayerPath);

        playersTurns.add(blueTurn);
        playersTurns.add(yellowTurn);
        playersTurns.add(greenTurn);
        playersTurns.add(redTurn);

        bluePawn1.setDisable(true);
        yellowPawn1.setDisable(true);
        greenPawn1.setDisable(true);
        redPawn1.setDisable(true);

        yellowDice.setDisable(true);
        greenDice.setDisable(true);
        redDice.setDisable(true);
    }

    public void bluePawnMovement() {
        if(playerIndex==1) {
            pawnMovement(0, 0, bluePawn1Object.getCurrentPosition(), 0, blueDice, 0, 1,0);
        }
    }

    public void moveBluePawn2() {
        if(playerIndex==1) {
            pawnMovement(1, 1, bluePawn2Object.getCurrentPosition(), 0, blueDice, 0, 1,0);
        }
    }

    public void moveBluePawn3() {
        if(playerIndex==1) {
            pawnMovement(2, 2, bluePawn3Object.getCurrentPosition(), 0, blueDice, 0, 1,0);
        }
    }

    public void moveBluePawn4() {
        if(playerIndex==1) {
            pawnMovement(3, 3, bluePawn4Object.getCurrentPosition(), 0, blueDice, 0, 1,0);
        }
    }

    public void yellowPawnMovement(ActionEvent actionEvent) {
        int nextPlayer = 0;
        if(playerIndex==2 && gameType==2) {
            nextPlayer = 0;
        }else if((playerIndex==2 && gameType==3) || (playerIndex==2 && gameType==4)){
            nextPlayer = 2;
        }
        pawnMovement(4, 4, yellowPawn1Object.getCurrentPosition(), 1, yellowDice, 1, nextPlayer,1);
    }


    public void yellowPawn2Movement(ActionEvent actionEvent) {
        int nextPlayer = 0;
        if(playerIndex==2 && gameType==2) {
            nextPlayer = 0;
        }else if((playerIndex==2 && gameType==3) || (playerIndex==2 && gameType==4)){
            nextPlayer = 2;
        }
        pawnMovement(5, 5, yellowPawn2Object.getCurrentPosition(), 1, yellowDice, 1, nextPlayer,1);
    }

    public void yellowPawn3Movement(ActionEvent actionEvent) {
        int nextPlayer = 0;
        if(playerIndex==2 && gameType==2) {
            nextPlayer = 0;
        }else if((playerIndex==2 && gameType==3) || (playerIndex==2 && gameType==4)){
            nextPlayer = 2;
        }
        pawnMovement(6, 6, yellowPawn3Object.getCurrentPosition(), 1, yellowDice, 1, nextPlayer,1);
    }

    public void yellowPawn4Movement(ActionEvent actionEvent) {
        int nextPlayer = 0;
        if(playerIndex==2 && gameType==2) {
            nextPlayer = 0;
        }else if((playerIndex==2 && gameType==3) || (playerIndex==2 && gameType==4)){
            nextPlayer = 2;
        }
        pawnMovement(7, 7, yellowPawn4Object.getCurrentPosition(), 1, yellowDice, 1, nextPlayer,1);
    }

    public void greenPawnMovement(ActionEvent actionEvent) {
        int nextPlayer = 0;
        if(playerIndex==3 && gameType==4) {
            nextPlayer = 3;
        }else if(playerIndex==3 && gameType==3){
            nextPlayer = 0;
        }
        pawnMovement(8, 8, greenPawn1Object.getCurrentPosition(), 2, greenDice, 2, nextPlayer,2);
    }


    public void greenPawn2Movement(ActionEvent actionEvent) {
        int nextPlayer = 0;
        if(playerIndex==3 && gameType==4) {
            nextPlayer = 3;
        }else if(playerIndex==3 && gameType==3){
            nextPlayer = 0;
        }
        pawnMovement(9, 9, greenPawn2Object.getCurrentPosition(), 2, greenDice, 2, nextPlayer,2);
    }

    public void greenPawn3Movement(ActionEvent actionEvent) {
        int nextPlayer = 0;
        if(playerIndex==3 && gameType==4) {
            nextPlayer = 3;
        }else if(playerIndex==3 && gameType==3){
            nextPlayer = 0;
        }
        pawnMovement(10, 10, greenPawn3Object.getCurrentPosition(), 2, greenDice, 2, nextPlayer,2);
    }

    public void greenPawn4Movement(ActionEvent actionEvent) {
        int nextPlayer = 0;
        if(playerIndex==3 && gameType==4) {
            nextPlayer = 3;
        }else if(playerIndex==3 && gameType==3){
            nextPlayer = 0;
        }
        pawnMovement(11, 11, greenPawn4Object.getCurrentPosition(), 2, greenDice, 2, nextPlayer,2);
    }

    public void redPawnMovement(ActionEvent actionEvent) {
        int nextPlayer = 0;
        if(playerIndex==4 && gameType==4) {
            nextPlayer = 0;
        }
        pawnMovement(12, 12, redPawn1Object.getCurrentPosition(), 3, redDice, 3, nextPlayer,3);
    }

    public void redPawn2Movement(ActionEvent actionEvent) {
        int nextPlayer = 0;
        if(playerIndex==4 && gameType==4) {
            nextPlayer = 0;
        }
        pawnMovement(13, 13, redPawn2Object.getCurrentPosition(), 3, redDice, 3, nextPlayer,3);
    }

    public void redPawn3Movement(ActionEvent actionEvent) {
        int nextPlayer = 0;
        if(playerIndex==4 && gameType==4) {
            nextPlayer = 0;
        }
        pawnMovement(14, 14, redPawn3Object.getCurrentPosition(), 3, redDice, 3, nextPlayer,3);
    }

    public void redPawn4Movement(ActionEvent actionEvent) {
        int nextPlayer = 0;
        if(playerIndex==4 && gameType==4) {
            nextPlayer = 0;
        }
        pawnMovement(15, 15, redPawn4Object.getCurrentPosition(), 3, redDice, 3, nextPlayer,3);
    }

    public int pawnMovement(int pawnButtonID, int pawnObjectID, int currentPosition, int pathID, Button dice, int currentPlayer, int nextPlayer, int yourPawns){
        int moveBy = 0;
        if(diceThrow == 6){
            nextPlayer=currentPlayer;
        }
        if(diceThrow == 6 && indexesOfPawnsObject.get(pawnObjectID).getSpawnPosition().isTaken()){
            setPawnPosition(pawnButtonID,pawnObjectID,pathID,0,currentPlayer,nextPlayer);
            indexesOfPawns.get(pawnButtonID).setDisable(false);
            indexesOfPawnsObject.get(pawnObjectID).getSpawnPosition().setTaken(false);
            dice.setDisable(false);
        }else {
            moveBy = currentPosition + diceThrow;
            indexesOfPawns.get(pawnButtonID).setDisable(false);
            setPawnPosition(pawnButtonID, pawnObjectID, pathID, moveBy, currentPlayer, nextPlayer);
            allButtons.get(yourPawns).get(0).setDisable(true);
            allButtons.get(yourPawns).get(1).setDisable(true);
            allButtons.get(yourPawns).get(2).setDisable(true);
            allButtons.get(yourPawns).get(3).setDisable(true);
            dice.setDisable(false);
        }
        if((allPawnsObjects.get(yourPawns).get(0).currentPosition >= 40) && (allPawnsObjects.get(yourPawns).get(1).currentPosition >= 40) && (allPawnsObjects.get(yourPawns).get(2).currentPosition >= 40) && (allPawnsObjects.get(yourPawns).get(3).currentPosition >= 40) ){
            System.out.println("Player nr: " + currentPlayer + " won the game!");
        }
        return moveBy;
    }

    public void blueDiceRoll() {
        if(playerIndex==1){
            if (blueSpawn1.isTaken() && blueSpawn2.isTaken() && blueSpawn3.isTaken() && blueSpawn4.isTaken()) {
                this.blueTries++;
            }
            diceRoll(0,blueTries,0,0,0);
            if (((blueSpawn1.isTaken() && blueSpawn2.isTaken() && blueSpawn3.isTaken() && blueSpawn4.isTaken()) && this.blueTries == 2) || ((!blueSpawn1.isTaken() && !blueSpawn2.isTaken() && !blueSpawn3.isTaken() && !blueSpawn4.isTaken()) && this.blueTries == 1) || ((!blueSpawn1.isTaken() && !blueSpawn2.isTaken() && !blueSpawn3.isTaken() && !blueSpawn4.isTaken()) && this.blueTries == 0)){
                if(blueTries == 2 && bluePawn1.isDisabled()){
                    setPawnPosition(0, 0, 0, -1, 0, 1);
                }
                this.blueTries = -1;
            }
        }
    }

    public void yellowDiceRoll(ActionEvent actionEvent) {
        int nextPlayer = 0;
        if(gameType == 2){
            nextPlayer = 0;
        }
        if(gameType == 3 || gameType == 4){
            nextPlayer = 2;
        }
        if((playerIndex==2 && gameType==4) || (playerIndex==2 && gameType==3) ||  (playerIndex==2 && gameType==2)) {
            if (yellowSpawn1.isTaken() && yellowSpawn2.isTaken() && yellowSpawn3.isTaken() && yellowSpawn4.isTaken()) {
                this.yellowTries++;
            }
            diceRoll(1,yellowTries,1,1,1);
            if (((yellowSpawn1.isTaken() && yellowSpawn2.isTaken() && yellowSpawn3.isTaken() && yellowSpawn4.isTaken()) && this.yellowTries == 2) || ((!yellowSpawn1.isTaken() && !yellowSpawn2.isTaken() && !yellowSpawn3.isTaken() && !yellowSpawn4.isTaken()) && this.yellowTries == 1) || ((!yellowSpawn1.isTaken() && !yellowSpawn2.isTaken() && !yellowSpawn3.isTaken() && !yellowSpawn4.isTaken()) && this.yellowTries == 0)) {
                if(yellowTries == 2 && yellowPawn1.isDisabled()){
                    setPawnPosition(4, 4, 1, -1, 1, nextPlayer);
                }
                this.yellowTries = -1;
            }
        }
    }

    public void greenDiceRoll(ActionEvent actionEvent) {
        int nextPlayer = 0;
        if(gameType == 3){
            nextPlayer = 0;
        }
        if(gameType == 4){
            nextPlayer = 3;
        }
        if(playerIndex==3 && gameType==4 || playerIndex==3 && gameType==3) {
            if (greenSpawn1.isTaken() && greenSpawn2.isTaken() && greenSpawn3.isTaken() && greenSpawn4.isTaken()) {
                this.greenTries++;
            }
            diceRoll(2,greenTries,2,2,2);
            if (((greenSpawn1.isTaken() && greenSpawn2.isTaken() && greenSpawn3.isTaken() && greenSpawn4.isTaken()) && this.greenTries == 2) || ((!greenSpawn1.isTaken() && !greenSpawn2.isTaken() && !greenSpawn3.isTaken() && !greenSpawn4.isTaken()) && this.greenTries == 1) || ((!greenSpawn1.isTaken() && !greenSpawn2.isTaken() && !greenSpawn3.isTaken() && !greenSpawn4.isTaken()) && this.greenTries == 0)) {                if(greenTries == 2 && greenPawn1.isDisabled()){
                    setPawnPosition(8, 8, 2, -1, 2, nextPlayer);
                }
                this.greenTries = -1;
            }
        }
    }

    public void redDiceRoll(ActionEvent actionEvent) {
        if(playerIndex==4 && gameType==4) {
            if (redSpawn1.isTaken() && redSpawn2.isTaken() && redSpawn3.isTaken() && redSpawn4.isTaken()) {
                this.redTries++;
            }
            diceRoll(3,redTries,3,3,3);
            if (((redSpawn1.isTaken() && redSpawn2.isTaken() && redSpawn3.isTaken() && redSpawn4.isTaken()) && this.redTries == 2) || ((!redSpawn1.isTaken() && !redSpawn2.isTaken() && !redSpawn3.isTaken() && !redSpawn4.isTaken()) && this.redTries == 1) || ((!redSpawn1.isTaken() && !redSpawn2.isTaken() && !redSpawn3.isTaken() && !redSpawn4.isTaken()) && this.redTries == 0)) {                if(redTries == 2 && redPawn1.isDisabled()){
                    setPawnPosition(12, 12, 3, -1, 3, 0);
                }
                this.redTries = -1;
            }
        }
    }

    public void diceRoll(int yourTurn, int yourTries, int yourDice, int yourPawns, int yourSpawns){
        if(playersTurns.get(yourTurn)){
            if(yourTries < 3){
                System.out.println("Proby: " + yourTries);
                diceThrow = diceThrow();
                indexesOfDices.get(yourDice).setText(diceThrow.toString());
                if(diceThrow == 6){
                    allButtons.get(yourPawns).get(0).setDisable(false);
                    allButtons.get(yourPawns).get(1).setDisable(false);
                    allButtons.get(yourPawns).get(2).setDisable(false);
                    allButtons.get(yourPawns).get(3).setDisable(false);
                    indexesOfDices.get(yourDice).setDisable(true);
                }
                if(!allSpawns.get(yourSpawns).get(0).isTaken()){
                    allButtons.get(yourPawns).get(0).setDisable(false);
                }
                if(!allSpawns.get(yourSpawns).get(1).isTaken()){
                    allButtons.get(yourPawns).get(1).setDisable(false);
                }
                if(!allSpawns.get(yourSpawns).get(2).isTaken()){
                    allButtons.get(yourPawns).get(2).setDisable(false);
                }
                if(!allSpawns.get(yourSpawns).get(3).isTaken()){
                    allButtons.get(yourPawns).get(3).setDisable(false);
                }
            }
        }
    }

    public int diceThrow(){
        return ThreadLocalRandom.current().nextInt(1, 6 + 1);
    }

    public void setPawnPosition(int buttonID, int pawnID, int pathID, int moveBy, int currentPlayer, int nextPlayer){
        output.println(buttonID);
        output.println(pawnID);
        output.println(pathID);
        output.println(moveBy);
        output.println(currentPlayer);
        output.println(nextPlayer);
    }

    public void sendMessageAction(ActionEvent actionEvent) {
        String message;
        message = inputBox.getText();
        try {
            new ChatClientWriter(chatSocket, message).start();
        }catch (IOException e){
            System.out.println(e.toString());
        }
        inputBox.setText("");
    }

}
