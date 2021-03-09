/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.station;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Ramy
 */
public class tagreeb2 {
   static String id;

public void reado(String carno ) throws FileNotFoundException, IOException
{ String d[]=carno.split(",");
    File file = new File("D:/newfile.txt");
 Scanner scan =new Scanner(file);
 int i=0;
 String x="true";
 String word;
 String  ok[]=new String[20];
  FileWriter fw =new FileWriter("D:/newfile.txt",true);
        BufferedWriter b= new BufferedWriter(fw);
        String R=d[0];
 while (scan.hasNextLine())
 {
    word=scan.nextLine(); 
         String[]f= word.split(",");
       
        
        if (f[4].equals("false")&&f[1].equals(d[0]))
        {System.out.println(d[0]);
            
            b.write("\n"+f[0]+","+f[1]+","+f[2]+","+f[3]+",true");
      b.close();
      scan.close();
             break;
        }
      
 }
Scanner s=new Scanner(file);
i=0;
 while(s.hasNextLine())
 {System.out.println("11111");
     word=s.nextLine();
     String[] y =word.split(",");
     if (y[1].equals(d[0])&&word.endsWith("false"))
     {
     }
     else {
     ok[i]=word;
         i++;
     }
 }
  FileWriter fw1 =new FileWriter("D:/newfile.txt");
        BufferedWriter b1= new BufferedWriter(fw1);
 b1.write("");
 int j;
 for(j=0;j<i;j++)
 {
     b1.write(ok[j]);
     if(j<i-1)
     b1.newLine();
 }
 b1.close();
}
public void reado1(String ID ) throws FileNotFoundException, IOException
{ String d[]=ID.split(",");
    File file = new File("D:/newfile2.txt");
 Scanner scan =new Scanner(file);
 int i=0;
 
 String word;
 String  ok[]=new String[20];
  FileWriter fw =new FileWriter("D:/newfile2.txt",true);
        BufferedWriter b= new BufferedWriter(fw);
        String R=d[1];
 while (scan.hasNextLine())
 {
    word=scan.nextLine(); 
         String[]f= word.split(",");
       
        
        if (f[3].equals("false")&&f[1].equals(d[1]))
        {System.out.println(d[0]);
            
            b.write("\n"+f[0]+","+f[1]+","+f[2]+",true");
      b.close();
      scan.close();
             break;
        }
      
 }
Scanner s=new Scanner(file);
i=0;
 while(s.hasNextLine())
 {System.out.println("11111");
     word=s.nextLine();
     String[] y =word.split(",");
     if (y[1].equals(d[1])&&word.endsWith("false"))
     {
     }
     else {
     ok[i]=word;
         i++;
     }
 }
  FileWriter fw1 =new FileWriter("D:/newfile2.txt");
        BufferedWriter b1= new BufferedWriter(fw1);
 b1.write("");
 int j;
 for(j=0;j<i;j++)
 {
     b1.write(ok[j]);
     if(j<i-1)
     b1.newLine();
 }
 b1.close();
}
public boolean search(String s) throws FileNotFoundException
{ 
    
boolean x=true;
    File file = new File("D:/newfile1.txt");
Scanner scan = new Scanner(file);
while(scan.hasNextLine())
{String word=scan.nextLine();
    String []v=word.split(",");
    if (v[3].equals(s))
    {
    
        x=false;
        this.id=s;
        return x;
    }
   
}
return x;
}
public String trip(String s) throws FileNotFoundException
{ 
    
File file = new File("D:/newfile1.txt");
Scanner scan = new Scanner(file);
while(scan.hasNextLine())
{String word=scan.nextLine();
    String []v=word.split(",");
    if (v[3].equals(s))
    {
        return word;
    }
} 
return "";
}
public String getId(){
    return this.id;
}
}