package Test.Participants;

import Participants.Athlete;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.HashMap;

/** 
* Athlete Tester. 
* 
* @author <Ningqi Lu>
* @since <pre>四月 26, 2017</pre> 
* @version 1.0 
*/ 
public class AthleteTest {
    Athlete athlete;
    HashMap athletePointHashMap;

@Before
public void before() throws Exception {
    athlete = new Athlete("Oz4005", "Will", "QLD",32,"2");
    athletePointHashMap = new HashMap<>();
} 

@After
public void after() throws Exception { 
}

    /**
     *
     * Method: getAthleteALL()
     *
     */
    @Test
    public void testGetAthleteALL() throws Exception {
        athlete.getAthleteALL();



    }

    /**
     *
     * Method: setAthleteALL(ArrayList<String[]> athleteALL)
     *
     */
    @Test
    public void testSetAthleteALL() throws Exception {
        athlete.setAthleteALL(Athlete.athleteALL);

    }

/**
*
* Method: getScore()
*
*/
@Test
public void testGetScore() throws Exception {
    athlete.getScore();
//TODO: Test goes here...
}

/**
*
* Method: setScore(String score)
*
*/
@Test
public void testSetScore() throws Exception {
    athlete.setScore("2");
//TODO: Test goes here...
}

/**
*
* Method: getPoint()
*
*/
@Test
public void testGetPoint() throws Exception {
    athlete.getPoint();
//TODO: Test goes here...
}

/**
*
* Method: setPoint(Integer point)
*
*/
@Test
public void testSetPoint() throws Exception {
    athlete.setPoint(2);
//TODO: Test goes here...
}

/**
*
* Method: getAthletePointHashMap()
*
*/
@Test
public void testGetAthletePointHashMap() throws Exception {
    athlete.getAthletePointHashMap();
//TODO: Test goes here...
}

/**
*
* Method: setAthletePointHashMap(HashMap<String, Integer> athletePointHashMap)
*
*/
@Test
public void testSetAthletePointHashMap() throws Exception {
    athlete.setAthletePointHashMap(athletePointHashMap);
//TODO: Test goes here...
}


}
