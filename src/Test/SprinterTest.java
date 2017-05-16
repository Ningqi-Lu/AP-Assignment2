package Test;

import Sprinter;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* Sprinter Tester.
* 
* @author <Ningqi Lu>
* @since <pre>四月 26, 2017</pre> 
* @version 1.0 
*/ 
public class SprinterTest {
    Sprinter sprinter;

@Before
public void before() throws Exception {
    sprinter=new Sprinter("Oz2002","Jack","NSW",25,"5");
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: readSprinterdata() 
* 
*/ 
@Test
public void testReadSprinterdata() throws Exception {
    sprinter.readSprinterdata();
//TODO: Test goes here...
} 

/** 
* 
* Method: getSprinter() 
* 
*/ 
@Test
public void testGetSprinter() throws Exception {
    sprinter.getSprinter();
//TODO: Test goes here... 
} 

/** 
* 
* Method: setSprinter(ArrayList<String[]> sprinter) 
* 
*/ 
@Test
public void testSetSprinter() throws Exception {
    sprinter.setSprinter(Sprinter.sprinter);
//TODO: Test goes here... 
} 


} 
