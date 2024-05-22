
public class Cell < T > {
	
	private T data; //data for this cell
	private Cell < T > nextCell; // reference for the next cell in the list
	
	// constructor for creating a cell that refers to the 
	// specified object and to the next cell
	public Cell(T object, Cell < T > cell){
		data = object;
		nextCell = cell;
	}
	
	// constructor creates a cell that refers to object
	public Cell(T object){
		this(object,null);
	}
	
	//return the data in the cell
	public T getData (){
		return data;
	}
	
	// sets the given data into the cell
	public void setData(T object){
		data = object;
	}
	
	// return reference to the next cell
	public Cell< T > getNext(){
		return nextCell;
	}
	
	// sets the next cell 
	public void setNext(Cell< T > cell){
		nextCell = cell;
	}
	
	
}
