/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ae.oop.sudoku.abstractfactory;

import javax.swing.JFrame;
import æ.oop.sudoku.controller.NumberController;
import æ.oop.sudoku.controller.OptionController;
import æ.oop.sudoku.controller.PuzzleController;
import æ.oop.sudoku.controller.RedoController;
import æ.oop.sudoku.controller.UndoController;
import æ.oop.sudoku.view.NumberPanel;
import æ.oop.sudoku.view.OptionPanel;
import æ.oop.sudoku.view.PuzzlePanel;
import æ.oop.sudoku.view.RedoPanel;
import æ.oop.sudoku.view.UndoPanel;

/**
 * Kullanici arayuzu olusturan factory icin interface
 * 
 * @author Emre
 */
public interface AbstractGUIFactory {
    public OptionPanel createOptionPanel();
    public OptionController createOptionController();
    public NumberPanel createNumberPanel();
    public NumberController createNumberController();
    public PuzzlePanel createPuzzlePanel();
    public PuzzleController createPuzzleController();
    public UndoPanel createUndoPanel();
    public UndoController createUndoController();
    public RedoPanel createRedoPanel();
    public RedoController createRedoController();
    public JFrame createSudokuFrame();
}
