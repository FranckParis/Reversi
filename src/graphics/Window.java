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
import reversi.GameBoard;

public class Window extends JFrame{
    private JMenuBar menuBar = new JMenuBar();
    private JMenu test1 = new JMenu("Game");
    
    private JMenuItem item1 = new JMenuItem("new game");
    
    public Window(GameBoard board){
        this.setTitle("Reversi");
        this.setSize(400, 450);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
        this.setVisible(true);
        
        //Instanciation d'un objet JPanel
        GameBoardView pan = new GameBoardView(board);
        //Définition de sa couleur de fond
        this.setBackground(Color.LIGHT_GRAY);
        //On prévient notre JFrame que notre JPanel sera son content pane
        this.setContentPane(pan);               
        this.setVisible(true);
        
        //On initialise nos menus      
        this.test1.add(item1);

        //L'ordre d'ajout va déterminer l'ordre d'apparition dans le menu de gauche à droite
        //Le premier ajouté sera tout à gauche de la barre de menu et inversement pour le dernier
        this.menuBar.add(test1);
        this.setJMenuBar(menuBar);
        this.setVisible(true);
      }
    
}
