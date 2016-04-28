package gameobjects;

import engine.Player;

import java.awt.*;

/**
 * Created by menros on 31/03/16.
 */
public class Piece {
    private Player player;


    public Piece(Player player){
        this.player = player;
    }

    public Player getPlayer(){
        return this.player;
    }

    public Color getPieceColor(){
        return this.player.getPlayerColor();
    }
    public int getNumPlayer(){
        return this.player.getPlayerNum();
    }

    public void capture (Player player){
        this.player = player;
    }
}
