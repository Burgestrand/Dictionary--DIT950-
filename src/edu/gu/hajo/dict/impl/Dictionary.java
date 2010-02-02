package edu.gu.hajo.dict.impl;

import edu.gu.hajo.dict.*;
import edu.gu.hajo.dict.exception.DictionaryException;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Implementation of the dictionary as a Bean 
 * Uses Trie as helper class
 */
public class Dictionary implements IDictionary {
    // We operate on the tree, so we must have it! D:
    private Trie tree;

   /**
    * Load a given dictionary using the dictionaryloader provided.
    *
    * @param from
    * @param to
    * @param IDictionaryLoader
    * @throws DictionaryException
    * @return Dictionary
    */
   public static Dictionary factory(LanguageName from
                                   ,LanguageName to
                                   ,IDictionaryLoader loader)
                                   throws DictionaryException
   {
       Map<String, String[]> dict = loader.loadDictionary(from, to);

       // Word Trie; need only one… why use two?
       Trie tree = new Trie();

       // Construct the complete tree
       TrieNode origin;
       for (Entry<String, String[]> entry : dict.entrySet())
       {
           origin = tree.add(entry.getKey());

           // Add translations and connect the nodes
           String[] targets = entry.getValue();
           for (String target : targets)
           {
               origin.connect(tree.add(target));
           }
       }

       return new Dictionary(tree);
   }

   /**
    * Wraps a tree in a dictionary!
    */
   private Dictionary(Trie tree)
   {
       this.tree = tree;
   }

   /**
    * Search the dictionary for any word matching the input
    *
    * @param String
    * @return all matches
    */
   public TreeMap<String, String[]> search(String search)
   {
       TreeMap<String, String[]> results = new TreeMap<String, String[]>();
       TrieNode root = tree.get(search);

       if (root != null)
       {
           // Iterate through all children, and their children… and
           for (TrieNode node : root.flatten())
           {
               if (node.connections().length >= 1)
               {
                   String[] connections = new String[node.connections().length];
                   int i = 0;
                   for (TrieNode t : node.connections())
                   {
                       connections[i++] = t.toString();
                   }
                   results.put(node.toString(), connections);
               }
           }
       }

       return results;
   }
}
