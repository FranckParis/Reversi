/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;


import engine.Game;
import gameobjects.Score;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JButton;

/**
 *
 * @author theo
 */
public class ScoreView extends JButton{
    private Game game;
    
    public ScoreView(Game turn){
        this.game = turn;
        int width = this.getWidth();
        this.setPreferredSize(new Dimension(this.getWidth(),40));
        setContentAreaFilled(false);
        setBorderPainted(false);
    }
    
    @Override
   public void paintComponent(Graphics g){
        Font fonteB = new Font("TimesRoman ",Font.BOLD,30);
        Font fonteP = new Font("TimesRoman ",Font.PLAIN,30);
        String s1 = "joueur1 : "+Score.getScore1();
        String s2 = "    |    ";
        String s3 = "joueur2 : "+Score.getScore2();
        g.setFont(fonteB);
        int sLen1 = (int)g.getFontMetrics().getStringBounds(s1, g).getWidth();
        int sLen2 = (int)g.getFontMetrics().getStringBounds(s2, g).getWidth();
        int sLen3 = (int)g.getFontMetrics().getStringBounds(s3, g).getWidth();
        int start = this.getWidth()/2 - (sLen1+sLen2+sLen3)/2;
        if(game.getTurn() == 0){
            g.setFont(fonteB);
            g.drawString(s1,start,30);
            g.setFont(fonteP);
            g.drawString(s2+s3,start+sLen1,30);
        }
        else {
            g.setFont(fonteP);
            g.drawString(s1+s2,start,30);
            g.setFont(fonteB);
            g.drawString(s3,start+sLen1+sLen2,30);
        }
   }
}
