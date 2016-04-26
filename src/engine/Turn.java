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
    private ArrayList <PlayableCase> tabPlayableCases;
    
    public Turn (Player p, GameBoard board){
        this.player = p;
        this.playedCase = null;
        this.tabPlayableCases = board.listOfPlayablePos(this.player.getPlayerColor());
    }
    
    public void run(GameBoard board){
        int i;
        boolean canPlay = false;
        Position pos;
        do{
            i = 0;
            pos = this.player.play(this,board);
            while(i < this.tabPlayableCases.size() && !canPlay){
                if(this.tabPlayableCases.get(i).getpCase().getPos() == pos){
                    canPlay = true;
                }
                else i++;
            }
        }while(!canPlay);
        board.addPieceOnPos(pos, this.player.getPlayerColor());
        board.capturePieces(this.tabPlayableCases.get(i).getTabPieces());
        this.playedCase = board.getCase(pos);
    }

    public Player getPlayer(){
        return this.player;
    }

    public Case getPlayedCase(){
        return this.playedCase;
    }

    public ArrayList <PlayableCase> getTabPlayableCases(){
        return this.tabPlayableCases;
    }
}
