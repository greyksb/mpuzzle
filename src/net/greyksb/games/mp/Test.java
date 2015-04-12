package net.greyksb.games.mp;

import net.greyksb.games.mp.*;

import java.util.Random;

/**
 * Created by greyksb(ksb) on 08.04.2015.
 * Задание Multiplicate Puzzle
 */
public class Test {
    Numeric multFirst = new Numeric(3) ;
    Numeric multSecond = new Numeric(2) ;
    Numeric summFirst = new Numeric(4) ;
    Numeric summSecond = new Numeric(4) ;
    Numeric result = new Numeric(5) ;

    // methods
    private void setNuneric(Numeric n, int value) {
        Enigma enigma = new Enigma() ;
        String tmpbuff = Integer.toString(value) ;
        int tmpInt ;
        for (int i=0; i<n.cell.length; i++) {
            tmpInt = Character.getNumericValue(tmpbuff.charAt(i)) ;
            n.cell[i].setValue(tmpInt);
            n.cell[i].setCode(enigma.getCode(tmpInt));
            n.cell[i].setStatus(CellStatus.UNSOLVED);
        }

    }

    public void newTest() {
        int m1, m2, s1, s2, r ;
        Random rnd = new Random() ;
        String tmpStr ;
        char tmpCh ;
        int tmpInt ;

        while (true) {
            m1 = 100+rnd.nextInt(900) ;             // Трехзначный первый множитель
            m2 = 11+rnd.nextInt(89) ;               // Двухзначный второй множитель

            tmpStr = Integer.toString(m2) ;

            tmpCh = tmpStr.charAt(1) ;
            tmpInt = Character.getNumericValue(tmpCh) ;
            s1 = m1*tmpInt ;
            if (s1<1000) continue;                 // первое слагаемое не четырехзначное

            tmpCh = tmpStr.charAt(0) ;
            tmpInt = Character.getNumericValue(tmpCh) ;
            s2 = m1*tmpInt ;
            if (s2<1000) continue;                 // второе слагаемое не четырехзначное

            r = m1*m2 ;
            if (r<10000) continue;                  // результат не пятизначный

            // если до этой точки дошли, значит все в порядке и можно покинуть цикл
            break;
        }

        // для нового задания формируем новый шифр
        Enigma enigma = new Enigma();
        enigma.shuffleCipher();

        // формируем составляющие "столбика" умножения
        setNuneric(this.multFirst, m1);
        setNuneric(this.multSecond, m2);
        setNuneric(this.summFirst, s1);
        setNuneric(this.summSecond, s2);
        setNuneric(this.result, r);
    }

    //
    public void printTest() {
        System.out.println("  "+this.multFirst.makeStringView());
        System.out.println("   " + this.multSecond.makeStringView());
        System.out.println("-----");
        System.out.println(" " + this.summFirst.makeStringView());
        System.out.println(this.summSecond.makeStringView());
        System.out.println("-----");
        System.out.println(this.result.makeStringView());
    }
    public void printAnswer() {
        System.out.println("  "+this.multFirst.makeAnswerStringView());
        System.out.println("   " + this.multSecond.makeAnswerStringView());
        System.out.println("-----");
        System.out.println(" " + this.summFirst.makeAnswerStringView());
        System.out.println(this.summSecond.makeAnswerStringView());
        System.out.println("-----");
        System.out.println(this.result.makeAnswerStringView());
    }

}
