package æ.oop.sudoku.controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import æ.oop.sudoku.model.Game;
import æ.oop.sudoku.view.Field;

/**
 * PuzzlePanel panelinden gelen tum fare hareketlerini kontrol eder.
 *
 * @author Emre
 */
public class PuzzleController implements MouseListener {

    private UndoController undoController;
    private Game game;

    /**
     * Yapilandirici
     * 
     */
    public PuzzleController() {

    }
    
    /**
     * Yapilandirici, game'i ayarlar.
     *
     * @param game game'e atanacak parametre.
     */
    public PuzzleController(Game game) {
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
     * Setter, undoController'i ayarlar.
     *
     * @param undoController undoController'a atanacak parametre.
     */
    public void setUndoController(UndoController undoController) {
        this.undoController = undoController;
    }

    /**
     * 
     * Kullanici Puzzle panelinde bir field'a tikladiginda tiklanan sahaya,
     * secili sayiyi yerlestirir.
     * Kullanici farenin sag tusuna bastiysa, tiklanan sahada bir sayi degeri 
     * varsa silinir.
     *
     * @param e MouseEvent.
     */
    public void mousePressed(MouseEvent e) {
        JPanel panel = (JPanel) e.getSource();
        Component component = panel.getComponentAt(e.getPoint());
        if (component instanceof Field) {
            Field field = (Field) component;
            int x = field.getFieldX();
            int y = field.getFieldY();

            if (e.getButton() == MouseEvent.BUTTON1 && (game.getNumber(x, y) == 0 || field.getForeground().equals(Color.WHITE))) {
                int number = game.getSelectedNumber();
                if (number == -1) {
                    return;
                }
                undoController.updateMemento();
                game.setNumber(x, y, number);
                field.setNumber(number, true);
            } else if (e.getButton() == MouseEvent.BUTTON3 && !field.getForeground().equals(Color.BLACK)) {
                undoController.updateMemento();
                game.setNumber(x, y, 0);
                field.setNumber(0, false);
            }
        }
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }
}
