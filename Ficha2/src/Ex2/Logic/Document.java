package Ex2.Logic;

public class Document {
    static final String SEP_WORDS = " \t \n (),.?!|";
    static final int MAX_AUTHORS = 10;
    static final int MAX_LINES = 10;
    String title;
    String [] authors;
    private int nAuthors = 0;
    String[] lines;
    private int nLines = 0;
    String text;

    public Document(String title) {
        this.title = title;
        authors = new String[MAX_AUTHORS];
    }

    public String getText() {
        return text;
    }

    public boolean addAuthor(String newAuthor) {
        if(nAuthors < 0 || nAuthors >= MAX_AUTHORS)
            return false;
        authors[nAuthors++] = newAuthor;
        return true;
    }

    @Override
    public String toString() {
        return title;
    }

    public int indexOf(String author) {
        for (int i = 0; i < authors.length; i++) {
            if(authors[i].equalsIgnoreCase(author)) {
                removeAuthor(i);
                return i;
            }
        }
        return -1;
    }

    public boolean removeAuthor(String author) {
        int pos = indexOf(author);
        if(pos < 0)
            return false;
        else {
            removeAuthor(pos);
            return true;
        }
    }

    public boolean removeAuthor(int index) {
        if(index < 0 || index >= nAuthors)
            return false;
        for (int i = index; i < authors.length - 1; i++) {
            authors[i] = authors[i + 1];
        }
        authors[--nAuthors] = null;
        return true;
    }

    public int getNAuthors() {
        return nAuthors;
    }

    public void addLine() {
    }

    public int countWords() {
        int nWords = 0;
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            boolean isWord = true;
            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);
                //if(Character.isAlphabetic(c))
                if(isWord && SEP_WORDS.indexOf(c) >= 0)
                    isWord = false;
                else
                    if(!isWord && SEP_WORDS.indexOf(c) >= 0)
                        continue;
                    if(!isWord && SEP_WORDS.indexOf(c) < 0) {
                        nWords++;
                        isWord = true;
                    }
            }
        }
        return nWords;
    }

    public int countWords_Split() {
        int nWords = 0;
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            String[] s = line.split("[" + SEP_WORDS + "]");
            nWords += s.length;
        }
        return nWords;
    }

    public int countWords_Split(String word) {
        int nWords = 0;
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            String[] s = line.split("[" + SEP_WORDS + "]");
            for (String string : s) {
                if(string.equalsIgnoreCase(word))
                    nWords++;
            }
        }
        return nWords;
    }
}


