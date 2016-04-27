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
import engine.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class NewGameMenu extends JDialog{
  private ArrayList<Player> players = new ArrayList <>();
  private JLabel typeLabel1, colorLabel1,typeLabel2, colorLabel2;
  private JComboBox type1, type2, color1, color2;
  private Game game;

  public NewGameMenu(JFrame parent, Game game){
    super(parent, "New Game", true);
    this.game = game;
    this.setSize(550, 200);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    this.initComponent();
  }

  public void showMenu(){
    this.setVisible(true);   
  }

  private void initComponent(){
    JPanel panIcon = new JPanel();
    panIcon.setBackground(Color.white);
    panIcon.setLayout(new BorderLayout());
    typeLabel1 = new JLabel("type : ");
    colorLabel1 = new JLabel("  | color : ");
    typeLabel2 = new JLabel("type : ");
    colorLabel2 = new JLabel("  | color : ");

    //First Player
    JPanel panPlayer1 = new JPanel();
    panPlayer1.setBackground(Color.white);
    panPlayer1.setPreferredSize(new Dimension(400, 60));
    panPlayer1.setBorder(BorderFactory.createTitledBorder("Player 1"));
    type1 = new JComboBox();
    type1.addItem("Human");
    type1.addItem("Random AI");
    type1.addItem("Value AI");
    type1.addItem("Min AI");
    type1.addItem("Max AI");
    panPlayer1.add(typeLabel1);
    panPlayer1.add(type1);
    color1 = new JComboBox();
    color1.addItem("Black");
    color1.addItem("White");
    color1.addItem("Blue");
    color1.addItem("Green");
    color1.addItem("Red");
    color1.addItem("Magenta");
    panPlayer1.add(colorLabel1);
    panPlayer1.add(color1);
    
    //Second Player
    JPanel panPlayer2 = new JPanel();
    panPlayer2.setBackground(Color.white);
    panPlayer2.setPreferredSize(new Dimension(400, 60));
    panPlayer2.setBorder(BorderFactory.createTitledBorder("Player 2"));
    type2 = new JComboBox();
    type2.addItem("Human");
    type2.addItem("Random AI");
    type2.addItem("Value AI");
    type2.addItem("Min AI");
    type2.addItem("Max AI");
    panPlayer2.add(typeLabel2);
    panPlayer2.add(type2);
    color2 = new JComboBox();
    color2.addItem("White");
    color2.addItem("Black");
    color2.addItem("Blue");
    color2.addItem("Green");
    color2.addItem("Red");
    color2.addItem("Magenta");
    panPlayer2.add(colorLabel2);
    panPlayer2.add(color2);

    JPanel content = new JPanel();
    content.setBackground(Color.white);
    content.add(panPlayer1);
    content.add(panPlayer2);

    JPanel control = new JPanel();
    JButton okBouton = new JButton("OK");
    
    okBouton.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent arg0) {
        Player player1,player2;
        switch(type1.getSelectedIndex()){
            case 0:player1 = new Human(1);
                break;
            case 1:player1 = new AIRandom(1);
                break;
            case 2:player1 = new AIValue(1);
                break;
            case 3:player1 = new AIMin(1);
                break;
            case 4:player1 = new AIMax(1);
                break;
            default:player1 = new Human(1);
                break;
        }
        switch(color1.getSelectedIndex()){
            case 0:player1.setColor(Color.BLACK);
                break;
            case 1:player1.setColor(Color.WHITE);
                break;
            case 2:player1.setColor(Color.BLUE);
                break;
            case 3:player1.setColor(Color.GREEN);
                break;
            case 4:player1.setColor(Color.RED);
                break;
            case 5:player1.setColor(Color.MAGENTA);
                break;
            default:player1.setColor(Color.WHITE);
                break;
        }
        switch(type2.getSelectedIndex()){
            case 0:player2 = new Human(-1);
                break;
            case 1:player2 = new AIRandom(-1);
                break;
            case 2:player2 = new AIValue(-1);
                break;
            case 3:player2 = new AIMin(-1);
                break;
            case 4:player2 = new AIMax(-1);
                break;
            default:player2 = new Human(-1);
                break;
        }
        switch(color2.getSelectedIndex()){
            case 0:player2.setColor(Color.WHITE);
                break;
            case 1:player2.setColor(Color.BLACK);
                break;
            case 2:player2.setColor(Color.BLUE);
                break;
            case 3:player2.setColor(Color.GREEN);
                break;
            case 4:player2.setColor(Color.RED);
                break;
            case 5:player2.setColor(Color.MAGENTA);
                break;
            default:player2.setColor(Color.BLACK);
                break;
        }
        game.newGame(player1,player2);
        setVisible(false);
      }  
    });

    JButton cancelBouton = new JButton("Cancel");
    cancelBouton.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent arg0) {
        setVisible(false);
      }      
    });

    control.add(okBouton);
    control.add(cancelBouton);

    this.getContentPane().add(content, BorderLayout.CENTER);
    this.getContentPane().add(control, BorderLayout.SOUTH);
  }  
    
}
