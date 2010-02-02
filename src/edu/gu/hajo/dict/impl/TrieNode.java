package edu.gu.hajo.dict.impl;

import java.util.ArrayList;
import java.util.HashMap; //?
import java.util.Hashtable;
import java.util.LinkedList;


/**
 * Nodes for the Trie. Each nodes' value is immutable.
 *
 * @author Kim Burgestrand
 */
public class TrieNode {
    private Character value = null;
    private TrieNode parent = null;
    private HashMap<Character, TrieNode> children = new HashMap();
    private ArrayList<TrieNode> connections = new ArrayList();

    /**
     * Create a root node.
     */
    public TrieNode() {}

    /**
     * Every node (except the root node) has a parent
     *
     * @param parent
     */
    private TrieNode(Character value, TrieNode parent)
    {
        this.value = value;
        this.parent = parent;
    }

    /**
     * Returns the string representation of a node.
     *
     * This method traverses upwards through the nodes' parents
     * to construct the final string value of this particular node.
     */
    @Override
    public String toString()
    {
        String string = value() == null ? "" : value().toString();
        return parent == null ? string // direct subnode of root
                              : parent.toString().concat(string);
    }

    /**
     * Getter for nodes' value
     *
     * @return Null for the root node
     */
    public Character value()
    {
        return value;
    }

    /**
     * Connect a node to add a translation from this node to the other.
     *
     * Note: will not add the same element twice
     *
     * @param node
     */
    public boolean connect(TrieNode node)
    {
        if ( ! connections.contains(node))
        {
            return connections.add(node);
        }

        return false;
    }

    /**
     * Retrieves all connections this node has to any other nodes.
     *
     * @return ArrayList<TrieNode> all connections
     */
    public TrieNode[] connections()
    {
        return connections.toArray(new TrieNode[0]);
    }

    /**
     * Retrieves the child node with the specified character.
     *
     * @param Character
     * @return TrieNode Returns null if the node does not exist.
     */
    public TrieNode get(Character chr)
    {
        return children.get(chr);
    }

    /**
     * Adds a child node, but only if it does not exist already
     *
     * @param Character
     * @return TrieNode The node that was added.
     */
    public TrieNode add(Character chr)
    {
        TrieNode node = get(chr);
        if (node == null)
        {
            node = new TrieNode(chr, this);
            children.put(chr, node);
        }
        return node;
    }

    /**
     * Comparison of one TrieNode to another.
     *
     * Note to self: isn’t this the default for object?
     *
     * @param TrieNode
     * @return Boolean
     */
    public boolean equals(TrieNode node)
    {
        return this == node;
    }

    /**
     * Returns true if the TrieNode contains the specified character.
     *
     * @param Character
     * @return Boolean
     */
    public boolean equals(Character chr) // char?
    {
        return chr.equals(value());
    }

    /**
     * Retrieves this nodes’ parent.
     *
     * @return parent
     */
    public TrieNode parent()
    {
        return parent;
    }

    /**
     * Flatten the tree, returning all nodes descendant from this node.
     *
     * Note: this node is the first among the results
     *
     * @return a flattened tree
     */
    public TrieNode[] flatten()
    {
        ArrayList<TrieNode> nodes = new ArrayList<TrieNode>();
        nodes.add(this);
        for (TrieNode child : children.values())
        {
            for (TrieNode node : child.flatten())
            {
                nodes.add(node);
            }
        }
        return nodes.toArray(new TrieNode[0]);
    }
}
