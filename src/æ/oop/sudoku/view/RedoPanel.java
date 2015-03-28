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
import æ.oop.sudoku.controller.RedoController;

/**
 *
 * @author Emre
 */
public class RedoPanel extends JPanel {

    JButton btnRedo;
    
    /**
     * Yapilandirici, Redo paneli icin gerekli tum parcalari olusturur.
     */
    public RedoPanel() {
        super(new BorderLayout());
        
        JPanel pnlAlign = new JPanel();
        pnlAlign.setLayout(new BoxLayout(pnlAlign, BoxLayout.PAGE_AXIS));
        add(pnlAlign, BorderLayout.CENTER);
        
        JPanel pnlRedo = new JPanel();
        pnlRedo.setLayout(new BoxLayout(pnlRedo, BoxLayout.PAGE_AXIS));
        pnlRedo.setBorder(BorderFactory.createTitledBorder(" Redo "));
        pnlAlign.add(pnlRedo);
        
        btnRedo = new JButton("Redo");
        btnRedo.setFocusable(false);
        pnlRedo.add(btnRedo);
    }
    
    /**
     * Redo butonu icin controller tanimlar.
     *
     * @param redoController redo butonunu kontrol eden controller.
     */
    public void setController(RedoController redoController) {
        btnRedo.addActionListener(redoController);
    }
}
