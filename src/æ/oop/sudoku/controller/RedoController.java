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
 * RedoPanel panelinden gelen tum hareketleri kontrol eder.
 *
 * @author Emre
 */
public class RedoController implements ActionListener {

    private Game game;
    private static PreviousStateToCareTaker nextStates;

    /**
     * Yapilandirici
     * 
     */
    public RedoController() {
    }
    
    /**
     * Yapilandirici, game'i ayarlar.
     *
     * @param game game'e atanacak parametre.
     */
    public RedoController(Game game) {
        this.game = game;
    }
    
    /**
     * Getter, nextStates'i dondurur.
     *
     */
    public PreviousStateToCareTaker getNextStates() {
        return nextStates;
    }
    
    /**
     * Setter, nextStates'i ayarlar.
     *
     * @param nextStates nextStates'a atanacak parametre.
     */
    public static void setNextStates(PreviousStateToCareTaker nextStates) {
        RedoController.nextStates = nextStates;
    }
    
    /**
     * Getter, game'i dondurur.
     *
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
        if (e.getActionCommand().equals("Redo")) {
            game.restorePreviousState(nextStates);
        }
    }
}
