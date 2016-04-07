/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import java.util.ArrayList;

/**
 *
 * @author Francky
 */
public class Game {
    
    private ArrayList <Turn> turns;
    private ArrayList <Player> players;
    
    public Game (){
        this.turns = new ArrayList <Turn>();
        this.players = new ArrayList <Player>();
    }
    
    public ArrayList <Turn> getTurns(){
        return this.turns;
    }
    
    public ArrayList <Player> getPlayers(){
        return this.players;
    }
    
    public Turn getTurnAtIndex (int i){
        return this.turns.get(i);
    }
    
    public void addPlayer(Player p){
        this.players.add(p);
    }
}
