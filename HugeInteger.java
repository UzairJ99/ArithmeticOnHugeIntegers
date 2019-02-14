import java.util.Random;

//Uzair Jawaid
//2019-01-19
//HugeInteger will be a class which will handle arithmetic operations on large integers

public class HugeInteger 
{
	private String value; //holds value of the integer as a string
	private int size; //holds size in number of digits
	private boolean negative; //holds sign
	
	//constructors
	public HugeInteger(int n)
	{
		//check if value of n meets requirements
		if (n<=0)
		{
			throw new IllegalArgumentException("Error. Value must be greater than or equal to 1.");
		}
		else
		{
			this.size = n;
			//creates a string of a randomized integer of size n
			int min = (int) Math.pow(10, n - 1); //determine minimum value
		    int decimalVal = min + new Random().nextInt(9 * min); //generate random value between min and <max
		    int coin = (int)(Math.random() * 50 + 1); //use a random value to determine if the number will be positive or not
		    if (coin%2 == 0)
		    	this.negative = true;
		    else
		    	this.negative = false;
		    this.value = Integer.toString(decimalVal);
		}	
	}
	//create integer from string
	public HugeInteger(String val)
	{
		if (val.length() == 1 && val.charAt(0) == '0')
		{
			this.negative = false; //set negative parameter
			this.value = "0";
			this.size = val.length();
		}
		else if (val.charAt(0) == '-')
		{
			//remove special characters
				//code from https://stackoverflow.com/questions/14361556/remove-all-special-characters-in-java
			val = val.replaceAll("[^a-zA-Z0-9]", "");
			
			//remove leading zeros
			for(int i = 0; i < val.length(); i++)
			{
				//code from https://stackoverflow.com/questions/2800739/how-to-remove-leading-zeros-from-alphanumeric-text
				val = val.replaceFirst("^0+", "");
			}
			this.negative = true; //set negative parameter
			//creates a huge integer using the given decimal string
			this.value = val;
			this.size = val.length();
		}
		else
		{
			val = val.replaceAll("[^a-zA-Z0-9]", "");
			val = val.replaceAll("[a-zA-Z]", "");
			
			
			for(int i = 0; i < val.length(); i++)
			{
				val = val.replaceFirst("^0+", "");
			}
			this.negative = false; //set negative parameter
			this.value = val;
			//check for empty string
			if (val.equals(""))
			{
				this.value = "0";
				this.size = 1;
			}
			this.size = val.length();
		}
	}
	
	//returns value of integer
	public int getValue()
	{
		int numVal = Integer.parseInt(this.value);
		return numVal;
	}
	
	//returns the size of the integer in number of digits
	public int size()
	{
		return this.size;
	}
	
	//add two numbers
	public HugeInteger add(HugeInteger h)
	{
		char[] result;
		String finalResult;
		HugeInteger a, b;
		int carry = 0, top, bottom, k = 0, sum = 0;
		HugeInteger bigSum;
		
		if (this.negative && h.negative)
		{
			//add the magnitudes
			a = new HugeInteger(this.value);
			b = new HugeInteger(h.value);
			HugeInteger preNegative = a.add(b);
			//adding negatives result in a larger negative so add the negative sign in front
			String neg = "-" + preNegative.value;
			bigSum = new HugeInteger(neg);
			return bigSum;
		}
		else if (this.negative && !h.negative)
		{
			//adding a negative calls subtraction
			HugeInteger n = new HugeInteger(this.value);
			bigSum = h.subtract(n);
			return bigSum;
		}
		else if(h.negative)
		{
			//adding a negative calls subtraction
			HugeInteger n = new HugeInteger(h.value);
			bigSum = this.subtract(n);
			return bigSum;
		}
		//determine which number is larger
		else if (h.size < this.size)
		{
			a = this;
			b = h;
			result = new char[this.size + 1]; //result is maximum 1 digit larger than the larger operand
			k = h.size-1; //iterator for smaller number
		}
		else
		{
			a = h;
			b = this;
			result = new char[h.size + 1]; //result is maximum 1 digit larger than the larger operand
			k = this.size-1; //iterator for smaller number
		}
		for (int i = a.size - 1; i >= 0; i--)
		{
			//add the digits
			top = Character.getNumericValue(a.value.charAt(i));
			//check if the iterator is past the most significant digit in the smaller number
			if (i < (a.size - b.size))
				sum = top + 0 + carry;
			else
			{
				bottom = Character.getNumericValue(b.value.charAt(k));
				sum = top + bottom + carry;
			}
			
			//check for carry
			if (sum > 9)
			{
				sum -= 10;
				carry = 1;
			}
			else
				carry = 0;
			//add sum to result
			result[i+1] = (Integer.toString(sum)).charAt(0);
			k--;
		}
		//store the extra carry
		result[0] = (Integer.toString(carry)).charAt(0);
		//convert the char array of sum digits into a string holding the overall sum
		finalResult = new String(result);
		//make a huge integer using the created string
		bigSum = new HugeInteger(finalResult);
	
	//make a huge integer using the created string
	return bigSum;
	}
	
