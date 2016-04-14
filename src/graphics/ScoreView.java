/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;


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
    
    
    public ScoreView(){
        int width = this.getWidth();
        this.setPreferredSize(new Dimension(this.getWidth(),40));
        setContentAreaFilled(false);
        setBorderPainted(false);
    }
    
    @Override
   public void paintComponent(Graphics g){
        Font fonte = new Font("TimesRoman ",Font.BOLD,30);
        g.setFont(fonte);
        String s = "joueur1 : "+Score.getScore1()+"    |    "+"joueur2 : "+Score.getScore2();
        int stringLen = (int)g.getFontMetrics().getStringBounds(s, g).getWidth();
        int start = this.getWidth()/2 - stringLen/2;
        g.drawString(s,start,30);
   }
}
