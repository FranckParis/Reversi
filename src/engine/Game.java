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
    private int turnIndex;
    
    public Game (){
        this.turnIndex=0;
        Player player1 = new Human(Color.WHITE);
        Player player2 = new Human(Color.BLACK);
        GameBoard board = new GameBoard();
        
        this.turns = new ArrayList <>();
        this.players = new ArrayList <>();
        this.board = board;
        this.players.add(player1);
        this.players.add(player2);
        window = new Window(this);
    }
    
    public void run(){
        Player player;
        board.addPieceOnPos(3, 3, players.get(0).getPlayerColor());
        board.addPieceOnPos(3, 4, players.get(1).getPlayerColor());
        board.addPieceOnPos(4, 3, players.get(1).getPlayerColor());
        board.addPieceOnPos(4, 4, players.get(0).getPlayerColor());
        while(true){
            board.refreshScore(players.get(0).getPlayerColor(),players.get(1).getPlayerColor());
            window.revalidate();
            window.repaint();
            player = players.get(turnIndex);
            Turn turn = new Turn(player);
            turn.run(board);
            turns.add(turn);
            turnIndex = turnIndex==0 ? turnIndex+1 : turnIndex-1;
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

    public int getTurn() {
        return turnIndex;
    }

    public GameBoard getBoard() {
        return board;
    }
    
    
    
    
}
