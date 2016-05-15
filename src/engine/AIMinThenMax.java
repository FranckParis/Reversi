/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import gameobjects.GameBoard;
import gameobjects.Position;

/**
 *
 * @author theo
 */
public class AIMinThenMax extends AI{
    
    private AIMin min;
    private AIMax max;
    
    public AIMinThenMax(int number){
        super(number);
        this.min = new AIMin(number);
        this.max = new AIMax(number);
    }
    
    @Override
    public Position play(Turn turn, GameBoard board){
        if(board.numberEmptyCase()>5){
            return min.play(turn, board);
        }
        return max.play(turn, board);
    }
    
}
