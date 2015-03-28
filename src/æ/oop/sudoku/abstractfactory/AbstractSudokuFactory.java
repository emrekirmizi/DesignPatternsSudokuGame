/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ae.oop.sudoku.abstractfactory;

import æ.oop.sudoku.model.Game;

/**
 * Game sinifi olusturan Factory sinifi icin interface
 * 
 * @author Emre
 */
public interface AbstractSudokuFactory {
    public Game createGame();
    public AbstractGUIFactory createGUI();
}
