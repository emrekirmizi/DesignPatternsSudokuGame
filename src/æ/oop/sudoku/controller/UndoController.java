/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package æ.oop.sudoku.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import æ.oop.sudoku.memento.PreviousStateToCareTaker;
import æ.oop.sudoku.model.Game;

/**
 * UndoPanel panelinden gelen tum hareketleri kontrol eder.
 *
 * @author Emre
 */
public class UndoController implements ActionListener {

    private Game game;
    private static PreviousStateToCareTaker previousStates;
    private RedoController redoController;
    
    /**
     * Yapilandirici
     * 
     */
    public UndoController() {
    }
    
    /**
     * Yapilandirici, game'i ayarlar.
     *
     * @param game game'e atanacak parametre.
     */
    public UndoController(Game game) {
        this.game = game;
        previousStates = game.backupLastState();
    }
    
    /**
     * Setter, redoController'i ayarlar.
     *
     * @param redoController redoController'e atanacak parametre.
     */
    public void setRedoController(RedoController redoController) {
        this.redoController = redoController;
    }

    /**
     * onceki ve sonraki adimlarin tutuldugu listeyi gunceller.
     * 
     */
    public void updateMemento() {
        if (previousStates == null) {
            previousStates = game.backupLastState();
            redoController.setNextStates(game.backupLastState());
        } else {
            game.addNewState(this.previousStates);
        }
    }

    /**
     * getter, getPreviousStates'i dondurur.
     * 
     * @return 
     */
    public PreviousStateToCareTaker getPreviousStates() {
        return previousStates;
    }

    /**
     * Getter, game'i dondurur.
     *
     * @return 
     */
    public Game getGame() {
        return game;
    }
    
    /**
     * Setter, game'i ayarlar.
     * 
     * @param game game'e atanacak parametre.
     */
    public void setGame(Game game) {
        this.game = game;
    }
    
    /**
     * Kullanici butona bastiginda verilecek tepkiyi ayarlar.
     *
     * @param e ActionEvent.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Undo")) {
            game.restoreNextState(redoController.getNextStates());
            game.restorePreviousState(previousStates);
        }
    }
}
