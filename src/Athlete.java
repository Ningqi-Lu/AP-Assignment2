import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Athlete extends Participant{

    private String score; // the score of every athlete
    private Integer point; //the point of every athlete
    public static ArrayList<String[]> athleteALL; //cyclist arraylist

    static {
        try {
            athleteALL = new ArrayList<String[]>(readDBdata.getLineList());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static HashMap<String,Integer> AthletePointHashMap = new HashMap<>();


    public static ArrayList<String[]> getAthleteALL() {
        return athleteALL;
    }

    public static void setAthleteALL(ArrayList<String[]> athleteALL) {
        Athlete.athleteALL = athleteALL;
    }

    /**
     * Constructor
     *
     * @param participantID
     * @param participantName
     * @param participantState
     * @param participantAge
     */
    public Athlete(String participantID, String participantName, String participantState, int participantAge) {
        super(participantID, participantName, participantState, participantAge);
    }

    /**
     * Constructor
     * @param participantID
     * @param participantName
     * @param participantState
     * @param participantAge
     * @param score
     */
    public Athlete(String participantID, String participantName, String participantState, int participantAge, String score) {
        super(participantID, participantName, participantState, participantAge);
        this.score = score;
    }

    /**
     * Constructor
     * @param participantID
     * @param participantName
     * @param participantState
     * @param participantAge
     * @param point
     */
    public Athlete(String participantID, String participantName, String participantState, int participantAge, Integer point) {
        super(participantID, participantName, participantState, participantAge);
        this.point = point;
    }


    /**
     * getters and setters
     * @return
     */
    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public static HashMap<String, Integer> getAthletePointHashMap() {
        return AthletePointHashMap;
    }

    public void setAthletePointHashMap(HashMap<String, Integer> athletePointHashMap) {
        AthletePointHashMap = athletePointHashMap;
    }
}
