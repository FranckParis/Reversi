/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import gameobjects.*;

import java.util.ArrayList;

/**
 *
 * @author Francky
 */
public class Turn {
    
    private Player player;
    private ArrayList <Case> playablePos;
    private Case playedCase;
    
    public Turn (Player p, GameBoard gb){
        this.player = p;
        this.playedCase = null;
        this.playablePos = new ArrayList<>();
        this.getAllPlayablePos(gb);
    }

    public void getAllPlayablePos(GameBoard gb){
        for(int i = 0 ; i < gb.getHeight() ; i++){
            for(int j = 0 ; j < gb.getWidth() ; j++){
                
            }
        }
    }

    public ArrayList <Case> getPlayablePos(){
        return this.playablePos;
    }
}
