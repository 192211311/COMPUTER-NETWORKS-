9.	SIMULATION OF ERROR CORRECTION CODE – CRC
PROGRAM CODING: 
import java.util.*; class CRC { 
public static void main(String args[]) { 
Scanner scan = new Scanner(System.in); int n; 
System.out.println("Enter the size of the data:"); n = scan.nextInt(); 
int data[] = new int[n]; System.out.println("Enter the data, bit by bit:"); for(int i=0 ; i < n ; i++) { 
System.out.println("Enter bit number " + (n-i) + ":"); data[i] = scan.nextInt(); 
} 
System.out.println("Enter the size of the divisor:"); n = scan.nextInt(); 
int divisor[] = new int[n]; System.out.println("Enter the divisor, bit by bit:"); for(int i=0 ; i < n ; i++) { 
System.out.println("Enter bit number " + (n-i) + ":"); divisor[i] = scan.nextInt(); 
} 
int remainder[] = divide(data, divisor); for(int i=0 ; i < remainder.length-1 ; i++) { 
System.out.print(remainder[i]); 
} 
System.out.println("\nThe CRC code generated is:"); for(int i=0 ; i < data.length ; i++) { 
System.out.print(data[i]); 
} 
for(int i=0 ; i < remainder.length-1 ; i++) { System.out.print(remainder[i]); 
} 
System.out.println(); 
int sent_data[] = new int[data.length + remainder.length - 1]; System.out.println("Enter the data to be sent:"); 
for(int i=0 ; i < sent_data.length ; i++) { 
System.out.println("Enter bit number " + (sent_data.length-i)+ ":"); sent_data[i] = scan.nextInt(); 
} 
receive(sent_data, divisor); 
} 
static int[] divide(int old_data[], int divisor[]) { int remainder[] , i; 
int data[] = new int[old_data.length + divisor.length]; System.arraycopy(old_data, 0, data, 0, old_data.length); remainder = new int[divisor.length]; System.arraycopy(data, 0, remainder, 0, divisor.length); for(i=0 ; i < old_data.length ; i++) { 
System.out.println((i+1) + ".) First data bit is : "+ remainder[0]); System.out.print("Remainder : "); 
if(remainder[0] == 1) { 
for(int j=1 ; j < divisor.length ; j++) {
 
remainder[j-1] = exor(remainder[j], divisor[j]); System.out.print(remainder[j-1]); 
} 
} 
else { 
for(int j=1 ; j < divisor.length ; j++) { remainder[j-1] = exor(remainder[j], 0); System.out.print(remainder[j-1]); 
} 
} 
remainder[divisor.length-1] = data[i+divisor.length]; System.out.println(remainder[divisor.length-1]); 
} 
return remainder; 
} 
static int exor(int a, int b) { 
if(a == b) { 
return 0; 
} 
return 1; 
} 
static void receive(int data[], int divisor[]) { 
int remainder[] = divide(data, divisor); for(int i=0 ; i < remainder.length ; i++) { 
if(remainder[i] != 0) { 
System.out.println("There is an error in received data..."); return; 
} 
} 
System.out.println("Data was received without any error."); 
} 

} OUTPUT: 
Enter the size of the data: 	7 
Enter the data, bit by bit: 
Enter bit number 7: 	1 
Enter bit number 6: 	0 
Enter bit number 5: 	0 
Enter bit number 4: 	1 
Enter bit number 3: 	1 
Enter bit number 2: 	0 
Enter bit number 1: 	1 
Enter the size of the divisor: 4 Enter the divisor, bit by bit: 
Enter bit number 4: 	1 
Enter bit number 3: 	0 
Enter bit number 2: 	1 
Enter bit number 1: 	1 
1.) First data bit is : 1 
Remainder : 0101 
2.) First data bit is : 0 
Remainder : 1010 
3.) First data bit is : 1 

Remainder : 0011 
4.) First data bit is : 0 Remainder : 0110 
5.) First data bit is : 0 Remainder : 1100 
6.) First data bit is : 1 Remainder : 1110 
7.) First data bit is : 1 Remainder : 1010 
101 
The CRC code generated is: 1001101101 Enter the data to be sent: 
Enter bit number 10: 1 
Enter bit number 9: 0 
Enter bit number 8: 0 
Enter bit number 7: 1 
Enter bit number 6: 1 
Enter bit number 5: 0 
Enter bit number 4: 1 
Enter bit number 3: 1 
Enter bit number 2: 0 
Enter bit number 1: 1 
First data bit is : 1 Remainder : 0101 2.) First data bit is : 0 Remainder : 1010 3.) First data bit is : 1 Remainder : 0011 4.) First data bit is : 0 Remainder : 0111 5.) First data bit is : 0 Remainder : 1110 6.) First data bit is : 1 Remainder : 1011 7.) First data bit is : 1 Remainder : 0000 8.) First data bit is : 0 Remainder : 0000 9.) First data bit is : 0 Remainder : 0000 10.) First data bit is : 0 Remainder : 0000 Data was received without any error.
