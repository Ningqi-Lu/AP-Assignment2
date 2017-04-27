package Game;

import Participants.Cyclist;
import Participants.Sprinter;
import Participants.superAthlete;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/*
 * Cycling Class
 *
 * This class is Cycling game activities
 *
 * Created by Ningqi Lu on 3/20/2017.
 * Modified by both Ningqi Lu and Yingzhi Lu
 */

public class Cycling extends Games implements Complete {

    /**
     * Override method to calculate Cycling score
     *
     * @return score
     */
    @Override
    public String[] complete() {
        String[] score = new String[Games.getAttendAthlete().size()];
        for (int count = 0; count < Games.getAttendAthlete().size(); count++) {
            Random random = new Random();
            score[count] = String.format("%.2f", ((random.nextDouble() * 300.0d) + 500.0d));
        }
        return score;
    }

    /**
     * read data from txt file and select 4-8 athletes to attend cycling
     *
     * @throws IOException
     */
    @Override
    public void readDataFromAthlete() throws IOException {
    /*    System.out.println(Cyclist.getCyclist().size());//17
        System.out.println(Sprinter.getSprinter().size());//17
        System.out.println(superAthlete.getSuperathletes().size());//14*/
        ArrayList<String[]> attendCyclingAthlete = new ArrayList<>();
        attendCyclingAthlete.addAll(Cyclist.getCyclist());
        attendCyclingAthlete.addAll(Sprinter.getSprinter());
        attendCyclingAthlete.addAll(superAthlete.getSuperathletes());
        //System.out.println(attendCyclingAthlete.size());
        super.selectRandomNumberAthlete(attendCyclingAthlete);
    }

}



