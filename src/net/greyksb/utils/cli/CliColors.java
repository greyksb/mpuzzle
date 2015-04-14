package net.greyksb.utils.cli;

/**
 * Created by user8 on 12.04.2015.
 */
public enum CliColors {
    CLEAR("\u001b[2J"),
    BOLD("\033[1m"),
    UNDERLINE("\033[4m"),
    DEFAULT("\033[0m"),

    FC_BLACK("\033[30m"),
    FC_RED("\033[31m"),
    FC_GREEN("\033[32m"),
    FC_YELLOW("\033[33m"),
    FC_BLUE("\033[34m"),
    FC_MAGENTA("\033[35m"),
    FC_CYAN("\033[36m"),
    FC_WHITE("\033[37m");

    private String currentColor ;

    CliColors(String s) {
        this.currentColor = s ;
    }

    public String colorString() {
        return currentColor ;
    }

    public String getColorString(CliColors clic) {
        return clic.colorString() ;
    }

    public void setCliColor(String color_str) {
        System.out.print(color_str);
    }

    public void setDefaultColor() {
        System.out.print(this.getColorString(DEFAULT));
    }
    public void clearConsole() {
        System.out.print(this.getColorString(CLEAR));
    }
}
