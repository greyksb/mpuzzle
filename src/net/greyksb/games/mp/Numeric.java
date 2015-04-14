package net.greyksb.games.mp;

import net.greyksb.games.mp.*;

/**
 * Created by greyksb(ksb) on 08.04.2015.
 * Число - массив Cells...
 */
public class Numeric {
    public net.greyksb.games.mp.Cell[] cell ;

    public Numeric(int capacity) {
        cell = new net.greyksb.games.mp.Cell[capacity] ;
        for (int i = 0; i < capacity; i++)
            cell[i] = new net.greyksb.games.mp.Cell();
    }

    // изменить статус тех ячеек, значение которых равно value
    public void changeCellsStatus(int value) {
        for (Cell aCell : this.cell) {
            if (aCell.getValue() == value) aCell.setStatus(CellStatus.SOLVED);
        }

    }

    public String makeColorStringView() {
        String tmpStr = "" ;
        for (int i=0; i<cell.length; i++ )
            tmpStr += (cell[i].getColorCell()+" ") ;
        return tmpStr ;
    }

    public String makeStringView() {
        String tmpStr = "" ;
        for (int i=0; i<cell.length; i++ )
            tmpStr += (cell[i].getCell()+" ") ;
        return tmpStr ;
    }
    public boolean charIsPresent(char c) {
        boolean out = false ;
        for (int i = 0; i < cell.length ; i++) {
            if (cell[i].getCode() == c ) out = true ;
        }
        return out ;
    }

    public boolean charIsUnsolved(char c) {
        boolean out = false ;
        for (int i = 0; i < cell.length ; i++) {
            if (cell[i].getCode() == c && cell[i].getStatus() == CellStatus.UNSOLVED ) out = true ;
        }
        return out ;
    }


}
