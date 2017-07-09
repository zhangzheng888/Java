
/**
 * Write a description of class PadString here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PadString {
    public static void main (String[] args){
        padString("computer", 10);
    }
    
    public static String padString (String string, int length){
        int stringDif = length- string.length();
        String newString;
        newString = "";
        for (int space = 0; space < stringDif; space++){
            newString += " ";
        }
        newString = newString + string;
        return newString;
    }
}
