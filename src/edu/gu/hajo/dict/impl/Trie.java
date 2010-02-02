package edu.gu.hajo.dict.impl;

import java.io.DataInput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;


/**
 * A Trie, see http://en.wikipedia.org/wiki/Trie
 * Helper class for the dictionary
 * @author Kim Burgestrand
 */
public class Trie
{
    /**
     * The root node has no value, only children.
     */
    private TrieNode root;

    public Trie()
    {
        root = new TrieNode();
    }

    /**
     * Add a string to the Trie
     *
     * @param String
     * @return TrieNode
     */
    public TrieNode add(String string)
    {
        TrieNode node = root;
        for (Character chr : string.toCharArray())
        {
            node = node.add(chr);
        }
        return node;
    }

    /**
     * Retrieves the asked-for TrieNode. It does this by
     * traversing the node tree, character by character.
     *
     * @param String
     * @return TrieNode Null if it does not exist
     */
    public TrieNode get(String string)
    {
        TrieNode node = root;
        for (Character chr : string.toCharArray())
        {
            node = node.get(chr);
            if (node == null)
            {
                break;
            }
        }
        
        return node;
    }

    /**
     * Returns true if the Trie contains the given string. See @get@
     *
     * @param String
     * @return Boolean
     */
    public boolean contains(String string)
    {
        return get(string) != null;
    }
}
