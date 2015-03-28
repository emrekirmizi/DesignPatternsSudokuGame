package æ.oop.sudoku.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import æ.oop.sudoku.model.Game;

/**
 * OptionPanel panelinden gelen tum hareketleri kontrol eder.
 *
 * @author Emre
 */
public class OptionController implements ActionListener {

    private Game game;

    public OptionController() {
    }

    /**
     * Yapilandirici, game'i ayarlar.
     *
     * @param game game'e atanacak parametre.
     */
    public OptionController(Game game) {
        this.game = game;
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
     * Kullanici bir butona bastiginda verilecek tepkiyi ayarlar.
     *
     * @param e ActionEvent.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Hot game")) {
            game.newGame();
        } else if (e.getActionCommand().equals("Check it")) {
            game.checkGame();
        } else if (e.getActionCommand().equals("Adiós")) {
            System.exit(0);
        }
    }
}
