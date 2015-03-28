package æ.oop.sudoku.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import æ.oop.sudoku.controller.NumberController;
import æ.oop.sudoku.model.UpdateAction;
import æ.oop.sudoku.observer.Observer;
import æ.oop.sudoku.observer.Subject;

/**
 * Sayilarin ve Help butonunun oldugu paneli yaratir, ayrica bir gozlemci oldugu
 * icin, Game sinifi tarafindan uyarilirsa Update methodu ile kendini gunceller.
 *
 * @author Emre
 */
public class NumberPanel extends JPanel implements Observer {

    JCheckBox cbHelp;               // Help butonu icin kullanilan Check Box.
    ButtonGroup bgNumbers;          // Sayi butonlari icin buton grubu.
    JToggleButton[] btnNumbers;     // Ac kapa butonu tercih edilmistir.

    /**
     * Yapilandirici, Panel icin gerekli tum parcalar tanimlanir.
     */
    public NumberPanel() {
        super(new BorderLayout());

        JPanel pnlAlign = new JPanel();
        pnlAlign.setLayout(new BoxLayout(pnlAlign, BoxLayout.PAGE_AXIS));
        add(pnlAlign, BorderLayout.CENTER);

        JPanel pnlNumbers = new JPanel();
        pnlNumbers.setLayout(new BoxLayout(pnlNumbers, BoxLayout.PAGE_AXIS));
        pnlNumbers.setBorder(BorderFactory.createTitledBorder(" Numbers "));
        pnlAlign.add(pnlNumbers);

        JPanel pnlNumbersHelp = new JPanel(new FlowLayout(FlowLayout.LEADING));
        pnlNumbers.add(pnlNumbersHelp);

        cbHelp = new JCheckBox("Omg help me!", true);
        cbHelp.setFocusable(false);
        pnlNumbersHelp.add(cbHelp);

        JPanel pnlNumbersNumbers = new JPanel(new FlowLayout(FlowLayout.LEADING));
        pnlNumbers.add(pnlNumbersNumbers);

        bgNumbers = new ButtonGroup();
        btnNumbers = new JToggleButton[9];
        for (int i = 0; i < 9; i++) {
            btnNumbers[i] = new JToggleButton("" + (i + 1));
            btnNumbers[i].setPreferredSize(new Dimension(50, 50));
            btnNumbers[i].setFocusable(false);
            bgNumbers.add(btnNumbers[i]);
            pnlNumbersNumbers.add(btnNumbers[i]);
        }
    }

    /**
     * Tum sayi butonlari icin controller tanimlanir.
     *
     * @param numberController gecerli panel icin tanimli controller.
     */
    public void setController(NumberController numberController) {
        cbHelp.addActionListener(numberController);
        for (int i = 0; i < 9; i++) {
            btnNumbers[i].addActionListener(numberController);
        }
    }

    /**
     * Game sinifi tarafindan(model sinif) uyari gonderilirse, guncelle methodu
     * calisir.
     *
     * @param o Uyari gonderen sinif.
     * @param arg Hangi konuda guncelleme olacagi.
     */
    public void update(Subject s, Object arg) {
        switch ((UpdateAction) arg) {
            case NEW_GAME:
                cbHelp.setSelected(true);
            case CHECK:
                bgNumbers.clearSelection();
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
