#include<stdio.h>
 #include<netdb.h> 
#include<arpa/inet.h> 
#include<netinet/in.h>
int main(int argc,char**argv) 
{ char h_name; 
int h_type; 
struct hostent *host; 
struct in_addr h_addr; 
if(argc!=2)
 { fprintf(stderr,"USAGE:nslookup\n"); 
} 
if((host=gethostbyname(argv[1]))==NULL) 
{
 fprintf(stderr,"(mini)nslookup failed on %s\n",argv[1]); }
 h_addr.s_addr=*((unsigned long*)host->h_addr_list[0]);
 printf("\n IP ADDRESS=%s\n",inet_ntoa(h_addr));
 printf("\n HOST NAME=%s\n",host->h_name);
 printf("\nADDRESS LENGTH =%d\n",host->h_length); 
printf("\nADDRESS TYPE=%d\n",host->h_addrtype); 
printf("\nLIST OF ADDRESS=%s\n",inet_ntoa(h_addr_list[0]));
 }

OUTPUT 
[it28@localhost ~]$ vi dns.c
 [it28@localhost ~]$ 
cc dns.c [it28@localhost ~]$ 
./a.out 90.0.0.36
 IP ADDRESS=90.0.0.36
 HOST NAME=90.0.0.36 
ADDRESS LENGTH =4 
ADDRESS TYPE=2
 LIST OF ADDRESS=90.0.0.36
