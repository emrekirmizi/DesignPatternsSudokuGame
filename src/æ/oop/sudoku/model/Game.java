package æ.oop.sudoku.model;

import java.util.ArrayList;
import java.util.Collections;
import æ.oop.sudoku.memento.IGameMemento;
import æ.oop.sudoku.memento.PreviousStateImp;
import æ.oop.sudoku.memento.PreviousStateToCareTaker;
import æ.oop.sudoku.memento.PreviousStateToOriginator;
import æ.oop.sudoku.observer.Subject;

/**
 * Bu sinif sudoku oyununu olusturan , duzenleyen ve cozen asil siniftir.
 * Secili sayiyi, kullaniciya sunulan oyun matrisini, cozum matrisini,
 * Kontrol matrisini barindirir.
 * 
 * @author Emre
 */
public class Game extends Subject implements IGameMemento {
    
    private int[][] solution;       // Cozum matrisi
    private int[][] game;           // Kullaniciya sunulan oyun matrisi
    private boolean[][] check;      // Kontrol matrisi
    private int selectedNumber;     // Kullanicinin sectigi sayi
    private boolean help;           // Yardim secenegininin acik olup olmadigi

    /**
     * Yapilandirici, newGame() fonksiyonunu calistirir, 
     * varsayilan olarak yardim secenegini acik yapar,
     * kontrol matrisi olusturur.
     * 
     */
    public Game() {
        newGame();
        check = new boolean[9][9];
        help = true;
    }

    /**
     * Yeni sudoku cozumu olusturur.
     * Ardindan yeni bir oyun olusturur.
     * Tum gozlemcileri yeni bir oyun baslatildi diye uyarir.
     */
    public void newGame() {
        solution = generateSolution(new int[9][9], 0);
        game = generateGame(copy(solution));
        setChanged();
        notifyAllObservers(UpdateAction.NEW_GAME);
    }

