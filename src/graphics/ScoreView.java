/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JButton;

/**
 *
 * @author theo
 */
public class ScoreView extends JButton{
    private String Bscore;
    private String Wscore;
    
    public ScoreView(){
        this.setPreferredSize(new Dimension(this.getWidth(),40));
        this.Bscore = "black : 2";
        this.Wscore = "white : 2";
        this.setBackground(Color.WHITE);
        setContentAreaFilled(false);
        setBorderPainted(false);
    }
    
    @Override
   public void paintComponent(Graphics g){
        Font fonte = new Font("TimesRoman ",Font.BOLD,30);
        g.setFont(fonte);
        g.drawString(Wscore,10,30);
        g.drawString(Bscore,this.getWidth()/2,30);
   }
   
   public void refreshScore(int WScore, int BScore){
       this.Bscore = "black : "+BScore;
       this.Wscore = "white : "+WScore;
   }
}
