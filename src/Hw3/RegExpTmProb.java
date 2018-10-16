/*

COS 360   Team Problem

Regular Expressions


Team members :

This assignment has two main problems for regular expressions/patterns,
and each has two parts.  In the first part you build up to the regular 
expression pattern gradually, giving me the pattern in plain text, NOT 
AS YOU NEED TO GIVE IT TO THE PATTERN CLASS.  Do not put in all the escapes
you would need, they only make it harder for me to read the expression.  Also,
I ask you to use specific letters to stand for your earlier expressions.

You should insert your answers to the first parts of the questions right
in this comment.  

In the second part, you construct the pattern string to give to the static
method matches(String regExpPattern, CharSequence s) of the Pattern class.
The main method of this class will call that method on some test strings.

To make what you submit to me in the first part more readable, I stage 
the development, and require you to refer to earlier parts symbolically.
When you do the second part it may be useful for you to define the
subexpression patterns as strings that you append to build up the entire
pattern.  I would do it that way myself as it's easier to debug it.

You should use the following pattern expression conventions, in both
what you present for me and in your Java coding.

infix |  for union
postfix * for repeat 0 or more times
postfix + for repeat 1 or more times
postfix ? for repeat 0 or 1 time
juxtaposition for product
square brackets enclosing a list of characters for the set of length 1 
   strings of those characters, e.g.  [A-Za-z] for all of the strings of 
   single letters,  both upper and lower case
\s for a single white space character
\d for the set of ALL decimal digits

All characters other than

+ * ? \ ( ) [ ] - | . { }

will stand for themselves,  so that if you need to use these in your
expressions for me, you need to escape them, but not others.  You should
not have occasion to use it here, but the caret(^) also has special 
meaning in some contexts.

NOTE, WHITESPACE IN AN EXPRESSION FOR ME IS IGNORED, BUT NOT IN THE PATTERN
STRINGS YOU DO FOR JAVA.

(c | a)b for me allows "cb" and "ab", but "c b" and " ab" in a Pattern
expression.

Problem 1

a. Define a pattern for nonnegative decimal numerals without any extra 
   leading 0's.(just type in your answers here in your submission).

   Examples

   0
   1
   201
   12345678900

   0|([1-9][0-9]*)

b. Using N to stand for your pattern of (a), define a pattern for all 
   non-empty sequences of nonnegative decimal numerals where between 
   every pair, if there are more than one numeral in the list, there
   is a comma, and between the comma and the numeral on either side
   of it, there is an arbitrary amount of white space. Also,  before
   the first and last numeral of the sequence, there is optionally
   some white space(use the \s for the set of length one strings of
   white space).

   Examples(quotes used to show presence/absence of extremal white 
   space)

   "0"
   "   1"
   "2   "
   "   3  "
   "0,1,2,3,3,2,1,2,3"
   "  0, 1, 2, 3"
   "0  ,1  ,2  ,  3  "
   "  10, 21, 32, 43"
   "   0   ,   1   ,   2   ,   3   "

   \s*N(\s*,\s*N)*\s*
  
c. Using L to stand for the regular expression of (b), write an
   expression that represents L unioned with the language of all strings
   of white space, including the empty string.

   Examples

   all from (b) and also

   ""
   " "
   "             "

   L|\s*

d. Let S be the regular expression for (c).  Using S, write a regular 
   expression for the language whose strings are those that begin with
   {, followed by a string from S, followed by }.  You will have to
   escape the braces.

   Examples

   "{0}"
   "{   1}"
   "{2   }"
   "{   3  }"
   "{  0, 1, 2, 3}"
   "{0  ,1  ,2  ,  3  }"
   "{   0   ,   1   ,  3, 3, 2   ,   3   }"
   "{0,1,3,3,2,3}"
   "{}"
   "{ }"
   "{             }"

   \\{S\\}

e. Using T for the regular expression of (d), write a regular
   expression for the language that contains the strings of T,
   optionally prefixed by the string "CMP"

   Examples, all the strings of D and 

   "CMP{0}"
   "CMP{   1}"
   "CMP{2   }"
   "CMP{   3  }"
   etc.

   (CMP)?T

Problem 2

a. Do a pattern for unsigned whole number base ten integers with 
   extraneous leading 0's allowed

   Examples

   "0"
   "1"
   "000"
   "01"
   "1234"

   [0-9]+

b. letting U stand for the expression of (a), do an expression for a whole
   number with extraneous 0's allowed that optionally allows an initial
   minus sign(-), which is thus a signed whole number.

   Examples (all the examples of a and)

   "-0"
   "-1"
   "-000"
   "-01"
   "-1234"

   -?U

c. letting W stand for the expression of (b), code an expression for a
   signed mantissa, which must have digits both before and after the
   decimal point(period), and is optionally preceded by a minus sign;
   you can use both W and U here

   Examples

   "1.0002"
   "-0000.000"
   "-1.234"
   "567.8"

   W.U


d. letting W stand for expressions of (b) do a regular expression 
   for an exponent language that consists of the letter e followed 
   by a signed whole number.

   Examples 

   "e0"
   "e1"
   "e000"
   "e01"
   "e1234"
   "e-0"
   "e-1"
   "e-000"
   "e-01"
   "e-1234"

   eW

e. Using W for the language of (b), M for the language of (c),  and
   E for the language of (d), do a regular expression for the
   a language of floating point literals that are decimal numerals
   but must have a decimal point, or an exponent part, or both.  Your
   pattern should allow

   1.2
   -0.89
   12e-200
   -0.314159e1
   1e00

    but not allow

    --1.2.
    10e--12
    12
    -89
    7e
    .2
    -.3
    +1.2   
    2e+1
    e123
    e-29

   ME?|WE

Part II of the above problems

Define Java regular expression strings for your expressions of Problem 1(e)
and Problem 2(e) to complete the Java  program given below.  Submit your
finished file to Blackboard.

NOTE, IN THE REGULAR EXPRESSION STRING, WHICH IS A JAVA STRING, THE 
BACKSLASH WILL NEED TO BE ESCAPED TO HAVE IT RECOGNIZE \d OR \s, or any 
other symbol that is normally used as an operator or has special meaning.
There are several that you will need to escape to have Pattern interpret
it correctly, and to have Java pass the \ in as part of the String, you
will need to escape it in the Java string literal.  Look at my stub
definitions of prob1E and prob2E for an example; they just define 
arbitrary strings of white space.

Note also, that in the context of inside the square brackets, many of
the operator characters will stand for themselves and will not need 
to be escaped.  

The period character, which you will need, has a special meaning and 
depending on how you use it in your expression, may need escaping.


You can find tutorials on the syntax of these strings on the net.  Here is 
one link

http://www.ocpsoft.org/opensource/guide-to-regular-expressions-
in-java-part-1/

WHEN YOU HAVE COMPLETED ALL THE PROBLEMS, YOU CAN JUST SUBMIT THIS MODIFIED
SOURCE CODE FILE TO BLACKBOARD.


*/

