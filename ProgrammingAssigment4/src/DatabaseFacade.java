/**
 * @author Cody Liske
 */
public class DatabaseFacade {
    
    private static Dictionaries database = new Dictionaries();
    private static RandomGen generator = new RandomGen();
    
    public static String translateEnglishSpanish(String toTranslate)
    {
        return database.getSpanishDictionary().get(toTranslate) + "";
    }
    
    public static String translateSpanishEnglish(String toTranslate)
    {
        System.out.println(toTranslate);
        System.out.println(database.getSpanishDictionary().getKey(toTranslate));
        return database.getSpanishDictionary().getKey(toTranslate) + "";
    }
    
    public static String translateEnglishGerman(String toTranslate)
    {
        return database.getGermanDictionary().get(toTranslate) + "";
    }
    
    public static String translateGermanEnglish(String toTranslate)
    {
        return database.getGermanDictionary().getKey(toTranslate) + "";
    }
    
    public static String translateEnglishItalian(String toTranslate)
    {
        return database.getItalianDictionary().get(toTranslate) + "";
    }
    
    public static String translateItalianEnglish(String toTranslate)
    {
        return database.getItalianDictionary().getKey(toTranslate) + "";
    }
    
    public static String getEnglishWord()
    {
        setUpRandomGen();
        return database.getConstructor().getEnglish().get(generator.getRandomI());
    }
    
    public static String getSpanishWord()
    {
        setUpRandomGen();
        return database.getConstructor().getSpanish().get(generator.getRandomI());
    }
    
    public static String getGermanWord()
    {
        setUpRandomGen();
        return database.getConstructor().getGerman().get(generator.getRandomI());
    }
    
    public static String getItalianWord()
    {
        setUpRandomGen();
        return database.getConstructor().getItalian().get(generator.getRandomI());
    }
    
    public static int getDatabaseSize()
    {
        return database.getConstructor().getEnglish().size();
    }
    
    private static void setUpRandomGen()
    {
        generator.setHighBound(database.getConstructor().getEnglish().size() - 1);
        generator.setLowBound(0);
    }
}
