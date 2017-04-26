package Game;

import Participants.Sprinter;
import Participants.Swimmer;
import Participants.superAthlete;

import java.io.IOException;
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

public class Swimming extends Games implements Complete{

    /**
     * Override method to calculate Swimming score
     * @return score
     */
    @Override
    public String[] complete() {
        String[] score=new String[Games.getAttendAthlete().size()];
        for (int count=0;count<Games.getAttendAthlete().size();count++) {
            Random random = new Random();
            score[count] = String.format("%.2f",((random.nextDouble() * 100.0d) + 100.0d));
        }
        return score;
    }

    /**
     * read data from csv file and select 4-8 athletes to attend swimming
     * @throws IOException
     */
    @Override
    public void readDataFromAthlete() throws IOException {

        ArrayList<String[]> attendSwimmingAthlete = new ArrayList<>();
        attendSwimmingAthlete.addAll(Swimmer.getSwimmer());
        attendSwimmingAthlete.addAll(Sprinter.getSprinter());
        attendSwimmingAthlete.addAll(superAthlete.getSuperathletes());
        super.selectRandomNumberAthlete(attendSwimmingAthlete);



    }

}
