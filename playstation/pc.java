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
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ramy
 */
public class pc {
  
   public pc()
           {
               
           }
  public void set_pc(String name,String type,float price ) throws FileNotFoundException
  {  int i=1;
      File f= new File("D:/pcs.txt");
        Scanner sr= new Scanner(f);
         String s;
         String[] pcr;
         String Word="";
   
        while (sr.hasNextLine())
        {  s=sr.nextLine()+"\n";
           String sv[]=s.split(",");
           if(sv[0].equals(name))
           { i=0;
               Word=Word+name+","+type+","+Float.toString(price)+"\n";
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
         Word=Word+name+","+type+","+Float.toString(price)+"\n";
        }
   try {
           FileWriter myWriter = new FileWriter("D:/pcs.txt");
           if(Word.equals("")){
            myWriter.write(name+","+type+","+price+"\n");
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
  }

