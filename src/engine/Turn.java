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
        Position pos;
        ArrayList <Piece> tabPieces;
        do{
            pos = player.play(this,board);
            tabPieces = board.canAddPieceOnPos(pos, player.getPlayerColor());
        }while(tabPieces.isEmpty());
        board.addPieceOnPos(pos, player.getPlayerColor());
        board.capturePieces(tabPieces);
        this.playedCase = board.getCase(pos);
    }

    public void getAllPlayablePos(GameBoard gb){
        for(int i = 0 ; i < gb.getHeight() ; i++){
            for(int j = 0 ; j < gb.getWidth() ; j++){
                
            }
        }
    }
}
