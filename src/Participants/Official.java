package Participants;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static Participants.readTXTData.COLUMN_NUM;

/*
 * Official Class
 *
 * This class is superAthlete which read the Official data from txt
 *
 * Created by Yingzhi Lu on 3/20/2017.
 * Modified by both Ningqi Lu and Yingzhi Lu
 */
public class Official extends Participant{

    public static ArrayList<String[]> official = new ArrayList<String[]>();//official athlete

    /**
     * Constructor
     *
     * @param participantID
     * @param participantName
     * @param participantState
     * @param participantAge
     */
    public Official(String participantID, String participantName, String participantState, int participantAge) {
        super(participantID, participantName, participantState, participantAge);
    }

    /**
     * data reader of Official
     * @throws IOException
     */
    public static void readOfficialdata() throws IOException, SQLException, ClassNotFoundException {

        ArrayList<String[]> tempOf = readDBdata.getLineList();

        for (int i = 0; i < tempOf.size(); i++) {
            if (tempOf.get(i)[1].equals("OFFICIAL")) {
                String[] currCol = new String[COLUMN_NUM];
                for (int n = 0; n < COLUMN_NUM; n++) {
                    currCol[n] = tempOf.get(i)[COLUMN_NUM + n - 5];
                    //System.out.print(currCol[n]);
                }
                official.add(currCol);
            }
        }
    }

    /**
     * getter and setter of ArrayList official
     * @return official
     * @throws IOException
     */
    public static ArrayList<String[]> getOfficial() throws IOException, SQLException, ClassNotFoundException {
        official.clear();
        readOfficialdata();
        return official;
    }

    public static void setOfficial(ArrayList<String[]> official) {
        Official.official = official;
    }
}
