/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import engine.Game;
import engine.Player;
import gameobjects.Score;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author theo
 */
public class VictoryMenu  extends JDialog{
    private ArrayList<Player> players = new ArrayList <>();
    private Game game;
    
    public VictoryMenu(JFrame parent, Game game){
        super(parent, "Game over", true);
        this.game = game;
        this.setSize(550, 100);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        this.initComponent();
    }
    
    public void showMenu(){
        this.setVisible(true);   
    }
    
    private void initComponent(){
        JPanel content = new JPanel();
        content.setBackground(Color.white);
        JLabel typeLabel1;
        if(Score.getScore1()>Score.getScore2()){
            typeLabel1 = new JLabel("player 1 win ("+Score.getScore1()+"  to "+Score.getScore2()+")");
        }
        else{
            if(Score.getScore1()<Score.getScore2()){
                typeLabel1 = new JLabel("player 2 win ("+Score.getScore2()+"  to "+Score.getScore1()+")");
            }
            else{
                typeLabel1 = new JLabel("draw game ("+Score.getScore1()+"  - "+Score.getScore2()+")");
            }
        }
        content.add(typeLabel1);
        
        JButton cancelBouton = new JButton("Quit");
        cancelBouton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
                setVisible(false);
            }      
         });
        
        JButton newGameBouton = new JButton("new game");
        newGameBouton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                NewGameMenu ng = new NewGameMenu(null,game);
                ng.showMenu();
                setVisible(false);
            }      
         });
        
        JButton restartBouton = new JButton("restart Game");
        restartBouton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                game.reset();
                setVisible(false);
            }      
         });
        
        
        JPanel control = new JPanel();
        control.add(restartBouton);
        control.add(newGameBouton);
        control.add(cancelBouton);
        
        this.getContentPane().add(content, BorderLayout.CENTER);
        this.getContentPane().add(control, BorderLayout.SOUTH);
    }
}
