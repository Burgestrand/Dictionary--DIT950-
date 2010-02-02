/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.gu.hajo.dict.impl;

import java.util.ArrayList;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kim Burgestrand
 */
public class TrieTest {

    public TrieTest() {
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
     * Test of addAll method, of class Trie.
     */
    @Test
    public void testAddAll() {
        System.out.println("addAll");

        // Words to add
        Collection<String> lines = new ArrayList();
        lines.add("Hej");
        lines.add("Hejsan");
        lines.add("Hopp");
        lines.add("Muu");

        Trie instance = new Trie();
        instance.add(lines);

        // Make sure all lines are added
        for (String line : lines)
        {
            assertEquals("Does not contain " + line, true, instance.contains(line));
        }
    }

    @Test
    public void testAdd()
    {
        System.out.println("add");

        Trie instance = new Trie();
        TrieNode j1 = instance.add("Hej");
        TrieNode j2 = instance.add("Hejsan").parent().parent().parent(); // j-node
        TrieNode j3 = instance.add("Hoj");

        assertSame("Duplicate nodes in tree", j1, j2);
        assertTrue("Invalid nodes in tree", ! (j1 == j3));
        assertSame("Duplicate nodes in tree", instance.get("H"), j3.parent().parent());
    }

    /**
     * Test of get method, of class Trie.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        String string = "C";
        Trie instance = new Trie();
        TrieNode expResult = instance.add(string);
        TrieNode result = instance.get(string);
        assertEquals(expResult, result);
    }

    /**
     * Test of contains method, of class Trie.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        String string = "";
        Trie instance = new Trie();
        boolean expResult = true;
        boolean result = instance.contains(string);
        assertEquals(expResult, result);
    }

}