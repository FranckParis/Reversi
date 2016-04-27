/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import gameobjects.GameBoard;
import gameobjects.PlayableCase;
import gameobjects.Position;
import java.util.ArrayList;

/**
 *
 * @author theo
 */
public class AIMin extends AI{
    
    public AIMin(int number){
        super(number);
    }
    
    @Override
    public Position play(Turn turn, GameBoard board){
        ArrayList<PlayableCase> tabPlayableCases = board.listOfPlayablePos(this.getPlayerColor());
        int bestP = 0;
        int scoreP;
        int bestScore = 1000;
        for(int i = 0;i<tabPlayableCases.size();i++){
            scoreP = tabPlayableCases.get(i).getTabPieces().size();
            if(scoreP<bestScore){
                bestP = i;
                bestScore = scoreP;
            }
        }
        return tabPlayableCases.get(bestP).getpCase().getPos();
    }
    
}
