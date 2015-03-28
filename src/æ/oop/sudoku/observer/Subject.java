/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package æ.oop.sudoku.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Tum gozlemleyici arayuzune sahip nesnelerin listesini tutan sinif.
 * Icinde barindirdigi methodlar sayesinde, 
 * gozlemleyicilerin uyarilmasini saglar.
 * 
 * @author Emre
 */
public class Subject {

    private List<Observer> observers = new ArrayList<Observer>();   
    private boolean changed;    // Herhangi bir guncelleme var mi ?

    /**
     * Yeni bir gozlemleyici ekle.
     * 
     * @param o eklenecek gozlemci parametresi.
     */
    public void addObserver(Observer o) {
        if (o == null)
            throw new NullPointerException();
        if (!observers.contains(o)) {
            observers.add(o);
        }
    }
    
    /**
     * Bir gozlemleyici sil.
     * 
     * @param o silinecek gozlemci parametresi.
     */
    public void deleteObserver(Observer o) {
       observers.remove(o);
    }

    /**
     * Degisiklik islemi bitmisse durumu false yapar.
     * 
     */
    public void clearChanged() {
        changed = false;
    }

    /**
     * Degisiklik islemi varsa durumu true yapar.
     * 
     */
    public void setChanged() {
        changed = true;
    }
    
    /**
     * Getter, degisiklik var mi bilgisini dondurur.
     * 
     * @return changed, degisiklik var mi?
     */
    public boolean hasChanged() {
        return changed;
    }
    
    /**
     * Tum gozlemleyicileri temizler.
     * 
     */
    public void clearObservers() {
        observers.clear();
    }

    /**
     * Tum gozlemleyicileri uyarir.
     * 
     */
    public void notifyAllObservers() {
        notifyAllObservers(null);
    }

    /**
     * Tum gozlemleyicileri belirli bir konuda uyar.
     * 
     * @param arg uyarilacak konu parametresi.
     */
    public void notifyAllObservers(Object arg) {
        if (!hasChanged()) {
            return;
        }
        clearChanged();

        for (int i = observers.size() - 1; i >= 0; i--) {
            (observers.get(i)).update(this, arg);
        }
    }
}
