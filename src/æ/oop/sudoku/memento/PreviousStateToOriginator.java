/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package æ.oop.sudoku.memento;

/**
 * Memento'yu yaratip kullanan somut sinif icin bir arayuz.
 * 
 * Yaraticinin bir durum eklemesini ve son eklenen durumu geri almasini saglar.
 * 
 * @author Emre
 */
public interface PreviousStateToOriginator {
    public int[][] getSavedState();
    public void addSavedState(int [][] savedState);
}
