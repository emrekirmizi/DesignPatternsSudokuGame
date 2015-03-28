package æ.oop.sudoku.model;

/**
 * Observer arayuzunu kullanan gozlemleyicileri hangi konuda guncelleme,
 * yapacaklari konusunda uyarmak icin enum sinifi.
 *
 * @author Emre
 */
public enum UpdateAction {
    NEW_GAME,
    CHECK,
    SELECTED_NUMBER,
    CANDIDATES,
    HELP,
    UNDO_REDO
}