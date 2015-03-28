/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package æ.oop.sudoku.memento;

/**
 * Game sinifinin Memento kullanmasi icin arayuz
 * 
 * @author Emre
 */
public interface IGameMemento {

    /**
     * Son durumu geri dondurur
     * 
     * @return 
     */
    public PreviousStateToCareTaker backupLastState();

    /**
     * Parametre olarak bir durum alir ve o duruma geri doner.
     * 
     * @param previousState onceki veya sonraki bir durum.
     */
    public void restorePreviousState(PreviousStateToCareTaker previousState);
    
    /**
     * Parametre olarak alinan durum stack'e eklenir.
     * 
     * @param memento 
     */
    public void addNewState(PreviousStateToCareTaker memento);
    
    /**
     * Parametre olarak alinan durum'a geri donebilmek icin onceki durum eklenir.
     * 
     * @param nextState 
     */
    public void restoreNextState(PreviousStateToCareTaker nextState);
}
