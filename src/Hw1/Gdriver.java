package Hw1;

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



// YOU MUST CODE THIS
private static String g(long m, int n) throws Exception{
/*

returns the string s that g as discussed in the project
assignment should map m to.

You do not need to do any error checking, although m < 0
or n outside of [2,26] are error conditions.

*/

return "";

}

public static void main(String[] a)throws Exception{

int radix, i, len;


System.out.println("\nAn assortment of test values for all radixes");
len = tests.length;
for (radix = 2; radix < 27; radix++){
   System.out.println("\nRadix value is " + radix);
   for (i = 0; i < len; i++)
      System.out.println(g(tests[i],radix));
   
}
}// of main
}// of class
