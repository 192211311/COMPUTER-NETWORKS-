6.	ARP PROTOCOLS
PROGRAM CODING: 
arpclient.java import java.io.*; import java.net.*; import java.util.*; public class arpc 
{ 
public static void main(String args[]) 
{ 
try 
{ 
BufferedReader in=new BufferedReader(new InputStreamReader(System.in)); Socket clsct=new Socket("127.0.0.1",200); 
DataInputStream din=new DataInputStream(clsct.getInputStream()); DataOutputStream dout=new DataOutputStream(clsct.getOutputStream()); System.out.println("Enter the Logical address(IP):"); 
String str1=in.readLine(); dout.writeBytes(str1+'\n'); String str=din.readLine(); 
System.out.println("The Physical Address is: "+str); clsct.close(); 
} 
catch (Exception e) 
{ 
System.out.println(e); 
} 
} 
} 
arpServer.java import java.io.*; import java.net.*; import java.util.*; 
public class arpServer { 
public static void main(String args[]) 
{ 
try 
{ 
ServerSocket obj=new ServerSocket(2005); Socket obj1=obj.accept(); 
while(true) 
{ 
DataInputStream din=new DataInputStream(obj1.getInputStream()); DataOutputStream dout=new DataOutputStream(obj1.getOutputStream()); String str=din.readLine(); 
String ip[]={"165.165.80.80","165.165.79.1"}; 
String mac[]={"6A:08:AA:C2","8A:BC:E3:FA"}; 
for(int i=0;i<ip.length;i++) 
{ 
if(str.equals(ip[i])) 
{ 
dout.writeBytes(mac[i]+'\n'); break;
} 
}obj.close(); 
} 
} 
catch(Exception e) 
{ 
System.out.println(e); 
} 
} 
}

OUTPUT: 
arpClient D:\>javac arpc.java D:\>java arpc 
Enter the Logical address(IP): 165.165.80.80 
The Physical Address is:6A:08:AA:C2
