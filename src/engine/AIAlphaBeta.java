/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import gameobjects.Case;
import gameobjects.GameBoard;
import gameobjects.PlayableCase;
import gameobjects.Position;
import static java.lang.Math.max;
import java.util.ArrayList;

/**
 *
 * @author Francky
 */
public class AIAlphaBeta extends AI {
    
    @Override
    public Position play(Turn turn, GameBoard board){
        /*
        double alpha = Double.NEGATIVE_INFINITY;
        double beta = Double.POSITIVE_INFINITY;
        double best = 0;
        PlayableCase bestCase = null;
        
        for (PlayableCase c : turn.getTabPlayableCases()){
            double res = negamax(c, 5, alpha, beta, -1, board);
            if (res > best){
                best = res;
                bestCase = c;
            }
        */
        return null;
        
    }
    
    /*
    public double negamax(PlayableCase selectedCase, int depth, double a, double b, int pNum, GameBoard board){
        
        //Stop
        if (depth == 0 || board.gameOver()) {
            evaluate(board);
        }
        
        //Init lists
        ArrayList <PlayableCase> possibleCases = board.listOfPlayablePos(pNum); //Need une méthode qui renvoie tous les coups jouables sans Turn
        ArrayList <PlayableCase> optiCases = orderCases(possibleCases);
        double bestValue = Double.NEGATIVE_INFINITY;
        
        //Init Gameboard
        GameBoard simulatedBoard = new GameBoard(); // A déplacer
        simulatedBoard = board;
        
        //Recursive
        for (PlayableCase currentCase : optiCases){
    
            //Play move
            simulatedBoard.addPieceOnPos(currentCase.getpCase().getPos(), pNum); //Problème couleur, nous faut un int !
            
            int uDepth = depth - 1;

            double value = -negamax(currentCase, uDepth, -b, -a, -pNum, simulatedBoard);
            
            bestValue = max(bestValue, value);
            a = max(a, value);
            if (a >= b){
                break;
            }
            
            //Remove move
            simulatedBoard.removePieceOnPos(currentCase.getpCase().getPos(), pNum);//Problème couleur, nous faut un int !
        }
        return bestValue;
    }
    
    
    public int evaluate(GameBoard board){
        return board.listOfPlayablePos(pNum).size() - board.listOfPlayablePos(-pNum).size();
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

*/
}
