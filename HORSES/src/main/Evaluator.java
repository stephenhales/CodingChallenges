package main;

import com.sun.org.apache.xalan.internal.xsltc.dom.AbsoluteIterator;

import java.io.IOException;
import java.util.EmptyStackException;
import java.util.List;

/**
 * Created by shales on 2/23/2017.
 */
public class Evaluator {

    public int determineRaceCloseness(List<Integer> speeds){
        int max = speeds.size()-1;
        int min;
        int overallMin = Integer.MAX_VALUE;

        if(max<1){
            throw new EmptyStackException();
        }

        for(int i = 0; i < max ; i++ ){
            for(int j = i+1; j < max; j++) {
                min = Math.abs(speeds.get(i)-speeds.get(j));
                if (overallMin > min) {
                    overallMin = min;
                }
            }
        }
        return overallMin;
    }
}
