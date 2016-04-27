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
    
    public AIValue(int number){
        super(number);
    }
    
    @Override
    public Position play(Turn turn, GameBoard board){
        ArrayList<PlayableCase> tabPlayableCases = board.listOfPlayablePos(this.getPlayerNum());
        int bestP = 0;
        int scoreP = 0;
        for(int i = 0;i<tabPlayableCases.size();i++){
            Position p = tabPlayableCases.get(i).getpCase().getPos();
            int x = p.getPosX();
            int y = p.getPosY();
            if((x==0 && y==0) || (x==7 && y==0) || (x==0 && y==7) || (x==7 && y==7))
                return p;
            if((x==1 && (y<2||y>5)) || (x==6 && (y<2||y>5)) || (x==0 && (y==1||y==6)) || (x==7 && (y==1||y==6))){
                if(scoreP<1){
                    bestP=i;
                    scoreP=0;
                }
            }
            else{
                if((x==0||x==7||y==0||y==7)){
                    if((scoreP<2001)){
                        bestP=i;
                        scoreP=2000;
                    }
                }
                else{
                    if((((x==3||x==4) && (y>1 && y<6)) || ((x==2||x==5) && (y==3 || y==4)))){
                        if((scoreP<1000)){
                            bestP=i;
                            scoreP=1000;
                        }
                    }
                    else{
                        if(scoreP<500){
                            bestP=i;
                            scoreP=500;
                        }
                    }
                }
            }
        }
        return tabPlayableCases.get(bestP).getpCase().getPos();
    }
    
}
