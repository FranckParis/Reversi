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
    
    public GameBoard(){
        this.board = new Case[8][8];
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                this.board[i][j] = new Case();
            }
        }
    }
}
