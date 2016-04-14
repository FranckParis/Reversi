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
public class Case{
    private int cordX, cordY;
    private Piece piece;

    public Case(int x, int y){
        this.piece = null;
        this.cordX = x;
        this.cordY = y;
    }

    public void addPiece(Color color){
        if(this.piece == null)
            this.piece = new Piece(color);
    }

    public Piece getPiece(){
        return this.piece;
    }

    public int getCordX(){
        return this.cordX;
    }

    public int getCordY() {
        return cordY;
    }

    public boolean isEmpty(){
        return (this.piece == null);
    }

}
