package net.greyksb.games.mp;

/**
 * Created by greyksb(ksb) on 08.04.2015.
 * Разряд, ячейка...  Составляющая числа...
 */
public class Cell {
    // class fild
    //public enum CELL_STATUS {UNSOLVED, CALCULATED, SOLVED}

    //fields
    private int value ;
    private char code ;
    private CellStatus status ;

    // constructors and methods
    public Cell(){
        this.value = 0 ;
        this.code = 'A' ;
        this.status = CellStatus.UNSOLVED ;
    }
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public char getCode() {
        return code;
    }

    public void setCode(char code) {
        this.code = code;
    }

    public CellStatus getStatus() {
        return status;
    }

    public void setStatus(CellStatus status) {
        this.status = status;
    }

    boolean attemptValue(int test) {
        return (test==this.value) ; //? true : false ;
    }
}
