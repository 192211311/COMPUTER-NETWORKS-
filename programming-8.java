8.	APPLICATIONS USING TCP FILE TRANSFER
PROGRAM CODING: 
ftpclient.java import java.net.*; import java.io.*; 
public class ftpclient { 
public static void main(String args[])throws Exception 
{ 
Socket sock=new Socket("127.0.0.1",3000); System.out.println("Enter the filename:"); 
BufferedReader keyRead=new BufferedReader (new InputStreamReader(System.in)); String fname=keyRead.readLine(); 
OutputStream ostream=sock.getOutputStream(); PrintWriter pwrite=new PrintWriter(ostream,true); pwrite.println(fname); 
InputStream istream=sock.getInputStream(); 
BufferedReader socketRead=new BufferedReader(new InputStreamReader(istream)); String str; 
while((str=socketRead.readLine())!=null) 
{ 
System.out.println(str); 
} 
pwrite.close(); socketRead.close(); keyRead.close(); 
} 
} 
ftpserver.java 
import java.io.*; import java.net.*; public class ftpserver { 
public static void main(String args[])throws Exception 
{ 
ServerSocket sersock=new ServerSocket(3000); System.out.println("Server ready for connection"); Socket sock=sersock.accept(); 
System.out.println("connection is successful and waiting for chatting"); InputStream istream=sock.getInputStream(); 
BufferedReader fileRead=new BufferedReader(new InputStreamReader(istream)); String fname=fileRead.readLine(); 
BufferedReader contentRead=new BufferedReader (new FileReader(fname)); OutputStream ostream=sock.getOutputStream(); 
PrintWriter pwrite=new PrintWriter(ostream,true); String str; while((str=contentRead.readLine())!=null) 
{ 
pwrite.println(str); 
} 
sock.close(); sersock.close(); pwrite.close(); fileRead.close();
contentRead.close(); 
} 
} 
OUT PUT: 
ftpclient 
Z:\CN\FTP>java ftpclient Enter the filename: 
ftp.txt Hello FTP 
ftpserver 
Z:\CN\FTP>java ftpserver Server ready for connection 
connection is successful and waiting for chatting

