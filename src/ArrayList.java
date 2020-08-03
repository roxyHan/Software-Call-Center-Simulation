import java.util.Arrays ;
import java.util.Iterator ;
import java.util.NoSuchElementException;


/**
 * Write a description of interface ArrayList here.
 *
 * @author Hanifa Barry
 * @version 2017-04-22
 */
public class ArrayList<T> implements Iterable<T>{

    //-------------------------------------------
    //             INSTANCE DATA
    //-------------------------------------------

    private static final int DEFAULT_SIZE = 50 ;
    private int size ;
    private T[] elementData ;
 

    //-------------------------------------------
    //             CONSTRUCTOR
    //-------------------------------------------

    /**
    * Creates an arraylist of a not yet determined type
    */
    @SuppressWarnings("unchecked")
    public ArrayList(int capacity) {
        elementData = (T[]) new Object[capacity] ; 
        size = 0 ;
    }

    /**
     * Default constructor
     */
    public ArrayList() {
        this(DEFAULT_SIZE) ;
    }

    //---------------------------------------------
    //                 PUBLIC METHODS
    //---------------------------------------------

    /**
     *  Adds an element to the array
     *  @param     element
     *  @return    whether or not the element has been properly added
     */
    public boolean add(T type) {
        ensureCapacity(size + 1);
        elementData[size] = type ;
        size++;
        return true;
    }

    public void add(int index, T type) {
        // can't use checkIndex because size is legal in this case
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Invalid index specified; must be 0 <= index < size()");
        }
        ensureCapacity(size + 1);
        //for (int idx = size; idx >= index + 1; idx--) {
        for (int idx = size; idx > index; idx--) {
            elementData[idx] = elementData[idx - 1];
        }
        elementData[index] = type;
        size++;
    }

    public T remove(int index) {
        //checkIndex(index);
        T returnElement = elementData[index];
        for (int idx = index; idx < size - 1; idx++) {
            elementData[idx] = elementData[idx + 1];
        }
        size--;
        return returnElement;
    }

    public int size() {
        return size;
    }

    public int indexOf(T type) {
        for (int idx = 0; idx < size; idx++) {
            if (elementData[idx] == type) {
                return idx;
            }
        }
        return -1;
    }

    public boolean contains(T type) {
        return ((indexOf(type) >= 0) ? true : false);
    }

    public boolean isEmpty() {
        return ((size == 0) ? true : false);
    }

    public T get(int index) {
        //checkIndex(index);
        return elementData[index];
    }

    public T set(int index, T type) {
        //checkIndex(index);
        T returnElement = elementData[index];
        elementData[index] = type;
        return returnElement;
    }

    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            String result = "[" + elementData[0];
            for (int i = 1; i < size; i++) {
                result += ", " + elementData[i];
            }
            result += "]";
            return result;
        }
    }

    //---------------------------------------------------------------
    //      Private Methods
    //---------------------------------------------------------------
    // We assume that users will enter correct information or an invalid
    // index to stop the selection of parts.
    

    private void ensureCapacity(int desiredCapacity) {
        if (desiredCapacity > elementData.length) {
            int newCapacity = Math.max((elementData.length * 2) + 1, desiredCapacity);
            elementData = Arrays.copyOf(elementData, newCapacity);
            int x = 1;
        }
    }

    //----------------------------------------------------
    //                ITERATOR
    //----------------------------------------------------
    public Iterator<T> iterator() { 
        return new ArrayListIterator();
    }
    
    private class ArrayListIterator<E> implements Iterator<E> { 
        private int position;
        private boolean removeOK; 
    
        public ArrayListIterator() {
            position = 0; 
            removeOK = false; 
        }

        public boolean hasNext() {
            return position < size();
        }
        
        public E next() { 
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements"); 
            } 
            E result = (E) elementData[position]; 
            position++;
            removeOK = true; 
            return result;
        }
        
        public void remove() {
            if (!removeOK) {
                throw new IllegalStateException( "Attempted remove before next!");
            }
            ArrayList.this.remove(position - 1);
            position--;
            removeOK = false;
        }
    }

}