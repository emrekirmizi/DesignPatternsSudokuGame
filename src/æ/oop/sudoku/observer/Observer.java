/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package æ.oop.sudoku.observer;

/**
 * Bir guncelleme gerektiginde etkilenecek olan,
 * gozlemleyici siniflar icin bir arayuz.
 * 
 * @author Emre
 */
public interface Observer {
    public void update(Subject s, Object arg);
}
