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
    }
    
    public void run(GameBoard board){
        int i;
        boolean canPlay = false;
        Position pos;
        ArrayList <PlayableCase> tabPlayableCases = board.listOfPlayablePos(this.player.getPlayerColor());
        do{
            i = 0;
            pos = player.play(this,board);
            while(i < tabPlayableCases.size() && !canPlay){
                if(tabPlayableCases.get(i).getpCase().getPos() == pos){
                    canPlay = true;
                }
                else i++;
            }
        }while(!canPlay);
        board.addPieceOnPos(pos, player.getPlayerColor());
        board.capturePieces(tabPlayableCases.get(i).getTabPieces());
        this.playedCase = board.getCase(pos);
    }
}
