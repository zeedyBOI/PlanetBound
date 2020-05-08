package Ex1;

public class forcaGame {
    static final char CHAR = '_';
    StringBuffer answer;
    String word;
    String[] possibleWords = new String[10];
    int attemptsLeft;
    char[] attemptsWrong;

    forcaGame() {
        setPossibleWords();
        attemptsWrong = new char[getAttemptsLeft()];
    }

    public String getWord() {
        return word;
    }

    private int getAttemptsLeft() {
        return attemptsLeft;
    }

    private int getAttemptsWrongLength() {
        return attemptsWrong.length;
    }

    public String getPossibleWords() {
        int x = (int) (Math.random() * 9);
        return possibleWords[x];
    }

    public String getAnswer() {
        return answer.toString();
    }

    public String getAttemptsWrong() {
        return new String(attemptsWrong);
    }

    public void setPossibleWords() {
        possibleWords[0] = "phone";
        possibleWords[1] = "baseball";
        possibleWords[2] = "message";
        possibleWords[3] = "garbage";
        possibleWords[4] = "reflection";
        possibleWords[5] = "song";
        possibleWords[6] = "organization";
        possibleWords[7] = "election";
        possibleWords[8] = "meal";
        possibleWords[9] = "son";
    }

    public void setWord() {
        word = getPossibleWords();
    }

    public void setAttemptsLeft(int attemptsLeft) {
        this.attemptsLeft = attemptsLeft;
    }

    public void start() {
        setWord();
        setAttemptsLeft(10);
        attemptsWrong = new char[getAttemptsLeft()];
        answer = new StringBuffer();
        for (int i = 0; i < this.word.length(); i++) {
            answer.append(CHAR);
        }
    }

    boolean right() {
        return word.equals(getAnswer());
    }

    boolean end() {
        return attemptsLeft == 0;
    }

    public boolean checkAttempt(char attempt) {
        int x = word.indexOf(attempt);
        if(x == -1) {
            addAttempt(attempt);
            return false;
        }
        else
            return true;
    }

    public boolean checkAttempt(String attempt) {
        String w = attempt.toUpperCase().trim();
        if(w.length() == getWord().length()) {
            if (word.compareTo(attempt) == 0)
                return true;
            else
                return false;
        }
        else
            return checkAttempt(w.charAt(0));
    }

    private void addAttempt(char attempt) {
        for (char i : attemptsWrong) {
            if(i == attempt)
                return ;
        }
    }

    public static void main(String[] args) {
        forcaGame fg = new forcaGame();
        return;
    }
}
