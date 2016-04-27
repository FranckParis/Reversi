/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

/**
 *
 * @author theo
 */

import engine.Game;
import engine.Player;
import java.awt.Color;
import javax.swing.*;
import gameobjects.GameBoard;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Window extends JFrame{
    private JMenuBar menuBar = new JMenuBar();
    private ScoreView score;
    private GameBoardView pan;
    private Game game;
    
    public Window(Game g){
        this.game = g;
        java.util.Locale.setDefault ( java.util.Locale.ENGLISH ) ;
        javax.swing.UIManager.getDefaults().setDefaultLocale ( java.util.Locale.ENGLISH ) ;
        javax.swing.JComponent.setDefaultLocale ( java.util.Locale.ENGLISH ) ;
        
        
        this.setTitle("Reversi");
        this.setSize(500, 450);
        this.setMinimumSize(new Dimension(500,450));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
        this.setVisible(true);
        this.setLayout(new BorderLayout());

        this.pan = new GameBoardView(game);
        this.score= new ScoreView(game);
        //Background
        this.setBackground(Color.LIGHT_GRAY);

        this.setLayout(new BorderLayout());
        this.getContentPane().add(pan, BorderLayout.CENTER);
        this.getContentPane().add(score, BorderLayout.NORTH);
        
        //menu
        JMenu menu = new JMenu("Game");
        JMenuItem item1 = new JMenuItem("restart game");
        JMenuItem item2 = new JMenuItem("new game");
        item1.addActionListener(new MenuListener());
        item2.addActionListener(new NewGameListener());
        menu.add(item1);
        menu.add(item2);
        
        this.menuBar.add(menu);
        this.setJMenuBar(menuBar);
        this.setVisible(true);
    }
    
    
    
    public class MenuListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {    	
          JOptionPane jop = new JOptionPane();
            int option = JOptionPane.showConfirmDialog(null, 
            "Restart the game ?", 
            "restart", 
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.QUESTION_MESSAGE);
          

          if(option == JOptionPane.OK_OPTION){
            game.reset();
          }
        }
    }
    
    public class NewGameListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {    	
            NewGameMenu ng = new NewGameMenu(null,game);
            ng.showMenu();       
        }
    }
}
