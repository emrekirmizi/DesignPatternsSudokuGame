/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package æ.oop.sudoku.memento;

import java.util.Stack;

/**
 * Oyun icerisindeki tum hareketlerin atildigi stack'i barindiran,
 * somut bir memento sinifi.
 * 
 * @author Emre
 */
public class PreviousStateImp implements PreviousStateToCareTaker, PreviousStateToOriginator {

    private Stack<int[][]> savedStates = new Stack<int[][]>();  // Tum oyun state'lerini tutmak icin stack

    /** 
     * Yapilandirici, stack'e yeni bir durum ekler.
     * 
     * @param savedState yeni eklenecek durum.
     */
    public PreviousStateImp(int[][] savedState) {
        addSavedState(savedState);
    }
    
    /**
     * Stack'e yeni bir durum ekler.
     * 
     * @param savedState yeni eklenecek durum.
     */
    @Override
    public void addSavedState(int[][] savedState){
        this.savedStates.push(savedState);
    }
    
    /**
     * Getter, stack'ten bir durum cikarir.
     * 
     * @return stack'e eklenen son durum.
     */
    @Override
    public int[][] getSavedState() {
        if (savedStates.size() != 1) {
            return savedStates.pop();
        }
        return savedStates.elementAt(0);
    }
}
