//© A+ Computer Science  -  www.apluscompsci.com

//static binding example 

import java.util.*;

public class DynamicBinding
{
	public static double processList( List<Integer> list )
	{
		double sum = 0;
	   for( int i = 0; i < list.size(); i++ )
	      sum += list.get(i);
	   return sum / list.size();
	}

  public static void main ( String[] args )
  {
		List<Integer> stuff = new ArrayList<Integer>();
		stuff.add( 9 );
		stuff.add( 99 );
		System.out.println( processList( stuff ) );

		stuff = new LinkedList<Integer>();
		stuff.add( 55 );
		stuff.add( 77 );
		System.out.println( processList( stuff ) );

		stuff = new Stack<Integer>();
		stuff.add( 55 );
		stuff.add( 77 );
		stuff.add( 22 );
		stuff.add( 76 );
		System.out.println( processList( stuff ) );
  }
}