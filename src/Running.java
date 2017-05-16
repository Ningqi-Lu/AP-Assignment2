import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

/*
 * Running Class
 *
 * This class is Running game activities
 *
 * Created by Ningqi Lu on 3/20/2017.
 * Modified by both Ningqi Lu and Yingzhi Lu
 */
public class Running extends Games implements Complete {

    /**
     * Override method to calculate running score
     *
     * @return score
     */
    @Override
    public String[] complete() {
        String[] score = new String[getAttendAthlete().size()];
        for (int count = 0; count < getAttendAthlete().size(); count++) {
            Random random = new Random();
            score[count] = String.format("%.2f", ((random.nextDouble() * 10.0d) + 10.0d));
        }
        return score;
    }

    /**
     * read data from txt file and select 4-8 athletes to attend running
     * @throws IOException
     */
    @Override
    public void readDataFromAthlete() throws IOException, SQLException, ClassNotFoundException {

       /* System.out.println(Sprinter.getSprinter().size());//17
        System.out.println(superAthlete.getSuperathletes().size());//14*/
        ArrayList<String[]> attendRunningAthlete = new ArrayList<>();
        attendRunningAthlete.addAll(Sprinter.getSprinter());
        attendRunningAthlete.addAll(superAthlete.getSuperathletes());
        //System.out.println(attendRunningAthlete.size());
        super.selectRandomNumberAthlete(attendRunningAthlete);
    }

}
