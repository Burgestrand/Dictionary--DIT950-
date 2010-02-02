/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.gu.hajo.dict.impl;

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
public class TrieNodeTest {

    public TrieNodeTest() {
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
     * Test of toString method, of class TrieNode.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        TrieNode instance = new TrieNode();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of value method, of class TrieNode.
     */
    @Test
    public void testValue() {
        System.out.println("value");
        TrieNode instance = new TrieNode();
        Character expResult = null;
        Character result = instance.value();
        assertEquals(expResult, result);
    }

    /**
     * Test of connect method, of class TrieNode.
     */
    @Test
    public void testConnect() {
        System.out.println("connect");
        TrieNode node = new TrieNode();
        TrieNode instance = new TrieNode();
        boolean expResult = true;
        boolean result = instance.connect(node);
        assertEquals(expResult, result);
        result = instance.connect(node);
        assertEquals(false, result);
    }

    /**
     * Test of add method, of class TrieNode.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Character chr = 'C';
        TrieNode instance = new TrieNode();
        TrieNode result = instance.add(chr);
        TrieNode expResult = instance.get(chr);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of get method, of class TrieNode.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        Character chr = 'C';
        TrieNode instance = new TrieNode();
        TrieNode expResult = null;
        TrieNode result = instance.get(chr);
        assertEquals(expResult, result);

        TrieNode node = instance.add(chr);
        TrieNode nodf = instance.get(chr);
        assertNotNull(node);
        assertNotNull(nodf);
        assertEquals(node, nodf);
    }
}