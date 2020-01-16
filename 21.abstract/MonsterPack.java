//© A+ Computer Science
// www.apluscompsci.com

//Monster Pack Example

import static java.lang.System.*;
import java.util.Scanner;
import java.util.Random;

public class MonsterPack
{
	//this variable stores the references
	//to a whole mess of monsters
	private Monster[] monsters;

	public MonsterPack()
	{
		monsters = new Monster[0];
	}

	public void loadMonsters( )
	{
		System.out.print("loadMonsters\n\n");
		Scanner keyboard = new Scanner(in);

		System.out.print("How many monsters are in the pack? :: ");
		int size = keyboard.nextInt();
		keyboard.nextLine();
		monsters = new Monster[size];    //size the array of monsters

		for(int j=0; j<monsters.length; j++)
		{
			out.print("Enter Monster " + j + " Name :: ");
         int r = (int)(Math.random()*3);
			if(r==0)
				monsters[j] = new Vampire(keyboard.nextLine());
			else if( r==1 )
				monsters[j] = new Witch(keyboard.nextLine());
			else
				monsters[j] = new Ghost(keyboard.nextLine());
		}
	}

	public String monstersTalk( )
	{
		String out = "";
		for(int j=0; j<monsters.length; j++)
			out += monsters[j].talk();
	   return out;
	}

	public String toString( )
	{
		String output="";
		for(int j=0; j < monsters.length; j++)
			output+=monsters[j].toString();
		return output;
	}
}