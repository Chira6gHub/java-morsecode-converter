/**
 * morse_code_translator
 */
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class morse_code_translator {
    private static volatile Boolean exitRequested = false;

    private static final Map<String, String> morseMap = new HashMap<String, String>() {{
        put("A" , ". -  ");
        put("B" , "- . . .  ");
        put("C" , "- . - .  ");
        put("D" , "- . .  ");
        put("E" , ".  ");
        put("F" , ". . - .  ");
        put("G" , "- - .  ");
        put("H" , ". . . .  ");
        put("I" , ". .  ");
        put("J" , ". - - -  ");
        put("K" , "- . -  ");
        put("L" , ". - . .  ");
        put("M" , "- -  ");
        put("N" , "- .  ");
        put("O" , "- - -  ");
        put("P" , ". - - .  ");
        put("Q" , "- - . -  ");
        put("R" , ". - .  ");
        put("S" , ". . .  ");
        put("T" , "-  ");
        put("U" , ". . -  ");
        put("V" , ". . . -  ");
        put("W" , ". - -  ");
        put("X" , "- . . -  ");
        put("Y" , "- . - -  ");
        put("Z" , "- - . .  ");
        put("1" , ". - - - -  ");
        put("2" , ". . - - -  ");
        put("3" , ". . . - -  ");
        put("4" , ". . . . -  ");
        put("5" , ". . . . .  ");
        put("6" , "- . . . .  ");
        put("7" , "- - . . .  ");
        put("8" , "- - - . .  ");
        put("9" , "- - - - .  ");
        put("0" , "- - - - -  ");
        }};

        Set<Entry<String, String>> entries = morseMap.entrySet();


    public static void text_to_morse(String userinput) {
        for (int i = 0; i < userinput.length(); i++) {
            char currentletter = userinput.charAt(i);
            System.out.print(morseMap.get(String.valueOf(currentletter)));
        }
        System.out.println("\n");
    };

    public static void morse_to_text(String userinput) {
        String[] templist = userinput.split("  ");
        StringBuilder decode = new StringBuilder();

        for (String morse : templist) {
            morse += "  ";
            for (Map.Entry<String, String> entry : morseMap.entrySet()) {
                if (morse.equals(entry.getValue())) {
                    decode.append(entry.getKey());
                }
            }
        }
        System.out.println(decode.toString());
    }

    public static void main(String[] args) throws InterruptedException {

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Ctrl+C detected. Exiting the program.");
            //Boolean exitRequested = true;
        }));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter Text on word at a time and morse code with 2 white spaces after each character!");
        System.out.println("Example : . . .  - - -");
        System.out.println("Enter ctrl+c to exit");
        
        while (!exitRequested) {
            System.out.println("Enter the Morse Code or the Text to translate :");
            String user_input = scanner.nextLine().toUpperCase();
        try {
            if (morseMap.containsKey(String.valueOf(user_input.charAt(0)))){
            text_to_morse(user_input);
        } else if(user_input.contains(".") || user_input.contains("-")) {
            morse_to_text(user_input);    
        } else {
            System.out.println("Enter a valid Text or Morse code");
        }   
        } catch (InputMismatchException e) {
            System.err.println("Enter a valid value");
            scanner.nextLine();
            }
        }
    
        scanner.close();
    }
}