import java.util.*;
import java.util.regex.*;

public class RegExpTmProb{

   //Problem 1 Regular Expressions
   private static String a1 = "(0|([1-9][0-9]*))";
   private static String b1 = "(\\s*"+ a1 + "(\\s*,\\s*" + a1 + ")*\\s*)";
   private static String c1 = "("+ b1 + "|\\s*)";
   private static String d1 = "(\\{" + c1 + "})";
   private static String e1 = "((CMP)?" + d1 + ")";

   //Problem 2 Regular Expressions
   private static String a2 = "([0-9]+)";
   private static String b2 = "(-?" + a2 + ")";
   private static String c2 = "(" + b2 + "\\." + a2 + ")";
   private static String d2 = "(e" + b2 + ")";
   private static String e2 =   c2 + d2 + "?|" + b2 + d2  ;

   private static String
      prob1E = e1,  // YOU MUST CODE THIS
      prob2E = e2;  // YOU MUST CODE THIS

// NOTE, PASSING ALL MY TEST CASES DOES NOT GUARANTEE THAT YOUR
// EXPRESSION IS CORRECT.  I will look at the expression and
// evaluate it for correctness as well as look at your test results.

   private static String[]
      tests1 = {
        
         "",
         "{}",
         "CMP{}",
         "CM{}",
         "CP{}",
         "MP{}",

         "CMPCMP{}",
         "CMCM{}",
         "CPCP{}",
         "MPMP{}",

         "{0}",
         "{20}",
         "{300}",
         "{40001}",
         "CMP{0}",
         "CMP{20}",
         "CMP{300}",
         "CMP{40001}",

         "{09}",

         "{   10}",
         "{21   }",
         "{   0  }",
         "CMP{   10}",
         "CMP{29   }",
         "CMP{   0  }",

         "{\t1}",
         "{2\t}",
         "{\t3\t}",
         "CMP{\t1}",
         "CMP{2\t}",
         "CMP{\t3\t}",

         "{8,9}",
         "{8,9 }",
         "{8,  9}",
         "{8,  9 }",
         "{8 ,9}",
         "{8  ,9 }",
         "{8  ,  9}",
         "{8  ,  9  }",
         "{\t 8,9}",
         "{\t 8,9 }",
         "{\t 8,  9}",
         "{\t 8,  9 }",
         "{\t 8 ,9}",
         "{\t 8  ,9 }",
         "{\t 8  ,  9}",
         "{\t 8  ,  9  }",

         "CMP{8,9}",
         "CMP{8,9 }",
         "CMP{8,  9}",
         "CMP{8,  9 }",
         "CMP{8 ,9}",
         "CMP{8  ,9 }",
         "CMP{8  ,  9}",
         "CMP{8  ,  9  }",
         "CMP{\t 8,9}",
         "CMP{\t 8,9 }",
         "CMP{\t 8,  9}",
         "CMP{\t 8,  9 }",
         "CMP{\t 8 ,9}",
         "CMP{\t 8  ,9 }",
         "CMP{\t 8  ,  9}",
         "CMP{\t 8  ,  9  }",


         "{  0, 1, 2, 3}",
         "{0\t,1  ,2  ,  3  }",
         "{   0\t,  1 ,\t2   ,   3\t}",
         "{\t0,1,3,3,2,3}",
         "{}",
         "{ }",
         "{             }",

         "{ 100 ,  2001 , 302 , 3 }",
         "{0,1,3,3,2,3}",
         "{}",
         "{ }",
         "{             }",

         "CMP{0}",
         "CMP{   1}",
         "CMP{2   }",
         "CMP{   3  }",
         "CMP{  0, 1, 2, 3}",
         "CMP{0  ,1  ,2  ,  3  }",
         "CMP{  0  ,  1  , 2 , 3 }",
         "CMP{}",
         "CMP{ }",
         "CMP{             }",
         "CMP{0,1,3,3,2,3}",
         "CMP{0 1 3 3 2 3}",
         "CMP{00,01,03,03,02,03}",
         " {0}",
         "{   1} ",
         " {2   } ",
         "  {   3  }\t\t",
         "\t{  0, 1, 2, 3}\t",
         "{0  ,1  ,2  ,  3  }",
         "\n{ 0  ,  1  ,  2  ,  3 }\n",
         "\n{}",
         "{ }\n",
         "{             }\t",
         "CMP {0}",
         "CMP\n{   1}",
         "CMP\t{2   }",
         " CMP{   3  }",
         "\tCMP{  0, 1, 2, 3}",
         "\nCMP{0  ,1  ,2  ,  3  }",
         " CMP  {  0  , 1  , 2  , 3  }",
         "\n\rCMP{}",
         "CMP\r\t\n{ }",
         "CMP{             }",
         "\t\r\n  ",
         "10" },

