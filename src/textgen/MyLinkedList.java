package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		size = 0;
		head = new LLNode();
		tail = new LLNode();
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		/*
         LLNode newNode = new LLNode(element);
		
		// TODO: Implement this method
        LLNode previousNode = tail.prev;
        
        previousNode.next = newNode;
        newNode.prev = previousNode;
        newNode.next = tail;
        tail.prev = newNode;
        
        size ++; 
        */
		
		add(size, element);
        
        return true;       
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if(index > size - 1 || index < 0){
			throw new IndexOutOfBoundsException("index is out of bounds");
		}
		
		LLNode node = head.next;
		
		for (int i=1; i <= index; i++){		
			node = node.next;
		}
		
		return (E) node.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		if(element == null){
			throw new NullPointerException("cannot accept null element");
		}
		if(index > size || index < 0){
			throw new IndexOutOfBoundsException("index is out of bounds");
		}
		
		LLNode newNode = new LLNode(element);
		
		LLNode preNode = head;
		LLNode curNode = head.next;
		
		// TODO: Implement this method
		for (int i = 1; i<=index; i++){
			preNode = curNode;
			curNode = curNode.next;
		}
		
		preNode.next = newNode;
		newNode.prev = preNode;
		curNode.prev = newNode;
		newNode.next = curNode;
		
		size ++;	
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		if(size ==0){
			throw new IndexOutOfBoundsException("this is an empty list, nothing can be removed."); 
		}
		if(index < 0 || index > size - 1){
			throw new IndexOutOfBoundsException("index is out of bounds"); 
		}
		
		// TODO: Implement this method
		LLNode removedNode = head.next;
		LLNode preNode = head;
		LLNode nextNode = removedNode.next;
		
		for(int i = 1; i<=index; i++){
			removedNode = removedNode.next;
			preNode = removedNode.prev;
			nextNode = removedNode.next;
		}
		
		preNode.next = nextNode;
		nextNode.prev = preNode;
				
		size --; 
		return (E) removedNode.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if(size ==0){
			throw new IndexOutOfBoundsException("this is an empty list, nothing can be removed."); 
		}
		if(index < 0 || index > size - 1){
			throw new IndexOutOfBoundsException("index is out of bounds"); 
		}
		if(element == null){
			throw new NullPointerException("cannot accept null element");
		}
		
		LLNode node = head.next;
		
		for(int i=1; i<=index; i++){
			node = node.next;
		}
		
		node.data = element;
		
		return null;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor
	
	public LLNode(){
		this.data = null;
		this.prev = null;
		this.next = null;
	}

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
