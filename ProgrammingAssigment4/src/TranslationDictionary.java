
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author clisk
 */
public class TranslationDictionary extends Dictionary {
    
    private ArrayList<String> wordBank1 = new ArrayList<String>();
    private ArrayList<String> wordBank2 = new ArrayList<String>();

    public TranslationDictionary(ArrayList<String> wordBank1, ArrayList<String> wordBank2)
    {
        this.wordBank1 = wordBank1;
        this.wordBank2 = wordBank2;
    }
    
    // Returns true if the lookup string is in the base language
    // and false if it is in a foreign language
    
    public boolean baseLanguage (String lookup)
    {
        return (wordBank1.contains(lookup));
    }
            
    @Override
    public int size() {
        return wordBank1.size(); 
    }

    @Override
    public boolean isEmpty() {
        return (wordBank1.isEmpty() && wordBank2.isEmpty());
    }

    @Override
    public Enumeration keys() {
        System.out.println("Function not supported yet");
        return null;
    }

    @Override
    public Enumeration elements() {
        System.out.println("Function not supported yet");
        return null;
    }

    @Override
    public Object get(Object key) {
        if (wordBank1.contains(key + ""))
        {
            int index = wordBank1.indexOf(key);
            return wordBank2.get(index);
        } else 
        {
            System.out.println("Couldn't find the value");
            return null;
        }
    }
    
    public Object getKey(Object value)
    {
        if (wordBank2.contains(value + ""))
        {
            int index = wordBank2.indexOf(value);
            return wordBank1.get(index);
        } else 
        {
            System.out.println("Coudln't find the key");
            return null;
        }
    }

    @Override
    public Object put(Object key, Object value) {
        wordBank1.add(key + "");
        wordBank2.add(value + "");
        return null;
    }

    @Override
    public Object remove(Object key) {
        int index = wordBank1.indexOf(key);
        wordBank1.remove(key + "");
        wordBank2.remove(wordBank2.get(index));
        return key;
    }
    
    public Object removeValue(Object value)
    {
        int index = wordBank2.indexOf(value);
        wordBank1.remove(wordBank1.get(index));
        wordBank2.remove(value + "");
        return value;
    }
    
    public String toString()
    {
        String aux = "";
        for (String s : wordBank1)
        {
            aux = aux.concat(s + " ");
        }
        for (String s : wordBank2)
        {
            aux = aux.concat(s + " ");
        }
        return aux;
    }
}
