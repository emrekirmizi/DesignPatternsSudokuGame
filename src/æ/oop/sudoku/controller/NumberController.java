package æ.oop.sudoku.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import æ.oop.sudoku.model.Game;

/**
 * NumberPanel panelinden gelen tum hareketleri kontrol eder.
 *
 * @author Emre
 */
public class NumberController implements ActionListener {
    private Game game;

    public NumberController() {
    }

    /**
     * Yapilandirici, game'i ayarlar.
     *
     * @param game game'e atanacak parametre.
     */
    public NumberController(Game game) {
        this.game = game;
    }

    /**
     * Setter, Game'i ayarlar.
     * 
     * @param game game'e atanacak parametre.
     */
    public void setGame(Game game) {
        this.game = game;
    }

    /**
     * Kullanici bir butona bastiginda verilecek tepkiyi ayarlar.
     *
     * @param e ActionEvent.
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Omg help me!"))
            game.setHelp(((JCheckBox)e.getSource()).isSelected());
        else
            game.setSelectedNumber(Integer.parseInt(e.getActionCommand()));
    }
}