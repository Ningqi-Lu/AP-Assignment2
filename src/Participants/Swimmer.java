package Participants;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static Participants.readTXTData.COLUMN_NUM;

/*
 * Swimmer Class
 *
 * This class is Swimmer which read the Swimmer data from txt
 *
 * Created by Yingzhi Lu on 3/20/2017.
 * Modified by both Ningqi Lu and Yingzhi Lu
 */
public class Swimmer extends Athlete{


    public static ArrayList<String[]> swimmer = new ArrayList<String[]>();

    /**
     * Constructor
     *
     * @param participantID
     * @param participantName
     * @param participantState
     * @param participantAge
     */
    public Swimmer(String participantID, String participantName, String participantState, int participantAge) {
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
    public Swimmer(String participantID, String participantName, String participantState, int participantAge, String score) {
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
    public Swimmer(String participantID, String participantName, String participantState, int participantAge, Integer point) {
        super(participantID, participantName, participantState, participantAge, point);
    }


    /**
     * data reader of Swimmer athlete
     * @throws IOException
     */
    public static void readSwimmerdata() throws IOException, SQLException, ClassNotFoundException {

        ArrayList<String[]> tempSw = readDBdata.getLineList();

        for (int i = 0; i < tempSw.size(); i++) {
            if (tempSw.get(i)[1].equals("SWIMMER")) {
                String[] currCol = new String[COLUMN_NUM];
                for (int n = 0; n < COLUMN_NUM; n++) {
                    currCol[n] = tempSw.get(i)[COLUMN_NUM + n - 5];
                    //System.out.print(currCol[n]);
                }
                swimmer.add(currCol);
            }
        }
    }

    /**
     * getter and setter of ArrayList Swimmer
     * @return Swimmer
     * @throws IOException
     */
    public static ArrayList<String[]> getSwimmer() throws IOException, SQLException, ClassNotFoundException {
        swimmer.clear();
        readSwimmerdata();
        return swimmer;
    }

    public static void setSwimmer(ArrayList<String[]> swimmer) {
        Swimmer.swimmer = swimmer;
    }
}
