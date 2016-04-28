/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobjects;

import engine.Player;

import java.awt.*;

/**
 *
 * @author theo
 */
public class Case{
    private Position pos;
    private Piece piece;

    public Case (int x, int y, Piece piece){
        this.piece = piece;
        this.pos = new Position(x,y);
    }

    public Case(int x, int y){
        this.piece = null;
        this.pos = new Position(x,y);
    }
    
    public Case(){
        this(-1,-1);
    }

    public void addPiece(Player player){
        if(this.piece == null){
            this.piece = new Piece(player);
        }
    }

    public Piece getPiece(){
        return this.piece;
    }

    public int getCordX(){
        if(this.pos == null){
            return 5;
        }
        return this.pos.getPosX();
    }

    public int getCordY() {
        return this.pos.getPosY();
    }

    public boolean isEmpty(){
        return (this.piece == null);
    }

    public Position getPos() {
        return pos;
    }
    
    public void reset(){
        this.piece = null;
    }

    public void removePiece() {
        this.piece = null;
    }

}
