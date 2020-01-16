//© A+ Computer Science
// www.apluscompsci.com

//Monster example

import static java.lang.System.*;
import java.util.Scanner;

public abstract class Monster
{
   private String name;

   public Monster()
   {
      name="";
   }

   public Monster(String nm)
   {
   	name = nm;
   }

   public String getName()
   {
   	return name;
   }

   public abstract String talk( );

   public String toString() {
      return name + "  says  " + talk();
   }
}

