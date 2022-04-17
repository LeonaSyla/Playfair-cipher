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
