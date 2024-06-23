import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        start();
        // test();
    }

    public static void start() {

        Scanner scanner = new Scanner(System.in);

        String userGuess= "";

        System.out.println("Inserisci la parola da far indovinare");
        System.out.println("Suggerimento: PORTO, PONTE");
        String userValue = scanner.nextLine();
        System.out.println();

        Word wordToGuess = new Word(userValue);

        System.out.println(wordToGuess);

        // Filtro per non inserire una parola di lunghezza diversa da quella da indovinare
        boolean repeatExtern = true;
        boolean repeatIntern = true;
        do {
            do {
                System.out.println("La parola da indovinare è di " + wordToGuess.getWordLength() + " lettere!");
                userGuess= scanner.nextLine();
                System.out.println();
                
                if (userGuess.length() != wordToGuess.getWordLength()) {

                    System.out.println("Input errato:");
                    System.out.println(wordToGuess);
                } else {
                    repeatExtern = false;
                }

            } while (repeatExtern);

            System.out.println("Risultato:");
            System.out.println(wordToGuess.findMatchingLetters(userGuess));

            if (userGuess.equals(wordToGuess.getWordContent())) {

                System.out.println("You guessedd the word " + wordToGuess.getWordContent() + "!");
                System.out.println("It took you x tries");
                System.out.println("CONGRATS!!!");
                repeatIntern = false;
            }

        } while (repeatIntern);


        scanner.close();
    }

    public static void test() {
        System.out.println("TEST");
    }
}
