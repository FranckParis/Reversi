package gameobjects;

import java.util.ArrayList;

/**
 * Created by menros on 26/04/16.
 */
public class PlayableCase {
    private Case pCase;
    private ArrayList<Piece> tabPieces;

    public PlayableCase(Case playableCase, ArrayList<Piece> tabPieces){
        this.pCase = playableCase;
        this.tabPieces = tabPieces;
    }

    public Case getpCase(){
        return this.pCase;
    }

    public ArrayList <Piece> getTabPieces(){
        return this.tabPieces;
    }
}
