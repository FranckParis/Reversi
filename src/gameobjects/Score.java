/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobjects;

/**
 *
 * @author theo
 */
public class Score {
    private static int Score1= 0;
    private static int Score2= 0;

    public static int getScore1() {
        return Score1;
    }

    public static int getScore2() {
        return Score2;
    }
    
    public static void refreshScore(int Score1, int Score2){
       Score.Score1 = Score1;
       Score.Score2 = Score2;
   }
    
    
}
