package æ.oop.sudoku.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import æ.oop.sudoku.controller.OptionController;
import æ.oop.sudoku.model.UpdateAction;
import æ.oop.sudoku.observer.Observer;
import æ.oop.sudoku.observer.Subject;

/**
 * Ust kisimdaki option panel'ini olusturan sinif.
 *
 * @author Emre
 */
public class OptionPanel extends JPanel implements Observer {

    JButton btnNew, btnCheck, btnExit;   // Kullanilan butonlar

    /**
     * Yapilandirici, paneli ve icindeki tum parcalari olusturur.
     * 
     */
    public OptionPanel() {
        super(new BorderLayout());

        JPanel pnlAlign = new JPanel();
        pnlAlign.setLayout(new BoxLayout(pnlAlign, BoxLayout.PAGE_AXIS));
        add(pnlAlign, BorderLayout.CENTER);

        JPanel pnlOptions = new JPanel(new FlowLayout(FlowLayout.LEADING));
        pnlOptions.setBorder(BorderFactory.createTitledBorder(" Options "));
        pnlAlign.add(pnlOptions);

        btnNew = new JButton("Hot game");
        btnNew.setFocusable(false);
        pnlOptions.add(btnNew);

        btnCheck = new JButton("Check it");
        btnCheck.setFocusable(false);
        pnlOptions.add(btnCheck);

        btnExit = new JButton("Adiós");
        btnExit.setFocusable(false);
        pnlOptions.add(btnExit);
    }

    /**
     * Her bir buton icin controller atar.
     *
     * @param buttonController butonlari kontrol edecek olan controller.
     */
    public void setController(OptionController optionController) {
        btnNew.addActionListener(optionController);
        btnCheck.addActionListener(optionController);
        btnExit.addActionListener(optionController);
    }

    /**
     * Model sinif uyarida bulundugunda calisacak olan guncelleme methodu.
     *
     * @param o Model sinif(Game).
     * @param arg Guncelleme nedeni.
     */
    public void update(Subject s, Object arg) {
        switch ((UpdateAction) arg) {
            case NEW_GAME:
                break;
            case CHECK:
                break;
            case UNDO_REDO:
                break;
            case SELECTED_NUMBER:
                break;
            case CANDIDATES:
                break;
            case HELP:
                break;
        }
    }
}
