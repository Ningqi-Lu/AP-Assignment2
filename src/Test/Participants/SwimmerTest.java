package Test.Participants;

import Participants.Swimmer;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* Swimmer Tester. 
* 
* @author <Ningqi Lu>
* @since <pre>四月 26, 2017</pre> 
* @version 1.0 
*/ 
public class SwimmerTest {
    Swimmer swimmer;

@Before
public void before() throws Exception {
    swimmer=new Swimmer("Oz2009","Summer","VIC",24,"1");
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: readSwimmerdata() 
* 
*/ 
@Test
public void testReadSwimmerdata() throws Exception {
    swimmer.readSwimmerdata();
//TODO: Test goes here... 
} 

/** 
* 
* Method: getSwimmer() 
* 
*/ 
@Test
public void testGetSwimmer() throws Exception {
    swimmer.getSwimmer();
//TODO: Test goes here... 
} 

/** 
* 
* Method: setSwimmer(ArrayList<String[]> swimmer) 
* 
*/ 
@Test
public void testSetSwimmer() throws Exception {
    swimmer.setSwimmer(Swimmer.swimmer);


//TODO: Test goes here... 
} 


} 
