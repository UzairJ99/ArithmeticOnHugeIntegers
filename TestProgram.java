
public class TestProgram 
{
	public static void main(String[] args) 
	{
		System.out.println("Uzair Jawaid; jawaidu; 400114899");
		System.out.println("Testing add and subtract along with constructors in between and at the end");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("Two positive numbers test ");
		HugeInteger a = new HugeInteger("123");
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
		System.out.println("A positive with a negative test ");
		
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
		
		HugeInteger g = new HugeInteger("-893745");
		HugeInteger h = new HugeInteger("-4598");
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
		HugeInteger l = new HugeInteger("00ALFbce0046__$0$%5");
		HugeInteger m = new HugeInteger("0032302002");
		
		System.out.println("Special characters removed: " + k.printToString());
		System.out.println("leading zeros and special characters removed: " + l.printToString());
		System.out.println("leading zeros removed: " + m.printToString());

		System.out.println("----------------------------------------------------------------------------");
		System.out.println("Division Test");
		
		System.out.println("Two positives: ");
		HugeInteger q = new HugeInteger("38752153234");
		HugeInteger r = new HugeInteger("884758213");
		HugeInteger p = q.divide(r);
		
		System.out.println(q.printToString() + "/" + r.printToString() + " = " + p.printToString());
		System.out.println("----------------------------------------------------------------------------");
		
		System.out.println("Two negatives: ");
		
		HugeInteger s = new HugeInteger("-100000000");
		HugeInteger t = new HugeInteger("-12000");
		HugeInteger u = s.divide(t);

		System.out.println(s.printToString() + "/" + t.printToString() + " = " + u.printToString());
		System.out.println("----------------------------------------------------------------------------");
		
		System.out.println("One negative, one positive: ");
		
		HugeInteger a2 = new HugeInteger("-309237");
		HugeInteger w = new HugeInteger("535");
		HugeInteger x = a2.divide(w);

		System.out.println(a2.printToString() + "/" + w.printToString() + " = " + x.printToString());
		System.out.println("----------------------------------------------------------------------------");
		
		System.out.println("One positive, one negative: ");
		
		HugeInteger y = new HugeInteger("144");
		HugeInteger z = new HugeInteger("-12");
		HugeInteger a1 = y.divide(z);

		System.out.println(y.printToString() + "/" + z.printToString() + " = " + a1.printToString());
		System.out.println("----------------------------------------------------------------------------");
		
		System.out.println("Fractions (should round down): ");
		HugeInteger a3 = new HugeInteger("5");
		HugeInteger a4 = new HugeInteger("3");
		HugeInteger a5 = a3.divide(a4);
		
		System.out.println(a3.printToString() + "/" + a4.printToString() + " = " + a5.printToString());
		System.out.println("----------------------------------------------------------------------------");
		
		System.out.println("Division by zero: ");
		HugeInteger a6 = new HugeInteger("01");
		HugeInteger a7 = new HugeInteger("01");
		HugeInteger a8 = a6.divide(a7);
		
		System.out.println(a6.printToString() + "/" + a7.printToString() + " = " + a8.printToString());
		System.out.println("----------------------------------------------------------------------------");
		
		System.out.println("Multiply Test");
		System.out.println("Two positives: ");
		HugeInteger a9 = new HugeInteger("1000000");
		HugeInteger a10 = new HugeInteger("1000000");
		HugeInteger a11 = a9.multiply(a10);
		
		System.out.println(a9.printToString() + " x " + a10.printToString() + " = " + a11.printToString());
		
		System.out.println("----------------------------------------------------------------------------");
		
		System.out.println("Two negatives: ");
		HugeInteger a12 = new HugeInteger("-3284124");
		HugeInteger a13 = new HugeInteger("-121241");
		a11 = a12.multiply(a13);
		
		System.out.println(a12.printToString() + " x " + a13.printToString() + " = " + a11.printToString());
		System.out.println("----------------------------------------------------------------------------");

		System.out.println("One positive, one negative: ");
		HugeInteger a14 = new HugeInteger("23512");
		HugeInteger a15 = new HugeInteger("-241");
		a11 = a14.multiply(a15);
		
		System.out.println(a14.printToString() + " x " + a15.printToString() + " = " + a11.printToString());
		
		System.out.println("----------------------------------------------------------------------------");

		System.out.println("One negative, one positive: ");
		HugeInteger a16 = new HugeInteger("-2734");
		HugeInteger a17 = new HugeInteger("235315");
		a11 = a16.multiply(a17);
		
		System.out.println(a16.printToString() + " x " + a17.printToString() + " = " + a11.printToString());
		
		System.out.println("----------------------------------------------------------------------------");

		System.out.println("Multiply by zero: ");
		HugeInteger a18 = new HugeInteger("419");
		HugeInteger a19 = new HugeInteger("0");
		a11 = a18.multiply(a19);
		
		System.out.println(a18.printToString() + " x " + a19.printToString() + " = " + a11.printToString());
		
		System.out.println("----------------------------------------------------------------------------");

		System.out.println("End of all tests.");
	}
	

}
