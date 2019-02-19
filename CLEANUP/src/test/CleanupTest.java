package test;

import org.junit.Test;
import java.io.IOException;
import java.util.List;
import static org.junit.Assert.*;

/**
 * Created by shales on 2/22/2017.
 */
public class CleanupTest {
    @Test
    public void runTests(){
        Integer[] mN = {6,3};
        Integer[] completed = {2,4,1};
        testSetCleanup(mN, completed);
        Integer[] mN2 = {3,2};
        Integer[] completed2 = {3,2};
        testSetCleanup(mN2, completed2);
        Integer[] mN3 = {8,2};
        Integer[] completed3 = {3,8};
        testSetCleanup(mN3, completed3);
    }

    public void testSetCleanup(Integer[] mN, Integer[] completed){
        main.Cleanup clean = new main.Cleanup();

        clean.setCleanup(mN, completed);
        List<Integer> chefList = clean.getCleanupChef();
        List<Integer> assistantList = clean.getCleanupAssistant();

        //check the lists
        int index = 0;
        int assistantItem;
        for(Integer chefItem : chefList) {
            try{
                assistantItem = assistantList.get(index);
            }
            catch(IndexOutOfBoundsException e){
                break;
            }
            assertTrue(chefItem < assistantItem);
            index++;
        }
    }
}