      tests2 = {
         "",
         "-123",
         "1.2",
         "0.0",
         "-0.0",
         "1.-00",
         "-1.-00",
         "1.9",
         "2.8",
         "3.7",
         "4.6",
         "5.5",
         "6.4",
         "7.3",
         "8.2",
         "9.1",
         "-1.9",
         "-2.8",
         "-3.7",
         "-4.6",
         "-5.5",
         "-6.4",
         "-7.3",
         "-8.2",
         "-9.1",


         "1,2",
         "0,0",
         "-0,0",
         "1,-00",
         "-1,-00",
         "1,9",
         "2,8",
         "3,7",
         "4,6",
         "5,5",
         "6,4",
         "7,3",
         "8,2",
         "9,1",
         "-1,9",
         "-2,8",
         "-3,7",
         "-4,6",
         "-5,5",
         "-6,4",
         "-7,3",
         "-8,2",
         "-9,1",



         "1e0",
         "2e1",
         "3e2",
         "4e3",
         "5e4",
         "6e5",
         "7e6",
         "8e7",
         "9e8",
         "0e9",

         "-1e0",
         "-2e1",
         "-3e2",
         "-4e3",
         "-5e4",
         "-6e5",
         "-7e6",
         "-8e7",
         "-9e8",
         "-0e9",

         "-1e-0",
         "-2e-1",
         "-3e-2",
         "-4e-3",
         "-5e-4",
         "-6e-5",
         "-7e-6",
         "-8e-7",
         "-9e-8",
         "-0e-9",


         "1e-0",
         "2e-1",
         "3e-2",
         "4e-3",
         "5e-4",
         "6e-5",
         "7e-6",
         "8e-7",
         "9e-8",
         "0e-9",

         "1.9e01",
         "2.8e02",
         "3.7e03",
         "4.6e04",
         "5.5e05",
         "6.4e06",
         "7.3e07",
         "8.2e08",
         "9.1e09",


         "-1a9e01",
         "-2b8e02",
         "-3c7e03",
         "-4d6e04",
         "-5f5e05",
         "-6g4e06",
         "-7h3e07",
         "-8A2e08",
         "-9B1e09",

         "1.9e-01",
         "2.8e-02",
         "3.7e-03",
         "4.6e-04",
         "5.5e-05",
         "6.4e-06",
         "7.3e-07",
         "8.2e-08",
         "9.1e-09",

         "-1.9e-01",
         "-2.8e-02",
         "-3.7e-03",
         "-4.6e-04",
         "-5.5e-05",
         "-6.4e-06",
         "-7.3e-07",
         "-8.2e-08",
         "-9.1e-09",


         " 1.9e01",
         " 2.8e02",
         " 3.7e03",
         "\t4.6e04",
         "\t5.5e05",
         "\t6.4e06",
         "\n7.3e07",
         "\n8.2e08",
         "\n9.1e09",

         "-1.9e01 ",
         "-2.8e02 ",
         "-3.7e03 ",
         "-4.6e04\t",
         "-5.5e05\t",
         "-6.4e06\t",
         "-7.3e07\r",
         "-8.2e08\r",
         "-9.1e09\r",

         "1.9 e-01",
         "2.8 e-02",
         "3.7\te-03",
         "4.6\te-04",
         "5.5\re-05",
         "6.4\re-06",
         "7.3e -07",
         "8.2e -08",
         "9.1e\t-09",

         "-1.9e\t-01",
         "-2.8e\t-02",
         "-3.7e\r-03",
         "-4.6e\r-04",
         "-5.5e\r-05",
         "-6.4e -06",
         "-7.3e -07",
         "-8.2e -08",
         "-9.1e -09",



         "0.0",

         "-0.89",
         "12e-200",
         "-0 .314159e1",
         "1e00",
         "-1. 2",
         "10e--12",
         "12",
         "-0 1 2 3 4 5 6 7 8 . 9",
         "123.",
         "7e",
         ".2",
         "1.",
         "-.3",


         " 1.2",
         " -0.89",
         " 12e-200",
         " -0.314159e1",
         " 1e00",
         " --1.2",
         " 10e--12",
         " 12",
         "-89",
         " 7e",
         " .2",
         " -.3",
         "1.2\t",
         "-0.89\t",
         "12e-200\t",
         "-0.314159e1\t",
         "1e00\t",
         "--1.2\t",
         "10e--12\t",
         "12\t",
         "-89\t",
         "7e\t",
         ".2\t",
         "-.3\t",
         "1.2\t",
         "-0.89\t",
         "12e-200\t",
         "-0.314159e1\t",
         "1e00\t",
         "--1.2\t",
         "10e--12\t",
         "12\t",
         "-89\t",
         "7e\t",
         ".2\t",
         "-.3\t",
         "\t\r\n  " };

private static String substEscapes(String s){
/*

replaces some of the \s whitespace characters with
the escape sequences used for them and adds single quotes
around the string to make white space visible in
the display.

It also replaces null with the empty string, which will
NOT have the single quotes around it.

*/
   if (s == null) 
      return "";

   StringBuilder b = new StringBuilder();

   char[] A = s.toCharArray();
   char c;

   int 
      i,
      len = A.length;

   b.append('\'');
   for (i = 0; i < len; i++){
      c = A[i];
      if (c == '\t')
         b.append("\\t");
      else  if (c == '\r')
         b.append("\\r");
      else  if (c == '\n')
         b.append("\\n");
      else  if (c == '\f')
         b.append("\\f");
      else  if (c == '\b')
         b.append("\\b");
      else
         b.append(c);
   }
   // add the final \' to mark the end of the string
   b.append('\'');
   return b.toString();
}   


public static void main(String[] args){

   int i;

   System.out.println("\nTests for prob1E\n");

   for (i = 0; i < tests1.length; i++)
      System.out.println("Test " +
      String.format("%3d", i)
       + " string = " + 
      String.format("%-30s",substEscapes(tests1[i])) +
      " result = " + Pattern.matches(prob1E, tests1[i]));


   System.out.println("\n\nTests for prob2E\n");

   for (i = 0; i < tests2.length; i++)
      System.out.println("Test " +
      String.format("%3d", i)
       + " string = " + 
      String.format("%-30s",substEscapes(tests2[i])) +
      " result = " + Pattern.matches(prob2E, tests2[i]));

}

}