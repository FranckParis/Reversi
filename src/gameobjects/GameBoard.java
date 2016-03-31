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
        this.setPieceOnPos(3, 3, Color.white);
        this.setPieceOnPos(3, 4, Color.black);
        this.setPieceOnPos(4, 3, Color.black);
        this.setPieceOnPos(4, 4, Color.white);
    }
    
    public GameBoard(){
        this(8,8);
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
    
    public Case[][] getBoard() {
        return board;
    }
    
    public Case getCase(int i, int j) {
        return board[i][j];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


}
