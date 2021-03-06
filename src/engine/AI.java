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
public abstract class AI extends Player {

    public AI() {
        super(2, Color.white);
    }
    
    public AI(Color color,int number){
        super(number,color);
    }
    
    public AI(int number){
        super(number,Color.WHITE);
    }

    @Override
    public Position play(Turn turn, GameBoard board){
        return new Position(0,0);
    }
    
    public boolean pileOuFace(){
        int lower = 0;
        int higher = 100;
        int random = (int)(Math.random() * (higher-lower)) + lower;
        return (random<50);
    }
}