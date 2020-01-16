//© A+ Computer Science
// www.apluscompsci.com

//static example 

import static java.lang.System.*;

class Monster
{
   private String myName;
   private static int count = 0;   //all Monsters share this var

   public Monster()
   {
     myName="";
     count++;
   }
   public Monster( String name )
   {
     myName = name;
     count++;
   }

   public static int getCount( )
   {
     return count;
   }

   public String toString()
   {
      return myName;
   }
}

class Witch extends Monster
{
   public Witch( String name )
   {
      super(name);
   }
}

class Ghost extends Monster
{
   public Ghost( )
   {
      //super constructor called automatically
   }

   public Ghost( String name )
   {
      super(name);
   }
}

class Static
{
  public static void main ( String[] args )
  {
     System.out.println("\nMonster count == " + Monster.getCount() + "\n\n");

     Ghost casper = new Ghost("Casper");
     out.println(casper);
     out.println("Monster count == " + casper.getCount() + "\n");

     Witch witch= new Witch("Harriet");
     out.println(witch);
     out.println("Monster count == " + witch.getCount() + "\n");

     Ghost gone = new Ghost();
     Ghost gtwo = new Ghost();
     Ghost gthree = new Ghost();
     Witch west = new Witch("Wicked Witch Of the West");
     out.println(west);
     out.println("Monster count == " + west.getCount() + "\n");
  }
}