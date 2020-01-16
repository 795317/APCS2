//© A+ Computer Science  -  www.apluscompsci.com

//abstract example one 

import static java.lang.System.*;
import java.util.Scanner;

interface A
{
	void fun();
}

interface B
{
	void notFun();
}

interface C
{
	void weird();
}

interface D extends A,B,C		//works just fine
{

}

public class InterfaceExtends
{
  public static void main ( String[] args )
  {
  }
}