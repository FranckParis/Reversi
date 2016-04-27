/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import gameobjects.GameBoard;
import graphics.NewGameMenu;
import graphics.Window;
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
    private int playerIndex;
    private boolean newGame;
    
    public Game (){
        this.playerIndex=0;
        GameBoard board = new GameBoard();
        this.newGame=false;
        this.turns = new ArrayList <>();
        this.players = new ArrayList <>();
        this.board = board;
        NewGameMenu ng = new NewGameMenu(null,this);
        ng.showMenu();
        while(players.size()<1){
            if(ng.isActive()){
                try {
                       Thread.sleep(1);
                  } catch (InterruptedException exception) {
                  }
            }
            else{
                System.exit(0);
            }
        }
        window = new Window(this);
    }
    
    public void run(){
        Player player;
        board.addPieceOnPos(3, 3, players.get(0));
        board.addPieceOnPos(3, 4, players.get(1));
        board.addPieceOnPos(4, 3, players.get(1));
        board.addPieceOnPos(4, 4, players.get(0));
        while(true){
            board.refreshScore(players.get(0).getPlayerColor(),players.get(1).getPlayerColor());
            window.revalidate();
            window.repaint();
            player = players.get(playerIndex);
            if(this.turns.size() < 2 || (this.turns.get(this.turns.size()-1).getPlayedCase() != null && this.turns.get(this.turns.size()-2).getPlayedCase() != null)){
                Turn turn = new Turn(player, this.board);
                turn.run(board);
                turns.add(turn);
                playerIndex = playerIndex==0 ? playerIndex+1 : playerIndex-1;
            }
            else{
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.newGame = true;
            }
            if(newGame){
                this.playerIndex=0;
                this.board.reset();
                this.turns.clear();
                players.get(0).unStop();
                players.get(1).unStop();
                board.addPieceOnPos(3, 3, players.get(0));
                board.addPieceOnPos(3, 4, players.get(1));
                board.addPieceOnPos(4, 3, players.get(1));
                board.addPieceOnPos(4, 4, players.get(0));
                window.revalidate();
                window.repaint();
                this.newGame=false;
            }
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

    public int getPlayerIndex() {
        return playerIndex;
    }

    public GameBoard getBoard() {
        return board;
    }
    
    public Player getPlayer(){
        return this.players.get(playerIndex);
    }
    
    public void reset(){
        this.players.get(1).stop();
        this.players.get(0).stop();
        newGame = true;
    }
    
    public void newGame(Player p1, Player p2){
        if(players.size()==2){
            this.players.get(1).stop();
            this.players.get(0).stop();
        }
        this.players.clear();
        this.players.add(p1);
        this.players.add(p2);
        newGame = true;
    }
    
}
