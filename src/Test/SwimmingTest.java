package Test;

import Games;
import Swimming;
import Sprinter;
import Swimmer;
import superAthlete;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.ArrayList;
import java.util.Random;

/** 
* Swimming Tester. 
* 
* @author <Ningqi Lu>
* @since <pre>四月 26, 2017</pre> 
* @version 1.0 
*/ 
public class SwimmingTest {
    public static Swimming swimming = new Swimming();

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
    String[] score = new String[6];
    for (int count = 0; count < 6; count++) {
        Random random = new Random();
        score[count] = String.format("%.1f", ((random.nextDouble() * 100.0d) + 100.0d));
    }
    swimming.complete();

} 

/** 
* 
* Method: readDataFromAthlete() 
* 
*/ 
@Test
public void testReadDataFromAthlete() throws Exception {
    ArrayList<String[]> attendSwimmingAthlete = new ArrayList<>();
    attendSwimmingAthlete.addAll(Swimmer.getSwimmer());
    attendSwimmingAthlete.addAll(Sprinter.getSprinter());
    attendSwimmingAthlete.addAll(superAthlete.getSuperathletes());
    Games.selectRandomNumberAthlete(attendSwimmingAthlete);

} 


} 
