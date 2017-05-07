package Participants;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Dumpling on 5/6/2017.
 */
public class readDBdata {

    //public static final int COLUMN_NUM = 5;//the column of the csv file
    //static ArrayList<String[]> lineList = new ArrayList<String[]>();// ArrayList used to store the row of csv file

    private static Connection con;
    private static boolean hasAthleteData = false;
    private static boolean hasResultData=false;

    public ResultSet displayAthete() throws SQLException, ClassNotFoundException {
        if (con == null) {
            getConnection();
        }

        Statement state= con.createStatement();
        ResultSet res=state.executeQuery("SELECT aID,atype,aname,age,state FROM athlete");
        return res;
    }

    private void getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        con= DriverManager.getConnection("jdbc:sqlite:OzlympicAthleteData.db");
                initialiseAthlete();
    }

    private void initialiseAthlete() throws SQLException {
        if(!hasAthleteData){
            hasAthleteData=true;
            Statement state =con.createStatement();
            ResultSet res=state.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='athlete'");
                    if(!res.next()) {
                        System.out.println("Building the athlete table with prepopulated values");

                        Statement state2 = con.createStatement();
                        state2.execute("CREATE TABLE athlete(aID VARCHAR(10)," + "atype VARCHAR(15)," +
                                "aname VARCHAR(20)," + "age INTEGER," + "state VARCHAR(5)," + "PRIMARY KEY (aID));");
                        //insert some data
                        PreparedStatement prep = con.prepareStatement("INSERT INTO athlete VALUES('Oz1002','SUPERATHLETE','Jodie',34,'VIC')");
                        prep.execute();
                    }
        }
    }

/*    private void initialiseResult() throws SQLException {
        if(!hasResultData){
            hasResultData=true;
            Statement state =con.createStatement();
            ResultSet res=state.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='gameResult'");
            if(!res.next()) {
                System.out.println("Building the gameResult table with prepopulated values");

                Statement state2 = con.createStatement();
                state2.execute("CREATE TABLE athlete(gID VARCHAR(10)," + "oID VARCHAR(10)," +
                        "aID VARCHAR(10)," + "results DOUBLE ," + "score INTEGER ," + "PRIMARY KEY (gID));");
                //insert some data
                PreparedStatement prep = con.prepareStatement("INSERT INTO athlete VALUES('C01','Oz1008','Oz2008',118.2,5)");
                prep.execute();
            }
        }
    }*/


}
