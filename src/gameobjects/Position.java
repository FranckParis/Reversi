/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobjects;

/**
 *
 * @author theo
 */
public class Position {
    private int posX;
    private int posY;
    
    public Position(int x, int y){
        this.posX = x;
        this.posY = y;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public boolean isOnBoard(GameBoard board){
        return (this.posX >= 0 && this.posX < board.getWidth() && this.posY >= 0 && this.posY < board.getHeight());
    }
    
    public boolean equal(Position p){
        return this.posX == p.getPosX() && this.posY == p.getPosY();
    }
    
    public void reset(){
        this.setPosX(-1);
        this.setPosY(-1);
    }
}
