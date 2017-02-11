package com.nanter1986.walk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by user on 6/2/2017.
 */

public class PokerAI {
    public static String decidePreps(ArrayList<TheDeck> hand, ArrayList<TheDeck> board) {
        String action="";
        if (hand.get(0).getValue() == hand.get(1).getValue()
                || hand.get(0).getValue() > 11 || hand.get(1).getValue() > 11 ||
                (hand.get(0).getValue() > 6 && hand.get(1).getValue() > 6) ||
                (hand.get(0).getSuit().equals(hand.get(1).getSuit()) && (hand.get(0).getValue() > 9)) ||
                (hand.get(0).getSuit().equals(hand.get(1).getSuit()) && (hand.get(1).getValue() > 9)) ||
                (hand.get(0).getSuit().equals(hand.get(1).getSuit()) && (hand.get(0).getValue() > 5 && hand.get(1).getValue() > 5))) {
            action="raise";
        }else{
            action="fold";
        }
        return action;
    }

    public static String decide4bet25(ArrayList<TheDeck> hand, ArrayList<TheDeck> board) {
        String action="";
        if ((hand.get(0).getValue() == hand.get(1).getValue()) ||
                (hand.get(0).getValue() > 12) ||
                (hand.get(1).getValue() > 12) ||
                (hand.get(0).getValue()==12 && hand.get(1).getValue()>=9) ||
                (hand.get(1).getValue()==12 && hand.get(0).getValue()>=9) ||
                (hand.get(0).getValue()==11 && hand.get(1).getValue()==10) ||
                (hand.get(1).getValue()==11 && hand.get(0).getValue()==10)) {
            action="raise";
        }else{
            action="fold";
        }
            return action;
    }

    public static String decide4bet13(ArrayList<TheDeck> hand, ArrayList<TheDeck> board) {
        String action="";
        if ((hand.get(0).getValue() == hand.get(1).getValue()) &&  (hand.get(0).getValue()>1) && (hand.get(1).getValue()>1) ||
                ((hand.get(0).getValue() > 12) &&  (hand.get(1).getValue() > 6)) ||
                ((hand.get(1).getValue() > 12) &&  (hand.get(0).getValue() > 6))){
            action="raise";
        }else{
            action="fold";
        }
        return action;

    }

    public static String decide5betCall13(ArrayList<TheDeck> hand, ArrayList<TheDeck> board) {
        String action="";
        if ((hand.get(0).getValue() == hand.get(1).getValue()) &&  (hand.get(0).getValue()>1) && (hand.get(1).getValue()>1) ||
                ((hand.get(0).getValue() > 12) &&  (hand.get(1).getValue() > 6)) ||
                ((hand.get(1).getValue() > 12) &&  (hand.get(0).getValue() > 6))){
            action="call";
        }else{
            action="fold";
        }
        return action;
    }

    public static String decideSmall5bet(ArrayList<TheDeck> hand, ArrayList<TheDeck> board) {
        String action="";
        if ((hand.get(0).getValue() == hand.get(1).getValue()) &&  (hand.get(0).getValue()>1) && (hand.get(1).getValue()>1) ||
                ((hand.get(0).getValue() > 12) &&  (hand.get(1).getValue() > 6)) ||
                ((hand.get(1).getValue() > 12) &&  (hand.get(0).getValue() > 6))){
            action="raise";
        }else{
            action="fold";
        }
        return action;
    }

    public static String decideFacingFlopDonk(ArrayList<TheDeck> hand, ArrayList<TheDeck> board) {
        String action="";
        ArrayList<TheDeck>total=new ArrayList<>();
        total.addAll(hand);
        total.addAll(board);

        if(checkForFlush(hand,board)){
            action="raise";
        }else if(checkForStraight(hand,board)) {
            action="raise";
        }else if(checkForSet(hand,board)) {
            action="raise";
        }else if(checkForTwoPair(hand,board)) {
            action="raise";
        }else if(checkForOverPocketPair(hand,board)) {
            action="raise";
        }else if(checkForTopPair(hand,board)) {
            action="raise";
        }else if(checkForSecondPocketPair(hand,board)) {
            action="raise";
        }else if(checkForSecondPair(hand,board)) {
            action="raise";
        }else if(checkForThirdPair(hand,board)) {
            action="raise";
        }else if(checkForThirdPocketPair(hand,board)) {
            action="raise";
        }else if(checkForFourthPair(hand,board)) {
            action="raise";
        }else if(checkForFifthPair(hand,board)) {
            action="raise";
        }else if(checkForHalfAceHigh(hand,board)) {
            action="raise";
        }else if(checkForAceHigh(hand,board)) {
            action="raise";
        }else{
            action="fold";
        }


        return action;
    }

