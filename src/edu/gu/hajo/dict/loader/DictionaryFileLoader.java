package edu.gu.hajo.dict.loader;

import java.util.Map;

import edu.gu.hajo.dict.IDictionaryLoader;
import edu.gu.hajo.dict.LanguageName;
import edu.gu.hajo.dict.exception.DictionaryException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * A file loader implementation of IDictionaryLoader File format is;
 * 
 * Row Row Row ...
 * 
 * Where Row is;
 * 
 * word=translation1, translation2,....translationN (\n)
 * 
 * File names must be: from2to.dict where from and to are country and region
 * codes for example sv_SV2en_US.dict
 * 
 * @author Kim Burgestrand
 * 
 */
public final class DictionaryFileLoader implements IDictionaryLoader {

	public static final String SEPARATOR_WORD = "=";
	public static final String SEPARATOR_TRANS = ",";
	public static final String FILE_SUFFIX = ".dict";
	private final String base = "/Users/Kim/Documents/Skolan/VT2010/Java/Lab 1.nb/dict/";
	
	@Override
	public Map<String, String[]> loadDictionary(LanguageName from,
                                                    LanguageName to)
                                                    throws DictionaryException {
		TreeMap<String, String[]> dictionary = new TreeMap<String, String[]>();
		String filename = base + from + "2" + to + FILE_SUFFIX;

                // Open file
                File file = new File(filename);
                Scanner scanner;
                try
                {
                    scanner = new Scanner(file);
                    try
                    {
                        // Iterate through all lines…
                        while (scanner.hasNextLine())
                        {
                            Scanner line = new Scanner(scanner.nextLine());
                            
                            try
                            {
                                // Find source word
                                String word = line.findInLine("\\A[^=]+");
                                line.skip("=");

                                // Find translations
                                ArrayList<String> translations = new ArrayList<String>();
                                line.useDelimiter(",");
                                while (line.hasNext())
                                {
                                    translations.add(line.next().trim());
                                }

                                // Add all to dictionary
                                dictionary.put(word, (String[]) translations.toArray(new String[0]));
                            }
                            catch (Exception e)
                            {
                                System.out.println("WARNING: " + e.getMessage() + " (" + line + ")");
                            }
                        }
                    }
                    finally
                    {
                        scanner.close();
                    }
                }
                catch (FileNotFoundException e)
                {
                    throw new DictionaryException(e.getMessage());
                }

                return dictionary;
	}

}
