import java.util.Scanner;
import net.greyksb.games.mp.*;
//import net.greyksb.utils.*;
import net.greyksb.utils.cli.CliColors;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int numberErrors = 0 ;
        int numberGames = 0 ;
        double avgErrors = 0.00 ;
        boolean read_char_mode = true ;
        boolean last_line_mode = true ;
        String last_line = "Your try:" ;
        char inputChar = 'q' ;
        int inputInt = 0 ;
        Enigma enigma = new Enigma() ;

        CliColors cli_col = CliColors.DEFAULT;
        Scanner sc = new Scanner(System.in);

        Test tst = new Test();
        tst.newTest();
        boolean quit_flag = false ;
        while (!quit_flag) {
            cli_col.clearConsole();
            System.out.println("Number of errors (this game):\t" + cli_col.getColorString(CliColors.FC_YELLOW) + numberErrors);
            cli_col.setDefaultColor();
            System.out.println("Number of complited games:\t" + cli_col.getColorString(CliColors.FC_YELLOW) + numberGames);
            cli_col.setDefaultColor();
            System.out.println("Average number of errors:\t" + cli_col.getColorString(CliColors.FC_YELLOW) + avgErrors);
            cli_col.setDefaultColor();
            System.out.println("\nTest for You:\n");
            tst.printTest();

            while (last_line_mode) {
                System.out.print("\r"+last_line);
                if (read_char_mode) {
                    if (sc.hasNext()) {
                        inputChar = sc.nextLine().toUpperCase().charAt(0) ;
                        if (isEnigmaChar(inputChar)) {
                            if (tst.charIsPresent(inputChar) && tst.charIsUnsolved(inputChar)) {
                                last_line = "Your try: "+inputChar+" = ?" ;
                                read_char_mode = false ;
                            }
                            else
                                last_line = "Your try:" ;
                        }
                        else {
                            if ( inputChar == 'q' || inputChar == 'Q') {
                                last_line_mode = false;
                                quit_flag = true ;
                            }
                        }
                    }
                }
                else {
                    inputInt = sc.nextInt() ;
                    if (inputInt>=0 && inputInt<=9) {
                        if ( inputChar == enigma.getCode(inputInt)) {
                            last_line = "Yes!!! "+ inputChar + " is " +"Your next try:" ;
                            tst.changeCellStatus(inputInt);
                            // уменьшить на 1 количество неразгаданных ячеек
                            last_line_mode = false ;
                        }
                    }
                    else {
                        last_line = "Your try:" ;
                    }
                    read_char_mode = true ;
                }
            }

        }
    }

    public static boolean isEnigmaChar(char ch) {
        boolean out = false ;
        switch (ch) {
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
            case 'G':
            case 'H':
            case 'I':
            case 'J':
                    out = true ;
        }
        return out ;
    }
}

