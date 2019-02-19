package main;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shales on 2/24/2017.
 */
public class MusicSort {
    public static int SortAndKeepIndex(int initialIndex, List<Integer> oldPlaylist){
        initialIndex -= 1;
        int newIndex = 0;
        List<Integer> playlist = new ArrayList<>(oldPlaylist);

        //bubble sort..
        for(int i = 0; i < playlist.size(); i++){
            Item nextShortest = new Item(i, playlist.get(i));
            for(int j = i+1; j < playlist.size(); j++){
                //get smallest
                if(nextShortest.song > playlist.get(j)){
                    nextShortest.song = playlist.get(j);
                    nextShortest.index = j;
                }
            }
            if(nextShortest.index == initialIndex){
                newIndex = i;
            }
            if(initialIndex == i){
                initialIndex = nextShortest.index;
            }
            playlist.set(nextShortest.index, playlist.get(i));
            playlist.set(i, nextShortest.song);
        }

        return newIndex+1;
    }
}
