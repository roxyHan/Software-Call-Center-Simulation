public class Queue<E>{

    // Instance element:  all we need is a front reference!
    private Node<E> front;
    private Node<E> end;
    
    /**
     * Creates a queue
     */
    public Queue() {
        front = null;
    }

    //------------------------------------------------
    //                  Public Methods
    //------------------------------------------------
    
    /**
     * Adds an element to the queue
     * 
     * @param   element     an element
     */
    public void add(E element) {
        addAtEnd(element);    
    }
    
    /**
     * Removes an element from the queue
     *  
     * @param   element     an element
     * @return  whether or not the element has been removed
     */
    public boolean remove(E element){
        boolean wasRemoved = false;
        if (front == null) {
            
        } else if (front.element.equals(element)) {
            front = front.next;
            wasRemoved = true;
        } else {
            // Look for the element to remove
            Node<E> current = front;
            while (current.next != null && !(current.next.element.equals(element))) {
                current = current.next;
            }
            // We either found it or reached the end
            if (current.next != null && current.next.element.equals(element)) {
                current.next = current.next.next;
                wasRemoved = true;
            } else {
                // do nothing; element not found
            }
        }
        return wasRemoved;
    }
    
    /**
     * 
     */
    public E peek() {
        if (isEmpty()) {
            throw new IllegalArgumentException("The queue is empty!");
        }
        return front.element;
    }
    
    /**
     * Checks if the queue is empty
     * 
     * @return whether or not the queue is empty
     */
    public boolean isEmpty() {
        if (size() == 0 ) {
            return true;
        } 
        return false;
    }
    
    /**
     * Clears the queue
     */
    public void clear() {
        front = null;
        end = null;
    }
    
    /**
     * Determines the size of queue
     * 
     * @return  the number of elements in the queue
     */
    public int size() {
        int nodeCount = 0;
        if (front != null) {
            Node<E> current = front;
            nodeCount++;
            while (current.next != null) {
                nodeCount++;
                current = current.next;
            }
        }
        return nodeCount;
    }

    //-------------------------------------------
    //              Private Methods
    //-------------------------------------------
    
    /**
     * 
     */
    private void addAtFront(E element) {
        Node<E> newNode = new Node<E>(element);
        newNode.next = front;
        front = newNode;
    }

    /**
     * 
     */
    private void addAtEnd(E element) {
        Node<E> newNode = new Node<E>(element);
        if (front == null) {
            // tmpty list; goes at front
            addAtFront(element);
        } else {
            // Find the end, add it there
            Node<E> current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    
    // /**
     // * Gets the index of a given element
     // * 
     // * @param   anElement
     // * @return  the index of the given element
     // */
    // /// REMEMBER TO IMPLEMENT THE EQUALS METHOD IN ORDER TO
    // //  CHECK THAT EVERY VARIABLE IS THE SAME AS THOSE OF THE OTHER 
    // //  ELEMENT
    // private int indexOf(E anElement) {
        // int index = 0 ;
        // Node<E> current = front.next ;
        // while (current != null) {
            // if (current.element.equals(anElement)) {
                // return index ;
            // }
            // index++;
            // current = current.next ;          
        // }
        // return -1 ;
    // }

    // /**
     // * Checks whether or not the list contains a given element
     // * 
     // * @param    anElement  
     // * @return   whether or not the list contains the given element
     // */
    // public boolean contains(E anElement) {
        // return ((indexOf(anElement)) >= 0 ? true : false) ;
    // }


    @Override
    public String toString() {
        String listOutput = "List contents ";
        if (front == null) {
            listOutput += "(empty list)";
        } else {
            listOutput += "(" + size() + " nodes):\n";
            Node<E> current = front;
            listOutput += current;
            while (current.next != null) {
                current = current.next;
                listOutput += current;
            }
        }
        return listOutput;
    }

}
