package Participants;
import java.io.IOException;
import java.util.ArrayList;

import static Participants.readTXTData.COLUMN_NUM;

/*
 * Cyclist Class
 *
 * This class is Cyclist which read the cyclist data from txt
 *
 * Created by Yingzhi Lu on 3/20/2017.
 * Modified by both Ningqi Lu and Yingzhi Lu
 */

public class Cyclist extends Athlete{


    public static ArrayList<String[]> cyclist = new ArrayList<String[]>(); //cyclist arraylist

    /**
     * Constructor
     *
     * @param participantID
     * @param participantName
     * @param participantState
     * @param participantAge
     */
    public Cyclist(String participantID, String participantName, String participantState, int participantAge) {
        super(participantID, participantName, participantState, participantAge);
    }

    /**
     * Constructor
     *
     * @param participantID
     * @param participantName
     * @param participantState
     * @param participantAge
     * @param score
     */
    public Cyclist(String participantID, String participantName, String participantState, int participantAge, String score) {
        super(participantID, participantName, participantState, participantAge, score);
    }

    /**
     * Constructor
     *
     * @param participantID
     * @param participantName
     * @param participantState
     * @param participantAge
     * @param point
     */
    public Cyclist(String participantID, String participantName, String participantState, int participantAge, Integer point) {
        super(participantID, participantName, participantState, participantAge, point);
    }


    /**
     * data reader of cyclist athlete
     * @throws IOException
     */
    public static void readCyclistData() throws IOException {

        ArrayList<String[]> tempCy = readTXTData.getLineList();

        for (int i = 0; i < tempCy.size(); i++) {
            if (tempCy.get(i)[COLUMN_NUM - 1].equals("CYCLIST")) {
                String[] currCol = new String[COLUMN_NUM];
                for (int n = 0; n < COLUMN_NUM; n++) {
                    currCol[n] = tempCy.get(i)[COLUMN_NUM + n - 5];
                    //System.out.print(currCol[n]);
                }
                cyclist.add(currCol);
            }
        }
    }

    /**
     * getter and setter of ArrayList Cyclist
     * @return cyclist
     * @throws IOException
     */
    public static ArrayList<String[]> getCyclist() throws IOException {
        readCyclistData();
        return cyclist;
    }

    public static void setCyclist(ArrayList<String[]> cyclist) {
        Cyclist.cyclist = cyclist;
    }
}
