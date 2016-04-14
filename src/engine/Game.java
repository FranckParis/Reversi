/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import gameobjects.Case;
import gameobjects.GameBoard;
import graphics.Window;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Francky
 */
public class Game {
    
    private ArrayList <Turn> turns;
    private ArrayList <Player> players;
    private GameBoard board;
    private Window window;
    
    public Game (){
        Player player1 = new Human(Color.WHITE);
        Player player2 = new Human(Color.BLACK);
        GameBoard board = new GameBoard();
        window = new Window(board);
        this.turns = new ArrayList <>();
        this.players = new ArrayList <>();
        this.board = board;
        this.players.add(player1);
        this.players.add(player2);
    }
    
    public void run(){
        int index = 0;
        Player player;
        while(true){
            board.refreshScore(players.get(0).getPlayerColor(),players.get(1).getPlayerColor());
            window.revalidate();
            window.repaint();
            player = players.get(index);
            Turn turn = new Turn(player);
            turn.run(board);
            turns.add(turn);
            index = index==0 ? index+1 : index-1;
        }
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
