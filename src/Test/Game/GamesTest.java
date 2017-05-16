package Test.Game;

import Game.Games;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.ArrayList;

/** 
* Games Tester. 
* 
* @author <Ningqi Lu>
* @since <pre>四月 26, 2017</pre> 
* @version 1.0 
*/ 
public class GamesTest {
    Games games;
    ArrayList<String[]> attendAthlete;

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: readDataFromAthlete() 
* 
*/ 
@Test
public void testReadDataFromAthlete() throws Exception {
    games.readDataFromAthlete();
//TODO: Test goes here... 
} 

/** 
* 
* Method: selectRandomNumberAthlete(ArrayList<String[]> ad) 
* 
*/ 
@Test
public void testSelectRandomNumberAthlete() throws Exception {
    games.selectRandomNumberAthlete(attendAthlete);
//TODO: Test goes here... 
} 

/** 
* 
* Method: getAttendAthlete() 
* 
*/ 
@Test
public void testGetAttendAthlete() throws Exception {
    games.getAttendAthlete();
//TODO: Test goes here... 
} 

/** 
* 
* Method: setAttendAthlete(ArrayList<String[]> attendAthlete) 
* 
*/ 
@Test
public void testSetAttendAthlete() throws Exception {
    games.setAttendAthlete(attendAthlete);
//TODO: Test goes here... 
} 


} 
