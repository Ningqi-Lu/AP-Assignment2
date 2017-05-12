import Game.Cycling;
import Game.Games;
import Game.Running;
import Game.Swimming;
import Participants.Official;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;
import java.util.Map.Entry;

import static java.lang.Boolean.TRUE;

/*
 * Driver Class
 *
 * This class is the main class activities done
 *
 * Created by Yingzhi Lu on 3/20/2017.
 * Modified by both Ningqi Lu and Yingzhi Lu
 */

public class Driver {

    private int choice = 0;// the choice of the menu
    private String type = null; //the type of the game selected
    private int athleteChoice = 0;//the choice of athlete
    private String referee = null; // the string stored the current referee
    private Timestamp timestamp;//timestamp to get the current system date
    private String[] s = new String[100];//a String store the game ID
    private int runTimes=0;// a integer to store the game run times
    private String GameID =null; // store the game id of game
    private final int COLUMN_NUM=5;

    private static HashMap<String, String> scoreMap = new HashMap<String, String>();//hashmap used to store the score and athlete data

    private ArrayList<HashMap.Entry<String, String>> storeDecreasedScoreList = new ArrayList<>(); // an ArrayList to store the top 3 athlete

    private File storedData = new File("gameResults.txt"); // create a new file
    //the operator of the file
    private BufferedWriter out = new BufferedWriter(new FileWriter(storedData));

    Driver() throws IOException {
        if (!storedData.exists()) {
            storedData.createNewFile();
        }// if the fire not exists,create new one
    }

    /**
     * main menu class which control the main selection loop
     */
    public void mainMenu() {

        Menu menu = new Menu();
        do {
            Scanner in = new Scanner(System.in);
            try {
                menu.menuShow();
                choice = in.nextInt();
                switch (choice) {
                    case 1:
                        menu.showGameSelect();
                        showAthleteinSelectedGame();
                        break;
                    case 2:
                        predictWinner();
                        break;
                    case 3:
                        startGame();
                        break;
                    case 4:
                        displayAllPoints();
                        break;
                    case 5:
                        System.out.println("End of Game Ozlympic ! Thanks for playing!");
                        out.close(); // colse the file
                        return;
                }
            } catch (Exception e) {
                // if input is a string or others use try catch to let player
                // input again
                System.out.println("PLEASE INPUT RIGHT CHOICE NUMBER !");
            }
        } while (true);
    }

    /**
     * get athlete score with different types
     *
     * @return scoreMap
     */
    public HashMap getAthleteScore() {

        String[] score = new String[Games.getAttendAthlete().size()];
        switch (type) {
            case "swimming":
                Swimming s = new Swimming();
                score = s.complete();
                break;
            case "cycling":
                Cycling c = new Cycling();
                score = c.complete();
                break;
            case "running":
                Running r = new Running();
                score = r.complete();
                break;
        }

        for (int i = 0; i < Games.getAttendAthlete().size(); i++) {

            scoreMap.put(Games.getAttendAthlete().get(i)[0], score[i]);

        }
        return scoreMap;
    }

    /**
     * startGame method which is responsible for game running and score calculate
     * sort the score of athlete
     * judge the prediction of user
     * allocate the score
     *
     * @return list
     * @throws IOException
     */
    void startGame() throws IOException {
        System.out.println("Game Started..... ");
        runTimes++;
        storeDecreasedScoreList.clear();
        getAthleteScore().clear();
        getAthleteScore();
        ArrayList<Entry<String, String>> list = new ArrayList<>(scoreMap.entrySet());
        //use collection to sort
        list.sort(Comparator.comparing(Entry::getValue));

        //sort the list and get the decrease sort
        for (Entry<String, String> mapping : list) {

            System.out.println(mapping.getKey() + ":    " + mapping.getValue());
        }
        this.storeDecreasedScoreList = list;
        //judgePredictWinner();
    }

    /**
     * judge if the player guess the right top athlete
     */
    public void judgePredictWinner() {
        //System.out.println(Games.getAttendAthlete().get(athleteChoice - 1)[0]);
        if (athleteChoice == 0) {
            System.out.println("Please do not forget to predict the winner! ");
        } else if (storeDecreasedScoreList.get(0).getKey().equals(Games.getAttendAthlete().get(athleteChoice - 1)[0]) == TRUE && athleteChoice != 0) {
            System.out.println("Congratulation, your prediction is right!");
            athleteChoice = 0;
        } else {
            System.out.println("Sorry, maybe next time you could predit the right athletes :)");
            athleteChoice = 0;
        }
    }

