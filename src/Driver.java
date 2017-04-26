import Game.Cycling;
import Game.Games;
import Game.Running;
import Game.Swimming;
import Participants.Athlete;
import Participants.Official;

import java.io.IOException;
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

    private int choice;// the choice of the menu
    private String type; //the type of the game selected
    private int athleteChoice = 0;//the choice of athlete
    private String referee;
    public static HashMap<String, String> scoreMap = new HashMap<String, String>();//hashmap used to store the score and athlete data
    ArrayList<HashMap.Entry<String, String>> storeTopThreeList = new ArrayList<>(); // an ArrayList to store the top 3 athlete
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
                        displayAllResults();
                        break;
                    case 5:
                        displayAllPoints();
                        break;
                    case 6:
                        System.out.println("End of Game Ozlympic ! Thanks for playing!");
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

            scoreMap.put(Games.getAttendAthlete().get(i)[1], score[i]);

        }
        return scoreMap;
    }

    /**
     * startGame method which is responsible for game running and score calculate
     * sort the score of athlete
     * judge the prediction of user
     * allocate the score
     * @return list
     * @throws IOException
     */
    public void startGame() throws IOException {

        System.out.println("Game Started..... ");
        System.out.println("The referee of this game is:");
        getRandomOfficial();
        System.out.println("Here is the score of each athlete:");
        getAthleteScore().clear();
        getAthleteScore();

        ArrayList<HashMap.Entry<String, String>> list = new ArrayList<>(scoreMap.entrySet());
        //use collection to sort
        Collections.sort(list, Comparator.comparing(Entry::getValue));

        //sort the list and get the decrease sort
        for (HashMap.Entry<String, String> mapping : list) {
            System.out.println(mapping.getKey() + ":    " + mapping.getValue());
        }

        System.out.println("===================================================================");
        // if to judge weather this is the topped athelete user predicted
        if (list.get(0).getKey().equals(Games.getAttendAthlete().get(athleteChoice - 1)[1]) == TRUE) {
            System.out.println("Congratulation, your prediction is right!");
        } else {
            System.out.println("Sorry, maybe next time you could predit the right athletes :)");
        }
        this.storeTopThreeList=list;
    }



    /**
     * print out the results of this game
     * @throws IOException
     */

    public void displayAllResults() throws IOException {
        System.out.println("List below is all results:");
        if (type.equals("swimming")) {
            System.out.println("Game: S01");
        } else if (type.equals("running")) {
            System.out.println("Game: R01");
        } else if (type.equals("cycling"))
            System.out.println("Game: C01");
        System.out.print("Referee:   ");
        System.out.println(referee);

        Set entries = scoreMap.entrySet();
        Iterator iterator = entries.iterator();
        while (iterator.hasNext()) {
            HashMap.Entry entry = (HashMap.Entry) iterator.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println("Name: " + key + "     Score: " + value);
        }
    }

    /*
     * this method is printout the points of this game
     */
    public void displayAllPoints() throws IOException {
        System.out.println("===================================================================");
        System.out.println("Show all the athlete points:");

        String gold = storeTopThreeList.get(0).getKey();
        String silver = storeTopThreeList.get(1).getKey();
        String bronze = storeTopThreeList.get(2).getKey();

        System.out.println(gold +"  5 points");
        System.out.println(silver +"  2 points");
        System.out.println(bronze + "  1 points");
        int i=3;
        while(i<Games.getAttendAthlete().size()){
            System.out.println(storeTopThreeList.get(i).getKey() + "  0 points");
            i++;
        }

    }

    /**
     * Show the athlete attending each game
     */
    public void showAthleteinSelectedGame() throws IOException {
        type = selectGameLoop();
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
            boolean b = false;
            try {
                athleteChoice = in.nextInt();
                if (athleteChoice > Games.getAttendAthlete().size()) {
                    //when input order number larger than size of arraylist
                    System.out.println("Please input a reasonable choice!");
                } else {
                    System.out.println("The Athlete you predicted is:");
                    for (int n = 0; n < Ozlympic.COLUMN_NUM; n++) {
                        System.out.print(Games.getAttendAthlete().get(athleteChoice - 1)[n] + " ");
                        //
                    }
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please input an order number of athlete list above!");
                b = true;
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
    public void getRandomOfficial() throws IOException {
        int i = (int) (Math.random() * Official.getOfficial().size());
        referee = new String(Official.getOfficial().get(i)[1]);
        System.out.println(referee);
    }

}
