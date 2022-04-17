
// returns a point containing the row and column of the letter  
private Point getPoint(char c)  
{  
Point pt = new Point(0,0);  
for(int i = 0; i < 5; i++)  
for(int j = 0; j < 5; j++)  
if(c == table[i][j].charAt(0))  
pt = new Point(i,j);  
return pt;  
}  
//function prints the key-table in matrix form for playfair cipher  
private void keyTable(String[][] printTable)  
{  
System.out.println("Playfair Cipher Key Matrix: ");  
System.out.println();  
//loop iterates for rows  
for(int i = 0; i < 5; i++)  
{  
//loop iterates for column    
for(int j = 0; j < 5; j++)  
{  
//prints the key-table in matrix form     
System.out.print(printTable[i][j]+" ");  
}  
System.out.println();  
}  
System.out.println();  
}    
//method that prints all the results  
private void printResults(String encipher, String dec)  
{  
System.out.print("Encrypted Message: ");  
//prints the encrypted message  
System.out.println(encipher);  
System.out.println();  
System.out.print("Decrypted Message: ");  
//prints the decryted message  
System.out.println(dec);  
 }  
}