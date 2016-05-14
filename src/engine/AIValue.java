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
public class AIValue extends AI{
    
    private int[][] values;
    
    public AIValue(int number){
        super(number);
        int[][] matrice = {
            {2000, 0  ,1000,1000,1000,1000, 0  ,2000},
            { 0  , 0  , 10 , 10 , 10 , 10 , 0  , 0  },
            {1000, 10 ,500 ,500 ,500 ,500 , 10 ,1000},
            {1000, 10 ,500 ,100 ,100 ,500 , 10 ,1000},
            {1000, 10 ,500 ,100 ,100 ,500 , 10 ,1000},
            {1000, 10 ,500 ,500 ,500 ,500 , 10 ,1000},
            { 0  , 0  , 10 , 10 , 10 , 10 , 0  , 0  },
            {2000, 0  ,1000,1000,1000,1000, 0  ,2000}
        };
        this.values = matrice;
    }
    
    @Override
    public Position play(Turn turn, GameBoard board){
        ArrayList<PlayableCase> tabPlayableCases = board.listOfPlayablePos(this.getPlayerNum());
        int bestP = 0;
        int bestScore = -1;
        int scoreP = 0;
        for(int i = 0;i<tabPlayableCases.size();i++){
            Position p = tabPlayableCases.get(i).getpCase().getPos();
            scoreP = this.values[p.getPosX()][p.getPosY()];
            if(scoreP > bestScore ||(scoreP==bestScore && pileOuFace())){
                bestScore = scoreP;
                bestP = i;
            }
        }
        return tabPlayableCases.get(bestP).getpCase().getPos();
    }
    
}
