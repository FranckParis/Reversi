/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import gameobjects.*;

import static java.lang.Math.max;
import java.util.ArrayList;

/**
 *
 * @author Francky
 */
public class AIAlphaBeta extends AI {
    
    public AIAlphaBeta(int number){
        super(number);
    }
    
    
    @Override
    public Position play(Turn turn, GameBoard board){
       
        double alpha = Double.NEGATIVE_INFINITY;
        double beta = Double.POSITIVE_INFINITY;
        double best = Double.NEGATIVE_INFINITY;;
        PlayableCase bestCase = null;
        
        for (PlayableCase c : turn.getTabPlayableCases()){
            double res = negamax(c, 5, alpha, beta, turn.getPlayer(), board, false);
            if (res > best){
                best = res;
                bestCase = c;
            }
        }
        return bestCase.getpCase().getPos();
    }
    
    
    public double negamax(PlayableCase selectedCase, int depth, double a, double b, Player p, GameBoard board, boolean prevPlayerCantPlay){

        //Init Gameboard
        GameBoard simulatedBoard = new GameBoard();

        //Init lists
        ArrayList <PlayableCase> possibleCases = board.listOfPlayablePos(p.getPlayerNum());
        ArrayList <PlayableCase> optiCases;
        
        double bestValue = Double.NEGATIVE_INFINITY;

        //Stop
        if (depth == 0 || (possibleCases.isEmpty() && prevPlayerCantPlay)){
            return evaluate(board, p);
        }
        
        //No actions possible case
        if(possibleCases.isEmpty()){
            int uDepth = depth - 1;
            Human ennemy = new Human(-p.getPlayerNum());
            double value = -negamax(selectedCase, uDepth, -b, -a, ennemy , simulatedBoard, true);
        }
        
        else{
            simulatedBoard.setHeight(board.getHeight());
            simulatedBoard.setWidth(board.getWidth());
            for(int x = 0 ; x < simulatedBoard.getHeight() ; x++){
                for(int y = 0 ; y < simulatedBoard.getWidth() ; y++){
                    if(!board.getCase(x, y).isEmpty()){
                        simulatedBoard.setCase(x, y, new Case(x, y, new Piece(board.getCase(x, y).getPiece().getPlayer())));
                    }
                    else{
                        simulatedBoard.setCase(x, y, new Case(x, y));
                    }
                }
            }

            optiCases = orderCases(possibleCases);

            //Recursive
            for (PlayableCase currentCase : optiCases){

                //Play move
                simulatedBoard.addPieceOnPos(currentCase.getpCase().getPos(), p);

                int uDepth = depth - 1;

                Human enemy = new Human(-p.getPlayerNum());
                double value = -negamax(currentCase, uDepth, -b, -a, enemy , simulatedBoard, false);

                bestValue = max(bestValue, value);
                a = max(a, value);
                if (a >= b){
                    break;
                } 
                
                //Remove move
                simulatedBoard.removePieceOnPos(currentCase.getpCase().getPos());
            }
        }
        return bestValue;
    }
    
    public int evaluate(GameBoard board, Player p){
        return board.listOfPlayablePos(p.getPlayerNum()).size() - board.listOfPlayablePos(- p.getPlayerNum()).size();
    }
   

    private ArrayList<PlayableCase> orderCases(ArrayList<PlayableCase> possibleCases) {
        
        ArrayList<PlayableCase> optiCases = new ArrayList<PlayableCase>();
                
        for(int i=0; i<possibleCases.size(); i++){
            
            //Grid edges
            if(possibleCases.get(i).getpCase().getCordX() == possibleCases.get(i).getpCase().getCordY() && 
                    (possibleCases.get(i).getpCase().getCordX() == 0 || possibleCases.get(i).getpCase().getCordX() == 7)){
                optiCases.add(0, possibleCases.get(i));
            }
            
            if(possibleCases.get(i).getpCase().getCordX() == 0 && possibleCases.get(i).getpCase().getCordX() == 7){
                optiCases.add(0, possibleCases.get(i));
            }
            
            if(possibleCases.get(i).getpCase().getCordX() == 7 && possibleCases.get(i).getpCase().getCordX() == 0){
                optiCases.add(0, possibleCases.get(i));
            }
            
            else{
                optiCases.add(possibleCases.get(i));
            }
        }
        return optiCases;
    }
}