    public static String decideFacingFlopCheck(ArrayList<TheDeck> hand, ArrayList<TheDeck> board) {
        String action="";
        ArrayList<TheDeck>total=new ArrayList<>();
        total.addAll(hand);
        total.addAll(board);

        if(checkForFlush(hand,board)){
            action="bet";
        }else if(checkForStraight(hand,board)) {
            action="bet";
        }else if(checkForSet(hand,board)) {
            action="bet";
        }else if(checkForTwoPair(hand,board)) {
            action="bet";
        }else if(checkForOverPocketPair(hand,board)) {
            action="bet";
        }else if(checkForTopPair(hand,board)) {
            action="bet";
        }else if(checkForSecondPocketPair(hand,board)) {
            action="bet";
        }else if(checkForSecondPair(hand,board)) {
            action="bet";
        }else if(checkForThirdPair(hand,board)) {
            action="bet";
        }else if(checkForThirdPocketPair(hand,board)) {
            action="bet";
        }else if(checkForFourthPair(hand,board)) {
            action="bet";
        }else if(checkForFifthPair(hand,board)) {
            action="bet";
        }else if(checkForHalfAceHigh(hand,board)) {
            action="bet";
        }else if(checkForAceHigh(hand,board)) {
            action="bet";
        }else{
            action="fold";
        }


        return action;
    }

    public static String decideFacingFlopReraise(ArrayList<TheDeck> hand, ArrayList<TheDeck> board) {
        String action="";
        ArrayList<TheDeck>total=new ArrayList<>();
        total.addAll(hand);
        total.addAll(board);

        if(checkForFlush(hand,board)){
            action="raise";
        }else if(checkForStraight(hand,board)) {
            action="raise";
        }else if(checkForSet(hand,board)) {
            action="raise";
        }else if(checkForTwoPair(hand,board)) {
            action="raise";
        }else if(checkForOverPocketPair(hand,board)) {
            action="raise";
        }else if(checkForTopPair(hand,board)) {
            action="raise";
        }else if(checkForSecondPocketPair(hand,board)) {
            action="raise";
        }else if(checkForSecondPair(hand,board)) {
            action="raise";
        }else{
            action="fold";
        }


        return action;
    }

    public static String decideFacingFlopDonk4bet(ArrayList<TheDeck> hand, ArrayList<TheDeck> board) {
        String action="";
        ArrayList<TheDeck>total=new ArrayList<>();
        total.addAll(hand);
        total.addAll(board);

        if(checkForFlush(hand,board)){
            action="raise";
        }else if(checkForStraight(hand,board)) {
            action="raise";
        }else if(checkForSet(hand,board)) {
            action="raise";
        }else if(checkForTwoPair(hand,board)) {
            action="raise";
        }else if(checkForOverPocketPair(hand,board)) {
            action="raise";
        }else if(checkForTopPair(hand,board)) {
            action="raise";
        }else if(checkForSecondPocketPair(hand,board)) {
            action="raise";
        }else if(checkForSecondPair(hand,board)) {
            action="raise";
        }else if(checkForThirdPair(hand,board)) {
            action="raise";
        }else if(checkForThirdPocketPair(hand,board)) {
            action="raise";
        }else if(checkForFourthPair(hand,board)) {
            action="raise";
        }else if(checkForFifthPair(hand,board)) {
            action="raise";
        }else if(checkForHalfAceHigh(hand,board)) {
            action="raise";
        }else{
            action="fold";
        }


        return action;
    }

