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

/**
 *
 * @author Ramy
 */
public class Playstation {
private int price;
private float pc_price;
private long time;
private long endtime;

public void start_time()
{
    time=System.currentTimeMillis();
    System.out.println(time);
    
}
public int get_price(String name) throws IOException
{
    endtime=System.currentTimeMillis()-time;
    float timeS=endtime/(1000F*60F);
    System.out.print(timeS);
   
    price =(int) (timeS*get_prices(name));
    this.check_out();
    return price;
}
public float get_time ()
{
    endtime=System.currentTimeMillis()-time;
    float timeS=endtime/(1000F*60F);
    return (float) timeS;
}
public void check_out() throws IOException
{   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd,HH:mm:ss");  
   LocalDateTime now = LocalDateTime.now();  
    FileWriter fw1 =new FileWriter("D:/checkout.txt",true);
        BufferedWriter b1= new BufferedWriter(fw1);
        b1.write(dtf.format(now)+","+this.price);
        b1.newLine();
        b1.close();
}
public float get_prices(String name) throws FileNotFoundException
{   pc_price=0;
    File f= new File("D:/pcs.txt");
        Scanner sr= new Scanner(f);
         String s;
         String[] pcr;
         String Word="";
   
        while (sr.hasNextLine())
        {  s=sr.nextLine()+"\n";
           String sv[]=s.split(",");
           if(sv[0].equals(name))
           { pc_price=Float.parseFloat(sv[2]);
           break;
           }
           }
           return pc_price ;
}
}
