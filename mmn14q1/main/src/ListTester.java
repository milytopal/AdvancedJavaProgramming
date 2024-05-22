import java.util.Scanner;
import java.awt.Point;
import java.util.Random;

public class ListTester {
	public static void main (String[] args){
		
		List <String> list1 = new List < String >(); // first list
		
		// get user input
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter 6 strings :");
		for ( int i = 1 ; i < 7 ; i++)
		{
			System.out.println("Please enter String No " + i + " :");
			list1.add(sc.next());
		}
		// print given list
		System.out.println("First List:");
		System.out.println(list1);
		
		List <String> list2 = new List < String >(); // second list

		try {
			while ( !list1.isEmpty() )
			{
				list2.addToFront(list1.remove());
			}
		}
		catch (EmptyListException e)
		{
			e.printStackTrace();
		}
		
		// print second list
		System.out.println("Second List:");
		System.out.println(list2);
		
		List <Point> list3 = new List < Point >(); // third list
		Random rnd = new Random();
		for ( int i =0 ; i < 10 ; i++ )
		{
			list3.add(new Point(rnd.nextInt(100),rnd.nextInt(100)));
		}
		
		// print third list
		System.out.println("Third List:");
		System.out.println(list3);
		
		List <CompPoint> list4 = new List < CompPoint >(); // fourth list
		for ( int i =0 ; i < 10 ; i++ )
		{
			list4.add(new CompPoint(rnd.nextInt(100),rnd.nextInt(100)));
		}
		// print third list
		System.out.println("Fourth List:");
		System.out.println(list4);
		// print the smallest member in the fourth list
		System.out.println("Smallest CompPoint in List:");
		System.out.println(findMin(list4));
	}
	
	
	static < E extends Comparable > E  findMin (List < E > list ){
		
		if (list.isEmpty())
			return null;
		
		E min  = list.getHead().getData();
		Cell < E > current  = list.getHead();
		
		while ( current != null )
		{
			if (min.compareTo(current.getData()) > 0)
				min = current.getData();
			current = current.getNext();
		}
		
		return min;
	}
}







