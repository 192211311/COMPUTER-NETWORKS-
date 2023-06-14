5.	APPLICATIONS USING TCP CHAT CLIENT AND CHAT SERVER

PROGRAM CODING: 
ChatClient.java 
import java.io.*; import java.net.*; class chatClient { 
public static void main(String[] args)throws Exception 
{ 
Socket sock=new Socket("127.00.1",1309); 
BufferedReader keyRead=new BufferedReader(new InputStreamReader(System.in)); OutputStream ostream=sock.getOutputStream(); 
PrintWriter pwrite=new PrintWriter(ostream,true); InputStream istream=sock.getInputStream(); 
BufferedReader receiveRead =new BufferedReader(new InputStreamReader(istream)); System.out.println("Start the chitchat,type and press Enter key"); 
String receiveMessage,sendMessage; while(true) 
{ 
sendMessage=keyRead.readLine(); pwrite.println(sendMessage); pwrite.flush(); 
if((receiveMessage=receiveRead.readLine())!=null) 
{ 
System.out.println(receiveMessage); 
} 
} 
} 
} 
ChatServer.java 
import java.io.*; import java.net.*; class chatServer { 
public static void main(String[] args)throws Exception 
{ 
ServerSocket sersock=new ServerSocket(1309); System.out.println("server ready for chatting"); Socket sock=sersock.accept(); 
BufferedReader keyRead=new BufferedReader(new InputStreamReader(System.in)); OutputStream ostream=sock.getOutputStream(); 
PrintWriter pwrite=new PrintWriter(ostream,true); InputStream istream=sock.getInputStream(); 
BufferedReader receiveRead=new BufferedReader(new InputStreamReader(istream)); String receiveMessage,sendMessage; 
while(true) 
{ 
if((receiveMessage=receiveRead.readLine())!=null) 
{ 
System.out.println(receiveMessage); 
} 
sendMessage=keyRead.readLine(); pwrite.println(sendMessage);

pwrite.flush(); 
} 
} 
} 
OUTPUT: 
ChatClient 
Z:\CN\Chat>java chatClient 
Start the chitchat,type and press Enter key Hi!!! 
Hi! How are you ? 
Chat Server Z:\CN\Chat>java chatServer server ready for chatting Hi!!! 
Hi! How are you ?
