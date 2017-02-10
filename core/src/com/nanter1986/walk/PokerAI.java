package com.nanter1986.walk;

import java.util.ArrayList;
import java.util.Collections;

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

        if (
                (hand.get(0).getValue() == hand.get(1).getValue()) ||
                        (hand.get(0).getValue() == board.get(0).getValue() || hand.get(0).getValue() == board.get(1).getValue() || hand.get(0).getValue() == board.get(2).getValue())  ||
                        (hand.get(1).getValue() == board.get(0).getValue() || hand.get(1).getValue() == board.get(1).getValue() || hand.get(1).getValue() == board.get(2).getValue())  ||
                        (hand.get(0).getValue()==13 || hand.get(1).getValue()==13) ||
                        (total.get(0).getSuit().equals(total.get(1).getSuit()) && total.get(0).getSuit().equals(total.get(2).getSuit()) && total.get(0).getSuit().equals(total.get(3).getSuit()) && total.get(0).getSuit().equals(total.get(4).getSuit()))
                ) {
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
        ArrayList<TheDeck>flop=new ArrayList<>();
        flop.add(board.get(0));
        flop.add(board.get(1));
        flop.add(board.get(2));
        Collections.sort(flop);
        total.addAll(flop);

        if (
                (hand.get(0).getValue() == hand.get(1).getValue()) ||
                        (hand.get(0).getValue() == board.get(0).getValue() || hand.get(0).getValue() == board.get(1).getValue() || hand.get(0).getValue() == board.get(2).getValue())  ||
                        (hand.get(1).getValue() == board.get(0).getValue() || hand.get(1).getValue() == board.get(1).getValue() || hand.get(1).getValue() == board.get(2).getValue())  ||
                        (hand.get(0).getValue()==13 || hand.get(1).getValue()==13) ||
                        (total.get(0).getSuit().equals(total.get(1).getSuit()) && total.get(0).getSuit().equals(total.get(2).getSuit()) && total.get(0).getSuit().equals(total.get(3).getSuit()) && total.get(0).getSuit().equals(total.get(4).getSuit()))
                ) {
            action="bet";
        }else{
            action="check";
        }
        return action;
    }

    public static String decideFacingFlopReraise(ArrayList<TheDeck> hand, ArrayList<TheDeck> board) {
        String action="";
        ArrayList<TheDeck>total=new ArrayList<>();
        total.addAll(hand);
        ArrayList<TheDeck>flop=new ArrayList<>();
        flop.add(board.get(0));
        flop.add(board.get(1));
        flop.add(board.get(2));
        Collections.sort(flop);
        total.addAll(flop);

        if (
                (hand.get(0).getValue() == hand.get(1).getValue() && hand.get(0).getValue()>flop.get(1).getValue() && hand.get(0).getValue()>flop.get(1).getValue()) ||
                        (hand.get(0).getValue() == flop.get(1).getValue() || hand.get(1).getValue() == flop.get(1).getValue()) ||
                        (hand.get(0).getValue() == flop.get(0).getValue() || hand.get(1).getValue() == flop.get(0).getValue()) ||
                        (hand.get(0).getValue() == hand.get(1).getValue() && hand.get(0).getValue() == flop.get(0).getValue() ) ||
                        (hand.get(0).getValue() == hand.get(1).getValue() && hand.get(0).getValue() == flop.get(1).getValue() ) ||
                        (hand.get(0).getValue() == hand.get(1).getValue() && hand.get(0).getValue() == flop.get(2).getValue() ) ||
                        ((hand.get(0).getValue() == flop.get(0).getValue() || hand.get(0).getValue() == flop.get(1).getValue() || hand.get(0).getValue() == flop.get(2).getValue()) && (hand.get(1).getValue() == flop.get(0).getValue() || hand.get(1).getValue() == flop.get(1).getValue() || hand.get(1).getValue() == flop.get(2).getValue())) ||
                        (total.get(0).getSuit().equals(total.get(1).getSuit()) && total.get(0).getSuit().equals(total.get(2).getSuit()) && total.get(0).getSuit().equals(total.get(3).getSuit()) && total.get(0).getSuit().equals(total.get(4).getSuit()))


                ) {
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
        ArrayList<TheDeck>flop=new ArrayList<>();
        flop.add(board.get(0));
        flop.add(board.get(1));
        flop.add(board.get(2));
        Collections.sort(flop);
        total.addAll(flop);

        if (
                (hand.get(0).getValue()==hand.get(1).getValue()) ||
                        (hand.get(0).getValue()==flop.get(0).getValue() || hand.get(0).getValue()==flop.get(1).getValue() ||hand.get(0).getValue()==flop.get(1).getValue()) ||
                        (hand.get(1).getValue()==flop.get(0).getValue() || hand.get(1).getValue()==flop.get(1).getValue() ||hand.get(1).getValue()==flop.get(2).getValue()) ||
                        (hand.get(0).getValue()==13 && hand.get(1).getValue()>7) ||
                        (hand.get(1).getValue()==13 && hand.get(0).getValue()>7)


                ) {
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
        ArrayList<TheDeck>flop=new ArrayList<>();
        flop.add(board.get(0));
        flop.add(board.get(1));
        flop.add(board.get(2));
        Collections.sort(flop);
        total.addAll(flop);

        if (
                (hand.get(0).getValue()==hand.get(1).getValue()) ||
                        (hand.get(0).getValue()==flop.get(0).getValue() || hand.get(0).getValue()==flop.get(1).getValue() ||hand.get(0).getValue()==flop.get(1).getValue()) ||
                        (hand.get(1).getValue()==flop.get(0).getValue() || hand.get(1).getValue()==flop.get(1).getValue() ||hand.get(1).getValue()==flop.get(2).getValue()) ||
                        (hand.get(0).getValue()==13 && hand.get(1).getValue()>7) ||
                        (hand.get(1).getValue()==13 && hand.get(0).getValue()>7)


                ) {
            action="bet";
        }else{
            action="check";
        }
        return action;
    }
}
