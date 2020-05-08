package Ex4;
import java.util.*;

public class Dictionary {
    Map<String, Map<String, String>> dicts;
    private String language;
    Map<String,String> dic;

    Dictionary() {
        dicts = new HashMap<>();
        language = "ingles";
        dic = new HashMap<String, String>();
    }

    public void add(String language, String word, String translation) {
        Map<String, String> d = dicts.get(language.trim().toLowerCase());
        if(d == null){
            d = new HashMap<>();
            dicts.put(language.trim().toLowerCase(), d);
        }
        dic.put(word.trim().toUpperCase(), translation.trim().toLowerCase());
    }

    public void defineLanguage(String language) {
        Map<String, String> dic = dicts.get(language.trim().toLowerCase());
        if(dic == null)
            return;
        this.dic = dic;
    }

    public String get(String word) {
        if(dic == null)
            return null;
        return dic.get(word.trim().toUpperCase());
    }

    public String get(String language, String word) {
        Map<String, String> d = dicts.get(language.trim().toLowerCase());
        if(d == null)
            return null;
        return d.get(word.trim().toUpperCase());
    }
}
