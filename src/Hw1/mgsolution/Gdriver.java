import static java.lang.Math.*;

public class Gdriver{
/*

Your team members:


Class to implement the g function to convert a long to a string in A*
where A is some initial part of the sequence of lower case letters.

*******************************************************************/

private static final long MAX = Long.MAX_VALUE,
                          HALF_MAX = MAX/2,
                          QUARTER_MAX = HALF_MAX/2;


private static long[] tests = {
   0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 
   20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 
   40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 
   60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 
   80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 
   100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115,
   116, 117, 118, 119, 120, MAX,
    MAX - 1, MAX - 2, MAX - 3, MAX - 4, MAX - 5, MAX - 6, MAX - 7, MAX - 8, MAX - 9,
    MAX - 10, HALF_MAX - 1, HALF_MAX - 2, HALF_MAX - 3, HALF_MAX - 4, 
    HALF_MAX - 4, HALF_MAX - 6, HALF_MAX - 7, HALF_MAX - 8, HALF_MAX - 9, 
    HALF_MAX - 10, HALF_MAX, HALF_MAX + 1, HALF_MAX + 2, HALF_MAX + 3, HALF_MAX + 4,
    HALF_MAX + 5, HALF_MAX + 6, HALF_MAX + 7, HALF_MAX + 8, HALF_MAX + 9, HALF_MAX + 10, 
    QUARTER_MAX - 1, QUARTER_MAX - 2, QUARTER_MAX - 3, QUARTER_MAX - 4, QUARTER_MAX - 5, 
    QUARTER_MAX - 6,  QUARTER_MAX - 7,
    QUARTER_MAX - 8, QUARTER_MAX - 9, QUARTER_MAX - 10, QUARTER_MAX, 
    QUARTER_MAX + 1, QUARTER_MAX + 2, QUARTER_MAX + 3, QUARTER_MAX + 4, QUARTER_MAX + 5, 
    QUARTER_MAX + 6, QUARTER_MAX + 7, QUARTER_MAX + 8, QUARTER_MAX + 9, QUARTER_MAX + 10
};

// pasted from Fdriver
private static int calcLength(long m, int n){
/*

pre:  2 <= n <= 26
      m >= 0

returns the length of the string for the value m by iteration;

This is very ticklish to calculate for extremal values of m, since
the operations can overflow, leading to an infinite loop.  We will have 
to test for overflow as we go.

The iteration is for the sum described in the assignment, but
you need to test for overflow while doing it.

******************************************************************/

// we will set this if one of the operations would
// exceed the range for long ints
boolean sumWouldOverflow = false,
        multWouldOverflow = false;

int currExpOfPower = 0;
long currPowerOfN = 1L,
     multOvBound = MAX / ((long) n),
     currSumOfPowers = 0L,
     nL = (long) n;

// 0 is always associated with the empty string
if (m == 0L)
   return 0;


/*

invariant(if overflow were not an issue):

   currExpOfPower  >= 0
   currPowerOfN = n to the currExpOfPower
   currSumOfPowers = sum for i running from 0 to currExpOfPower - 1 of
                     n to the power i

  
   m >= sum for i running from 0 to currExpOfPower - 2 of n to the i

*/

while (m >= currSumOfPowers && !multWouldOverflow && !sumWouldOverflow){
   // add the next power of n and advance

   if (currSumOfPowers > MAX - currPowerOfN)
      sumWouldOverflow = true;
   else{
      currSumOfPowers += currPowerOfN;
      if (currPowerOfN > multOvBound)
         multWouldOverflow = true;
      else{
         currExpOfPower++;
         currPowerOfN *= nL;
      }
   }
}

// now we need to figure out whether we exited because we reached length+1
// or because we overflowed, and return the correct value for the length
if (multWouldOverflow)
   /*
      the next power of N,

      n to the currExpOfPower + 1

     would be larger than MAX but

     sum for i from 0 to currExpOfPower - 1 <= m <= MAX
     sum for i from 0 to currExpOfPower <= MAX

     so we just need to see where m falls relative to those two sums

     currSumOfPowers is the latter sum
   */
   if (currSumOfPowers <= m)
      return currExpOfPower + 1;
   else
      return currExpOfPower;
else
   if (sumWouldOverflow)
      /*
         sum for i from 0 to currExpOfPower - 1 <= m <= MAX
         < sum for i from 0 to currExpOfPower
      */
      return currExpOfPower;
    else
       /*

          1 <=  m < sum for i from 0 to currExpOfPower - 1

       */
       return currExpOfPower - 1;

}

// calculate b
private static long hornerAlgo(int k, int n) {
	long    tmp = 0;

	for(int i = 0; i < k; i++) { 
			tmp += 1;

		if(i != (k-1))
			tmp = n * tmp;
	}

	return tmp;
}

/* author: Miguel.
 * purpose: Helper. Map integer to char.
 **/
public static char trans_int(int value) {
    switch (value) {
    case 0: return 'a';
    case 1: return 'b';
    case 2: return 'c';
    case 3: return 'd';
    case 4: return 'e';
    case 5: return 'f';
    case 6: return 'g';
    case 7: return 'h';
    case 8: return 'i';
    case 9: return 'j';
    case 10: return 'k';
    case 11: return 'l';
    case 12: return 'm';
    case 13: return 'n';
    case 14: return 'o';
    case 15: return 'p';
    case 16: return 'q';
    case 17: return 'r';
    case 18: return 's';
    case 19: return 't';
    case 20: return 'u';
    case 21: return 'v';
    case 22: return 'w';
    case 23: return 'x';
    case 24: return 'y';
    case 25: return 'z';
    default: return '.';

    }
}


// YOU MUST CODE THIS
private static String g(long m, int n) throws Exception{
/*

returns the string s that g as discussed in the project
assignment should map m to.

You do not need to do any error checking, although m < 0
or n outside of [2,26] are error conditions.

*/
	StringBuffer buffer = new StringBuffer();
	
	if(m < 0 || n < 2 || n > 26)
		throw new Exception("invalid parameters.");
	
	int k = calcLength(m,n);
	long b = hornerAlgo(k, n);
	long o = m - b;

	if(o == 0) {
		if(m ==0)
			return " ";
		else {
			while(k > 0) {
				buffer.append("a");
				k--;
			}
			return buffer.toString();
		}
	} else {
		long tmp = o;
		
		while(tmp != 0) {
			buffer.append(trans_int((int) (tmp % n)));
			tmp = (long) (tmp/n);
		}

		if(buffer.length() == k)
			return buffer.reverse().toString();
		else {
			k = k - buffer.length();
			while(k > 0) {
				buffer.append("a");
				k--;
			}
			return buffer.reverse().toString();
		}
	}
}

public static void main(String[] a)throws Exception{

int radix, i, len;


System.out.println("\nAn assortment of test values for all radixes");
len = tests.length;
for (radix = 2; radix < 27; radix++){
   System.out.println("\nRadix value is " + radix);
   for (i = 0; i < len; i++) {
      System.out.println(g(tests[i],radix));
   }
   
}
}// of main
}// of class
