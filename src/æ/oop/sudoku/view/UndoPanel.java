/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package æ.oop.sudoku.view;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import æ.oop.sudoku.controller.UndoController;

/**
 *
 * @author Emre
 */
public class UndoPanel extends JPanel {

    JButton btnUndo;

    /**
     * Yapilandirici, Undo paneli icin gerekli tum parcalari olusturur.
     */
    public UndoPanel() {
        super(new BorderLayout());

        JPanel pnlAlign = new JPanel();
        pnlAlign.setLayout(new BoxLayout(pnlAlign, BoxLayout.PAGE_AXIS));
        add(pnlAlign, BorderLayout.CENTER);

        JPanel pnlUndo = new JPanel();
        pnlUndo.setLayout(new BoxLayout(pnlUndo, BoxLayout.PAGE_AXIS));
        pnlUndo.setBorder(BorderFactory.createTitledBorder(" Undo "));
        pnlAlign.add(pnlUndo);

        btnUndo = new JButton("Undo");
        btnUndo.setFocusable(false);
        pnlUndo.add(btnUndo);
    }

    /**
     * Undo butonu icin controller tanimlar.
     *
     * @param undoController undo butonunu kontrol eden controller.
     */
    public void setController(UndoController undoController) {
        btnUndo.addActionListener(undoController);
    }
}
