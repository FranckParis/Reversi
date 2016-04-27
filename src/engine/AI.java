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
        super(2, Color.WHITE);
    }

    @Override
    public Position play(Turn turn, GameBoard board){
        return new Position(0,0);
    }
}
