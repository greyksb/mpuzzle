package net.greyksb.games.mp;

import java.util.Random;

/**
 * Created by greyksb(ksb) on 08.04.2015.
 * Инструмент шифрования цифр 0-9 буквами английского алфавита в верхнем регистре
 */
public class Enigma {
    // class fields
    private static final int NUMBER_SHIFTS = 0x8;
    private static char[] cipher = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'} ;

    // public methods
    /**
     * Перетасовка массива cipher[]
     */
    public void shuffleCipher() {        // перетасовка массива шифрования
        Random rnd = new Random() ;
        int numShifts = Enigma.NUMBER_SHIFTS +rnd.nextInt( Enigma.NUMBER_SHIFTS) ;
        for (int i=0; i<numShifts; i++) {
            int iFirst = rnd.nextInt(10) ;
            int iSecond =rnd.nextInt(10) ;
            char tmp = Enigma.cipher[iFirst] ;
            Enigma.cipher[iFirst] = Enigma.cipher[iSecond] ;
            Enigma.cipher[iSecond] = tmp ;
        }

    }

    /**
     * Получаем шифр цифры на входе
     * @param idx
     * @return 
     */
    public char getCode(int idx) {
        return Enigma.cipher[idx] ;
    }
    
    /**
     * Проверка правильностии предположения о том, что цифра и символ на входе
     * представляют актуальный на текущий момент времени шифр
     * @param val
     * @param ch
     * @return 
     */
    public boolean isCorrect(int val, char ch) {
        return (ch == Enigma.cipher[val]) ;    // нет смысла в вызове метода
        //return (ch == this.getCode(val)) ;
    }
    
    /**
     * Проверка принадлежит ли символ на входе массиву cipher[]
     * @param ch
     * @return 
     */
    public boolean isEnigmaChar(char ch) {
        boolean out = false ;
        for (int i=0; i<cipher.length; i++)
            if (out = (cipher[i] == ch)) break ;
        return out ;
    }

}