    public static String decideFacingFlopCheck4bet(ArrayList<TheDeck> hand, ArrayList<TheDeck> board) {
        String action="";
        ArrayList<TheDeck>total=new ArrayList<>();
        total.addAll(hand);
        total.addAll(board);

        if(checkForFlush(hand,board)){
            action="bet";
        }else if(checkForStraight(hand,board)) {
            action="bet";
        }else if(checkForSet(hand,board)) {
            action="bet";
        }else if(checkForTwoPair(hand,board)) {
            action="bet";
        }else if(checkForOverPocketPair(hand,board)) {
            action="bet";
        }else if(checkForTopPair(hand,board)) {
            action="bet";
        }else if(checkForSecondPocketPair(hand,board)) {
            action="bet";
        }else if(checkForSecondPair(hand,board)) {
            action="bet";
        }else if(checkForThirdPair(hand,board)) {
            action="bet";
        }else if(checkForThirdPocketPair(hand,board)) {
            action="bet";
        }else if(checkForFourthPair(hand,board)) {
            action="bet";
        }else if(checkForFifthPair(hand,board)) {
            action="bet";
        }else if(checkForHalfAceHigh(hand,board)) {
            action="bet";
        }else{
            action="fold";
        }


        return action;
    }

    public static String decideFacingDonkAfterFlopReraise(ArrayList<TheDeck> hand, ArrayList<TheDeck> board) {
        String action="";
        ArrayList<TheDeck>total=new ArrayList<>();
        total.addAll(hand);
        total.addAll(board);

        if(checkForFlush(hand,board)){
            action="raise";
        }else if(checkForStraight(hand,board)) {
            action="raise";
        }else if(checkForSet(hand,board)) {
            action="raise";
        }else if(checkForTwoPair(hand,board)) {
            action="raise";
        }else if(checkForOverPocketPair(hand,board)) {
            action="raise";
        }else if(checkForTopPair(hand,board)) {
            action="raise";
        }else if(checkForSecondPocketPair(hand,board)) {
            action="raise";
        }else if(checkForSecondPair(hand,board)) {
            action="raise";
        }else if(checkForThirdPair(hand,board)) {
            action="raise";
        }else if(checkForThirdPocketPair(hand,board)) {
            action="raise";
        }else if(checkForFourthPair(hand,board)) {
            action="raise";
        }else if(checkForFifthPair(hand,board)) {
            action="raise";
        }else{
            action="fold";
        }


        return action;
    }

    public static String decideFacingCheckAfterFlopReraiseCall(ArrayList<TheDeck> hand, ArrayList<TheDeck> board) {
        String action="";
        ArrayList<TheDeck>total=new ArrayList<>();
        total.addAll(hand);
        total.addAll(board);

        if(checkForFlush(hand,board)){
            action="bet";
        }else if(checkForStraight(hand,board)) {
            action="bet";
        }else if(checkForSet(hand,board)) {
            action="bet";
        }else if(checkForTwoPair(hand,board)) {
            action="bet";
        }else if(checkForOverPocketPair(hand,board)) {
            action="bet";
        }else if(checkForTopPair(hand,board)) {
            action="bet";
        }else if(checkForSecondPocketPair(hand,board)) {
            action="bet";
        }else if(checkForSecondPair(hand,board)) {
            action="bet";
        }else if(checkForThirdPair(hand,board)) {
            action="bet";
        }else if(checkForThirdPocketPair(hand,board)) {
            action="bet";
        }else if(checkForFourthPair(hand,board)) {
            action="bet";
        }else if(checkForFifthPair(hand,board)) {
            action="bet";
        }else{
            action="fold";
        }


        return action;
    }

    public static Boolean checkForTopPair(ArrayList<TheDeck> hand, ArrayList<TheDeck> boardSoFar){
        Boolean hasThis=false;
        Collections.sort(boardSoFar,new SortByValueD());
        if(hand.get(0).getValue()== boardSoFar.get(0).getValue()){
            hasThis=true;
        }else if(hand.get(1).getValue()== boardSoFar.get(0).getValue()){
            hasThis=true;
        }else{
            hasThis=false;
        }
        return hasThis;
    }

    public static Boolean checkForSecondPair(ArrayList<TheDeck> hand, ArrayList<TheDeck> boardSoFar){
        Boolean hasThis=false;
        Collections.sort(boardSoFar,new SortByValueD());
        if(hand.get(0).getValue()== boardSoFar.get(1).getValue()){
            hasThis=true;
        }else if(hand.get(1).getValue()== boardSoFar.get(1).getValue()){
            hasThis=true;
        }else{
            hasThis=false;
        }
        return hasThis;
    }

