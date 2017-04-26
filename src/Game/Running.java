package Game;

import Participants.Sprinter;
import Participants.superAthlete;

import java.io.IOException;
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
     * @return score
     */
    @Override
    public String[] complete() {
        String[] score=new String[Games.getAttendAthlete().size()];
        for (int count=0;count<Games.getAttendAthlete().size();count++) {
            Random random = new Random();
            score[count] = String.format("%.2f",((random.nextDouble() * 10.0d) + 10.0d));
        }
        return score;
    }

    /**
     * read data from csv file and select 4-8 athletes to attend running
     * @throws IOException
     */
    @Override
    public void readDataFromAthlete() throws IOException {

        ArrayList<String[]> attendRunningAthlete = new ArrayList<>();
        attendRunningAthlete.addAll(Sprinter.getSprinter());
        attendRunningAthlete.addAll(superAthlete.getSuperathletes());

        super.selectRandomNumberAthlete(attendRunningAthlete);
    }

}
