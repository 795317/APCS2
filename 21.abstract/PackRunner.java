//© A+ Computer Science
// www.apluscompsci.com

//Pack Runner Example

import static java.lang.System.*;
import java.util.Scanner;
import java.util.Random;

public class PackRunner
{
	public static void main ( String[] args )
	{
		MonsterPack pack = new MonsterPack();
		pack.loadMonsters();
		out.print( pack.monstersTalk() );
		out.println(pack);
	}
}