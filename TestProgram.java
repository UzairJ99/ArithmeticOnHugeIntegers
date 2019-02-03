public class TestProgram 
{
	public static void main(String[] args) 
	{
		System.out.println("Uzair Jawaid; jawaidu; 400114899");
		System.out.println("Testing add and subtract along with constructors in between and at the end");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("Two positive numbers test ");
		HugeInteger a = new HugeInteger("1055");
		HugeInteger b = new HugeInteger("465");
		System.out.println("First number: " + a.printToString()); 
		System.out.println("Second number: " + b.printToString());
		
		//holds the resulting value
		HugeInteger v;
		//add
		v = a.add(b);
		System.out.println(a.printToString() + " + " + b.printToString() + " = "  + v.printToString());
		//subtract
		v = a.subtract(b);
		System.out.println(a.printToString() + " - " + b.printToString() + " = "  + v.printToString());
		
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("A positive with aaaa negative test ");
		
		HugeInteger c = new HugeInteger("234");
		HugeInteger d = new HugeInteger("-5823");
		v = c.add(d);
		System.out.println(c.printToString() + " + " + d.printToString() + " = "  + v.printToString());
		//subtract
		v = c.subtract(d);
		System.out.println(c.printToString() + " - " + d.printToString() + " = "  + v.printToString());
		
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("A negative with a positive test ");
		
		HugeInteger e = new HugeInteger("-23124");
		HugeInteger f = new HugeInteger("6223");
		v = e.add(f);
		System.out.println(e.printToString() + " + " + f.printToString() + " = "  + v.printToString());
		//subtract
		v = e.subtract(f);
		System.out.println(e.printToString() + " - " + f.printToString() + " = "  + v.printToString());
		
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("Two negatives test ");
		
		HugeInteger g = new HugeInteger("-15");
		HugeInteger h = new HugeInteger("-42");
		v = g.add(h);
		System.out.println(g.printToString() + " + " + h.printToString() + " = "  + v.printToString());
		//subtract
		v = g.subtract(h);
		System.out.println(g.printToString() + " - " + h.printToString() + " = "  + v.printToString());
		
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("Random number genration test ");
		System.out.println("Re-run a few times to get more variation in numbers and +/- signs");
		//valid input
		HugeInteger i = new HugeInteger(3);
		System.out.println("Randomly generated number 1: " + i.printToString());
		//valid input
		HugeInteger n = new HugeInteger(1);
		System.out.println("Randomly generated number 2: " + n.printToString());
		//valid input
		HugeInteger o = new HugeInteger(8);
		System.out.println("Randomly generated number 3: " + o.printToString());
		
		//invalid input, this will cause an exception so it's commented out
		//HugeInteger j = new HugeInteger(0);
		
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("Special characters and leading zeros input test  ");
		
		HugeInteger k = new HugeInteger("12@#$1241");
		HugeInteger l = new HugeInteger("000046__$0$%5");
		HugeInteger m = new HugeInteger("0032302002");
		
		System.out.println("Special characters removed: " + k.printToString());
		System.out.println("leading zeros and special characters removed: " + l.printToString());
		System.out.println("leading zeros removed: " + m.printToString());

	}

}
