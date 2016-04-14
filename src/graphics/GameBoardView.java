/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;


import javax.swing.JPanel;
import gameobjects.GameBoard;
import java.awt.Point;

/**
 *
 * @author theo
 */
public class GameBoardView extends JPanel {
    private GameBoard board;
    
    public GameBoardView(GameBoard board){
        this.board = board;
        this.setLayout(new GameBoardLayoutManager());
        int width = board.getWidth();
        int height = board.getHeight();
        for (int i = 0; i < board.getHeight(); i++) {
            for (int j = 0; j < board.getWidth(); j++) {
                this.add(new CaseView(board.getCase(i, j)), new Point(j, i));
            }
        }
        
    }
}
