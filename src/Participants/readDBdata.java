package Participants;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Dumpling on 5/6/2017.
 */
public class readDBdata {

    //public static final int COLUMN_NUM = 5;//the column of the csv file
    static ArrayList<String[]> lineList = new ArrayList<String[]>();// ArrayList used to store the row of database data

    private static Connection con;
    private static boolean hasAthleteData = false;
    private static boolean hasResultData = false;

    public static ResultSet getDBdata() throws SQLException, ClassNotFoundException {
        //if (con == null) {
        getConnection();
        // }

        Statement state = con.createStatement();
        ResultSet res = state.executeQuery("SELECT aID,atype,aname,age,state FROM athlete");

        return res;
    }

    private static void getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:OzlympicAthleteData.db");
        initialiseAthleteTable();
    }

    /**
     * a method to initialise the athlete table if the database is deleted
     *
     * @throws SQLException
     */
    private static void initialiseAthleteTable() throws SQLException {
        if (!hasAthleteData) {
            hasAthleteData = true;
            Statement state = con.createStatement();
            ResultSet res = state.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='athlete'");

            if (!res.next()) {
                System.out.println("Binding the database and initialize the data");
                Statement state2 = con.createStatement();
                state2.execute("CREATE TABLE athlete(aID VARCHAR(10)," + "atype VARCHAR(15)," +
                        "aname VARCHAR(20)," + "age INTEGER," + "state VARCHAR(5)," + "PRIMARY KEY (aID));");
                readTXTDataToDB();
            }

        }
    }

    /**
     * read from the txt file and input all the data to database method
     *
     * @throws SQLException
     */
    public static void readTXTDataToDB() throws SQLException {
        System.out.println("running readTXTDataToBD method!");
        con.prepareStatement("DELETE FROM athlete").execute();
        //insert some data
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("participants.txt"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String a[] = line.split(",");
                //System.out.println(a[0]+a[1]+a[2]+a[3]+a[4]);
                con.prepareStatement("INSERT INTO athlete(aID,atype,aname,age,state)"
                        + "VALUES ('" + a[0] + "', '" + a[1] + "', '" + a[2] + "'," + Integer.parseInt(a[3]) + ", '" + a[4] + "');").execute();
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Reading file failed! ");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Initialize database failed! ");
            e.printStackTrace();
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
                state2.execute("CREATE TABLE gameResults(gID VARCHAR(10)," + "oID VARCHAR(10)," +
                        "aID VARCHAR(10)," + "results DOUBLE ," + "score INTEGER ," + "PRIMARY KEY (gID));");
                //insert some data
                PreparedStatement prep = con.prepareStatement("INSERT INTO athlete VALUES('C01','Oz1008','Oz2008',118.2,5)");
                prep.execute();
            }
        }
    }*/

    private static void readDBdataToArrayLIst() throws SQLException, ClassNotFoundException {
        ResultSet rs = getDBdata();
        while (rs.next()) {
            String[] a = new String[5];
            a[0] = rs.getString("aID");
            a[1] = rs.getString("atype");
            a[2] = rs.getString("aname");
            a[3] = rs.getString("age");
            a[4] = rs.getString("state");
            //System.out.println(a[0]+a[1]+a[2]+a[3]+a[4]);
            /*System.out.println(rs.getString("aID") + " " + rs.getString("atype") + " " + rs.getString("aname")
                    + " " + rs.getInt("age") + " " + rs.getString("state"));*/
            lineList.add(a);
        }
/*        for (int i = 0; i < 40; i++) {
            for (int j = 0; j <5 ; j++) {
                System.out.print(lineList.get(i)[j]+" ");
            }
            System.out.println();
        }*/
    }

    public static ArrayList<String[]> getLineList() throws SQLException, ClassNotFoundException {
        lineList.clear();
        readDBdataToArrayLIst();
        return lineList;
    }
}
