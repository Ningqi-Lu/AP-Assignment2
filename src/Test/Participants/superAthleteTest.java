package Test.Participants;

import Participants.superAthlete;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* superAthlete Tester. 
* 
* @author <Ningqi Lu>
* @since <pre>四月 26, 2017</pre> 
* @version 1.0 
*/ 
public class superAthleteTest {
    superAthlete superathlete;

@Before
public void before() throws Exception {
    superathlete=new superAthlete("Oz1007","Mike","NA",31,"5");
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: readSuperAthleteData() 
* 
*/ 
@Test
public void testReadSuperAthleteData() throws Exception {
    superathlete.readSuperAthleteData();
//TODO: Test goes here... 
} 

/** 
* 
* Method: getSuperathletes() 
* 
*/ 
@Test
public void testGetSuperathletes() throws Exception {
    superathlete.getSuperathletes();
//TODO: Test goes here... 
} 

/** 
* 
* Method: setSuperathletes(ArrayList<String[]> superathletes) 
* 
*/ 
@Test
public void testSetSuperathletes() throws Exception {
    superathlete.setSuperathletes(superAthlete.superathletes);
//TODO: Test goes here... 
} 


} 
