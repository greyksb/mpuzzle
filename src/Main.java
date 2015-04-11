import net.greyksb.games.mp.*;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        /*
        System.out.println("Тесты...");
        System.out.println("1. Проверяем шифрование...");
        testEnigma();
        */
        Test tst = new Test() ;
        tst.newTest();
        tst.printTest();
        System.out.println("**********************************");
        tst.printAnswer();

    }

    public static void testEnigma() {
        Enigma eng = new Enigma() ;
        int i ;

        System.out.print("Перед перетасовкой\n");
        for (i=0; i<=9; i++)
            System.out.print(eng.getCode(i));
        eng.shuffleCipher();

        System.out.print("\nПосле...\n");
        for (i=0; i<=9; i++)
            System.out.print(eng.getCode(i));
        eng.shuffleCipher();

        System.out.print("\nЕще раз...\n");
        for (i=0; i<=9; i++)
            System.out.print(eng.getCode(i));

    }
}
