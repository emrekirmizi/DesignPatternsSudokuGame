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
 * Kullanici arayuzu olusturan fabrika sinifi,
 * Arayuz olusturmak icin gerekli tum siniflari yaratir
 * 
 * @author Emre
 */
public class GUIFactory implements AbstractGUIFactory{

    @Override
    public OptionPanel createOptionPanel() {
        return new OptionPanel();
    }

    @Override
    public OptionController createOptionController() {
        return new OptionController();
    }

    @Override
    public NumberPanel createNumberPanel() {
        return new NumberPanel();
    }

    @Override
    public NumberController createNumberController() {
        return new NumberController();
    }

    @Override
    public PuzzlePanel createPuzzlePanel() {
        return new PuzzlePanel();
    }

    @Override
    public PuzzleController createPuzzleController() {
        return new PuzzleController();
    }

    @Override
    public JFrame createSudokuFrame() {
        return new JFrame();
    }

    @Override
    public UndoPanel createUndoPanel() {
        return new UndoPanel();
    }

    @Override
    public UndoController createUndoController() {
        return new UndoController();
    }

    @Override
    public RedoPanel createRedoPanel() {
        return new RedoPanel();
    }

    @Override
    public RedoController createRedoController() {
        return new RedoController();
    }
}