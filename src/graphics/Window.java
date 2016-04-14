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
import java.awt.Color;
import javax.swing.*;
import gameobjects.GameBoard;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class Window extends JFrame{
    private JMenuBar menuBar = new JMenuBar();
    private ScoreView score = new ScoreView();
    private GameBoardView pan;
    
    public Window(GameBoard board){
        this.setTitle("Reversi");
        this.setSize(400, 450);
        this.setMinimumSize(new Dimension(400,450));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
        this.setVisible(true);
        
        this.setLayout(new BorderLayout());

        this.pan = new GameBoardView(board);
        //Background
        this.setBackground(Color.LIGHT_GRAY);

        this.setLayout(new BorderLayout());
        this.getContentPane().add(pan, BorderLayout.CENTER);
        this.getContentPane().add(score, BorderLayout.NORTH);
        
        //menu
        JMenu menu = new JMenu("Game");
        JMenuItem item1 = new JMenuItem("new game");
        menu.add(item1);
        
        this.menuBar.add(menu);
        this.setJMenuBar(menuBar);
        this.setVisible(true);
    }
    
    public void refreshScore(int WScore, int BScore){
        this.score.refreshScore(WScore, BScore);
    }
}
