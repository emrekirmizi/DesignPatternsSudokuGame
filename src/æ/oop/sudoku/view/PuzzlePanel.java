package æ.oop.sudoku.view;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import æ.oop.sudoku.controller.PuzzleController;
import æ.oop.sudoku.model.Game;
import æ.oop.sudoku.model.UpdateAction;
import æ.oop.sudoku.observer.Observer;
import æ.oop.sudoku.observer.Subject;

/**
 * JPanel matrisinden olusan Matrisi icinde barindiran, merkezdeki paneli
 * olusturur.
 *
 * @author Emre
 */
public class PuzzlePanel extends JPanel implements Observer {

    // Secili sayinin yerlestirilebilecegi aday alanlar icin tanimlanan renk.
    private static final Color COLOR_CANDIDATE = Color.BLACK;

    private Field[][] fields;       // Field sinifindan nesne matrisi
    private JPanel[][] panels;      /* Field sinifindan nesneleri yerlestirmek 
     icin panel matrisi */


    /**
     * Yapilandirici, paneli ve icerisindeki matrisi tanimlar. Matris
     * panellerden ve panellerin icerisindeki Field nesnelerinden olusur.
     */
    public PuzzlePanel() {
        super(new GridLayout(3, 3));

        panels = new JPanel[3][3];
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                panels[y][x] = new JPanel(new GridLayout(3, 3));
                panels[y][x].setBorder(BorderFactory.createLineBorder(Color.RED));
                add(panels[y][x]);
            }
        }

        fields = new Field[9][9];
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                fields[y][x] = new Field(x, y);
                panels[y / 3][x / 3].add(fields[y][x]);
            }
        }
    }

    /**
     * Game sinifi yani model sinif uyari gonderdiginde, guncelleme yapacak olan
     * method.
     *
     * @param o Model sinifi(Game)
     * @param arg Yapilacak olan guncelleme.
     */
    public void update(Subject s, Object arg) {
        switch ((UpdateAction) arg) {
            case NEW_GAME:
                setGame((Game) s);
                break;
            case CHECK:
                setGameCheck((Game) s);
                break;
            case UNDO_REDO:
                refreshGame((Game) s);
                break;
            case SELECTED_NUMBER:
                setCandidates((Game) s);
                break;
            case CANDIDATES:
                setCandidates((Game) s);
                break;
            case HELP:
                setCandidates((Game) s);
                break;
        }
    }

    /**
     * Matrisi Game sinifindan gelen game matrisiyle doldurur.
     *
     * @param game Game sinifindan gelen matris icin nesne.
     */
    public void setGame(Game game) {
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                fields[y][x].setBackground(Color.LIGHT_GRAY);
                fields[y][x].setNumber(game.getNumber(x, y), false);
            }
        }
    }

    /**
     * Ekrani yeniler.
     *
     * @param game guncel oyun.
     */
    public void refreshGame(Game game) {
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                fields[y][x].setBackground(Color.LIGHT_GRAY);
                fields[y][x].setNumber(game.getNumber(x, y), fields[y][x].isUserInput());
            }
        }
    }

    /**
     * Guncel oyunu cozumle karsilastirir ve kontrol sonucunun dondurur.
     *
     * @param game guncel oyun.
     */
    private void setGameCheck(Game game) {
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                fields[y][x].setBackground(Color.LIGHT_GRAY);
                if (fields[y][x].getForeground().equals(Color.WHITE)) {
                    fields[y][x].setBackground(game.isCheckValid(x, y) ? Color.GREEN : Color.RED);
                }
            }
        }
    }

    /**
     * Secili sayiya gore sayinin yerlestirilebilecegi, aday bosluklar
     * gosterilir.
     *
     * @param game guncel oyun.
     */
    private void setCandidates(Game game) {
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                fields[y][x].setBackground(Color.LIGHT_GRAY);
                if (game.isHelp() && game.isSelectedNumberCandidate(x, y)) {
                    fields[y][x].setBackground(COLOR_CANDIDATE);
                }
            }
        }
    }

    /**
     * Matristeki her bir alt panel icin birer kontroller atanir.
     *
     * @param sudokuController field'lari kontrol edecek olan controller.
     */
    public void setController(PuzzleController sudokuController) {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                panels[y][x].addMouseListener(sudokuController);
            }
        }
    }
}
