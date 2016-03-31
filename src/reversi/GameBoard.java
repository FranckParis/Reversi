/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi;

/**
 *
 * @author theo
 */
public class GameBoard {
    private Case[][] board;
    int width;
    int height;
    
    
    public GameBoard(int width, int height){
        this.width = width;
        this.height = height;
        this.board = new Case[width][height];
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                this.board[i][j] = new Case();
            }
        }
    }
    
    public GameBoard(){
        this(8,8);
    }

    public Case[][] getBoard() {
        return board;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
    
}
