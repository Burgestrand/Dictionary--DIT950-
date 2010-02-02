package edu.gu.hajo.dict;

import java.util.Map;

import edu.gu.hajo.dict.exception.DictionaryException;

/**
 * Interface for a loader, a class the dictionary can use to load
 * word lists.
 * @author hajo
 *
 */
public interface IDictionaryLoader {
   /**
    * 
    * @param from, The from language
    * @param to, The to language
    * @return A map where key is a word from the from-language and
    *         the value is an array of translations of the key.
    * @throws DictionaryException
    */
   public Map<String, String[]> loadDictionary(LanguageName from, LanguageName to)
                                                            throws DictionaryException;
}
