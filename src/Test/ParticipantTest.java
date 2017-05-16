package Test;

import Participant;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* Participant Tester. 
* 
* @author <Ningqi Lu>
* @since <pre>四月 26, 2017</pre> 
* @version 1.0 
*/ 
public class ParticipantTest {
    Participant participant;


@Before
public void before() throws Exception {


} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getParticipantID() 
* 
*/ 
@Test
public void testGetParticipantID() throws Exception {
    participant.getParticipantID();
//TODO: Test goes here... 
} 

/** 
* 
* Method: setParticipantID(String participantID) 
* 
*/ 
@Test
public void testSetParticipantID() throws Exception {
    participant.setParticipantID("Oz1002");
//TODO: Test goes here... 
} 

/** 
* 
* Method: getParticipantName() 
* 
*/ 
@Test
public void testGetParticipantName() throws Exception {
    participant.getParticipantName();
//TODO: Test goes here... 
} 

/** 
* 
* Method: setParticipantName(String participantName) 
* 
*/ 
@Test
public void testSetParticipantName() throws Exception {
    participant.setParticipantName("Emma");
//TODO: Test goes here... 
} 

/** 
* 
* Method: getParticipantState() 
* 
*/ 
@Test
public void testGetParticipantState() throws Exception {
    participant.getParticipantState();
//TODO: Test goes here... 
} 

/** 
* 
* Method: setParticipantState(String participantState) 
* 
*/ 
@Test
public void testSetParticipantState() throws Exception {
    participant.setParticipantState("WA");
//TODO: Test goes here... 
} 

/** 
* 
* Method: getParticipantAge() 
* 
*/ 
@Test
public void testGetParticipantAge() throws Exception {
    participant.getParticipantAge();
//TODO: Test goes here... 
} 

/** 
* 
* Method: setParticipantAge(int participantAge) 
* 
*/ 
@Test
public void testSetParticipantAge() throws Exception {
    participant.setParticipantAge(29);
//TODO: Test goes here... 
} 


} 
