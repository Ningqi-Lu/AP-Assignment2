package Game;

import java.io.IOException;
import java.util.ArrayList;

/*
 * Abstract Game Class
 *
 * This class is an abstract class which is extended by games
 *
 * Created by Ningqi Lu on 3/20/2017.
 * Modified by both Ningqi Lu and Yingzhi Lu
 */

public abstract class Games {

    public abstract void readDataFromAthlete() throws IOException; // abstract method to read total
    // potential attending athletes

    public static ArrayList<String[]> attendAthlete = new ArrayList<String[]>(); //attend athlete in every game
    //stored current athlete attend games

    public static final int COLUMN_NUM = 5; // column number if csv file


    /**
     * select random number athlete
     *
     * @param ad
     * @return ArrayList attendAthlete
     */
    public void selectRandomNumberAthlete(ArrayList<String[]> ad) {
        ArrayList<Integer> judgeRepeatedList = new ArrayList<Integer>(); //a list used to judge if this row number is repeated
        int num = (int) (Math.random() * 5 + 3); //the number of athletes will attend the game
        if (num < 4) {
            System.out.println("Athlete number lower than 4, game cancelled ");
        } else {
            for (int i = 0; i < num; i++) {
                int rowNumber = (int) (Math.random() * (ad.size() - 1)); //select a random row in ArrayList passed in
                if(!judgeRepeatedList.contains(rowNumber));
                judgeRepeatedList.add(rowNumber);
            }
            // printout the athlete attend this game
            for (int i = 0; i < num; i++) {
                String[] currCol = new String[COLUMN_NUM];
                System.out.print((i+1)+": ");
                for (int j = 0; j < COLUMN_NUM; j++) {
                    currCol[j] = ad.get(judgeRepeatedList.get(i))[j];
                    System.out.print(currCol[j] + " ");
                }
                attendAthlete.add(currCol);
                System.out.println();
            }
        }
    }

    /**
     * getter and setter of ArrayList attendAthlete
     *
     * @return attendAthlete
     */
    public static ArrayList<String[]> getAttendAthlete() {
        return attendAthlete;
    }

    public static void setAttendAthlete(ArrayList<String[]> attendAthlete) {
        Games.attendAthlete = attendAthlete;
    }
}

