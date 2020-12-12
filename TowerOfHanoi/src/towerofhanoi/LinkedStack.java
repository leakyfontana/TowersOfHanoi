package towerofhanoi;

import java.util.EmptyStackException;
import stack.StackInterface;

/**
 * Virginia Tech Honor Code Pledge:
 * 
 * As a Hokie, I will conduct myself with honor and 
 * integrity at all times. I will not lie, cheat, or 
 * steal, nor will I accept the actions of those who do.
 * -- Xander Dyer (xdyer)
 * 
 * Implements a Node private class and methods for a
 * LinkedStack from an Interface.
 * 
 * @author Xander Dyer (xdyer)
 * @version 2020.07.31
 *
 *@param <T> generic for Linked Stack
 */
public class LinkedStack<T> implements StackInterface<T> {
    
    private Node<T> topNode;
    private int size;

    /**
     * Constructor for a Linked Stack.
     * Initializes topNode as null and size as 0
     */
    public LinkedStack()
    {
        topNode = null;
        this.size = 0;
    }
    
    /**
     * Returns the size of a Linked Stack
     * @return size field
     */
    public int size()
    {
        return this.size;
    }
    
    /**
     * Clears a Linked Stack of all nodes
     */
    @Override
    public void clear() 
    {
        while (!this.isEmpty())
        {
            this.pop();
        }
        
    }

    /**
     * Checks to see if a Linked Stack is empty.
     * @return true if empty, false if it is not
     */
    @Override
    public boolean isEmpty() 
    {
        return topNode == null;
    }
    
    /**
     * Returns the contents of a linked stack in the
     * form of a string
     * @return string of entries
     */
    public String toString()
    {
        StringBuilder contents = new StringBuilder("[");
        Node<T> countNode = topNode;
        for (int i = 0; i < this.size; i++)
        {
            contents.append(countNode.data);
            countNode = countNode.getNextNode();
            if (i != this.size - 1)
            {
                contents.append(", ");
            }
        }
        contents.append("]");
        return contents.toString();
    }

    /**
     * Returns the top node of a Linked Stack
     * @return data of top node
     */
    @Override
    public T peek() 
    {
        if (this.isEmpty())
        {
            throw new EmptyStackException();
        }
        return topNode.data;
    }

    /**
     * Removes the top node from a Linked Stack
     * @return top node
     */
    @Override
    public T pop() 
    {
        if (this.isEmpty())
        {
            throw new EmptyStackException();
        }
        T temp = topNode.data;
        topNode = topNode.next;
        size--;
        return temp;
    }

    /**
     * Adds a node to the top of a Linked Stack
     * @param anEntry node to be added
     */
    @Override
    public void push(T anEntry) 
    {
        Node<T> newNode = new Node<T>(anEntry, topNode);
        topNode = newNode;
        size++;  
    }
    

    /**
     * Implements a new type of Node specific to this 
     * program.
     * 
     * @author Xander Dyer (xdyer)
     * @version 2020.07.31
     *
     * @param <T> an Object
     */
    @SuppressWarnings("hiding")
    private class Node<T>
    {
        private Node<T> next;
        private T data;
        
        /**
         * Constructor for node
         */
        public Node(T data)
        {
            this.data = data;
        }
        /**
         * Constructor with next
         * @param data to be stored
         * @param link to next node
         */
        public Node(T data, Node<T> link)
        {
            this.data = data;
            this.next = link;
        }
        
        /**
         * Getter for next node
         * @return next node
         */
        public Node<T> getNextNode()
        {
            return this.next;
        }
        /**
         * Getter for data
         * @return data
         */
        public T getData()
        {
            return this.data;
        }
        
        /**
         * Setter for next node
         * @param node to be linked
         */
        public void setNextNode(Node<T> node)
        {
            this.next = node;
        }
        
    }
    

}
