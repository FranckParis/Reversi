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
public class AIRandom extends AI{
    
    public AIRandom(int number){
        super(number);
    }
    
    @Override
    public Position play(Turn turn, GameBoard board){
        ArrayList<PlayableCase> tabPlayableCases = board.listOfPlayablePos(this.getPlayerNum());
        int lower = 0;
        int higher = tabPlayableCases.size();
        int random = (int)(Math.random() * (higher-lower)) + lower;
        return tabPlayableCases.get(random).getpCase().getPos();
    }
    
}
