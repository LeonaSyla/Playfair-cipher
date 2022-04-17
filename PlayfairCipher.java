package ushtrimi1;

import java.awt.Point;  
import java.util.Scanner;  
public class playfair  
{  
//length of digraph array  
private int length = 0;  
//creates a matrix for Playfair cipher   
private String [][] table;  
//main() method to test Playfair method  
public static void main(String args[])  
{  
	playfair pf = new playfair();  
}  
//main run of the program, Playfair method  
//constructor of the class  
private playfair()  
{  
//prompts user for the keyword to use for encoding & creates tables  
System.out.print("Enter the key for playfair cipher: ");  
Scanner sc = new Scanner(System.in);  
String key = parseString(sc);  
while(key.equals(""))  
key = parseString(sc);  
table = this.cipherTable(key);  
//prompts user for message to be encoded  
System.out.print("Enter the plaintext to be encipher: ");  
//System.out.println("using the previously given keyword");  
String input = parseString(sc);  
while(input.equals(""))  
input = parseString(sc);  
//encodes and then decodes the encoded message  
String output = cipher(input);  
String decodedOutput = decode(output);  
//output the results to user  
this.keyTable(table);  
this.printResults(output,decodedOutput);  
}  
//parses an input string to remove numbers, punctuation,  
//replaces any J's with I's and makes string all caps  
private String parseString(Scanner sc)  
{  
String parse = sc.nextLine();  
//converts all the letters in upper case  
parse = parse.toUpperCase();  
//the string to be substituted by space for each match (A to Z)  
parse = parse.replaceAll("[^A-Z]", "");  
//replace the letter J by I  
parse = parse.replace("J", "I");  
return parse;  
}  
//creates the cipher table based on some input string (already parsed)  
private String[][] cipherTable(String key)  
{  
//creates a matrix of 5*5     
String[][] playfairTable = new String[5][5];  
String keyString = key + "ABCDEFGHIKLMNOPQRSTUVWXYZ";  
//fill string array with empty string  
for(int i = 0; i < 5; i++)  
for(int j = 0; j < 5; j++)  
playfairTable[i][j] = "";  
for(int k = 0; k < keyString.length(); k++)  
{  
boolean repeat = false;  
boolean used = false;  
for(int i = 0; i < 5; i++)  
{  
for(int j = 0; j < 5; j++)  
{  
if(playfairTable[i][j].equals("" + keyString.charAt(k)))  
{  
repeat = true;  
}  
else if(playfairTable[i][j].equals("") && !repeat && !used)  
{  
playfairTable[i][j] = "" + keyString.charAt(k);  
used = true;  
}  
}  
}  
}  
return playfairTable;  
}  
//cipher: takes input (all upper-case), encodes it, and returns the output  
private String cipher(String in)  
{  
length = (int) in.length() / 2 + in.length() % 2;  
//insert x between double-letter digraphs & redefines "length"  
  
for(int i = 0; i < (length - 1); i++)  
{  
if(in.charAt(2 * i) == in.charAt(2 * i + 1))  
{  
in = new StringBuffer(in).insert(2 * i + 1, 'X').toString();  
length = (int) in.length() / 2 + in.length() % 2;  
}  
}  
//------------makes plaintext of even length--------------  
//creates an array of digraphs  
String[] digraph = new String[length];  
//loop iterates over the plaintext  
for(int j = 0; j < length ; j++)  
{  
//checks the plaintext is of even length or not   
if(j == (length - 1) && in.length() / 2 == (length - 1))  
//if not addends X at the end of the plaintext    
in = in + "X";  
digraph[j] = in.charAt(2 * j) +""+ in.charAt(2 * j + 1);  
}  
//encodes the digraphs and returns the output  
String out = "";  
String[] encDigraphs = new String[length];  
encDigraphs = encodeDigraph(digraph);  
for(int k = 0; k < length; k++)  
out = out + encDigraphs[k];  
return out;  
}  