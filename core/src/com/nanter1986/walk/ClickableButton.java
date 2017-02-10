package com.nanter1986.walk;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

/**
 * Created by user on 7/2/2017.
 */

public class ClickableButton {
    int xStart;
    int xFinish;
    int yStart;
    int yFinish;
    int height;
    int width;
    Texture pic;

    public ClickableButton(int xStart, int xFinish, int yStart, int yFinish, Texture pic) {
        this.xStart = xStart;
        this.xFinish = xFinish;
        this.yStart = yStart;
        this.yFinish = yFinish;
        this.height=yFinish-yStart;
        this.width=xFinish-xStart;
        this.pic = pic;
    }

    public boolean checkIfClicked(int x,int y){
        boolean clicked=false;
        if(Gdx.input.justTouched()){
            if(x>xStart && x<xFinish && y>yStart && y<yFinish){
                clicked=true;
            }
        }


        return clicked;
    }

    public void drawSelf(Batch b){
        b.draw(pic, xStart, 480-yFinish, width, height);
    }
}
