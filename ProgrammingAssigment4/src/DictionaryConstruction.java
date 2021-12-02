/**
 * @author Cody Liske
 */
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryConstruction {
    
    private ArrayList<String> English, Spanish, German, Italian;
    
    public DictionaryConstruction ()
    {
        Extraction extraction = new Extraction();
        English = extraction.English();
        Spanish = extraction.Spanish();
        German = extraction.German();
        Italian = extraction.Italian();
    }
    
    public ArrayList<String> getEnglish()
    {
        return English;
    }
    
    public ArrayList<String> getSpanish()
    {
        return Spanish;
    }
    
    public ArrayList<String> getGerman()
    {
        return German;
    }
    
    public ArrayList<String> getItalian()
    {
        return Italian;
    }
    
    public void setEnglish(ArrayList<String> words)
    {
        this.English = words;
    }
    
    public void setSpanish(ArrayList<String> words)
    {
        this.Spanish = words;
    }
    
    public void setGerman(ArrayList<String> words)
    {
        this.German = words;
    }
    
    public void setItalian(ArrayList<String> words)
    {
        this.Italian = words;
    }
    
    private class Extraction
    {
        private ArrayList<String> words;
        private FileIO IO;
        Scanner fileScnr;
        
        public Extraction()
        {
            words = new ArrayList<String>();
            
        }
        
        public ArrayList<String> English()
        {
            words = new ArrayList<String>();
            IO = new FileIO("English.txt");
            fileScnr = IO.openFileForReading();
            while (fileScnr.hasNext())
            {
                words.add(fileScnr.nextLine().toUpperCase());
            }
            return words;
        }
        
        public ArrayList<String> Spanish()
        {
            words = new ArrayList<String>();
            IO = new FileIO("Spanish.txt");
            fileScnr = IO.openFileForReading();
            while (fileScnr.hasNext())
            {
                words.add(fileScnr.nextLine().toUpperCase());
            }
            return words;
        }
        
        public ArrayList<String> German()
        {
            words = new ArrayList<String>();
            IO = new FileIO("German.txt");
            fileScnr = IO.openFileForReading();
            while (fileScnr.hasNext())
            {
                words.add(fileScnr.nextLine().toUpperCase());
            }
            return words;
        }
        
        public ArrayList<String> Italian()
        {
            words = new ArrayList<String>();
            IO = new FileIO("Italian.txt");
            fileScnr = IO.openFileForReading();
            while (fileScnr.hasNext())
            {
                words.add(getWord().toUpperCase());
            }
            return words;
        }
        
        private String getWord()
        {
            String aux = null;
            if (fileScnr.hasNext())
            {
                aux = fileScnr.nextLine();
            } else return null;
            return aux;
        }
    }
}
