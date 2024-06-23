import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        start();
    }

    public static void start() {

        Scanner scanner = new Scanner(System.in);

        int attemptsCounter = 1;
        // tentativo di indovinare
        String userGuess = "";
        // Parola da indovinare
        String userValue = "";

        // Filtro per rifiutare valori con numeri
        boolean repeatIfNumber = true;

        do {
            System.out.println("Inserisci la parola da far indovinare");
            userValue = scanner.nextLine().toUpperCase();

            if (isNumberPresent(userValue.toCharArray())) {
                System.out.println("La parola non deve contenere numeri, riprova" + "\n");
            } else {
                repeatIfNumber = false;
            }

        } while (repeatIfNumber);

        System.out.println();

        // Creazione oggetto Word
        Word wordToGuess = new Word(userValue);

        boolean repeatIntern = true;

        System.out.println("La parola da indovinare è di " + wordToGuess.getWordLength() + " lettere!");

        do {

            // Filtro per non inserire una parola di lunghezza diversa da quella da
            // indovinare
            System.out.println("Inserisci la parola:");
            userGuess = scanner.nextLine().toUpperCase();
            System.out.println();

            if (userGuess.length() != wordToGuess.getWordLength()) {

                System.out.println("Input errato:");
                System.out.println("La parola da indovinare è di " + wordToGuess.getWordLength() + " lettere!");
                // Senza questo continue, le parole più lunghe vengono controllate mentre le più
                // corte vanno in crash
                continue;
            }

            System.out.println("Risultato:");
            System.out.println(wordToGuess.findMatchingLetters(userGuess));

            if (userGuess.equals(wordToGuess.getWordContent())) {

                System.out.println("You guessedd the word " + wordToGuess.getWordContent().toUpperCase() + "!");
                System.out.println("It took you " + attemptsCounter + " attempts");
                System.out.println("CONGRATS!!!");
                repeatIntern = false;
            }

            attemptsCounter++;
        } while (repeatIntern);

        scanner.close();
    }

    public static boolean isNumberPresent(char[] array) {

        for (char c : array) {
            if (Character.isDigit(c))
                return true;
        }

        return false;
    }
}
