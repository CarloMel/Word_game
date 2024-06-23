import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        start();
        // test();
    }

    public static void start() {

        Scanner scanner = new Scanner(System.in);

        int attemptsCounter = 1;
        String userGuess= "";

        System.out.println("Inserisci la parola da far indovinare");
        System.out.println("Suggerimento: PORTO, PONTE");
        String userValue = scanner.nextLine();
        System.out.println();

        Word wordToGuess = new Word(userValue);

        boolean repeatIntern = true;

        System.out.println("La parola da indovinare è di " + wordToGuess.getWordLength() + " lettere!");

        do {
            // Filtro per non inserire una parola di lunghezza diversa da quella da indovinare
           

                System.out.println("Inserisci la parola:");
                userGuess= scanner.nextLine();
                System.out.println();
                
                if (userGuess.length() != wordToGuess.getWordLength()) {

                    System.out.println("Input errato:");
                    System.out.println("La parola da indovinare è di " + wordToGuess.getWordLength() + " lettere!");
                    continue;
                } 

            System.out.println("Risultato:");
            System.out.println(wordToGuess.findMatchingLetters(userGuess));

            if (userGuess.equals(wordToGuess.getWordContent())) {

                System.out.println("You guessedd the word " + wordToGuess.getWordContent() + "!");
                System.out.println("It took you " + attemptsCounter + " attempts");
                System.out.println("CONGRATS!!!");
                repeatIntern = false;
            }

            attemptsCounter++;
        } while (repeatIntern);


        scanner.close();
    }

    public static void test() {
        System.out.println("TEST");
    }
}