    public static Boolean checkForThirdPair(ArrayList<TheDeck> hand, ArrayList<TheDeck> boardSoFar){
        Boolean hasThis=false;
        Collections.sort(boardSoFar,new SortByValueD());
        if(hand.get(0).getValue()== boardSoFar.get(2).getValue()){
            hasThis=true;
        }else if(hand.get(1).getValue()== boardSoFar.get(2).getValue()){
            hasThis=true;
        }else{
            hasThis=false;
        }
        return hasThis;
    }

    public static Boolean checkForFourthPair(ArrayList<TheDeck> hand, ArrayList<TheDeck> boardSoFar){
        Boolean hasThis=false;
        if(boardSoFar.size()>3){

            Collections.sort(boardSoFar,new SortByValueD());
            if(hand.get(0).getValue()== boardSoFar.get(3).getValue()){
                hasThis=true;
            }else if(hand.get(1).getValue()== boardSoFar.get(3).getValue()){
                hasThis=true;
            }else{
                hasThis=false;
            }

        }
        return hasThis;
    }

    public static Boolean checkForFifthPair(ArrayList<TheDeck> hand, ArrayList<TheDeck> boardSoFar){
        Boolean hasThis=false;
        if(boardSoFar.size()>4){

            Collections.sort(boardSoFar,new SortByValueD());
            if(hand.get(0).getValue()== boardSoFar.get(4).getValue()){
                hasThis=true;
            }else if(hand.get(1).getValue()== boardSoFar.get(4).getValue()){
                hasThis=true;
            }else{
                hasThis=false;
            }

        }
        return hasThis;
    }

    public static Boolean checkForTwoPair(ArrayList<TheDeck> hand, ArrayList<TheDeck> boardSoFar){
        Boolean hasThis=false;
        if(boardSoFar.contains(hand.get(0)) && boardSoFar.contains(hand.get(1))){
            hasThis=true;
        }
        return hasThis;
    }

    public static Boolean checkForSet(ArrayList<TheDeck> hand, ArrayList<TheDeck> boardSoFar){
        Boolean hasThis=false;
        if(hand.get(0).getValue()==hand.get(1).getValue() && boardSoFar.contains(hand.get(0))){
            hasThis=true;
        }
        return hasThis;
    }

    public static Boolean checkForTrips(ArrayList<TheDeck> hand, ArrayList<TheDeck> boardSoFar){
        Boolean hasThis=false;
        int first=0;
        int second=0;
        for(int i=0;i<boardSoFar.size();i++){
            if(hand.get(0).getValue()==boardSoFar.get(i).getValue()){
                first++;
            }
            if(hand.get(1).getValue()==boardSoFar.get(i).getValue()){
                second++;
            }
        }
        if(first>1 || second > 2){
            hasThis=true;
        }
        return hasThis;
    }

