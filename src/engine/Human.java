/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import gameobjects.GameBoard;
import gameobjects.Position;

import java.awt.Color;

/**
 *
 * @author Francky
 */
public class Human extends Player {
    
    private static Position clickedPos = new Position(-1,-1);

    public Human() {
        this(Color.BLACK);
    }
    
    public Human(Color color){
        super(1, color);
    }

    @Override
    public Position play(Turn turn,GameBoard board){
        this.clickedPos.reset();
        while (clickedPos.getPosX()<0 || clickedPos.getPosY()<0) {
              try {
                   Thread.sleep(1);
              } catch (InterruptedException exception) {
              }
         }
        return clickedPos;
    }

    public static void setClickedPos(Position ClickedPos) {
        Human.clickedPos = ClickedPos;
    }
}