    /**
     * Print out the details of each game preparation
     *
     * @throws IOException
     */
    public void printDetails() throws IOException {

        timestamp = new Timestamp(System.currentTimeMillis());  //the run time of this game
        System.out.println("The referee of this game is:");
        try {
            getRandomOfficial();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(referee);
        System.out.println("here is the run time of this game: ");
        System.out.println(timestamp);

    }

    /**
     * print out the results of this game
     *
     * @throws IOException
     */
    public void generateGameID() throws IOException {
        for (int i = 0; i < 100; i++) {
            s[i] = String.format("%02d", i);
        }

        if (type.equals("swimming")) {
            GameID="S"+s[runTimes];
            out.write("S"+s[runTimes]+", ");
        } else if (type.equals("running")) {
            GameID="R"+s[runTimes];
            out.write("R"+s[runTimes]+", ");
        } else if (type.equals("cycling")) {
            GameID="C"+s[runTimes];
            out.write("C"+s[runTimes]+", ");
        }

    }

    /**
     * This method gather the game results of each game
     *
     * @return a LinkedHashMap (stored game data in order)
     * @throws IOException
     */
    public void displayAllPoints() throws IOException {
        printDetails();
        generateGameID();
        out.write(referee + ", " + timestamp + "\r\n");
        //storeDecreasedScoreList.clear();

        // HashMap mapping athleteID,score and points of every athlete
        LinkedHashMap<Entry<String, String>, Integer> orderedScoreMap = new LinkedHashMap<>();
        orderedScoreMap.clear();
        System.out.println("===================================================================");
        System.out.println("Show all the athlete points:");

        //input the AthleteID,AthleteScore and AthletePoints into a linked ID
        // in which could printout in order
        orderedScoreMap.put(storeDecreasedScoreList.get(0), 5);
        orderedScoreMap.put(storeDecreasedScoreList.get(1), 2);
        orderedScoreMap.put(storeDecreasedScoreList.get(2), 1);
        int i = 3;
        while (i < Games.getAttendAthlete().size()) {
            orderedScoreMap.put(storeDecreasedScoreList.get(i), 0);
            i++;
        }
        //print out all the data in order
        for (Entry<Entry<String, String>, Integer> entryAll : orderedScoreMap.entrySet()) {
            String key = String.valueOf(entryAll.getKey());
            String s[] = key.split("=");
            int value = entryAll.getValue();
            System.out.println(s[0] + ", " + s[1] + ", " + value);
            out.write(s[0] + ", " + s[1] + ", " + value + "\r\n");
        }
        //storeDecreasedScoreList.clear();
        out.write("\r\n");
        out.flush(); // put into the file
    }

    /**
     * Show the athlete attending each game
     */
    public void showAthleteinSelectedGame() throws IOException, SQLException, ClassNotFoundException {
        //type = selectGameLoop();
        System.out.println("List below is the name of athlete attend " + type + ":");
        System.out.println("===================================================");
        switch (type) {
            case "swimming":
                Games.getAttendAthlete().clear();
                Swimming s = new Swimming();
                s.readDataFromAthlete();
                break;
            case "cycling":
                Games.getAttendAthlete().clear();
                Cycling c = new Cycling();
                c.readDataFromAthlete();
                break;
            case "running":
                Games.getAttendAthlete().clear();
                Running r = new Running();
                r.readDataFromAthlete();
                break;
        }
    }


    /**
     * Predict winner of ecah game for user
     */
    public void predictWinner() {
        //System.out.println(Games.attendAthlete.size());
        if (Games.getAttendAthlete().size() == 0) {
            System.out.println("You need to select the game first!");
            return;
        } else {
            System.out.println("Input the order number of Athlete to predict the winner:");
        }

        do {
            Scanner in = new Scanner(System.in);
            try {
                athleteChoice = in.nextInt();
                if (athleteChoice > Games.getAttendAthlete().size()) {
                    //when input order number larger than size of arraylist
                    System.out.println("Please input a reasonable choice!");
                } else {
                    System.out.println("The Athlete you predicted is:");
                    for (int n = 0; n < COLUMN_NUM; n++) {
                        System.out.print(Games.getAttendAthlete().get(athleteChoice - 1)[n] + " ");
                    }
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please input an order number of athlete list above!");
            }
        } while (true);
        System.out.println();
    }

    /**
     * the selection loop of game type
     */

    public String selectGameLoop() {
        do {
            Scanner in = new Scanner(System.in);
            try {
                choice = in.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("You selected Swimming and it will be started soon.");
                        System.out.println("Remember to predict a winner !");
                        type = "swimming";
                        return type;
                    case 2:
                        System.out.println("You selected Cycling and it will be started soon.");
                        System.out.println("Remember to predict a winner !");
                        type = "cycling";
                        return type;
                    case 3:
                        System.out.println("You selected Running and it will be started soon.");
                        System.out.println("Remember to predict a winner !");
                        type = "running";
                        return type;
                    default:
                        System.out.println("NO GAME OF THIS NUMBER! CHOOSE AGAIN!");
                }
            } catch (Exception e) {
                // if input is a string or others use try catch to let player
                // input again
                System.out.println("PLEASE INPUT RIGHT CHOICE NUMBER OF GAME SELECTION!");
            }
        } while (true);
    }


    /**
     * get a random official to each game
     *
     * @throws IOException
     */
    public void getRandomOfficial() throws IOException, SQLException, ClassNotFoundException {
        int i = (int) (Math.random() * Official.getOfficial().size());
        referee = new String(Official.getOfficial().get(i)[0]);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReferee() {
        return referee;
    }

    public void setReferee(String referee) {
        this.referee = referee;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getGameID() {
        return GameID;
    }

    public void setGameID(String gameID) {
        GameID = gameID;
    }

    public ArrayList<Entry<String, String>> getStoreDecreasedScoreList() {
        return storeDecreasedScoreList;
    }
}
