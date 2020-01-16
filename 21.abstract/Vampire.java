//© A+ Computer Science
// www.apluscompsci.com

//abstract example one 

import static java.lang.System.*;
import java.util.Scanner;

public class Vampire extends Monster
{
  public Vampire( String name )
  {
     super(name);
  }

  public String talk()
  {
     return  " \"I want to drink your blood!\"\n\n";
  }
}
