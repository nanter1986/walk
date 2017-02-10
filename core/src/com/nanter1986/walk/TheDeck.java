package com.nanter1986.walk;

/**
 * Created by user on 5/2/2017.
 */

public enum TheDeck {
    Ah(13,"h","Ah"),Ac(13,"c","Ac"),As(13,"s","As"),Ad(13,"d","Ad"),
    Kh(12,"h","Kh"),Kc(12,"c","Kc"),Ks(12,"s","Ks"),Kd(12,"d","Kd"),
    Qh(11,"h","Qh"),Qc(11,"c","Qc"),Qs(11,"s","Qs"),Qd(11,"d","Qd"),
    Jh(10,"h","Jh"),Jc(10,"c","Jc"),Js(10,"s","Js"),Jd(10,"d","Jd"),
    Tenh(9,"h","10h"),Tenc(9,"c","10c"),Tens(9,"s","10s"),Tend(9,"d","10d"),
    Nineh(8,"h","9h"),Ninec(8,"c","9c"),Nines(8,"s","9s"),Nined(8,"d","9d"),
    Eighth(7,"h","8h"),Eightc(7,"c","8c"),Eights(7,"s","8s"),Eightd(7,"d","8d"),
    Sevenh(6,"h","7h"),Sevenc(6,"c","7c"),Sevens(6,"s","7s"),Sevend(6,"d","7d"),
    Sixh(5,"h","6h"),Sixc(5,"c","6c"),Sixs(5,"s","6s"),Sixd(5,"d","6d"),
    Fiveh(4,"h","5h"),Fivec(4,"c","5c"),Fives(4,"s","5s"),Fived(4,"d","5d"),
    Fourh(3,"h","4h"),Fourc(3,"c","4c"),Fours(3,"s","4s"),Fourd(3,"d","4d"),
    Threeh(2,"h","3h"),Threec(2,"c","3c"),Threes(2,"s","3s"),Threed(2,"d","3d"),
    Twoh(1,"h","2h"),Twoc(1,"c","2c"),Twos(1,"s","2s"),Twod(1,"d","2d");

    int value;
    String suit;
    String fileLocation;

    TheDeck(int v,String s,String f){
        value=v;
        suit=s;
        fileLocation=f;
    }

    int getValue(){
        return value;
    }

    String getSuit(){
        return suit;
    }

    String getFileLocation(){
        String s=fileLocation+".png";
        return s;
    }
}
