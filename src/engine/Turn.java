/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import gameobjects.*;
import java.awt.Color;

import java.util.ArrayList;

/**
 *
 * @author Francky
 */
public class Turn {
    
    private Player player;
    private Case playedCase;
    
    public Turn (Player p){
        this.player = p;
        this.playedCase = null;
        this.playedCase = null;
    }
    
    public void run(GameBoard board){
        Position pos = player.play(this,board);
        board.addPieceOnPos(pos, player.getPlayerColor());
        this.playedCase = board.getCase(pos);
    }

    public void getAllPlayablePos(GameBoard gb){
        for(int i = 0 ; i < gb.getHeight() ; i++){
            for(int j = 0 ; j < gb.getWidth() ; j++){
                
            }
        }
    }
}
