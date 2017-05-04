package Test.Game;

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
        String[] score = new String[5];
        for (int count = 0; count < 5; count++) {
            Random random=new Random();
            score[count] = String.format("%.1f", ((random.nextDouble() * 300.0d) + 500.0d));
        }

    }

    /**
     * Method: readDataFromAthlete()
     */
    @Test
    public void testReadDataFromAthlete() throws Exception {
//TODO: Test goes here... 
    }


} 
