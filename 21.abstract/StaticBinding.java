//© A+ Computer Science  -  www.apluscompsci.com

//static binding example 

public class StaticBinding
{
  public static void main ( String[] args )
  {
		Object o = new String("dog");

		int len = o.length();	//syntax error
													//object has no length

		int lenny = ((String)o).length();   //add a cast
		System.out.println( lenny );
  }
}