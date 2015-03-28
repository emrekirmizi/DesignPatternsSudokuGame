/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ae.oop.sudoku.abstractfactory;

import æ.oop.sudoku.model.Game;

/**
 * Game isimli siniftan bir nesne,
 * ve somut bir gui fabrikasi ureten,
 * SudokuFactory isimli fabrika sinifi.
 * 
 * @author Emre
 */
public class SudokuFactory implements AbstractSudokuFactory{

    @Override
    public Game createGame() {
        return new Game();
    }

    @Override
    public AbstractGUIFactory createGUI() {
        return new GUIFactory();
    }
    
}
