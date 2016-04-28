/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobjects;

import engine.Player;

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

    public void setWidth(int width){
        this.width = width;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public void setCase(int x, int y, Case c){
        this.board[x][y] = c;
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
    public boolean addCapture(Position pos, int playerNum, int sens, ArrayList <Piece> tabP){
        if(pos.isOnBoard(this) && this.getPieceOnPos(pos) != null){
            if(this.getPieceOnPos(pos).getNumPlayer() == playerNum) return true;
            else{
                switch(sens){
                    case 1:
                        if(addCapture(new Position(pos.getPosX()-1, pos.getPosY()-1), playerNum, sens, tabP)){
                            tabP.add(this.getPieceOnPos(pos));
                            return true;
                        }
                        break;
                    case 2:
                        if(addCapture(new Position(pos.getPosX(), pos.getPosY()-1), playerNum, sens, tabP)){
                            tabP.add(this.getPieceOnPos(pos));
                            return true;
                        }
                        break;
                    case 3:
                        if(addCapture(new Position(pos.getPosX()+1, pos.getPosY()-1), playerNum, sens, tabP)){
                            tabP.add(this.getPieceOnPos(pos));
                            return true;
                        }
                        break;
                    case 4:
                        if(addCapture(new Position(pos.getPosX()-1, pos.getPosY()), playerNum, sens, tabP)){
                            tabP.add(this.getPieceOnPos(pos));
                            return true;
                        }
                        break;
                    case 5:
                        if(addCapture(new Position(pos.getPosX()+1, pos.getPosY()), playerNum, sens, tabP)){
                            tabP.add(this.getPieceOnPos(pos));
                            return true;
                        }
                        break;
                    case 6:
                        if(addCapture(new Position(pos.getPosX()-1, pos.getPosY()+1), playerNum, sens, tabP)){
                            tabP.add(this.getPieceOnPos(pos));
                            return true;
                        }
                        break;
                    case 7:
                        if(addCapture(new Position(pos.getPosX(), pos.getPosY()+1), playerNum, sens, tabP)){
                            tabP.add(this.getPieceOnPos(pos));
                            return true;
                        }
                        break;
                    case 8:
                        if(addCapture(new Position(pos.getPosX()+1, pos.getPosY()+1), playerNum, sens, tabP)){
                            tabP.add(this.getPieceOnPos(pos));
                            return true;
                        }
                        break;
                }
            }
        }
        return false;
    }

    public ArrayList canAddPieceOnPos(Position pos, int playerNum){
        Position p;
        ArrayList <Piece> tabP = new ArrayList <>();

        if(this.getPieceOnPos(pos) == null){
            p = new Position(pos.getPosX()-1, pos.getPosY()-1);
            if(p.isOnBoard(this) && this.getPieceOnPos(p) != null && this.getPieceOnPos(p).getNumPlayer() != playerNum){
                this.addCapture(p, playerNum, 1, tabP);
            }

            p = new Position(pos.getPosX(), pos.getPosY()-1);
            if(p.isOnBoard(this) && this.getPieceOnPos(p) != null && this.getPieceOnPos(p).getNumPlayer() != playerNum){
                this.addCapture(p, playerNum, 2, tabP);
            }

            p = new Position(pos.getPosX()+1, pos.getPosY()-1);
            if(p.isOnBoard(this) && this.getPieceOnPos(p) != null && this.getPieceOnPos(p).getNumPlayer() != playerNum){
                this.addCapture(p, playerNum, 3, tabP);
            }

            p = new Position(pos.getPosX()-1, pos.getPosY());
            if(p.isOnBoard(this) && this.getPieceOnPos(p) != null && this.getPieceOnPos(p).getNumPlayer() != playerNum){
                this.addCapture(p, playerNum, 4, tabP);
            }

            p = new Position(pos.getPosX()+1, pos.getPosY());
            if(p.isOnBoard(this) && this.getPieceOnPos(p) != null && this.getPieceOnPos(p).getNumPlayer() != playerNum){
                this.addCapture(p, playerNum, 5, tabP);
            }

            p = new Position(pos.getPosX()-1, pos.getPosY()+1);
            if(p.isOnBoard(this) && this.getPieceOnPos(p) != null && this.getPieceOnPos(p).getNumPlayer() != playerNum){
                this.addCapture(p, playerNum, 6, tabP);
            }

            p = new Position(pos.getPosX(), pos.getPosY()+1);
            if(p.isOnBoard(this) && this.getPieceOnPos(p) != null && this.getPieceOnPos(p).getNumPlayer() != playerNum){
                this.addCapture(p, playerNum, 7, tabP);
            }

            p = new Position(pos.getPosX()+1, pos.getPosY()+1);
            if(p.isOnBoard(this) && this.getPieceOnPos(p) != null && this.getPieceOnPos(p).getNumPlayer() != playerNum){
                this.addCapture(p, playerNum, 8, tabP);
            }
        }
        return tabP;
    }

    public ArrayList<PlayableCase> listOfPlayablePos(int playerNum){
        ArrayList <PlayableCase> tabPc = new ArrayList<>();
        ArrayList <Piece> tabP;

        for(int i = 0 ; i < this.height ; i++){
            for(int j = 0 ; j< this.width ; j++){
                tabP = this.canAddPieceOnPos(new Position(i, j), playerNum);
                if(!tabP.isEmpty()){
                    tabPc.add(new PlayableCase(getCase(i, j), tabP));
                }
            }
        }
        return tabPc;
    }

    public void addPieceOnPos(Position pos, Player player){
        Case c = this.getCase(pos);
        c.addPiece(player);
    }
    
    public void addPieceOnPos(int x, int y, Player player){
        addPieceOnPos(new Position(x,y), player);
    }

    public void capturePieces(ArrayList <Piece> tabP, Player player){
        for (int i = 0 ; i < tabP.size() ; i++){
            tabP.get(i).capture(player);
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
    
    public void refreshScore(int num1,int num2) {
        Piece p;
        int Score1=0,Score2=0;
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                p = this.getCase(i, j).getPiece();
                if(p!=null){
                    if(p.getNumPlayer()==num1){
                        Score1++;
                    }
                    else if(p.getNumPlayer()==num2){
                        Score2++;
                    }
                }
            }
        }
        Score.refreshScore(Score1, Score2);
    }
    

    public boolean gameOver() {
        //To do
        return true;
    }

    public void reset(){
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                this.board[i][j].reset();
            }
        }
    }

    public void removePieceOnPos(Position pos) {
        Case c = this.getCase(pos);
        c.removePiece();
    }

}
