package net.greyksb.games.mp;

import net.greyksb.games.mp.*;

/**
 * Created by greyksb(ksb) on 08.04.2015.
 * Число - массив Cells...
 */
public class Numeric {
    public net.greyksb.games.mp.Cell[] cells ;

    public Numeric(int capacity) {
        cells = new net.greyksb.games.mp.Cell[capacity] ;
        for (int i = 0; i < capacity; i++)
            cells[i] = new net.greyksb.games.mp.Cell();
    }

    // изменить статус тех ячеек, значение которых равно value
    public void changeCellsStatus(int value) {
        for (Cell aCell : this.cells) {
            if (aCell.getValue() == value) aCell.setStatus(CellStatus.SOLVED);
        }

    }

    public String makeColorStringView() {
        String tmpStr = "" ;
        for (int i=0; i<cells.length; i++ )
            tmpStr += (cells[i].getColorCell()+" ") ;
        return tmpStr ;
    }

    public String makeStringView() {
        String tmpStr = "" ;
        for (int i=0; i<cells.length; i++ )
            tmpStr += (cells[i].getCell()+" ") ;
        return tmpStr ;
    }
    public boolean charIsPresent(char c) {
        boolean out = false ;
        for (int i = 0; i < cells.length ; i++) {
            if (cells[i].getCode() == c ) out = true ;
        }
        return out ;
    }

    public boolean charIsUnsolved(char c) {
        boolean out = false ;
        for (int i = 0; i < cells.length ; i++) {
            if (cells[i].getCode() == c && cells[i].getStatus() == CellStatus.UNSOLVED ) out = true ;
        }
        return out ;
    }


}
