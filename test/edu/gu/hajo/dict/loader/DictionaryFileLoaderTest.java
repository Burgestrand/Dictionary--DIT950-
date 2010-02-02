/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.gu.hajo.dict.loader;

import edu.gu.hajo.dict.LanguageName;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kim
 */
public class DictionaryFileLoaderTest {

    public DictionaryFileLoaderTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of loadDictionary method, of class DictionaryFileLoader.
     */
    @Test
    public void testLoadDictionary() throws Exception {
        System.out.println("loadDictionary");
        LanguageName from = LanguageName.sv_SE; // from sv_SV… no swedish in El Salvador!
        LanguageName to = LanguageName.en_US;
        DictionaryFileLoader instance = new DictionaryFileLoader();
        TreeMap<String, String[]> result = instance.loadDictionary(from, to);
        assertFalse("Dictionary is empty!", result.isEmpty());

        // Fördefinierat, vi vet att ordboken innehåller “personbil”
        assertNotNull("Personbil not in dictionary", result.get("personbil"));

        // Personbil har 4 (!) översättningar
        assertTrue("Personbil missing entries", result.get("personbil").length == 4);
    }

}