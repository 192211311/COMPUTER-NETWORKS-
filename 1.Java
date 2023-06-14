PROGRAM: //TCP Date Server--tcpdateserver.java
 import java.net.*;
 import java.io.*; 
import java.util.*; 
class tcpdateserver
 { 
public static void main(String arg[]) 
{
 ServerSocket ss = null; 
Socket cs; 
PrintStream ps; 
BufferedReader dis; 
String inet;
 try 
{
 ss = new ServerSocket(4444);

System.out.println("Press Ctrl+C to quit");
 while(true)
 { cs = ss.accept(); 
ps = new PrintStream(cs.getOutputStream());
 Date d = new Date(); 
ps.println(d); 
dis = new BufferedReader(new InputStreamReader(cs.getInputStream()));
 inet = dis.readLine();
 System.out.println("Client System/IP address is :"+ inet);
 ps.close();
 dis.close(); 
} } 
catch(IOException e) 
{ System.out.println("The exception is :" + e); 
} } } 
// TCP Date Client--tcpdateclient.java
 import java.net.*; 
import java.io.*;
 class tcpdateclient 
{ public static void main (String args[])
 { Socket soc;
 BufferedReader dis; 
String sdate;
 PrintStream ps;
 try { InetAddress ia = InetAddress.getLocalHost(); 
if (args.length == 0) 
soc = new Socket(InetAddress.getLocalHost(),4444);
 else soc = new Socket(InetAddress.getByName(args[0]),4444);
 dis = new BufferedReader(new InputStreamReader(soc.getInputStream())); 
sdate=dis.readLine(); 
System.out.println("The date/time on server is : " +sdate);
 ps = new PrintStream(soc.getOutputStream());
 ps.println(ia); ps.close();
 catch(IOException e) 
{ 
System.out.println("THE EXCEPTION is :" + e);
 } 
} 
}

output :
 $ javac tcpdateclient.java 
$ java tcpdateclient 
The date/time on server is: Wed Jul 06 07:12:03 GMT 2011
 Every time when a client connects to the server, server‟s date/time will be returned to the client for synchronization.
