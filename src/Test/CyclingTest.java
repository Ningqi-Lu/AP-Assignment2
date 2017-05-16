package Test;

import Cycling;
import Games;
import Cyclist;
import Sprinter;
import superAthlete;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

/** 
* Cycling Tester.
* 
* @author <Ningqi Lu>
* @since <pre>四月 26, 2017</pre>
* @version 1.0 
*/ 
public class CyclingTest {

    public static Cycling cycling= new Cycling();


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
    String[] score = new String[4];
    for (int count = 0; count < 4; count++) {
        Random random = new Random();
        score[count] = String.format("%.1f", ((random.nextDouble() * 300.0d) + 500.0d));
    }
    cycling.complete();


} 

/** 
* 
* Method: readDataFromAthlete() 
* 
*/ 
@Test
public void testReadDataFromAthlete() throws IOException, SQLException, ClassNotFoundException {
    ArrayList<String[]> attendCyclingAthlete = new ArrayList<>();
    attendCyclingAthlete.addAll(Cyclist.getCyclist());
    attendCyclingAthlete.addAll(Sprinter.getSprinter());
    attendCyclingAthlete.addAll(superAthlete.getSuperathletes());
    Games.selectRandomNumberAthlete(attendCyclingAthlete);

} 


} 