    /**
     * Oyuncunun girdigi degerlerle cozum matrisini karsilastirir.
     * Sonucu kontrol matrisine yazar.
     * 
     * Tum gozlemcileri oyun kontrol edildi diye uyarir.
     */
    public void checkGame() {
        selectedNumber = 0;
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                check[y][x] = game[y][x] == solution[y][x];
            }
        }
        setChanged();
        notifyAllObservers(UpdateAction.CHECK);
    }

    /**
     * Yardim secenegini aldigi parametreyle degistirir.
     * Tum gozlemcileri yardim secenegi degistirildi diye uyarir.
     *
     * @param help yardim seceneginin belirlenmesi icin parametre.
     */
    public void setHelp(boolean help) {
        this.help = help;
        setChanged();
        notifyAllObservers(UpdateAction.HELP);
    }

    /**
     * Secilen sayiyi selectedNumber degiskenine atar.
     * Tum gozlemcileri kullanici tarafindan bir sayi secildi diye uyarir.
     *
     * @param selectedNumber kullanici tarafindan secilen sayi parametresi.
     */
    public void setSelectedNumber(int selectedNumber) {
        this.selectedNumber = selectedNumber;
        setChanged();
        notifyAllObservers(UpdateAction.SELECTED_NUMBER);
    }

    /**
     * Kullanici tarafindan secilen sayiyi dondurur.
     *
     * @return selectedNumber.
     */
    public int getSelectedNumber() {
        return selectedNumber;
    }

    /**
     * Help secenegi isaretliyse True, degilse False dondurur.
     *
     * @return help.
     */
    public boolean isHelp() {
        return help;
    }

    /**
     * Secilen sayinin verilen pozisyonda aday olup olmadigini kontrol eder.
     *
     * @param x Oyundaki X pozisyonu.
     * @param y Oyundaki Y pozisyonu.
     * @return True(secilen sayi adaysa)
     * @return False (secilen sayi aday degilse)
     * 
     */
    public boolean isSelectedNumberCandidate(int x, int y) {
        return game[y][x] == 0 && isPossibleX(game, y, selectedNumber)
                && isPossibleY(game, x, selectedNumber) && isPossibleBlock(game, x, y, selectedNumber);
    }

    /**
     * Parametre olarak alinan sayiyi oyun matrisindeki yerine atar.
     *
     * @param x Oyundaki X pozisyonu.
     * @param y Oyundaki Y pozisyonu.
     * @param number ayarlanacak sayi.
     */
    public void setNumber(int x, int y, int number) {
        game[y][x] = number;
        setChanged();
        notifyAllObservers(UpdateAction.CANDIDATES);
    }

    /**
     * Verilen pozisyondaki sayiyi dondurur.
     *
     * @param x Oyundaki X pozisyonu.
     * @param y Oyundaki Y pozisyonu.
     * @return pozisyonu verilen sayi.
     */
    public int getNumber(int x, int y) {
        return game[y][x];
    }

    /**
     * Kullanicinin girdigi sayiyi kontrol matrisinde kontrol eder
     *
     * @param x Oyundaki X pozisyonu.
     * @param y Oyundaki Y pozisyonu.
     * @return True (Kullanicinin girdigi sayi uygunsa)
     * @return False (Kullanicinin girdigi sayi uygun degilse)
     */
    public boolean isCheckValid(int x, int y) {
        return check[y][x];
    }

    /**
     * Y ekseni verilen sayinin X ekseninde uygun olup olmadigi kontrol edilir.
     *
     * @param game kontrol edilecek oyun matrisi.
     * @param y verilen Y ekseni.
     * @param number Kontrol edilecek sayi.
     * @return True (Verilen sayi X ekseninde uygunsa)
     * @return False (Verilen sayi X ekseninde uygun degilse)
     */
    private boolean isPossibleX(int[][] game, int y, int number) {
        for (int x = 0; x < 9; x++) {
            if (game[y][x] == number) {
                return false;
            }
        }
        return true;
    }

    /**
     * X ekseni verilen sayinin Y ekseninde uygun olup olmadigi kontrol edilir.
     *
     * @param game kontrol edilecek oyun matrisi.
     * @param x verilen X ekseni.
     * @param number Kontrol edilecek sayi.
     * @return True (Verilen sayi Y ekseninde uygunsa)
     * @return False (Verilen sayi Y ekseninde uygun degilse)
     */
    private boolean isPossibleY(int[][] game, int x, int number) {
        for (int y = 0; y < 9; y++) {
            if (game[y][x] == number) {
                return false;
            }
        }
        return true;
    }

    /**
     * X ve Y ekseni verilen sayinin 3x3 luk blok icinde
     * uygun olup olmadigi kontrol edilir.
     *
     * @param game kontrol edilecek oyun matrisi.
     * @param x verilen X ekseni.
     * @param y verilen Y ekseni.
     * @param number Kontrol edilecek sayi.
     * @return True (Verilen sayi blok icinde uygunsa)
     * @return False (Verilen sayi blok icinde uygun degilse)
     */
    private boolean isPossibleBlock(int[][] game, int x, int y, int number) {
        int x1 = x < 3 ? 0 : x < 6 ? 3 : 6;
        int y1 = y < 3 ? 0 : y < 6 ? 3 : 6;
        for (int yy = y1; yy < y1 + 3; yy++) {
            for (int xx = x1; xx < x1 + 3; xx++) {
                if (game[yy][xx] == number) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * x ve y pozisyonu icin olabilecek ilk sayiyi o pozisyona atar.
     * Eger atanacak sayi kalmamissa -1 dondurur.
     * 
     * @param game kontrol edilecek oyun matrisi.
     * @param x Oyundaki X pozisyonu.
     * @param y Oyundaki Y pozisyonu.
     * @param numbers Rastgele sayilar.
     * @return number.
     * 
     */
    private int getNextPossibleNumber(int[][] game, int x, int y, ArrayList<Integer> numbers) {
        while (numbers.size() > 0) {
            int number = numbers.remove(0);
            if (isPossibleX(game, y, number) && isPossibleY(game, x, number) && isPossibleBlock(game, x, y, number)) {
                return number;
            }
        }
        return -1;
    }

    /**
     * Sudoku oyunu icin cozumu uretir.
     *
     * @param game Cozum matrisi.
     * @param index Olusturulmaya baslanacak olan index.(Sifirla baslanir.)
     * @return game Cozum matrisi.
     */
    private int[][] generateSolution(int[][] game, int index) {
        if (index > 80) {
            return game;
        }
        
        int x = index % 9;
        int y = index / 9;
        
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int i = 1; i <= 9; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        
        while (numbers.size() > 0) {
            int number = getNextPossibleNumber(game, x, y, numbers);
            if (number == -1) {
                return null;
            }
            
            game[y][x] = number;
            int[][] tmpGame = generateSolution(game, index + 1);
            if (tmpGame != null) {
                return tmpGame;
            }
            game[y][x] = 0;
        }
        
        return null;
    }

    /**
     * Sudoku oyunu icin rastgele oyun uretir.
     *
     * @param game Oyun matrisi.
     * @return generateGame(Oyun matrisi, Rastgele karistirilmis pozisyonlar)
     */
    private int[][] generateGame(int[][] game) {
        ArrayList<Integer> positions = new ArrayList<Integer>();
        for (int i = 0; i < 81; i++) {
            positions.add(i);
        }
        Collections.shuffle(positions);
        return generateGame(game, positions);
    }
    
    /**
     * Sudoku oyunu icin rastgele oyun uretir.
     *
     * @param game Oyun matrisi.
     * @param positions Rastgele karistirilmis silinecek pozisyonlar listesi.
     * @return game Oyun matrisi.
     */
    private int[][] generateGame(int[][] game, ArrayList<Integer> positions) {
        while (positions.size() > 0) {
            int position = positions.remove(0);
            int x = position % 9;
            int y = position / 9;
            int temp = game[y][x];
            game[y][x] = 0;
            
            if (!isValid(game)) {
                game[y][x] = temp;
            }
        }
        
        return game;
    }

    /**
     * Verilen oyun matrisinin oyun icin uygunlugunu kontrol eder.
     *
     * @param game Kontrol edilecek oyun matrisi.
     * @return True(Oyun uygunsa)
     * @return False(Oyun uygun degilse)
     */
    private boolean isValid(int[][] game) {
        return isValid(game, 0, new int[]{0});
    }
    
     /**
     * Verilen oyun matrisinin oyun icin uygunlugunu kontrol eder.
     * Tek bir cozum olabilir.
     *
     * @param game Kontrol edilecek oyun matrisi.
     * @param index Kontrole baslanacak index.(Sifirdan baslanir.)
     * @param numberOfSolutions bulunan cozumler
     * @return True(Oyun uygunsa)
     * @return False(Oyun uygun degilse)
     */
    private boolean isValid(int[][] game, int index, int[] numberOfSolutions) {
        if (index > 80) {
            return ++numberOfSolutions[0] == 1;
        }
        
        int x = index % 9;
        int y = index / 9;
        
        if (game[y][x] == 0) {
            ArrayList<Integer> numbers = new ArrayList<Integer>();
            for (int i = 1; i <= 9; i++) {
                numbers.add(i);
            }
            
            while (numbers.size() > 0) {
                int number = getNextPossibleNumber(game, x, y, numbers);
                if (number == -1) {
                    break;
                }
                game[y][x] = number;
                
                if (!isValid(game, index + 1, numberOfSolutions)) {
                    game[y][x] = 0;
                    return false;
                }
                game[y][x] = 0;
            }
        } else if (!isValid(game, index + 1, numberOfSolutions)) {
            return false;
        }
        
        return true;
    }

    /**
     * Verilen matrisi kopyalar.
     *
     * @param game Kopyalanacak matris
     * @return copy Kopya matris.
     */
    private int[][] copy(int[][] game) {
        int[][] copy = new int[9][9];
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                copy[y][x] = game[y][x];
            }
        }
        return copy;
    }

    /**
     * Oyunun guncel halinin kopyasini Memento tasarimina uygun sekilde dondurur.
     * 
     * @return 
     */
    @Override
    public PreviousStateToCareTaker backupLastState() {
        return new PreviousStateImp(copy(game));
    }
    
    /**
     * Oyun matrisini parametre olarak aldigi onceki durumdaki haline dondurur.
     * Oyunu geri alir.
     * 
     * @param previousState parametre olarak alinan onceki durum.
     */
    @Override
    public void restorePreviousState(PreviousStateToCareTaker previousState) {
        game = copy(((PreviousStateToOriginator) previousState).getSavedState());
        setChanged();
        notifyAllObservers(UpdateAction.UNDO_REDO);
    }

    /**
     * Hatirlayici listesine parametre olarak aldigi yeni durumu ekler.
     * 
     * @param memento parametre olarak alinan yeni durum.
     */
    @Override
    public void addNewState(PreviousStateToCareTaker memento) {
        ((PreviousStateToOriginator) memento).addSavedState(copy(game));
    }
    
    /**
     * Oyun matrisini parametre olarak aldigi sonraki durumdaki haline dondurur.
     * Oyunu ileri alir.
     * 
     * @param nextState parametre olarak alinan sonraki durum.
     */
    @Override
    public void restoreNextState(PreviousStateToCareTaker nextState){
        ((PreviousStateToOriginator) nextState).addSavedState(copy(game));
    }
}