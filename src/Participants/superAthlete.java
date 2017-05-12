package Participants;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static Participants.readTXTData.COLUMN_NUM;

/*
 * superAthlete Class
 *
 * This class is superAthlete which read the superAthlete data from txt
 *
 * Created by Yingzhi Lu on 3/20/2017.
 * Modified by both Ningqi Lu and Yingzhi Lu
 */

public class superAthlete extends Athlete {

    public static ArrayList<String[]> superathletes = new ArrayList<String[]>();// super athlete ArrayList

    /**
     * Constructor
     *
     * @param participantID
     * @param participantName
     * @param participantState
     * @param participantAge
     */
    public superAthlete(String participantID, String participantName, String participantState, int participantAge) {
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
    public superAthlete(String participantID, String participantName, String participantState, int participantAge, String score) {
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
    public superAthlete(String participantID, String participantName, String participantState, int participantAge, Integer point) {
        super(participantID, participantName, participantState, participantAge, point);
    }

    /**
     * data reader of superAthlete athlete
     * @throws IOException
     */
    public static void readSuperAthleteData() throws IOException, SQLException, ClassNotFoundException {

        ArrayList<String[]> tempSa = readDBdata.getLineList();

        for (int i = 0; i < tempSa.size(); i++) {
            if (tempSa.get(i)[1].equals("SUPERATHLETE")) {
                String[] currCol = new String[COLUMN_NUM];
                for (int n = 0; n < COLUMN_NUM; n++) {
                    currCol[n] = tempSa.get(i)[COLUMN_NUM + n - 5];
                    //System.out.print(currCol[n]);
                }
                superathletes.add(currCol);
            }
        }
    }

    /**
     * getter and setter of ArrayList superAthlete
     * @return superAthlete
     * @throws IOException
     */
    public static ArrayList<String[]> getSuperathletes() throws IOException, SQLException, ClassNotFoundException {
        superathletes.clear();
        readSuperAthleteData();
        return superathletes;
    }

    public static void setSuperathletes(ArrayList<String[]> superathletes) {
        superAthlete.superathletes = superathletes;
    }
}
