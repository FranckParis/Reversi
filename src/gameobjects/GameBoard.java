/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobjects;

import java.awt.*;

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
        this.setPieceOnPos(3, 3, Color.white);
        this.setPieceOnPos(3, 4, Color.black);
        this.setPieceOnPos(4, 3, Color.black);
        this.setPieceOnPos(4, 4, Color.white);
    }

    public Case getCaseOnPos(int x, int y){
        return this.board[x][y];
    }

    public Piece getPieceOnPos(int x, int y){
        return this.getCaseOnPos(x, y).getPiece();
    }

    public Color getPieceColorOnPos(int x, int y) {
        return this.getPieceOnPos(x, y).getPieceColor();
    }

    public void setPieceOnPos(int x, int y, Color color){
        this.getCaseOnPos(x, y).addPiece(color);
    }

    public void addPieceOnPos(int x, int y, Color color){
        this.getCaseOnPos(x, y).addPiece(color);
        this.capturePieceByPos(x, y);
    }

    private void capturePieceByPos(int x, int y){
        Piece p = getPieceOnPos(x, y);
        int xt = x, yt = y;
    }


}
