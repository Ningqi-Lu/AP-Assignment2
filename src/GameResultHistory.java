import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Dumpling on 5/3/2017.
 */
public class GameResultHistory {

        private  SimpleStringProperty athleteID;
        private  SimpleStringProperty athleteScore;
        private  SimpleStringProperty points;

        GameResultHistory(String aID, String aScore, String poi) {
            this.athleteID = new SimpleStringProperty(aID);
            this.athleteScore = new SimpleStringProperty(aScore);
            this.points = new SimpleStringProperty(poi);
        }

    public String getAthleteID() {
        return athleteID.get();
    }

    public SimpleStringProperty athleteIDProperty() {
        return athleteID;
    }

    public void setAthleteID(String athleteID) {
        this.athleteID.set(athleteID);
    }

    public String getAthleteScore() {
        return athleteScore.get();
    }

    public SimpleStringProperty athleteScoreProperty() {
        return athleteScore;
    }

    public void setAthleteScore(String athleteScore) {
        this.athleteScore.set(athleteScore);
    }

    public String getPoints() {
        return points.get();
    }

    public SimpleStringProperty pointsProperty() {
        return points;
    }

    public void setPoints(String points) {
        this.points.set(points);
    }
}

