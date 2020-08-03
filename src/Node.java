/**
 * Write a description of class ElementNode here.
 *
 * @author Hanifa Barry
 * @version 2017-05-05
 */
public class Node<E> {
    
    //-----------------------------------------
    //               Data
    //-----------------------------------------
    
    public E element ;
    public Node<E> next ;
    public Node<E> previous ;
    
    //-----------------------------------------
    //               Constructor
    //-----------------------------------------
    
    /**
     * Creates an element node
     */
    public Node(E element) {
        this.element = element ;
        next         = null ;
        previous     = null ;
    }
    
    //-----------------------------------------
    //               Accessor(s)
    //-----------------------------------------
    
    /**
     * Creates a text description 
     * 
     * @return a text description
     */
    public String toString() {
        String description = this.element +"\n" ;
        description       += "next = " + next  + "\n";
        description       += "previous = "  + previous + "\n";
        return description ;
    }
}
