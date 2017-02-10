package com.nanter1986.walk;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by user on 5/2/2017.
 */

public class HandEvaluator {
    public static String evaluate(ArrayList<TheDeck> handOfPlayer, ArrayList<TheDeck> handOfCom,
                                  ArrayList<TheDeck> board) {
        ArrayList<TheDeck> p7 = new ArrayList<>();
        p7.addAll(handOfPlayer);
        p7.addAll(board);
        ArrayList<TheDeck> c7 = new ArrayList<>();
        c7.addAll(handOfCom);
        c7.addAll(board);

        HandDeconstructor player1 = new HandDeconstructor(p7);
        HandDeconstructor player2 = new HandDeconstructor(c7);

        checkForStraightFlush(player1);
        checkForFourOfAKind(player1);
        checkForFullHouse(player1);
        checkForThreeOfAKind(player1);
        checkForPair(player1);

        return "";
    }

    private static TheHand checkForFullHouse(HandDeconstructor player1) {
        TheHand h=null;



        return h;
    }

    private static int checkForPair(HandDeconstructor hd) {
        int strength = 0;
        if (hd.aa.size() == 2) {
            strength = 5013;
        } else if (hd.kk.size() == 2) {
            strength = 5012;
        } else if (hd.qq.size() == 2) {
            strength = 8011;
        } else if (hd.jj.size() == 2) {
            strength = 5010;
        } else if (hd.tt.size() == 2) {
            strength = 5009;
        } else if (hd.nine.size() == 2) {
            strength = 5008;
        } else if (hd.eight.size() == 2) {
            strength = 5007;
        } else if (hd.seven.size() == 2) {
            strength = 5006;
        } else if (hd.six.size() == 2) {
            strength = 5005;
        } else if (hd.five.size() == 2) {
            strength = 5004;
        } else if (hd.four.size() == 2) {
            strength = 5003;
        } else if (hd.three.size() == 2) {
            strength = 5002;
        } else if (hd.two.size() == 2) {
            strength = 5001;
        }

        return strength;

    }

    private static int checkForThreeOfAKind(HandDeconstructor hd) {
        int strength = 0;
        if (hd.aa.size() == 3) {
            strength = 8013;
        } else if (hd.kk.size() == 3) {
            strength = 8012;
        } else if (hd.qq.size() == 3) {
            strength = 8011;
        } else if (hd.jj.size() == 3) {
            strength = 8010;
        } else if (hd.tt.size() == 3) {
            strength = 8009;
        } else if (hd.nine.size() == 3) {
            strength = 8008;
        } else if (hd.eight.size() == 3) {
            strength = 8007;
        } else if (hd.seven.size() == 3) {
            strength = 8006;
        } else if (hd.six.size() == 3) {
            strength = 8005;
        } else if (hd.five.size() == 3) {
            strength = 8004;
        } else if (hd.four.size() == 3) {
            strength = 8003;
        } else if (hd.three.size() == 3) {
            strength = 8002;
        } else if (hd.two.size() == 3) {
            strength = 8001;
        }

        return strength;

    }

    private static TheHand checkForFourOfAKind(HandDeconstructor hd) {
        TheHand h=null;
        Collections.sort(hd.allCards,new SortByValueD());
        if (hd.aa.size() == 4) {
            h=new TheHand(90000, hd.allCards.get(0).value, 0, 0, 0, 0);
        } else if (hd.kk.size() == 4) {
            h=new TheHand(90000, hd.allCards.get(0).value, 0, 0, 0, 0);
        } else if (hd.qq.size() == 4) {
            h=new TheHand(90000, hd.allCards.get(0).value, 0, 0, 0, 0);
        } else if (hd.jj.size() == 4) {
            h=new TheHand(90000, hd.allCards.get(0).value, 0, 0, 0, 0);
        } else if (hd.tt.size() == 4) {
            h=new TheHand(90000, hd.allCards.get(0).value, 0, 0, 0, 0);
        } else if (hd.nine.size() == 4) {
            h=new TheHand(90000, hd.allCards.get(0).value, 0, 0, 0, 0);
        } else if (hd.eight.size() == 4) {
            h=new TheHand(90000, hd.allCards.get(0).value, 0, 0, 0, 0);
        } else if (hd.seven.size() == 4) {
            h=new TheHand(90000, hd.allCards.get(0).value, 0, 0, 0, 0);
        } else if (hd.six.size() == 4) {
            h=new TheHand(90000, hd.allCards.get(0).value, 0, 0, 0, 0);
        } else if (hd.five.size() == 4) {
            h=new TheHand(90000, hd.allCards.get(0).value, 0, 0, 0, 0);
        } else if (hd.four.size() == 4) {
            h=new TheHand(90000, hd.allCards.get(0).value, 0, 0, 0, 0);
        } else if (hd.three.size() == 4) {
            h=new TheHand(90000, hd.allCards.get(0).value, 0, 0, 0, 0);
        } else if (hd.two.size() == 4) {
            h=new TheHand(90000, hd.allCards.get(0).value, 0, 0, 0, 0);
        }

        return h;

    }

