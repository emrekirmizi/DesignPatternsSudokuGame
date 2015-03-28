/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ae.oop.sudoku.abstractfactory;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import æ.oop.sudoku.controller.NumberController;
import æ.oop.sudoku.controller.OptionController;
import æ.oop.sudoku.controller.PuzzleController;
import æ.oop.sudoku.controller.RedoController;
import æ.oop.sudoku.controller.UndoController;
import æ.oop.sudoku.model.Game;
import æ.oop.sudoku.view.NumberPanel;
import æ.oop.sudoku.view.OptionPanel;
import æ.oop.sudoku.view.PuzzlePanel;
import æ.oop.sudoku.view.RedoPanel;
import æ.oop.sudoku.view.UndoPanel;

/**
 * SudokuFactory sinifini kullanarak 
 * Game sinifini ve kullanici arayuzunu 
 * adim adim somut olarak yaratir
 * 
 * @author Emre
 */
public class SudokuClient {

    private AbstractSudokuFactory sudokuFactory;
    private AbstractGUIFactory guiFactory;
    private Game game;
    private JFrame sudokuFrame;
    private NumberPanel numberButtonPanel;
    private NumberController numberButtonController;
    private OptionPanel optionButtonPanel;
    private OptionController optionButtonController;
    private PuzzlePanel puzzleGridPanel;
    private PuzzleController puzzleGridController;
    private UndoPanel undoButtonPanel;
    private UndoController undoButtonController;
    private RedoPanel redoButtonPanel;
    private RedoController redoButtonController;

    public SudokuClient() {
        sudokuFactory = new SudokuFactory();
        guiFactory = sudokuFactory.createGUI();
        game = sudokuFactory.createGame();
        numberButtonController = guiFactory.createNumberController();
        numberButtonPanel = guiFactory.createNumberPanel();
        optionButtonController = guiFactory.createOptionController();
        optionButtonPanel = guiFactory.createOptionPanel();
        puzzleGridPanel = guiFactory.createPuzzlePanel();
        puzzleGridController = guiFactory.createPuzzleController();
        undoButtonPanel = guiFactory.createUndoPanel();
        undoButtonController = guiFactory.createUndoController();
        redoButtonPanel = guiFactory.createRedoPanel();
        redoButtonController = guiFactory.createRedoController();
        requestGUI();
        requestGame();
    }
    
    /**
     * Bu method ile,
     * Game sinifi icin istekte bulunulur.
     * Observer arayuzunu kullanan tum gozlemciler,
     * Game sinifinin gozlemci listesine eklenir,
     * Boylece Game sinifi gozlemcileri uyardiginda tum gozlemciler guncellenir.
     * 
     */
    public void requestGame() {
        game.addObserver(optionButtonPanel);
        game.addObserver(numberButtonPanel);
        game.addObserver(puzzleGridPanel);
    }

    /**
     * Bu method ile,
     * GUI icin gereken tum parcalar icin istekte bulunulur.
     * 
     */
    public void requestGUI() {
        requestSudokuFrame();
        requestOptionButtonPanel();
        requestUndoButtonPanel();
        requestPuzzleGridPanel();
        requestRedoButtonPanel();
        requestNumberButtonPanel();
    }
    
    /**
     * Bu method ile,
     * Kullanici arayuzunun ana cercevesi olusturulur
     * ve uzerindeki tum parcalar eklenir.
     */
    private void requestSudokuFrame() {
        sudokuFrame = guiFactory.createSudokuFrame();
        sudokuFrame.setTitle("SUuji wa DOkishin ni KagirU");
        sudokuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sudokuFrame.getContentPane().setLayout(new BorderLayout());
        sudokuFrame.add(redoButtonPanel, BorderLayout.EAST);
        sudokuFrame.add(undoButtonPanel, BorderLayout.WEST);
        sudokuFrame.add(optionButtonPanel, BorderLayout.NORTH);
        sudokuFrame.add(puzzleGridPanel, BorderLayout.CENTER);
        sudokuFrame.add(numberButtonPanel, BorderLayout.SOUTH);
        sudokuFrame.pack();
        sudokuFrame.setLocationRelativeTo(null);
        sudokuFrame.setVisible(true);
    }

    /**
     * Bu method ile,
     * Yukari kisimdaki Option isimli panelin olusmasi icin istekte bulunulur.
     * 
     */
    private void requestOptionButtonPanel() {
        optionButtonController.setGame(game);
        optionButtonPanel.setController(optionButtonController);
    }

    /**
     * Bu method ile,
     * Sol kisimdaki Undo isimli panelin olusmasi icin istekte bulunulur.
     * 
     */
    private void requestUndoButtonPanel() {
        undoButtonController.setGame(game);
        undoButtonController.updateMemento();
        undoButtonController.setRedoController(redoButtonController);
        undoButtonPanel.setController(undoButtonController);
    }

    /**
     * Bu method ile,
     * Asagi kisimdaki NumberPanel isimli panelin olusmasi icin istekte bulunulur.
     * 
     */
    private void requestNumberButtonPanel() {
        numberButtonController.setGame(game);
        numberButtonPanel.setController(numberButtonController);
    }

    /**
     * Bu method ile,
     * Sag kisimdaki Redo isimli panelin olusmasi icin istekte bulunulur.
     * 
     */
    private void requestRedoButtonPanel() {
        redoButtonController.setGame(game);
        redoButtonPanel.setController(redoButtonController);
    }

    /**
     * Bu method ile,
     * Orta kisimdaki PuzzleGrid isimli panelin olusmasi icin istekte bulunulur.
     * Bu, Field isimli kucuk panel parcalarinin olusturdugu matristen olusur.
     * 
     */
    private void requestPuzzleGridPanel() {
        puzzleGridPanel.setGame(game);
        puzzleGridPanel.setController(puzzleGridController);
        puzzleGridController.setGame(game);
        puzzleGridController.setUndoController(undoButtonController);
    }
}
