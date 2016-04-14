/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobjects;

import graphics.ScoreView;
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
                this.board[i][j] = new Case(i, j);
            }
        }
        this.addPieceOnPos(3, 3, Color.white);
        this.addPieceOnPos(3, 4, Color.black);
        this.addPieceOnPos(4, 3, Color.black);
        this.addPieceOnPos(4, 4, Color.white);
    }
    
    public GameBoard(){
        this(8,8);
    }

    public Piece getPieceOnPos(Position pos){
        return this.getCase(pos).getPiece();
    }

    public Color getPieceColorOnPos(Position pos) {
        return this.getPieceOnPos(pos).getPieceColor();
    }

    public void addPieceOnPos(Position pos, Color color){
        Case c = this.getCase(pos);
        c.addPiece(color);
        //this.capturePieceByPos(x, y);
    }
    
    public void addPieceOnPos(int x, int y, Color color){
        addPieceOnPos(new Position(x,y),color);
    }

    private void capturePieceByPos(int x, int y){
        Piece p = getPieceOnPos(new Position(x,y));
        int xt = x, yt = y;
    }
    
    public Case[][] getBoard() {
        return board;
    }
    
    public Case getCase(int x, int y) {
        return board[x][y];
    }
    
    public Case getCase(Position pos) {
        return board[pos.getPosX()][pos.getPosY()];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
    public void refreshScore(Color color1,Color color2) {
        Piece p;
        int BScore=0,WScore=0;
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                p = this.getCase(i, j).getPiece();
                if(p!=null){
                    if(p.getPieceColor()==color1){
                        BScore++;
                    }
                    else if(p.getPieceColor()==color2){
                        WScore++;
                    }
                }
            }
        }
        Score.refreshScore(BScore, WScore);
    }

}
