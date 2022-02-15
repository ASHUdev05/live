//8 Feb, 2022 || Codign live - EP 01
import java.util.*;
class pass
{
	Scanner sc=new Scanner(System.in);
	Random ran=new Random(); //Using Random() from java.util.*; to randomise the password
	String s; // This will store user input

	pass()
	{
		s="";
	}

	void input()
	{
		System.out.println("Enter password:");
		s=sc.nextLine();
	}

	boolean isDigit(String a)
	{
		char ab='\u0000';
		int c=0;
		for(int i=0;i<a.length(); i++)
		{
			ab=a.charAt(i);
			if(ab>=48 && ab<=57)
				c++;
		}
		return (c>0);
	}

	boolean isLowerCase(String a)
	{
		char ab='\u0000';
		int c=0;
		for(int i=0;i<a.length(); i++)
		{
			ab=a.charAt(i);
			if(ab>=97 && ab<=122)
				c++;
		}
		return (c>0);
	}

	boolean isUpperCase(String a)
	{

		char ab='\u0000';
		int c=0;
		for(int i=0;i<a.length(); i++)
		{
			ab=a.charAt(i);
			if(ab>=65 && ab<=90) 
				c++;
		}
		return (c>0);
	}

	boolean isSpecialChar(String a)
	{

		char ab='\u0000';
		int c=0;
		for(int i=0;i<a.length(); i++)
		{
			ab=a.charAt(i);
			if(ab=='!' || ab=='@' || ab=='#' || ab=='$' || ab=='%' || ab=='&' || ab=='*' || ab=='(' || ab==')' || ab=='-' || ab=='+' || ab=='=' || ab=='^')
				c++;
		}
		return (c>0);
	}

	boolean isSpace(String a)
	{

		char ab='\u0000';
		int c=0;
		for(int i=0;i<a.length(); i++)
		{
			ab=a.charAt(i);
			if(ab==32)
				c++;
		}
		return (c==0);
	}

	boolean validate()
	{
		int l=s.length();
		boolean ret=false;
		
		if(l<8 || l>20)
			ret=false;
		else if(isDigit(s) && isLowerCase(s) && isUpperCase(s) && isSpecialChar(s) && isSpace(s))
			ret=true;
		return ret;
	}

	int range()
	{
		// get a random number between 8-20, including 8 & 20
		int r=ran.nextInt(8,21);
		return r; 
	}

	char[] recommend()
	{
		// will write the recommendation system here
		String upper="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lower="abcdefghijklmnopqrstuvwxyz";
		String num="0123456789";
		String special="!@#$%&*()-+=^";

		String S = upper + lower + num + special;
		int l = range(); // fetch teh length of the password
		char[] code = new char[l];

		code[0]=num.charAt(ran.nextInt(num.length()));
		code[1]=upper.charAt(ran.nextInt(upper.length()));
		code[2]=lower.charAt(ran.nextInt(lower.length()));
		code[3]=special.charAt(ran.nextInt(special.length()));

		for(int i=4; i<l; i++)
		{
			code[i] = S.charAt(ran.nextInt(S.length()));
		}
		return code;

	}

	public static void main(String args[])
	{
		pass obj=new pass();
		obj.input();
		if(obj.validate())
			System.out.println("Validated successfully!");
		else
		{
			System.out.println("Invalid format, recommended: "+obj.recommend()); // maybe i should use destructor
		}
		obj.finalize();
		obj=null;
		System.gc(); // not sure if clearing heap works
	}

	protected void finalize()
	{
		return;
	}
}
