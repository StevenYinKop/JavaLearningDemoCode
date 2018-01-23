package com.yinzifan.utils;

/**
 * MorseCode encode and decode
 * @author yinzf2 2018/01/23 17:54:39
 */
public class MorseCode {
    public static String encode(String toEncode) {
        String morse = toEncode;
        if (toEncode.equalsIgnoreCase("a"))
            morse = ".-";
        if (toEncode.equalsIgnoreCase("b"))
            morse = "-...";
        if (toEncode.equalsIgnoreCase("c"))
            morse = "-.-.";
        if (toEncode.equalsIgnoreCase("d"))
            morse = "-..";
        if (toEncode.equalsIgnoreCase("e"))
            morse = ".";
        if (toEncode.equalsIgnoreCase("f"))
            morse = "..-.";
        if (toEncode.equalsIgnoreCase("g"))
            morse = "--.";
        if (toEncode.equalsIgnoreCase("h"))
            morse = "....";
        if (toEncode.equalsIgnoreCase("i"))
            morse = "..";
        if (toEncode.equalsIgnoreCase("j"))
            morse = ".---";
        if (toEncode.equalsIgnoreCase("k"))
            morse = "-.-";
        if (toEncode.equalsIgnoreCase("l"))
            morse = ".-..";
        if (toEncode.equalsIgnoreCase("m"))
            morse = "--";
        if (toEncode.equalsIgnoreCase("n"))
            morse = "-.";
        if (toEncode.equalsIgnoreCase("o"))
            morse = "---";
        if (toEncode.equalsIgnoreCase("p"))
            morse = ".--.";
        if (toEncode.equalsIgnoreCase("q"))
            morse = "--.-";
        if (toEncode.equalsIgnoreCase("r"))
            morse = ".-.";
        if (toEncode.equalsIgnoreCase("s"))
            morse = "...";
        if (toEncode.equalsIgnoreCase("t"))
            morse = "-";
        if (toEncode.equalsIgnoreCase("u"))
            morse = "..-";
        if (toEncode.equalsIgnoreCase("v"))
            morse = "...-";
        if (toEncode.equalsIgnoreCase("w"))
            morse = ".--";
        if (toEncode.equalsIgnoreCase("x"))
            morse = "-..-";
        if (toEncode.equalsIgnoreCase("y"))
            morse = "-.--";
        if (toEncode.equalsIgnoreCase("z"))
            morse = "--..";
        if (toEncode.equalsIgnoreCase("0"))
            morse = "-----";
        if (toEncode.equalsIgnoreCase("1"))
            morse = ".----";
        if (toEncode.equalsIgnoreCase("2"))
            morse = "..---";
        if (toEncode.equalsIgnoreCase("3"))
            morse = "...--";
        if (toEncode.equalsIgnoreCase("4"))
            morse = "....-";
        if (toEncode.equalsIgnoreCase("5"))
            morse = ".....";
        if (toEncode.equalsIgnoreCase("6"))
            morse = "-....";
        if (toEncode.equalsIgnoreCase("7"))
            morse = "--...";
        if (toEncode.equalsIgnoreCase("8"))
            morse = "---..";
        if (toEncode.equalsIgnoreCase("9"))
            morse = "----.";
        if (toEncode.equalsIgnoreCase("."))
            morse = ".-.-";
        if (toEncode.equalsIgnoreCase(","))
            morse = "--..--";
        if (toEncode.equalsIgnoreCase("?"))
            morse = "..--..";
        
        return morse;
    }
    
    public static String decode(String toEncode) {
        String morse = toEncode;
        
        if (toEncode.equalsIgnoreCase(".-"))
            morse = "A";
        if (toEncode.equalsIgnoreCase("-..."))
            morse = "B";
        if (toEncode.equalsIgnoreCase("-.-."))
            morse = "C";
        if (toEncode.equalsIgnoreCase("-.."))
            morse = "D";
        if (toEncode.equalsIgnoreCase("."))
            morse = "E";
        if (toEncode.equalsIgnoreCase("..-."))
            morse = "F";
        if (toEncode.equalsIgnoreCase("--."))
            morse = "G";
        if (toEncode.equalsIgnoreCase("...."))
            morse = "H";
        if (toEncode.equalsIgnoreCase(".."))
            morse = "I";
        if (toEncode.equalsIgnoreCase(".---"))
            morse = "J";
        if (toEncode.equalsIgnoreCase("-.-"))
            morse = "K";
        if (toEncode.equalsIgnoreCase(".-.."))
            morse = "L";
        if (toEncode.equalsIgnoreCase("--"))
            morse = "M";
        if (toEncode.equalsIgnoreCase("-."))
            morse = "N";
        if (toEncode.equalsIgnoreCase("---"))
            morse = "O";
        if (toEncode.equalsIgnoreCase(".--."))
            morse = "P";
        if (toEncode.equalsIgnoreCase("--.-"))
            morse = "Q";
        if (toEncode.equalsIgnoreCase(".-."))
            morse = "R";
        if (toEncode.equalsIgnoreCase("..."))
            morse = "S";
        if (toEncode.equalsIgnoreCase("-"))
            morse = "T";
        if (toEncode.equalsIgnoreCase("..-"))
            morse = "U";
        if (toEncode.equalsIgnoreCase("...-"))
            morse = "V";
        if (toEncode.equalsIgnoreCase(".--"))
            morse = "W";
        if (toEncode.equalsIgnoreCase("-..-"))
            morse = "X";
        if (toEncode.equalsIgnoreCase("-.--"))
            morse = "Y";
        if (toEncode.equalsIgnoreCase("--.."))
            morse = "Z";
        if (toEncode.equalsIgnoreCase("-----"))
            morse = "0";
        if (toEncode.equalsIgnoreCase(".----"))
            morse = "1";
        if (toEncode.equalsIgnoreCase("..---"))
            morse = "2";
        if (toEncode.equalsIgnoreCase("...--"))
            morse = "3";
        if (toEncode.equalsIgnoreCase("....-"))
            morse = "4";
        if (toEncode.equalsIgnoreCase("....."))
            morse = "5";
        if (toEncode.equalsIgnoreCase("-...."))
            morse = "6";
        if (toEncode.equalsIgnoreCase("--..."))
            morse = "7";
        if (toEncode.equalsIgnoreCase("---.."))
            morse = "8";
        if (toEncode.equalsIgnoreCase("----."))
            morse = "9";
        if (toEncode.equalsIgnoreCase("|"))
            morse = "";
        return morse;
    }
}
