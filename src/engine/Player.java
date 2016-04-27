/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import gameobjects.GameBoard;
import gameobjects.Position;

import java.awt.Color;

/**
 *
 * @author Francky
 */
public abstract class Player {

    private int playerNum;
    protected Color playerColor;
    private boolean stop = false;

    public Player(int num, Color c) {
            this.playerNum = num;
            this.playerColor = c;
    }

    public int getPlayerNum() {
        return this.playerNum;
    }

    public Color getPlayerColor() {
        return this.playerColor;
    }
    
    public void stop(){
        stop=true;
    }

    public boolean isStop() {
        return stop;
    }

    public abstract Position play(Turn turn, GameBoard board);
}