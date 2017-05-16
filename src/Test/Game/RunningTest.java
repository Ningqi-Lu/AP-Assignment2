package Test.Game;

import Game.Games;
import Game.Running;
import Participants.Sprinter;
import Participants.superAthlete;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.ArrayList;
import java.util.Random;

/** 
* Running Tester. 
* 
* @author <Ningqi Lu>
* @since <pre>四月 26, 2017</pre> 
* @version 1.0 
*/ 
public class RunningTest {

    public static Running running = new Running();

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: complete() 
* 
*/ 
@Test
public void testComplete() throws Exception {
    String[] score = new String[5];
    for (int count = 0; count < 5; count++) {
        Random random = new Random();
        score[count] = String.format("%.2f", ((random.nextDouble() * 10.0d) + 10.0d));
    }
    running.complete();

} 

/** 
* 
* Method: readDataFromAthlete() 
* 
*/ 
@Test
public void testReadDataFromAthlete() throws Exception {
    ArrayList<String[]> attendRunningAthlete = new ArrayList<>();
    attendRunningAthlete.addAll(Sprinter.getSprinter());
    attendRunningAthlete.addAll(superAthlete.getSuperathletes());
    Games.selectRandomNumberAthlete(attendRunningAthlete);

} 


} 
