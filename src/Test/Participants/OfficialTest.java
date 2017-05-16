package Test.Participants;

import Participants.Official;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* Official Tester. 
* 
* @author <Ningqi Lu>
* @since <pre>四月 26, 2017</pre> 
* @version 1.0 
*/ 
public class OfficialTest {
    Official official;

@Before
public void before() throws Exception {
    official = new Official("Oz1002","Helen","VIC",32);
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: readOfficialdata() 
* 
*/ 
@Test
public void testReadOfficialdata() throws Exception {
    official.readOfficialdata();
//TODO: Test goes here... 
} 

/** 
* 
* Method: getOfficial() 
* 
*/ 
@Test
public void testGetOfficial() throws Exception {
    official.getOfficial();
//TODO: Test goes here... 
} 

/** 
* 
* Method: setOfficial(ArrayList<String[]> official) 
* 
*/ 
@Test
public void testSetOfficial() throws Exception {
    official.setOfficial(Official.official);
//TODO: Test goes here... 
} 


} 
