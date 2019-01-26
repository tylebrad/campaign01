package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.List;

public class SinglyLinkedList<E> implements List<E> {

    /**
     *Class to create Nodes for SinglyLinkedList
     *Nested Within SinglyLinkedList
     */
    public static class Node<E>{
        // declaring variables
        public E data;
        public Node<E> next;
        public Node<E> prev;

        // Node constructor
        public Node(E d, Node<E> n){
            this.data = d;
            this.next = n;
        }

        // gets data from node
        public E getData(){
            return data;
        }

        public void setData(E data) {this.data = data;}
        // returning next node
        public Node<E> getNext(){
            return next;
        }
        // setting data to next node
        public void setNext(Node<E> next){
            this.next = next;
        }
        public Node<E> getPrev(){return prev;}
        public void setPrev(Node<E> prev){
            this.prev = prev;
        }
    }

    //Instance variables for SinglyLinked List
    public Node<E> head = null;
    public Node<E> tail = null;
    public int size = 0;
    //Creation of empty list
    public SinglyLinkedList(){}

    /**Access methods using getData to return desired Node Data*/
    //First
    @Override
    public E first() {
        if(isEmpty()) return null;
        return head.getData();
    }
    //Last
    @Override
    public E last() {
        if(isEmpty()) return null;
        return tail.getData();
    }

    /**
     * Identifies the 0-based index of the given item in the list. If the item does
     * not exist in the list or is null, then returns -1.
     *
     * @param item Item to search for
     * @return 0 based index of the provided item
     */
    @Override
    public int indexOf(E item){
        return 0;
    }
    /** Update Methods */

    /**
     * Adds the provided element to the front of the list, only if the element
     * is not null.
     *
     * @param item Item to be added to the front of the list.
     */
    @Override
    public void addFirst(E item) {
        if (item == null)
            return;
        Node<E> newNode = new Node<>(item, head);
        newNode.setNext(head);
        if (isEmpty())
            tail = newNode;
        head = newNode;
        size ++;
    }
    /**
     * Adds the provided element to the end of the list, only if the element is
     * not null.
     *
     * @param item Item to be added to the end of the list.
     */
    @Override
    public void addLast(E item) {
        if (item == null)
            return;
        Node<E> newNode = new Node<>(item, null); //creates newNode pointing to null
        if(isEmpty())//if the list is empty, head becomes the first and only item in the list.
            head = newNode;

        else
            this.tail.setNext(newNode); // otherwise, we grab the current tail, and set it's next to the new node
        this.tail = newNode;
        size ++;
    }


    // removes first item from the list, unless the list is empty
    // decrements size by 1
    @Override
    public E removeFirst() {
        if (isEmpty())
            return null;
        E answer = head.getData();
        head = head.getNext();
        size--;
        if (size == 0)
            tail = null;
        return answer;
    }
    //Removes last item from the list, unless list is empty
    //Decrements size by 1
    @Override
    public E removeLast() {
        if (isEmpty())
            return null;
        E answer = tail.getData();
        tail = tail.getPrev();
        size --;
        return answer;
    }
    /**
     * Retrieves the value at the specified index. Will return null if the index
     * provided is less than 0 or greater than or equal to the current size of
     * the list.
     *
     * @param index Index of the value to be retrieved.
     * @return Element at the given index, or null if the index is less than 0
     * or greater than or equal to the list size.
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size)
            return null;

        Node<E> current = head;
        for (int i = 0; i < index; i++)
            current = current.getNext();

        Node<E> toHold = current;
        return toHold.getData();
    }
    // Removes a node at a given index of the list, unless index given is below 0,
    // or below the size of the list
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size)
            return null;

        Node<E> current = head;
        for (int i = 0; i < index - 1; i++)
            current = current.getNext();

        Node<E> toRemove = current.getNext();
        current.setNext(toRemove.getNext());
        toRemove.setNext(null);
        size --;
        return toRemove.getData();
    }
    // returns size variable (number of variables in the list)
    @Override
    public int size() {
        return size;
    }

    /**
     * @return true if there are no items currently stored in the list, false
     * otherwise.
     */
    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    /**
     * Inserts the given element into the list at the provided index. The
     * element will not be inserted if either the element provided is null or if
     * the index provided is less than 0. If the index is greater than or equal
     * to the current size of the list, the item will be added to the end of
     * the list.
     *
     * @param item Item to be added (as long as it is not null).
     * @param index Index in the list where the element is to be inserted.
     */
    @Override
    public void insert(E item, int index) {
        Node<E> newInsert = new Node<>(item, null); // declaring variable for new Insert
        Node<E> current = this.head;
        if(item == null || index < 0) // returns nothing if item is null or index is less than 0
            return;

        if(index >= this.size()) { //Inserts to end of the list if index>size
            this.tail.setNext(newInsert); // sets current tails next to newInsert
            this.tail = newInsert; // sets newInsert as new tail

        }
        else
            // setting head to current, and Climbing
            for (int i = 0; i < index - 1; i++)
                current = current.getNext();
        Node<E> newTemp = current.getNext(); // holding data previously stored at index
        current.setNext(newInsert); // setting index previous to desired location's TAIL to a new node
        newInsert.setNext(newTemp); // setting newInsert's tail to new temp
        size ++;
    }

    /**
     * Prints the contents of the list in a single line separating each element
     * by a space to the default System.out
     */
    @Override
    public void printList(){
        if(isEmpty())
            return;
        Node<E> current = this.head;
        // while loop that prints each item in a list with a line separator
        // UNTIL an item in the list is null
        while (current != null) {
            System.out.print(current.data + System.lineSeparator());
            current = current.getNext();
        }

    }


}




