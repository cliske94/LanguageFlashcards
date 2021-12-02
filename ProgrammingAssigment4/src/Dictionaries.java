/**
 * @author Cody Liske
 */
import java.util.ArrayList;

public class Dictionaries {
    
    private TranslationDictionary englishToSpanish;
    private TranslationDictionary englishToGerman;
    private TranslationDictionary englishToItalian;
    private DictionaryConstruction constructor;
    
    public Dictionaries()
    {
        constructor = new DictionaryConstruction();
        englishToSpanish = new TranslationDictionary(constructor.getEnglish(), constructor.getSpanish());
        englishToGerman = new TranslationDictionary(constructor.getEnglish(), constructor.getGerman());
        englishToItalian = new TranslationDictionary(constructor.getEnglish(), constructor.getItalian());
//        this.setGerman(constructor.getEnglish(), constructor.getGerman());
//        this.setSpanish(constructor.getEnglish(), constructor.getSpanish());
//        this.setItalian(constructor.getEnglish(), constructor.getItalian());
    }
    
    private void setSpanish(ArrayList<String> english, ArrayList<String> spanish)
    {
        for (int i = 0; i < english.size(); i++)
        {
            englishToSpanish.put(english.get(i), spanish.get(i));
        }
    }
    
    private void setGerman(ArrayList<String> english, ArrayList<String> german)
    {
        for (int i = 0; i < english.size(); i++)
        {
            englishToGerman.put(english.get(i), german.get(i));
        }
    }
    
    private void setItalian(ArrayList<String> english, ArrayList<String> italian)
    {
        for (String s : english)
        {
            englishToItalian.put(s, italian.get(english.indexOf(s)));
        }
    }
    
    public TranslationDictionary getSpanishDictionary()
    {
        return englishToSpanish;
    }
    
    public TranslationDictionary getGermanDictionary()
    {
        return englishToGerman;
    }
    
    public TranslationDictionary getItalianDictionary()
    {
        return englishToItalian;
    }
    
    public DictionaryConstruction getConstructor()
    {
        return constructor;
    }
    
    public String toString()
    {
        String aux = "";
        for (int i = 0; i < constructor.getEnglish().size(); i++)
        {
            aux = aux.concat(constructor.getEnglish().get(i));
        }
        return aux;
    }
}
