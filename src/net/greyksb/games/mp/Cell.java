package net.greyksb.games.mp;

/**
 * Created by greyksb(ksb) on 08.04.2015.
 * Разряд, ячейка...  Составляющая числа...
 */
public class Cell {
    // class fild
    public enum CELL_STATUS {UNSOLVED, CALCULATED, SOLVED}

    //fields
    private int value ;
    private char code ;
    private CELL_STATUS status ;

    // constructors and methods
    public Cell(){
        this.value = 0 ;
        this.code = 'A' ;
        this.status = CELL_STATUS.UNSOLVED ;
    }
    public Cell(int v) {
        this.value = v ;
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

    public CELL_STATUS getStatus() {
        return status;
    }

    public void setStatus(CELL_STATUS status) {
        this.status = status;
    }

    boolean attemptValue(int test) {
        return (test==this.value) ; //? true : false ;
    }
}
