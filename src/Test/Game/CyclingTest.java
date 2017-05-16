package Test.Game;

import Game.Cycling;
import Participants.Cyclist;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

/**
 * Cycling Tester.
 *
 * @author <Ningqi Lu>
 * @version 1.0
 * @since <pre>四月 26, 2017</pre>
 */
public class CyclingTest {
    Cycling cycling;

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: complete()
     */
    @Test
    public void testComplete() throws Exception {
        cycling.complete();

    }

    /**
     * Method: readDataFromAthlete()
     */
    @Test
    public void testReadDataFromAthlete() throws Exception {
        cycling.readDataFromAthlete();
//TODO: Test goes here... 
    }


} 
