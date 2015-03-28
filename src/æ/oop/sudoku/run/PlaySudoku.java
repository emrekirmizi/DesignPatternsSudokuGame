/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package æ.oop.sudoku.run;

import ae.oop.sudoku.abstractfactory.SudokuClient;
import javax.swing.UIManager;

/**
 *
 * @author Emre
 */
public class PlaySudoku {

    /**
     * Programin ana giris noktasidir.
     *
     * @param args 
     */
    public static void main(String[] args) {
        // Pencere gorunumunu ayarlar.
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // Sudoku istemcisini cagirir.
        new SudokuClient();
    }
}
