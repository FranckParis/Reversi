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
public class Case {
    private Piece piece;

    public Case(){
        this.piece = null;
    }

    public void addPiece(Color color){
        if(this.piece == null)
            this.piece = new Piece(color);
    }

    public Piece getPiece(){
        return this.piece;
    }
    
    public boolean isEmpty(){
        return !(this.piece == null);
    }
}
