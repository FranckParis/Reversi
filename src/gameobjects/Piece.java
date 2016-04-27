package gameobjects;

import java.awt.*;

/**
 * Created by menros on 31/03/16.
 */
public class Piece {
    private Color color;

    public Piece(){
        this(Color.black);
    }

    public Piece(Color color){
        this.color = color;
    }

    public Color getPieceColor(){
        return this.color;
    }

    public void setPieceColor(Color color){
        this.color = color;
    }

    public void switchColor(Color color){
        this.setPieceColor(color);
    }
}
