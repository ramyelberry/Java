/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playstation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ramy
 */
public class nonvexpenses {
     String name ;
 Float no;
 
 public nonvexpenses()
 {
     
 }
 public void set_name(String name)
 {
     this.name=name;
     
 }
 public void set_no(String no)
 {
    this.no=Float.parseFloat(no);
    
 }
 public void save_file() throws IOException
 { int i=1;
 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
   LocalDateTime now = LocalDateTime.now();  
  
      File f= new File("D:/nonvexpenses.txt");
        Scanner sr= new Scanner(f);
         String s;
         String[] pcr;
         String Word="";
   
        while (sr.hasNextLine())
        {  s=sr.nextLine()+"\n";
           String sv[]=s.split(",");
           if(sv[1].equals(this.name))
           { i=0;
               Word=Word+sv[0]+","+sv[1]+","+Float.toString(this.no)+"\n";
            System.out.println("ahha");
           }
           else
           { 
               Word=Word+s;
                System.out.println("zeby");
           }
        }
        
        if (i==1)
        { 
         Word=Word+dtf.format(now)+","+this.name+","+Float.toString(this.no)+"\n";
        }
   try {
           FileWriter myWriter = new FileWriter("D:/nonvexpenses.txt");
           if(Word.equals("")){
            myWriter.write(dtf.format(now)+","+this.name+","+this.no+"\n");
           myWriter.close();}
           else
           {
             myWriter.write(Word);
           myWriter.close();
           }
       } catch (IOException ex) {
           Logger.getLogger(pc.class.getName()).log(Level.SEVERE, null, ex);
       }
           
            
  }
 
 public String read_expenses() throws FileNotFoundException
 {
     File f= new File("D:/nonvexpenses.txt");
        Scanner sr= new Scanner(f);
        String word = "";
   String s;
   
        while (sr.hasNextLine())
        {  s=sr.nextLine();
           String sv[]=s.split(",");
         
           {s=s.replace(',', ' ');
            word=word+sv[1]+"  "+sv[2]+"\n";
           }
        }
        return word;
 }
    public float dfexpenses() throws FileNotFoundException
    {
        float tot=0;
        File f= new File("D:/nonvexpenses.txt");
        Scanner sr= new Scanner(f);
        String word = "";
        
   String s;
   
        while (sr.hasNextLine())
        {  s=sr.nextLine();
           String sv[]=s.split(",");
         
           {tot=Float.parseFloat(sv[2])+tot;
           }
        }
        return tot;
    }
}
