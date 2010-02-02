/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package se.burgestrand.dit950;

import edu.gu.hajo.dict.LanguageName;
import edu.gu.hajo.dict.exception.DictionaryException;
import edu.gu.hajo.dict.impl.Dictionary;
import edu.gu.hajo.dict.loader.DictionaryFileLoader;
import java.util.Map.Entry;

/**
 *
 * @author Kim
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws DictionaryException {
        Dictionary test = Dictionary.factory(LanguageName.sv_SE, LanguageName.en_US, new DictionaryFileLoader());
        for (Entry<String, String[]> entry : test.search("p").entrySet())
        {
            System.out.println(entry.getKey().toString() + ":" + entry.getValue().toString());
        }
    }

}
