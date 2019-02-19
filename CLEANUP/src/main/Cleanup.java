package main;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by shales on 2/22/2017.
 */
public class Cleanup {
    LinkedList<Integer> chefList = new LinkedList<>();
    LinkedList<Integer> assistantList = new LinkedList<>();

    public void setCleanup(Integer[] mN, Integer[] completed){
        int m = mN[0];
        int n = mN[1];
        int[] taskList = new int[m+1];

        Arrays.sort(completed);

        for(int item : completed){
            taskList[item] = item;
        }
        int person = 1;
        for(int i = 1; i < m+1; i++){
            if(taskList[i] == 0 ){
                if( person == 1){           //chef
                    chefList.add(i);
                    person *= -1;
                }
                else{                       //assistant
                    assistantList.add(i);
                    person *= -1;
                }
            }
        }
        System.out.println("chefList: " + chefList);
        System.out.println("assistantList: " + assistantList);
    }

    public List<Integer> getCleanupChef(){
        return chefList;
    }
    public List<Integer> getCleanupAssistant(){
        return assistantList;
    }
}
