/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.greyksb.games.mp;

/**
 * Проверка некоторых ситуаций, при которых имеет смысл помочь игроку в разгадывании
 * задания
 * 
 * @author greyksb(ksb)
 */
public class TestChecker {
    Test test ;
    
    // constructor
    public TestChecker(Test t) {
        this.test = t ;
    }
    
    // private methods
    
    /**
     * известен ли первый (верхний) множитель?
     */
    private boolean isM1solved(){
        boolean out = true ;
        
        for (int i=0; i<3; i++) 
            out &= (test.multFirst.cells[i].getStatus() != CellStatus.UNSOLVED) ? true : false ;
        
        return out ;
    } 
    
    private boolean isM2solved(){
        boolean out = true ;
        
        for (int i=0; i<2; i++) 
            out &= (test.multSecond.cells[i].getStatus() != CellStatus.UNSOLVED) ? true : false ;
        
        return out ;
    }
    
    public void checkMultipliers() {
        if (isM1solved()) {
            // первый множитель известен... теперь выполним доп. проверки в 
            // такой последовательности:
            //      - известен ли младший разряд второго множителя
            //      - известен ли старший разряд второго множителя
            //      
            //      и после этого проверяем известен ли второй множитель полностью, т.к.
            //      возможны ситуации, что один из разрядов раскроется в ходе
            //      предыдущих проверок и, соответственно, коррекции статуса
            //      разрядов в первом и втором слагаемых
            //
            //      такой алгоритм проще рекурсивного...
            
            if (test.multSecond.cells[1].getStatus() != CellStatus.UNSOLVED) {
                // во втором множителе известна младшая ячейка  
                // обрабатываем первое слагаемое
                for (int i=0; i<4; i++) {
                    if (test.summFirst.cells[i].getStatus() == CellStatus.UNSOLVED) {
                        test.summFirst.cells[i].setStatus(CellStatus.CALCULATED) ;
                        test.changeCellStatus(test.summFirst.cells[i].getValue(), CellStatus.CALCULATED);
                        test.setFlagSolvedValue(test.summFirst.cells[i].getValue());
                    }
                }
            }
            if (test.multSecond.cells[0].getStatus() != CellStatus.UNSOLVED){
                // во втором множителе известна старшая ячейка  
                // обрабатываем второе слагаемое
                for (int i=0; i<4; i++) {
                    if (test.summSecond.cells[i].getStatus() == CellStatus.UNSOLVED) {
                        test.summSecond.cells[i].setStatus(CellStatus.CALCULATED) ;
                        test.changeCellStatus(test.summSecond.cells[i].getValue(), CellStatus.CALCULATED);
                        test.setFlagSolvedValue(test.summSecond.cells[i].getValue());
                    }
                }
                
            }
                        if (isM2solved()) {
                // известны оба множителя...  игру надо считать законченной
                
                // обрабатываем первое слагаемое
                for (int i=0; i<4; i++) {
                    if (test.summFirst.cells[i].getStatus() == CellStatus.UNSOLVED) {
                        test.summFirst.cells[i].setStatus(CellStatus.CALCULATED) ;
                        test.changeCellStatus(test.summFirst.cells[i].getValue(), CellStatus.CALCULATED);
                        test.setFlagSolvedValue(test.summFirst.cells[i].getValue());
                    }
                }
                
                // обрабатываем второе слагаемое
                for (int i=0; i<4; i++) {
                    if (test.summSecond.cells[i].getStatus() == CellStatus.UNSOLVED) {
                        test.summSecond.cells[i].setStatus(CellStatus.CALCULATED) ;
                        test.changeCellStatus(test.summSecond.cells[i].getValue(), CellStatus.CALCULATED);
                        test.setFlagSolvedValue(test.summSecond.cells[i].getValue());
                    }
                }
                
                // обрабатываем результат
                for (int i=0; i<5; i++) {
                    if (test.result.cells[i].getStatus() == CellStatus.UNSOLVED) {
                        test.result.cells[i].setStatus(CellStatus.CALCULATED) ;
                        test.changeCellStatus(test.result.cells[i].getValue(), CellStatus.CALCULATED);
                        test.setFlagSolvedValue(test.result.cells[i].getValue());
                    }
                }
            }

        }
    }
    
}
