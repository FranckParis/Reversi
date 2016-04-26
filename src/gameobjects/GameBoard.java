/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobjects;

import java.awt.*;
import java.util.ArrayList;

/**
 *
 * @author theo
 */
public class GameBoard {
    private Case[][] board;
    private int width;
    private int height;

    public GameBoard(int width, int height){
        this.width = width;
        this.height = height;
        this.board = new Case[width][height];
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                this.board[i][j] = new Case(i, j);
            }
        }
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

    /*
    sens :  1- top left diagonal
            2- left
            3- bottom left diagonal
            4- top
            5- bottom
            6- top right diagonal
            7- right
            8- bottom right diagonal
     */
    public boolean addCapture(Position pos, Color color, int sens, ArrayList <Piece> tabP){
        if(pos.isOnBoard(this) && this.getPieceOnPos(pos) != null){
            if(this.getPieceOnPos(pos).getPieceColor() == color) return true;
            else{
                switch(sens){
                    case 1:
                        if(addCapture(new Position(pos.getPosX()-1, pos.getPosY()-1), color, sens, tabP)){
                            tabP.add(this.getPieceOnPos(pos));
                            return true;
                        }
                        break;
                    case 2:
                        if(addCapture(new Position(pos.getPosX(), pos.getPosY()-1), color, sens, tabP)){
                            tabP.add(this.getPieceOnPos(pos));
                            return true;
                        }
                        break;
                    case 3:
                        if(addCapture(new Position(pos.getPosX()+1, pos.getPosY()-1), color, sens, tabP)){
                            tabP.add(this.getPieceOnPos(pos));
                            return true;
                        }
                        break;
                    case 4:
                        if(addCapture(new Position(pos.getPosX()-1, pos.getPosY()), color, sens, tabP)){
                            tabP.add(this.getPieceOnPos(pos));
                            return true;
                        }
                        break;
                    case 5:
                        if(addCapture(new Position(pos.getPosX()+1, pos.getPosY()), color, sens, tabP)){
                            tabP.add(this.getPieceOnPos(pos));
                            return true;
                        }
                        break;
                    case 6:
                        if(addCapture(new Position(pos.getPosX()-1, pos.getPosY()+1), color, sens, tabP)){
                            tabP.add(this.getPieceOnPos(pos));
                            return true;
                        }
                        break;
                    case 7:
                        if(addCapture(new Position(pos.getPosX(), pos.getPosY()+1), color, sens, tabP)){
                            tabP.add(this.getPieceOnPos(pos));
                            return true;
                        }
                        break;
                    case 8:
                        if(addCapture(new Position(pos.getPosX()+1, pos.getPosY()+1), color, sens, tabP)){
                            tabP.add(this.getPieceOnPos(pos));
                            return true;
                        }
                        break;
                }
            }
        }
        return false;
    }

    public ArrayList canAddPieceOnPos(Position pos, Color color){
        Position p;
        ArrayList <Piece> tabP = new ArrayList <>();

        if(this.getPieceOnPos(pos) == null){
            p = new Position(pos.getPosX()-1, pos.getPosY()-1);
            if(p.isOnBoard(this) && this.getPieceOnPos(p) != null && this.getPieceOnPos(p).getPieceColor() != color){
                this.addCapture(p, color, 1, tabP);
            }

            p = new Position(pos.getPosX(), pos.getPosY()-1);
            if(p.isOnBoard(this) && this.getPieceOnPos(p) != null && this.getPieceOnPos(p).getPieceColor() != color){
                this.addCapture(p, color, 2, tabP);
            }

            p = new Position(pos.getPosX()+1, pos.getPosY()-1);
            if(p.isOnBoard(this) && this.getPieceOnPos(p) != null && this.getPieceOnPos(p).getPieceColor() != color){
                this.addCapture(p, color, 3, tabP);
            }

            p = new Position(pos.getPosX()-1, pos.getPosY());
            if(p.isOnBoard(this) && this.getPieceOnPos(p) != null && this.getPieceOnPos(p).getPieceColor() != color){
                this.addCapture(p, color, 4, tabP);
            }

            p = new Position(pos.getPosX()+1, pos.getPosY());
            if(p.isOnBoard(this) && this.getPieceOnPos(p) != null && this.getPieceOnPos(p).getPieceColor() != color){
                this.addCapture(p, color, 5, tabP);
            }

            p = new Position(pos.getPosX()-1, pos.getPosY()+1);
            if(p.isOnBoard(this) && this.getPieceOnPos(p) != null && this.getPieceOnPos(p).getPieceColor() != color){
                this.addCapture(p, color, 6, tabP);
            }

            p = new Position(pos.getPosX(), pos.getPosY()+1);
            if(p.isOnBoard(this) && this.getPieceOnPos(p) != null && this.getPieceOnPos(p).getPieceColor() != color){
                this.addCapture(p, color, 7, tabP);
            }

            p = new Position(pos.getPosX()+1, pos.getPosY()+1);
            if(p.isOnBoard(this) && this.getPieceOnPos(p) != null && this.getPieceOnPos(p).getPieceColor() != color){
                this.addCapture(p, color, 8, tabP);
            }
        }
        return tabP;
    }

    public ArrayList listOfPlayablePos(Color color){
        ArrayList <PlayableCase> tabPc = new ArrayList<>();
        ArrayList <Piece> tabP;

        for(int i = 0 ; i < this.height ; i++){
            for(int j = 0 ; j< this.width ; j++){
                tabP = this.canAddPieceOnPos(new Position(i, j), color);
                if(!tabP.isEmpty()){
                    tabPc.add(new PlayableCase(getCase(i, j), tabP));
                }
            }
        }
        return tabPc;
    }

    public void addPieceOnPos(Position pos, Color color){
        Case c = this.getCase(pos);
        c.addPiece(color);
    }
    
    public void addPieceOnPos(int x, int y, Color color){
        addPieceOnPos(new Position(x,y),color);
    }

    public void capturePieces(ArrayList <Piece> tabP){
        for (int i = 0 ; i < tabP.size() ; i++){
            tabP.get(i).switchColor();
        }
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
    
    public void reset(){
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                this.board[i][j].reset();
            }
        }
    }

}