    public static Boolean checkForStraight(ArrayList<TheDeck> hand, ArrayList<TheDeck> boardSoFar){
        Boolean hasThis=false;
        ArrayList<TheDeck>hasDuplicates=new ArrayList<>();
        hasDuplicates.addAll(hand);
        hasDuplicates.addAll(boardSoFar);
        Set<TheDeck> myset=new HashSet<>();
        myset.addAll(hasDuplicates);
        ArrayList<TheDeck>noDuplicates=new ArrayList<>();
        hasDuplicates.addAll(myset);
        Collections.sort(noDuplicates,new SortByValueA());

        if(hasDuplicates.size()==7){
            if(hand.get(2).getValue()==hand.get(3).getValue()+1 &&
                    hand.get(2).getValue()==hand.get(4).getValue()+2 &&
                    hand.get(2).getValue()==hand.get(5).getValue()+3 &&
                    hand.get(2).getValue()==hand.get(6).getValue()+4){
                hasThis=true;
            }else if(hand.get(1).getValue()==hand.get(2).getValue()+1 &&
                    hand.get(1).getValue()==hand.get(3).getValue()+2 &&
                    hand.get(1).getValue()==hand.get(4).getValue()+3 &&
                    hand.get(1).getValue()==hand.get(5).getValue()+4){
                hasThis=true;
            }else if(hand.get(0).getValue()==hand.get(1).getValue()+1 &&
                    hand.get(0).getValue()==hand.get(2).getValue()+2 &&
                    hand.get(0).getValue()==hand.get(3).getValue()+3 &&
                    hand.get(0).getValue()==hand.get(4).getValue()+4){
                hasThis=true;
            }
        }else if(hasDuplicates.size()==6){
            if(hand.get(1).getValue()==hand.get(2).getValue()+1 &&
                    hand.get(1).getValue()==hand.get(3).getValue()+2 &&
                    hand.get(1).getValue()==hand.get(4).getValue()+3 &&
                    hand.get(1).getValue()==hand.get(5).getValue()+4){
                hasThis=true;
            }else if(hand.get(0).getValue()==hand.get(1).getValue()+1 &&
                    hand.get(0).getValue()==hand.get(2).getValue()+2 &&
                    hand.get(0).getValue()==hand.get(3).getValue()+3 &&
                    hand.get(0).getValue()==hand.get(4).getValue()+4){
                hasThis=true;
            }
        }else if(hasDuplicates.size()==5){
            if(hand.get(0).getValue()==hand.get(1).getValue()+1 &&
                    hand.get(0).getValue()==hand.get(2).getValue()+2 &&
                    hand.get(0).getValue()==hand.get(3).getValue()+3 &&
                    hand.get(0).getValue()==hand.get(4).getValue()+4){
                hasThis=true;
            }
        }
        return hasThis;
    }

    public static Boolean checkForFlush(ArrayList<TheDeck> hand, ArrayList<TheDeck> boardSoFar){
        Boolean hasThis=false;
        int hearts=0;
        int spades=0;
        int diamonds=0;
        int clubs=0;
        ArrayList<TheDeck>hasDuplicates=new ArrayList<>();
        hasDuplicates.addAll(hand);
        hasDuplicates.addAll(boardSoFar);
        for(TheDeck i:hasDuplicates){
            if(i.suit=="h"){
                hearts++;
            }else if(i.suit=="c"){
                clubs++;
            }else if(i.suit=="d"){
                diamonds++;
            }else if(i.suit=="s"){
                spades++;
            }
        }
        if(hearts>4 || clubs>4 || diamonds>4 || spades>4){
            hasThis=true;
        }
        return hasThis;
    }

    public static Boolean checkForAceHigh(ArrayList<TheDeck> hand, ArrayList<TheDeck> boardSoFar){
        Boolean hasThis=false;
        if(hand.get(0).getValue()==13 || hand.get(1).getValue()==13){
            hasThis=true;
        }

        return hasThis;
    }

    public static Boolean checkForHalfAceHigh(ArrayList<TheDeck> hand, ArrayList<TheDeck> boardSoFar){
        Boolean hasThis=false;
        if(hand.get(0).getValue()==13 && hand.get(1).getValue()>7){
            hasThis=true;
        }else if(hand.get(1).getValue()==13 && hand.get(0).getValue()>7){

        }

        return hasThis;
    }

    public static Boolean checkForOverPocketPair(ArrayList<TheDeck> hand, ArrayList<TheDeck> boardSoFar){
        Boolean hasThis=false;
        Collections.sort(boardSoFar,new SortByValueD());
        if(hand.get(0).getValue()== hand.get(1).getValue() && hand.get(0).getValue()>boardSoFar.get(0).getValue()){
            hasThis=true;
        }
        return hasThis;
    }

    public static Boolean checkForSecondPocketPair(ArrayList<TheDeck> hand, ArrayList<TheDeck> boardSoFar){
        Boolean hasThis=false;
        Collections.sort(boardSoFar,new SortByValueD());
        if(hand.get(0).getValue()== hand.get(1).getValue() && hand.get(0).getValue()>boardSoFar.get(1).getValue()){
            hasThis=true;
        }
        return hasThis;
    }

    public static Boolean checkForThirdPocketPair(ArrayList<TheDeck> hand, ArrayList<TheDeck> boardSoFar){
        Boolean hasThis=false;
        Collections.sort(boardSoFar,new SortByValueD());
        if(hand.get(0).getValue()== hand.get(1).getValue() && hand.get(0).getValue()>boardSoFar.get(2).getValue()){
            hasThis=true;
        }
        return hasThis;
    }
}
