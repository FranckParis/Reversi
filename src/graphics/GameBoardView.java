/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import gameobjects.Case;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import static java.lang.Math.*;
import javax.swing.JPanel;
import gameobjects.GameBoard;

/**
 *
 * @author theo
 */
public class GameBoardView extends JPanel {
    private GameBoard board;
    
    public GameBoardView(GameBoard board){
        this.board = board;
    }
    
   @Override
   public void paintComponent(Graphics g){
       Graphics2D g2d = (Graphics2D)g;
       GradientPaint gp = new GradientPaint(0, 0, Color.RED, 30, 30, Color.cyan, true);
       Case c;
       int x1,y1;
       int width = board.getWidth();
       int height = board.getHeight();
       int size = min(this.getWidth(),this.getHeight())/max(width,height);
       int marginW = (this.getWidth() - size*width)/2;
       int marginH = (this.getHeight() - size*height)/2;
       for(int i=0;i<width;i++){
           for(int j=0;j<height;j++){
               c = board.getCase(i, j);
               x1 = size*i+marginW;
               y1 = size*j+marginH;
               g2d.setPaint(new Color(214,206,196));
               g.fillRoundRect(x1, y1, size, size, size/5, size/5);               
               g2d.setPaint(gp);
               //x1, y1, width, height, arcWidth, arcHeight
               g.drawRoundRect(x1, y1, size, size, size/5, size/5);
               if(c.isEmpty()){
                   g2d.setPaint(c.getPiece().getPieceColor());
                   g.fillOval(x1, y1, size, size);
               }
           }
       }
       
    }   
}
