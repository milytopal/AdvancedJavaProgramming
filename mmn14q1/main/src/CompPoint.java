
import java.awt.Point;

public class CompPoint extends Point implements Comparable < CompPoint >{
	
	CompPoint(){
		super();
	}
	
	CompPoint(int a, int b){
		super ( a,b );
	}
	
	public int compareTo(CompPoint cp){
			return  (this.x + this.y) - (cp.x + cp.y);
	}
	
	
}