    private static TheHand checkForStraightFlush(HandDeconstructor hd) {
        TheHand h = null;
        ArrayList<TheDeck> ordered = new ArrayList<>();

        if (hd.clubs.size() > 4) {
            Collections.sort(hd.clubs, new SortByValueD());
            ordered = hd.clubs;
            h = whatStraightFlush(ordered);
        } else if (hd.hearts.size() > 4) {
            Collections.sort(hd.hearts, new SortByValueD());
            ordered = hd.hearts;
            h = whatStraightFlush(ordered);
        } else if (hd.diamnds.size() > 4) {
            Collections.sort(hd.diamnds, new SortByValueD());
            ordered = hd.diamnds;
            h = whatStraightFlush(ordered);
        } else if (hd.spades.size() > 4) {
            Collections.sort(hd.spades, new SortByValueD());
            ordered = hd.spades;
            h = whatStraightFlush(ordered);
        }

        return h;
    }

    public static TheHand whatStraightFlush(ArrayList<TheDeck> ordered) {
        TheHand h = null;
        if (ordered.size() == 5) {
            if (ordered.get(0).value == ordered.get(1).value + 1 && ordered.get(0).value == ordered.get(2).value + 2
                    && ordered.get(0).value == ordered.get(3).value + 3
                    && ordered.get(0).value == ordered.get(4).value + 4) {
                h = new TheHand(100000, ordered.get(0).value, ordered.get(1).value, ordered.get(2).value,
                        ordered.get(3).value, ordered.get(4).value);
            } else if (ordered.get(4).value == 13 && ordered.get(3).value == 1 && ordered.get(2).value == 2
                    && ordered.get(1).value == 3 && ordered.get(0).value == 4) {
                h = new TheHand(100000, ordered.get(0).value, ordered.get(1).value, ordered.get(2).value,
                        ordered.get(3).value, ordered.get(4).value);
            }
        } else if (ordered.size() == 6) {
            if (ordered.get(0).value == ordered.get(1).value + 1 && ordered.get(0).value == ordered.get(2).value + 2
                    && ordered.get(0).value == ordered.get(3).value + 3
                    && ordered.get(0).value == ordered.get(4).value + 4) {
                h = new TheHand(100000, ordered.get(0).value, ordered.get(1).value, ordered.get(2).value,
                        ordered.get(2).value, ordered.get(3).value);
            } else if (ordered.get(1).value == ordered.get(2).value + 1
                    && ordered.get(1).value == ordered.get(3).value + 2
                    && ordered.get(1).value == ordered.get(4).value + 3
                    && ordered.get(1).value == ordered.get(5).value + 4) {
                h = new TheHand(100000, ordered.get(1).value, ordered.get(2).value, ordered.get(3).value,
                        ordered.get(4).value, ordered.get(5).value);
            }else if (ordered.get(5).value == 13 && ordered.get(4).value == 1 && ordered.get(3).value == 2
                    && ordered.get(2).value == 3 && ordered.get(1).value == 4) {
                h = new TheHand(100000, ordered.get(1).value, ordered.get(2).value, ordered.get(3).value,
                        ordered.get(4).value, ordered.get(5).value);
            }

        } else if (ordered.size() == 7) {
            if (ordered.get(0).value == ordered.get(1).value + 1 && ordered.get(0).value == ordered.get(2).value + 2
                    && ordered.get(0).value == ordered.get(3).value + 3
                    && ordered.get(0).value == ordered.get(4).value + 4) {
                h = new TheHand(100000, ordered.get(0).value, ordered.get(1).value, ordered.get(2).value,
                        ordered.get(2).value, ordered.get(3).value);
            } else if (ordered.get(1).value == ordered.get(2).value + 1
                    && ordered.get(1).value == ordered.get(3).value + 2
                    && ordered.get(1).value == ordered.get(4).value + 3
                    && ordered.get(1).value == ordered.get(5).value + 4) {
                h = new TheHand(100000, ordered.get(1).value, ordered.get(2).value, ordered.get(3).value,
                        ordered.get(4).value, ordered.get(5).value);
            } else if (ordered.get(2).value == ordered.get(2).value + 2
                    && ordered.get(2).value == ordered.get(3).value + 3
                    && ordered.get(2).value == ordered.get(4).value + 4
                    && ordered.get(2).value == ordered.get(5).value + 5) {
                h = new TheHand(100000, ordered.get(2).value, ordered.get(3).value, ordered.get(4).value,
                        ordered.get(5).value, ordered.get(6).value);
            }else if (ordered.get(6).value == 13 && ordered.get(5).value == 1 && ordered.get(4).value == 2
                    && ordered.get(3).value == 3 && ordered.get(2).value == 4) {
                h = new TheHand(100000, ordered.get(2).value, ordered.get(3).value, ordered.get(4).value,
                        ordered.get(5).value, ordered.get(6).value);
            }
        }
        return h;
    }
}
