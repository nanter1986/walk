package com.nanter1986.walk;


import java.util.Comparator;

/**
 * Created by user on 5/2/2017.
 */

public class SortByValueA implements Comparator<TheDeck> {
    @Override
    public int compare(TheDeck o1, TheDeck o2) {
        int i=0;
        if(o1.value>o2.value){
            i=1;
        }else if(o2.value>o1.value){
            i=-1;
        }
        return i;
    }
}
