package main;

public class Utils {
    public static int substringInt (String S){
        return Integer.valueOf(S.replaceAll("[^0-9]", ""));


    }

}
