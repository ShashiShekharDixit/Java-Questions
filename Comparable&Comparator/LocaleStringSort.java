import java.util.*;
import java.text.Collator;
import java.util.Locale;

public class LocaleStringSort {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("papita", "apple", "sharbat", "banana", "parle-G");
        Collator collator = Collator.getInstance(Locale.FRENCH);
        collator.setStrength(Collator.PRIMARY); 
        words.sort(collator);
        System.out.println("Sorted words (Hindi locale, accents ignored): " + words);
        Collator usCollator = Collator.getInstance(Locale.US);
        usCollator.setStrength(Collator.PRIMARY);
        List<String> wordsUS = new ArrayList<>(words);
        wordsUS.sort(usCollator);
        System.out.println("Sorted words (US locale, accents ignored): " + wordsUS);
    }
}
