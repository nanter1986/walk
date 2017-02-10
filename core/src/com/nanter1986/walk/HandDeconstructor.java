package com.nanter1986.walk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by user on 5/2/2017.
 */

public class HandDeconstructor {
    ArrayList<TheDeck>allCards=new ArrayList<>();

    ArrayList<TheDeck>aa=new ArrayList<>();
    ArrayList<TheDeck>kk=new ArrayList<>();
    ArrayList<TheDeck>qq=new ArrayList<>();
    ArrayList<TheDeck>jj=new ArrayList<>();
    ArrayList<TheDeck>tt=new ArrayList<>();
    ArrayList<TheDeck>nine=new ArrayList<>();
    ArrayList<TheDeck>eight=new ArrayList<>();
    ArrayList<TheDeck>seven=new ArrayList<>();
    ArrayList<TheDeck>six=new ArrayList<>();
    ArrayList<TheDeck>five=new ArrayList<>();
    ArrayList<TheDeck>four=new ArrayList<>();
    ArrayList<TheDeck> three=new ArrayList<>();
    ArrayList<TheDeck>two=new ArrayList<>();

    ArrayList<TheDeck>clubs=new ArrayList<>();
    ArrayList<TheDeck>diamnds=new ArrayList<>();
    ArrayList<TheDeck>spades=new ArrayList<>();
    ArrayList<TheDeck>hearts=new ArrayList<>();

    ArrayList<TheDeck>noDuplicates=new ArrayList<>();

    public HandDeconstructor(ArrayList<TheDeck> a){
        allCards=a;
        for(TheDeck i:a){
            if(i.value==13){
                aa.add(i);
            }else if(i.value==12){
                kk.add(i);
            }else if(i.value==11){
                qq.add(i);
            }else if(i.value==10){
                jj.add(i);
            }else if(i.value==9){
                tt.add(i);
            }else if(i.value==8){
                nine.add(i);
            }else if(i.value==7){
                eight.add(i);
            }else if(i.value==6){
                seven.add(i);
            }else if(i.value==5){
                six.add(i);
            }else if(i.value==4){
                five.add(i);
            }else if(i.value==3){
                four.add(i);
            }else if(i.value==2){
                three.add(i);
            }else if(i.value==1){
                two.add(i);
            }
        }
        for(TheDeck i:a){
            if(i.suit=="h"){
                hearts.add(i);
            }else if(i.suit=="c"){
                clubs.add(i);
            }else if(i.suit=="d"){
                diamnds.add(i);
            }else if(i.suit=="s"){
                spades.add(i);
            }
        }


        Set<TheDeck> myset=new HashSet<>();
        myset.addAll(a);
        noDuplicates.addAll(myset);
        Collections.sort(noDuplicates,new SortByValueA());

    }
}
