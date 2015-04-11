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
        for (int i=0; i<this.cell.length; i++) {
            if (this.cell[i].getValue() == value) {
                this.cell[i].setStatus(net.greyksb.games.mp.Cell.CELL_STATUS.SOLVED);
            }
        }

    }

    public String makeStringView() {
        String tmpStr = "" ;
        for (int i=0; i<cell.length; i++ ) {
            if (cell[i].getStatus() == net.greyksb.games.mp.Cell.CELL_STATUS.UNSOLVED)
                tmpStr += Character.toString(cell[i].getCode()) ;
            else
                tmpStr += Integer.toString(cell[i].getValue()) ;
        }
        return tmpStr ;
    }

    public String makeAnswerStringView() {
        String tmpStr = "" ;
        for (int i=0; i<cell.length; i++ ) {
                tmpStr += Integer.toString(cell[i].getValue()) ;
        }
        return tmpStr ;
    }

}
