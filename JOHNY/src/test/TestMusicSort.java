package test;

import main.MusicSort;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by shales on 2/24/2017.
 */
public class TestMusicSort {
    @Test
    public void NullListThrowException(){

    }
    @Test
    public void TestSortSortedList(){
        List<Integer> playlist = Arrays.asList(1,2,3,4);
        assertEquals(2, MusicSort.SortAndKeepIndex(2, playlist));
    }
    @Test
    public void TestSortUnSortedList(){
        List<Integer> playlist = Arrays.asList(1,5,2,3,6); //1,2,3,5,6
        assertEquals(4, MusicSort.SortAndKeepIndex(2, playlist));
    }
}
