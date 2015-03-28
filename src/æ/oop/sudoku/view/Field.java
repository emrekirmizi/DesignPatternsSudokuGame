package æ.oop.sudoku.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

/**
 * Puzzle paneldeki Label matrisini olusturan her bir alan icin gecerli sinif.
 * 
 * @author Emre
 */
public class Field extends JLabel {

    private int x;      // X position in game.
    private int y;      // Y position in game.
    private boolean userInput;

    /**
     * Yapilandiricidir, nesnenin matristeki x ve y konumunu da ayarlar.
     *
     * @param x oyundaki X pozisyonu
     * @param y oyundaki Y pozisyonu
     */
    public Field(int x, int y) {
        super("", CENTER);
        this.x = x;
        this.y = y;

        setPreferredSize(new Dimension(40, 40));
        setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
        setOpaque(true);
    }

    /**
     * Field icerisinde gosterilecek olan sayiyi ve rengini ayarlar.
     *
     * @param number gosterilecek sayi.
     * @param userInput gosterilecek sayinin kullanici girdisi olup olmadigi.
     */
    public void setNumber(int number, boolean userInput) {
        setForeground(userInput ? Color.WHITE : Color.BLACK);
        setText(number > 0 ? number + "" : "");
        this.userInput = userInput;
    }

    /**
     * Field'in oyundaki X pozisyonunu dondurur.
     *
     * @return X.
     */
    public int getFieldX() {
        return x;
    }

    /**
     * Field'in oyundaki Y pozisyonunu dondurur.
     *
     * @return Y.
     */
    public int getFieldY() {
        return y;
    }

    /**
     * Gosterilen sayi kullanici girdisi mi?
     * 
     * @return userInput.
     */
    public boolean isUserInput() {
        return userInput;
    }
}
