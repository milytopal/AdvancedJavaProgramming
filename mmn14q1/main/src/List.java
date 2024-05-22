
public class List < T > {
	
	private Cell < T > head; // reference to the head of the list
	private Cell < T > tail; // reference to the tail of the list
	
	// constructs an empty list
	public List(){
		head = null;
		tail = null;
	}
	
	// returns the cell in the head of the list
	public Cell< T > getHead(){
		return head;
	}
	
	// returns the cell in the tail of the list
	public Cell< T > getTail(){
		return tail;
	}
	
	// adds a new cell to the end of the list
	public void add (T object){
		if ( isEmpty() )
			head = tail = new Cell< T > (object);
		else 
		{
			tail.setNext( new Cell< T > (object));
			tail = tail.getNext();
		}
	}
	
	// remove first cell from list
	public T remove() throws EmptyListException{
		// if the list is empty throw exception
		if ( isEmpty() )
			throw new EmptyListException("The list is empty !!!");
		
		T removedItem = head.getData(); // retrieve data being removed
		
		// update references head and tail
		if (head == tail)
			head = tail = null;
		else
			head = head.getNext();
		
		return removedItem; // return removed cell data
	}
	
	// adds a new cell to the front of the list
		public void addToFront (T object){
			if ( isEmpty() )
				head = tail = new Cell< T > (object);
			else 
			{
				Cell < T > newHead = new Cell < T > (object,head);
				head = newHead;
			}
		}
	
	// returns true if list is empty false if not
	public boolean isEmpty(){
		return head == null;
	}
	
	// returns a string representation of the list
	public String toString(){
		// if list is empty return that it's empty
		if ( isEmpty() )
			return "The list is Empty.";
		
		String returnString = ""; // the string that will return
		Cell < T > current = head; // keeps current cell to iterate the list
		
		// while not end of list appent current item
		while ( current != null )
		{
			returnString += current.getData() + "\t";
			current = current.getNext();
		}
		
		// return the string
		return returnString;
	}
}









