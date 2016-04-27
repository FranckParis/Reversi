/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import engine.Game;
import engine.Human;
import gameobjects.Case;
import gameobjects.PlayableCase;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static java.lang.Math.min;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author theo
 */
public class CaseView extends JButton implements MouseListener{

    private Case c;
    private GradientPaint backGround;
    private Game game;
    
    public CaseView(Case c, Game game){
        this.c=c;
        this.game = game;
        this.backGround = new GradientPaint(0, 0, Color.lightGray, 30, 30, new Color(150,150,150), true);
        setBackground(Color.WHITE);
        setContentAreaFilled(false);
        setBorderPainted(false);
        this.addMouseListener(this);
    }
    
    @Override
   public void paintComponent(Graphics g){
       Graphics2D g2d = (Graphics2D)g;
       int size = min(this.getWidth(),this.getHeight())-1;
        g2d.setPaint(this.backGround);
        g.fillRoundRect(0, 0, size, size, size/5, size/5);               
        g2d.setPaint(new Color(114,106,96));
        //x1, y1, width, height, arcWidth, arcHeight
        g.drawRoundRect(0, 0, size, size, size/5, size/5);
        if(!c.isEmpty()){
            g2d.setPaint(c.getPiece().getPieceColor());
            g.fillOval(size*1/20, size*1/20, size*9/10, size*9/10);
        }
        int i = 0;
        boolean playable = false;
        ArrayList<PlayableCase> tabPlayableCases = game.getBoard().listOfPlayablePos(game.getPlayer().getPlayerNum());
        while(i < tabPlayableCases.size() && !playable){
            if(tabPlayableCases.get(i).getpCase().getPos() == c.getPos()){
                playable = true;
            }
            else i++;
        }
        if(playable){
            g2d.setPaint(game.getPlayer().getPlayerColor());
            g.fillOval(size*7/20, size*7/20, size*3/10, size*3/10);
        }
    }

    //Méthode appelée lors du clic de souris
    @Override
  public void mouseClicked(MouseEvent event) { 
      Human.setClickedPos(c.getPos());
      super.repaint();
  }

  //Méthode appelée lors du survol de la souris
    @Override
  public void mouseEntered(MouseEvent event) {
      
  }

  //Méthode appelée lorsque la souris sort de la zone du bouton
    @Override
  public void mouseExited(MouseEvent event) { }

  //Méthode appelée lorsque l'on presse le bouton gauche de la souris
    @Override
  public void mousePressed(MouseEvent event) { }

  //Méthode appelée lorsque l'on relâche le clic de souris
    @Override
  public void mouseReleased(MouseEvent event) { }    

    public void setBackGround(GradientPaint backGround) {
        this.backGround = backGround;
    }
  
  
    
}
