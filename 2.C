PROGRAM CODING: 
EchoClient.java import java.io.*; import java.net.*; public class echoc 
{ 
public static void main(String[] args) 
{ 
try 
{ 
Socket s = new Socket("127.0.0.1",9999); BufferedReader r = new BufferedReader(new 
InputStreamReader(s.getInputStream())); 
PrintWriter w = new PrintWriter(s.getOutputStream(),true); BufferedReader con = new BufferedReader (new 
InputStreamReader(System.in)); 
String line; do 
{ 
line = r.readLine(); if(line != null) 
System.out.println(line); line = con.readLine(); w.println(line); 
} 
while(!line.trim().equals("bye")); 
}catch(Exception e) 
{ 
System.err.println(e); 
} 
} 
} 
Echoserver.java 
import java.io.*; import java.net.*; public class echos 
{ 
public echos(int portNum) 
{ 
try 
{server = new ServerSocket(portNum);} catch(Exception e) 
{System.out.println(e);} 
} 
public void serve() 
{ try 
{ 
while(true) 
{ 
Socket client = server.accept();
BufferedReader r = new BufferedReader(new InputStreamReader(client.getInputStream())); 
PrintWriter w = new PrintWriter(client.getOutputStream(),true); 
w.println("Welcome jeva Server Echo"); String line; 
do 
{ 
line = r.readLine(); if(line!=null) 
w.println("Got: "+line); 
} 
while(!line.trim().equals("bye")); client.close(); 
} 
}catch(Exception e) 
{ 
System.err.println(e); 
} 
} 
public static void main(String[] args) 
{ 
echos s = new echos(9999); s.serve(); 
} 
private ServerSocket server; 
} 
OUTPUT: 
Z:\CN>java echoc Welcome jeva Server Echo Hi!! 
Got: Hi!!
