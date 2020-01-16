//© A+ Computer Science
// www.apluscompsci.com

//abstract example two 

import static java.lang.System.*;
import java.util.Scanner;

/*
 *  Open up Monster.java
 *  Open up Ghost.java
 */

public class GhostRunner
{
  public static void main ( String[] args )
  {
    String name;
    Scanner kb = new Scanner(in);

    Monster m;

    System.out.print("Your name ::  ");
    name = kb.nextLine();

    m = new Ghost(name);
    out.println("Ghost :: " );
    System.out.println( m );
  }
}