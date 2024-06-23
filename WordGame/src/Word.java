public class Word {

    private String wordContent;
    private int wordLength;

    public Word(String wordContent) {

        setWordContent(wordContent);
        setWordLength(getWordContent().length());
    }

    public String getWordContent() {
        return wordContent;
    }

    public void setWordContent(String wordContent) {
        this.wordContent = wordContent;
    }

    public int getWordLength() {
        return wordLength;
    }

    public void setWordLength(int wordLength) {
        this.wordLength = wordLength;
    }

    public String findMatchingLetters(String userGuess) {
        // string che farà return
        char[] matchedStringArr = new char[getWordLength()];
        // string che copia la parola da indovinare
        char[] wordContentArr = getWordContent().toCharArray();
        // string di quello che ha inserito l'utente
        char[] userGuessArr = userGuess.toCharArray();

        for (int x = 0; x < wordContentArr.length; x++) {

            // blocco di codice che mette insieme le stesse lettere
            // ESEMPIO: Se scrivo O quando devo indovinare NONNO, mi uscirà _ O _ _ O
            if (isLetterPresentinArray(userGuessArr[x], wordContentArr)) {
                // salvi lettera trovata
                char foundLetter = userGuessArr[x];
                // cicli nella string da indovinare
                for (int check = 0; check < wordContentArr.length; check++) {
                    // se una lettera della string da indovinare è uguale alla lettera trovata
                    if (wordContentArr[check] == foundLetter) {
                        // la aggiungi alla string che farà return
                        matchedStringArr[check] = wordContentArr[check];
                        // se una lettera della string da indovinare NON è uguale alla lettera trovata
                    } else {
                        // inserisco '_'
                        if (!Character.isLetterOrDigit(matchedStringArr[check]))
                            matchedStringArr[check] = '_';
                    }
                }
            }

        }

        // stampa i risultati
        String matchedString = "";
        for (char i : matchedStringArr) {
            matchedString += i;
        }

        return matchedString.toUpperCase();
    }

    public boolean isLetterPresentinArray(char letter, char[] array) {

        for (int i : array) {

            if (letter == i)
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return getWordContent();
    }
}
