/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi;

/**
 *
 * @author theo
 */
public class Case {
    private boolean empty;
    private int joueur;
    
    public Case(int joueur, boolean empty){
        this.empty = empty;
        this.joueur = joueur;
    }
    
    public Case(int joueur){
        this(joueur,false);
    }
    
    public Case(){
        this(0,false);
    }

    public boolean isEmpty() {
        return empty;
    }

    public int getJoueur() {
        return joueur;
    }
    
    
}
