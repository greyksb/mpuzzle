package net.greyksb.games.mp;

import net.greyksb.utils.cli.CliColors;

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
/*
    boolean attemptValue(int test) {
        return (test==this.value) ; //? true : false ;
    }
*/
    public String getCell() {
        String tmpBuff = "" ;
        if (status == CellStatus.UNSOLVED)
            tmpBuff += Character.toString(getCode()) ;
        else
            tmpBuff += Integer.toString(getValue()) ;
        return tmpBuff ;
    }

    public String getColorCell() {
        String tmpBuff = "";
        if (status == CellStatus.UNSOLVED) {
            tmpBuff += CliColors.getColorString(CliColors.BOLD) ;
            tmpBuff += CliColors.getColorString(CliColors.FC_RED) ;
            tmpBuff += Character.toString(getCode());
            tmpBuff += CliColors.getColorString(CliColors.DEFAULT) ;
        }
        else {
            tmpBuff += CliColors.getColorString(CliColors.FC_GREEN) ;
            tmpBuff += Integer.toString(getValue());
            tmpBuff += CliColors.getColorString(CliColors.DEFAULT) ;
        }
        return tmpBuff ;
    }

}

