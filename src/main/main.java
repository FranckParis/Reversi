package main;

import graphics.Window;
import gameobjects.GameBoard;

/**
 * Created by menros on 31/03/16.
 */
public class main {
    public static void main(String[] args) {
        GameBoard board = new GameBoard();
        Window w = new Window(board);
    }
}
