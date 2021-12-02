/**
 *
 * @author Cody Liske
 */
public class Translator {
    
    private Dictionaries database;
    
    public String translate(Languages beginLanguage, Languages targetLanguage, String toTranslate, boolean reverseFlag)
    {
        database = new Dictionaries();
        toTranslate = toTranslate.toUpperCase();
        switch (beginLanguage)
        {
            case ENGLISH:
                switch (targetLanguage)
                {
                    case SPANISH:
                        if (database.getSpanishDictionary().baseLanguage(toTranslate))
                        {
                            return DatabaseFacade.translateEnglishSpanish(toTranslate);
                            
                        }                            
                        else return DatabaseFacade.translateSpanishEnglish(toTranslate);
                    case GERMAN:
                        if (database.getGermanDictionary().baseLanguage(toTranslate))
                            return DatabaseFacade.translateEnglishGerman(toTranslate);
                        else return DatabaseFacade.translateGermanEnglish(toTranslate);
                    case ITALIAN:
                        if (database.getItalianDictionary().baseLanguage(toTranslate))
                            return DatabaseFacade.translateEnglishItalian(toTranslate);
                        else return DatabaseFacade.translateItalianEnglish(toTranslate);
                    default:
                        System.out.println("The beginning language is not defined");
                        break;
                }
                break;
            case SPANISH:
                switch (targetLanguage)
                {
                    case ENGLISH:
                        if (reverseFlag)
                            return DatabaseFacade.translateSpanishEnglish(toTranslate);
                        else return DatabaseFacade.translateEnglishSpanish(toTranslate);
                    case GERMAN:
                        
                        break;
                    case ITALIAN:
                        
                        break;
                    default:
                        System.out.println("The beginning language is not defined");
                        break;
                }
                break;
            case ITALIAN:
                switch (targetLanguage)
                {
                    case SPANISH:
                        
                        break;
                    case GERMAN:
                        
                        break;
                    case ENGLISH:
                        return DatabaseFacade.translateItalianEnglish(toTranslate);
                    default:
                        System.out.println("The beginning language is not defined");
                        break;
                }
                break;
            case GERMAN:
                switch (targetLanguage)
                {
                    case SPANISH:
                        
                        break;
                    case ENGLISH:
                        return DatabaseFacade.translateGermanEnglish(toTranslate);
                    case ITALIAN:
                        
                        break;
                    default:
                        System.out.println("The beginning language is not defined");
                        break;
                }
                break;
            default:
                System.out.println("The target language is not defined");
                break;
        }
        return null;
    }
}