	public HugeInteger subtract(HugeInteger h)
	{
		char[] result;
		String finalResult;
		int diff, borrow = 0, top, bottom, k = 0;
		HugeInteger bigDiff, a, b;
		
		if(this.negative && h.negative)
		{
			//subtracting a negative calls addition
			HugeInteger neg = new HugeInteger(h.value);
			bigDiff = neg.add(this); //-5--3 = -5 + 3 = 3 + - 5
			return bigDiff;
		}
		else if(this.negative && !h.negative)
		{
			//subtracting a negative calls addition
			a = new HugeInteger(this.value);
			b = new HugeInteger(h.value);
			HugeInteger preNegative = a.add(b);
			String neg = "-" + preNegative.value;
			HugeInteger finalVal = new HugeInteger(neg);
			bigDiff = finalVal;
			return bigDiff;
		}
		else if(h.negative)
		{
			//make a huge integer using the created string
			HugeInteger n = new HugeInteger(h.value);
			bigDiff = this.add(n);	
			return bigDiff;
		}
		else
		{
			if (this.compare(h) == 1)
			{
				a = this;
				b = h;
				result = new char[this.size];
				k = h.size-1; //iterator for smaller number
			}
			else
			{
				a = h;
				b = this;
				result = new char[h.size];
				k = this.size-1; //iterator for smaller number
			}
			for (int i = a.size - 1; i >= 0; i--)
			{
				//add the digits
				top = Character.getNumericValue(a.value.charAt(i));
				//check if the iterator is past the most significant digit in the smaller number
				if (i < (a.size - b.size))
				{
					diff = top - borrow; //take into account if the previous digit borrowed from this digit
				}
				else
				{
					bottom = Character.getNumericValue(b.value.charAt(k));
					diff = top - bottom;
					//check if the previous digit borrowed from this digit
					if (borrow == 1)
					{
						if (top < bottom || top == bottom)
						{
							diff += 9; //take the borrow into account when subtracting and borrow from the next digit
							borrow = 1;
						}
						else
						{
							diff -= 1; //if top is larger then only take away the borrow
							borrow = 0;
						}
					}
					else
					{
						if (top < bottom)
						{
							diff += 10; //add the borrow to the difference
							borrow = 1;
						}
						else
						{
							borrow = 0;
						}
					}
				}
				//add difference to result
				result[i] = (Integer.toString(diff)).charAt(0);
				k--;
			}
			//this may return a negative number so append a negative sign to the beginning
			if (this.compare(h) == -1)
			{
				String answer = new String(result);
				finalResult = "-" + answer;
			}
			else
			{
				finalResult = new String(result);
			}
			//make a huge integer using the created string
			bigDiff = new HugeInteger(finalResult);	
		}
		return bigDiff;
	}
	
	public HugeInteger divide(HugeInteger h)
	{
		//variable to store how many groupings of h we can have in this number
		HugeInteger count = new HugeInteger(h.value);
		HugeInteger quotient;
		if(h.negative)
			count.negative = true;
		//check for division by zero
		else if (h.getValue() == 0)
		{
			quotient = new HugeInteger("^");
			System.out.println("Undefined");
			return quotient;
		}
		HugeInteger counter = new HugeInteger("1");
		HugeInteger increment = new HugeInteger("1");
		HugeInteger a = count;
		HugeInteger b = this;
		HugeInteger temp;
		
		//check fraction round down
		if (a.compare(b) == 1)
			counter = new HugeInteger("0");
		
		//count groupings
		while(a.compare(b) == -1)
		{
			temp = count.add(h); //check what the next addition would be
			count = count.add(h);
			a = count;
			b = this;
			
			//check for round down
			if (temp.compare(b) == -1 || temp.compare(b) == 0)
				counter = counter.add(increment);	
		}
		String val; 
		//check sign
		if (h.negative && this.negative)
		{
			val = counter.value;
			quotient = new HugeInteger(val);
			quotient.negative = false;
		}
		else if (h.negative || this.negative)
		{
			val = counter.value;
			quotient = new HugeInteger(val);
			quotient.negative = true;
		}
		else
		{
			val = counter.value;
			quotient = new HugeInteger(val);
			quotient.negative = false;
		}
		return quotient;
	}
	
	public HugeInteger multiply(HugeInteger h)
	{
		//Variable to store the product
		HugeInteger product = new HugeInteger("0");
		//counter for repeated addition
		HugeInteger i = new HugeInteger("0");
		HugeInteger zero = new HugeInteger("0");
		HugeInteger increment = new HugeInteger("1");
		//check zero multiplication
		if (this.compare(zero) == 0)
			return product;
		
		//repeated addition of h's value to this value
		while(i.compare(h) == -1)
		{
			product = product.add(this);
			i = i.add(increment);
		}
		
		//check sign
		if(h.negative && this.negative)
			product.negative = false;
		else if (h.negative || this.negative)
			product.negative = true;
		else
			product.negative = false;

		return product;
	}
	
	//checks huge integer values to see which is bigger
	public int compare(HugeInteger h)
	{
		int val = 1;
		if (this.size > h.size)
			val = 1;
		else if (this.size < h.size)
			val = -1;
		else if (this.size == h.size)
		{
			if (Character.getNumericValue(this.value.charAt(0)) > Character.getNumericValue(h.value.charAt(0)))
				val = 1;
			//if equal size in digits
			else if (Character.getNumericValue(this.value.charAt(0)) == Character.getNumericValue(h.value.charAt(0)))
			{
				for (int i = 0; i < this.size; i++)
				{
					if (Character.getNumericValue(this.value.charAt(i)) > Character.getNumericValue(h.value.charAt(i)))
					{
						val = 1;
						break;
					}
					//continue if still equal
					else if (Character.getNumericValue(this.value.charAt(i)) == Character.getNumericValue(h.value.charAt(i)))
						val = 0;
					else
					{
						val = -1;
						break;
					}
				}
			}
			else
				val = -1;
		}
		return val;
	}
	
	//output the huge  integer
	public String printToString()
	{
		//holds final string
		String result = new String("");
		//check if a negative sign needs to be allocated
		if (this.negative)
			result += "-" + this.value;
		else
			result = this.value;
		return result;
	}
}
