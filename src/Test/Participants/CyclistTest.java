package Test.Participants;

import Participants.Cyclist;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.HashMap;

/** 
* Cyclist Tester. 
* 
* @author <Ningqi Lu>
* @since <pre>四月 26, 2017</pre> 
* @version 1.0 
*/ 
public class CyclistTest {
    Cyclist cyclist;
    HashMap<String, Integer> athletePointHashMap;

@Before
public void before() throws Exception {
    cyclist = new Cyclist("Oz1008","Morgan","ACT", 24,"5");
    athletePointHashMap = new HashMap<>();
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: readCyclistData() 
* 
*/ 
@Test
public void testReadCyclistData() throws Exception {
    cyclist.readCyclistData();
//TODO: Test goes here... 
} 

/** 
* 
* Method: getCyclist() 
* 
*/ 
@Test
public void testGetCyclist() throws Exception {
    cyclist.getCyclist();
//TODO: Test goes here... 
} 

/** 
* 
* Method: setCyclist(ArrayList<String[]> cyclist) 
* 
*/ 
@Test
public void testSetCyclist() throws Exception {
    cyclist.setCyclist(Cyclist.cyclist);
//TODO: Test goes here... 
} 


} 
