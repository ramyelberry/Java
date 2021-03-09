package playstation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import static java.time.LocalDateTime.now;
import java.time.format.DateTimeFormatter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ramy
 */
public class expenses {
 String name ;
 Float no;
 
 public expenses()
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
 {    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd,HH:mm:ss");  
   LocalDateTime now = LocalDateTime.now();  
   System.out.println(dtf.format(now));
     FileWriter fw1 =new FileWriter("D:/expenses.txt",true);
        BufferedWriter b1= new BufferedWriter(fw1);
        b1.write(dtf.format(now)+","+this.name+","+this.no);
        b1.newLine();
        b1.close();
 }
}
