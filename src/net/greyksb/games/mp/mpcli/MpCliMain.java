/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.greyksb.games.mp.mpcli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import net.greyksb.games.mp.Test;
import net.greyksb.utils.cli.CliColors;

/**
 *
 * @author greyksb(ksb)
 */
public class MpCliMain {
  public static void main(String[] args) throws IOException {

        int  numberOfAllErrors = 0 ;
        int numberErrors = 0 ;
        int numberGames = 0 ;
        double avgErrors = 0.00 ;
        boolean read_char_mode = true ;
        //boolean last_line_mode = true ;
        String last_line = "Type q for exit or select character:" ;
        char inputChar = 'q' ;
        int inputInt = 0 ;
        String inputStr = "" ;

        //Enigma enigma = new Enigma() ;

        CliColors cli_col = CliColors.DEFAULT;
        //Scanner sc = new Scanner(System.in);

        BufferedReader brd = new BufferedReader(new InputStreamReader(System.in)) ;
        //brd.read()

        Test tst = new Test();
        tst.newTest();
        //sizOfTest = tst.getUnsolvedValue() ;

        while (true) {
            cli_col.clearConsole();
            System.out.println("Number of errors (this game):\t" + cli_col.getColorString(CliColors.FC_YELLOW) + numberErrors);
            cli_col.setDefaultColor();
            System.out.println("Number of complited games:\t" + cli_col.getColorString(CliColors.FC_YELLOW) + numberGames);
            cli_col.setDefaultColor();
            System.out.println("Average number of errors:\t" + cli_col.getColorString(CliColors.FC_YELLOW) + avgErrors);
            cli_col.setDefaultColor();
            System.out.println("\nTest for You:\n");
            tst.printTest();
            System.out.println("");
            System.out.print(last_line);
            inputStr = brd.readLine() ;
            if (inputStr.length() != 1) continue;
            if (read_char_mode) {
                inputChar = inputStr.toUpperCase().charAt(0) ;
                if (inputChar == 'Q') break ;
                  if (tst.enigma.isEnigmaChar(inputChar))
                        if (tst.charIsPresent(inputChar) && tst.charIsUnsolved(inputChar)) {
                            last_line = "Your try: "+inputChar+" = " ;
                            read_char_mode = false ;
                        }
            }
            else {
                try {
                    inputInt = Integer.valueOf(inputStr);
                }
                catch (NumberFormatException e) {
                }

                if (tst.isSolvedVavue(inputInt)) continue;

                   if (inputChar == tst.enigma.getCode(inputInt)) {
                       last_line = cli_col.getColorString(CliColors.FC_YELLOW)+"Yes! " + inputChar + " is " + inputInt +cli_col.getColorString(CliColors.DEFAULT)+ " Select next character:";
                       tst.changeCellStatus(inputInt);
                       tst.setFlagSolvedValue(inputInt);
                       //sizOfTest -= 1 ;
                       read_char_mode = true ;
                       if ( tst.getUnsolvedValue() == 0) {
                           // new game
                           numberGames += 1 ;
                           numberOfAllErrors += numberErrors ;
                           numberErrors = 0 ;
                           avgErrors = numberOfAllErrors / numberGames ;
                           tst.newTest();
                           //sizOfTest = tst.getUnsolvedValue() ;
                           last_line = "New game...Type q for exit or select character:" ;
                       }
                   }
                   else {
                       last_line = "Sorry... Type q for exit or select character:" ;
                       numberErrors += 1 ;
                       read_char_mode = true ;
                   }
            }
        }
        cli_col.clearConsole();
    }    
}
