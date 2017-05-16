import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

/*
 * Swimming Class
 *
 * This class is Swimming game activities
 *
 * Created by Ningqi Lu on 3/20/2017.
 * Modified by both Ningqi Lu and Yingzhi Lu
 */

public class Swimming extends Games implements Complete {

    /**
     * Override method to calculate Swimming score
     *
     * @return score
     */
    @Override
    public String[] complete() {
        String[] score = new String[getAttendAthlete().size()];
        for (int count = 0; count < getAttendAthlete().size(); count++) {
            Random random = new Random();
            score[count] = String.format("%.1f", ((random.nextDouble() * 100.0d) + 100.0d));
        }
        return score;
    }

    /**
     * read data from txt file and select 4-8 athletes to attend swimming
     *
     * @throws IOException
     */
    @Override
    public void readDataFromAthlete() throws IOException, SQLException, ClassNotFoundException {

       // System.out.println(Swimmer.getSwimmer().size());//12
       // System.out.println(Sprinter.getSprinter().size());//17
        //System.out.println(superAthlete.getSuperathletes().size());//14
        ArrayList<String[]> attendSwimmingAthlete = new ArrayList<>();
        attendSwimmingAthlete.addAll(Swimmer.getSwimmer());
        attendSwimmingAthlete.addAll(Sprinter.getSprinter());
        attendSwimmingAthlete.addAll(superAthlete.getSuperathletes());
        //System.out.println(attendSwimmingAthlete.size());
        super.selectRandomNumberAthlete(attendSwimmingAthlete);


    }

}
