package test;

import main.Evaluator;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by shales on 2/23/2017.
 */
public class EvaluatorTest {

    @Test(expected=EmptyStackException.class)
    public void determineRaceOneThrowsException() throws IOException {
        List<Integer> horseSpeeds = Arrays.asList(1);
        Evaluator evaluator = new Evaluator();
        assertNotNull(evaluator.determineRaceCloseness(horseSpeeds));
    }

    @Test(expected=EmptyStackException.class)
    public void determineRaceEmptyThrowsException() throws IOException {
        List<Integer> horseSpeeds = Arrays.asList();
        Evaluator evaluator = new Evaluator();
        assertNotNull(evaluator.determineRaceCloseness(horseSpeeds));
    }

    @Test
    public void determineRaceNotNull() {
        List<Integer> horseSpeeds = Arrays.asList(1, 23, 6, 15, 32);
        Evaluator evaluator = new Evaluator();
        assertNotNull(evaluator.determineRaceCloseness(horseSpeeds));

    }
    @Test
    public void determineHowCloseRaceCanBe() {
        List<Integer> horseSpeeds = Arrays.asList(1, 23, 6, 15, 32);
        Evaluator evaluator = new Evaluator();
        assertEquals(5, evaluator.determineRaceCloseness(horseSpeeds));

    }

}
    //Sean helping me with TDD, OOP, and Business Layers:

    //determineBlowoutWithTwoHorses
    //determineCloseRaceWithTwoHorses
    //determineTieWithTwoHorses
    //same as above, but with ThreeHorses
    //stable with one horse or zero horses ==> assert exception thrown
    //upper if more than 10 horses, evaluator does what
    //ifGreaterThan10HorsesEvaluatorDeterminesRaceWithFirstTenHeSees



    //horseBean
        //database layer, contains hibernate annotations to pull from db
        //id db unique id (primary key, not used in business layer)
        //size
        //speed
        //parent

    //stable bean
        //id
        //location
        //owner
        //horses

    //horse(size, speed, parent)
        //size
        //speed double
        //parent
        //ride()
        //howlongcanride()
        //eat()
        //sleep()

    //horseModel(size, speed, parent)
    //size
    //speed int
    //parent


    //new horse(10);
    //assert(10, horse.size())

    //horse(dbConnection db)
        //size = db.size
        //speed = db.speed
    //}

    //mockito java library

    //mockDB.when(size()).thenReturn(10)
    //new horse(mockDB)
    //assert(10, horse.size)

    //flat file

    //horse(dbconnection )
    //horse(file)



    //horse()
        //horse(){
            //getDBConnection
            //getFlatFile
            //size = db.size
            //speed = db.speed
        //}


    //horseTest
        //horsesSleep
        //horsesNeedAtLeastThreeHoursOfSleepEachDayOrTheyDie
        //horsesEat
        //horsesCanBeRidden
        //horsesCanBeRiddenForAnHourTops
            //howLongCanRide
        //tiredHorsesShouldBeRiddenForOnly30MinutesTops
        //hungryHorsesShouldBeRiddenOnly10Minutes
        //CanOnlySleep24HoursMax
        //CanEatNoFood
        //CanEatMaxFoodOfBlank

    //stable(horses, location, owner)
        //horses[]
        //location
        //owner
        //manage()
        //clean()
        //removeHorse()
        //addHorse()






    //visitor
            //EvaluatorTest visit
            //rider
            //buyer
    //stable ==> visitor pattern accept the EvaluatorTest
            //stable.visit(visitor guy){
            //  guy.visit(this)
            //}
    //EvaluatorTest ==> get close horses
            //EvaluatorTest.visit(stable horses){
                //EvaluatorTest(horses)
            //}



