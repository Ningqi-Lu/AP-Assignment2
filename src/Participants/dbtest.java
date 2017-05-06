package Participants;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Dumpling on 5/6/2017.
 */
public class dbtest {


    public static void main(String[] args) {
        ResultSet rs;
        readDBdata readDBdata=new readDBdata();

        try {
            rs= readDBdata.displayAthete();
            while (rs.next()){
                System.out.println(rs.getString("aID")+" "+rs.getString("aname"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
