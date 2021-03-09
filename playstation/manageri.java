/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playstation;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author Ramy
 */
public class manageri {
    String pass;
    String user;
    
    public manageri()
    {
        
    }
    public String read_daily_checkouts() throws FileNotFoundException
    {   float tot=0;
        File f= new File("D:/checkout.txt");
        Scanner sr= new Scanner(f);
        String word = "";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
   LocalDateTime now = LocalDateTime.now();
   String s;
   
        while (sr.hasNextLine())
        {  s=sr.nextLine();
           String sv[]=s.split(",");
           if(sv[0].equals(dtf.format(now)))
           {s=s.replace(',', ' ');
            word=word+s+"L.E"+"\n";
           }
        }
        return word;
    }
    public float read_total_dailycheckouts() throws FileNotFoundException
    {   float tot=0;
        File f= new File("D:/checkout.txt");
        Scanner sr= new Scanner(f);
        String word = "";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
   LocalDateTime now = LocalDateTime.now();
   String s;
   
        while (sr.hasNextLine())
        {  s=sr.nextLine();
           String sv[]=s.split(",");
           if(sv[0].equals(dtf.format(now)))
           {tot=Float.parseFloat(sv[2])+tot;
           }
        }
        return tot;
    }
    public float read_total_dailyprofit() throws FileNotFoundException
    {   float tot=0;
        File f= new File("D:/checkout.txt");
        Scanner sr= new Scanner(f);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
   LocalDateTime now = LocalDateTime.now();
   String s;
   
        while (sr.hasNextLine())
        {  s=sr.nextLine();
           String sv[]=s.split(",");
           if(sv[0].equals(dtf.format(now)))
           {tot=Float.parseFloat(sv[2])+tot;
           }
        }
        float tot1=0;
        File f1= new File("D:/expenses.txt");
        Scanner sr1= new Scanner(f1);
        
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
   LocalDateTime now1 = LocalDateTime.now();
   String s1;
   
        while (sr1.hasNextLine())
        {  s1=sr1.nextLine();
           String sv1[]=s1.split(",");
           if(sv1[0].equals(dtf1.format(now1)))
           { tot1=Float.parseFloat(sv1[3])+tot1;
           }
        }
        return tot-tot1;

    }
    public String read_daily_expenses() throws FileNotFoundException
    {
        File f= new File("D:/expenses.txt");
        Scanner sr= new Scanner(f);
        String word = "";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
   LocalDateTime now = LocalDateTime.now();
   String s;
   
        while (sr.hasNextLine())
        {  s=sr.nextLine();
           String sv[]=s.split(",");
           if(sv[0].equals(dtf.format(now)))
           {s=s.replace(',', ' ');
            word=word+s+"\n";
           }
        }
        return word;
    }
    public float read_total_daily_expenses() throws FileNotFoundException
    {   float tot=0;
        File f= new File("D:/expenses.txt");
        Scanner sr= new Scanner(f);
        String word = "";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
   LocalDateTime now = LocalDateTime.now();
   String s;
   
        while (sr.hasNextLine())
        {  s=sr.nextLine();
           String sv[]=s.split(",");
           if(sv[0].equals(dtf.format(now)))
           { tot=Float.parseFloat(sv[3])+tot;
           }
        }
        return tot;
    }
    public String read_monthly_expenses() throws FileNotFoundException
    {
        File f= new File("D:/expenses.txt");
        Scanner sr= new Scanner(f);
        String word = "";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM");  
   LocalDateTime now = LocalDateTime.now();
   String s;
   
        while (sr.hasNextLine())
        {  s=sr.nextLine();
           String sv[]=s.split(",");
           String sv1[]=sv[0].split("/");
           String conc=sv1[0]+"/"+sv1[1];
           if(conc.equals(dtf.format(now)))
           {s=s.replace(',', ' ');
            word=word+s+"\n";
           }
        }
        return word;
    }
    public float read_totalmonthly_expenses() throws FileNotFoundException
    {   float tot=0;
        File f= new File("D:/expenses.txt");
        Scanner sr= new Scanner(f);
        String word = "";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM");  
   LocalDateTime now = LocalDateTime.now();
   String s;
   
        while (sr.hasNextLine())
        {  s=sr.nextLine();
           String sv[]=s.split(",");
           String sv1[]=sv[0].split("/");
           String conc=sv1[0]+"/"+sv1[1];
           if(conc.equals(dtf.format(now)))
           {tot=Float.parseFloat(sv[3])+tot;
           }
        }
        return tot;
    }
public String read_monthly_checkouts() throws FileNotFoundException
    {
        File f= new File("D:/checkout.txt");
        Scanner sr= new Scanner(f);
        String word = "";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM");  
        LocalDateTime now = LocalDateTime.now();
        String s;
        while (sr.hasNextLine())
        {  s=sr.nextLine();
           String sv[]=s.split(",");
           String sv1[]=sv[0].split("/");
           String conc=sv1[0]+"/"+sv1[1];
           if(conc.equals(dtf.format(now)))
           {s=s.replace(',', ' ');
            word=word+s+"\n";
           }
        }
        return word;
    }
 public float read_totalmonthly_checkouts() throws FileNotFoundException
    {   float tot=0;
        File f= new File("D:/checkout.txt");
        Scanner sr= new Scanner(f);
        String word = "";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM");  
   LocalDateTime now = LocalDateTime.now();
   String s;
   
        while (sr.hasNextLine())
        {  s=sr.nextLine();
           String sv[]=s.split(",");
           String sv1[]=sv[0].split("/");
           String conc=sv1[0]+"/"+sv1[1];
           if(conc.equals(dtf.format(now)))
           {tot=Float.parseFloat(sv[2])+tot;
           }
        }
        return tot;
    }
 public float read_totalmonthly_profit() throws FileNotFoundException
    {  float tot1=this.read_totalmonthly_checkouts();
       float tot=this.read_totalmonthly_expenses();
       return tot1-tot;
    }
 public float[] read_total3month_expenses() throws FileNotFoundException
    {   float tot=0;
        float tot1=0;
        float tot2=0;
        File f= new File("D:/expenses.txt");
        Scanner sr= new Scanner(f);
        String word = "";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM");  
   LocalDateTime now = LocalDateTime.now();
   String s;
   String get_pastmonth[]=dtf.format(now).split("/");
   int first_month=Integer.parseInt(get_pastmonth[1])-1;
   int year1=Integer.parseInt(get_pastmonth[0]);
   if(first_month<=0)
   {first_month=first_month+12;
    year1=year1-1;
       
   }
   int second_month=Integer.parseInt(get_pastmonth[1])-2;
   int year2=Integer.parseInt(get_pastmonth[0]);
   if(second_month<=0)
   {second_month=second_month+12;
    year2=year2-1;
       
   }
   int third_month=Integer.parseInt(get_pastmonth[1])-3;
   int year3=Integer.parseInt(get_pastmonth[0]);
   if(third_month<=0)
   {third_month=third_month+12;
    year3=year3-1;
       
   }
   String date1="";
           String date2="";
                   String date3="";
   if(first_month<=9){
    date1=Integer.toString(year1)+"/0"+Integer.toString(first_month);}
   else
   {
       date1=Integer.toString(year1)+"/"+Integer.toString(first_month);
   }
   if(second_month<=9){    
   date2=Integer.toString(year2)+"/0"+Integer.toString(second_month); }
   else
   {
   date2=Integer.toString(year2)+"/"+Integer.toString(second_month);    
   }
   if(third_month<=9){
   date3=Integer.toString(year3)+"/0"+Integer.toString(third_month);}
   else
   {
   date3=Integer.toString(year3)+"/"+Integer.toString(third_month);    
   }
   System.out.println(date1+" "+date2+" "+date3);
        while (sr.hasNextLine())
        {  s=sr.nextLine();
           String sv[]=s.split(",");
           String sv1[]=sv[0].split("/");
           String conc=sv1[0]+"/"+sv1[1];
           if(conc.equals(date1))
           {tot=Float.parseFloat(sv[3])+tot;
           }
           else if(conc.equals(date2))
           {
            tot1=Float.parseFloat(sv[3])+tot1;   
           }
           else if(conc.equals(date3)){
            tot2=Float.parseFloat(sv[3])+tot2;    
        }
        }
        float[] ror=new float[3];
        ror[0]=tot;
        ror[1]=tot1;
        ror[2]=tot2;
        
        return ror;
    }
 public String[] read_3month_expenses() throws FileNotFoundException
    {   String tot="";
        String tot1="";
        String tot2="";
        File f= new File("D:/expenses.txt");
        Scanner sr= new Scanner(f);
        String word = "";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM");  
   LocalDateTime now = LocalDateTime.now();
   String s;
   String get_pastmonth[]=dtf.format(now).split("/");
   int first_month=Integer.parseInt(get_pastmonth[1])-1;
   int year1=Integer.parseInt(get_pastmonth[0]);
   if(first_month<=0)
   {first_month=first_month+12;
    year1=year1-1;
       
   }
   int second_month=Integer.parseInt(get_pastmonth[1])-2;
   int year2=Integer.parseInt(get_pastmonth[0]);
   if(second_month<=0)
   {second_month=second_month+12;
    year2=year2-1;
       
   }
   int third_month=Integer.parseInt(get_pastmonth[1])-3;
   int year3=Integer.parseInt(get_pastmonth[0]);
   if(third_month<=0)
   {third_month=third_month+12;
    year3=year3-1;
       
   }
   String date1="";
           String date2="";
                   String date3="";
   if(first_month<=9){
    date1=Integer.toString(year1)+"/0"+Integer.toString(first_month);}
   else
   {
       date1=Integer.toString(year1)+"/"+Integer.toString(first_month);
   }
   if(second_month<=9){    
   date2=Integer.toString(year2)+"/0"+Integer.toString(second_month); }
   else
   {
   date2=Integer.toString(year2)+"/"+Integer.toString(second_month);    
   }
   if(third_month<=9){
   date3=Integer.toString(year3)+"/0"+Integer.toString(third_month);}
   else
   {
   date3=Integer.toString(year3)+"/"+Integer.toString(third_month);    
   }
   System.out.println(date1+" "+date2+" "+date3);
        while (sr.hasNextLine())
        {  s=sr.nextLine();
           String sv[]=s.split(",");
           String sv1[]=sv[0].split("/");
           String conc=sv1[0]+"/"+sv1[1];
           if(conc.equals(date1))
           {s=s.replace(',', ' ');
            tot=tot+s+"\n";
           }
           else if(conc.equals(date2))
           {s=s.replace(',', ' ');
            tot1=tot1+s+"\n";   
           }
           else if(conc.equals(date3)){
            s=s.replace(',', ' ');
            tot2=tot2+s+"\n";  
        }
        }
        String[] ror=new String[3];
        ror[0]=tot;
        ror[1]=tot1;
        ror[2]=tot2;
        
        return ror;
    }
 public float[] read_3month_checkouts() throws FileNotFoundException
    {   float tot=0;
        float tot1=0;
        float tot2=0;
        File f= new File("D:/checkout.txt");
        Scanner sr= new Scanner(f);
        String word = "";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM");  
   LocalDateTime now = LocalDateTime.now();
   String s;
   String get_pastmonth[]=dtf.format(now).split("/");
   int first_month=Integer.parseInt(get_pastmonth[1])-1;
   int year1=Integer.parseInt(get_pastmonth[0]);
   if(first_month<=0)
   {first_month=first_month+12;
    year1=year1-1;
       
   }
   int second_month=Integer.parseInt(get_pastmonth[1])-2;
   int year2=Integer.parseInt(get_pastmonth[0]);
   if(second_month<=0)
   {second_month=second_month+12;
    year2=year2-1;
       
   }
   int third_month=Integer.parseInt(get_pastmonth[1])-3;
   int year3=Integer.parseInt(get_pastmonth[0]);
   if(third_month<=0)
   {third_month=third_month+12;
    year3=year3-1;
       
   }
   String date1="";
           String date2="";
                   String date3="";
   if(first_month<=9){
    date1=Integer.toString(year1)+"/0"+Integer.toString(first_month);}
   else
   {
       date1=Integer.toString(year1)+"/"+Integer.toString(first_month);
   }
   if(second_month<=9){    
   date2=Integer.toString(year2)+"/0"+Integer.toString(second_month); }
   else
   {
   date2=Integer.toString(year2)+"/"+Integer.toString(second_month);    
   }
   if(third_month<=9){
   date3=Integer.toString(year3)+"/0"+Integer.toString(third_month);}
   else
   {
   date3=Integer.toString(year3)+"/"+Integer.toString(third_month);    
   }
   System.out.println(date1+" "+date2+" "+date3);
        while (sr.hasNextLine())
        {  s=sr.nextLine();
           String sv[]=s.split(",");
           String sv1[]=sv[0].split("/");
           String conc=sv1[0]+"/"+sv1[1];
           if(conc.equals(date1))
           {tot=Float.parseFloat(sv[2])+tot;
           }
           else if(conc.equals(date2))
           {
            tot1=Float.parseFloat(sv[2])+tot1;   
           }
           else if (conc.equals(date3))
           {
            tot2=Float.parseFloat(sv[2])+tot2;   
           }
        }
     float[] ror=new float[3];
        ror[0]=tot;
        ror[1]=tot1;
        ror[2]=tot2;
        
        return ror;
    }
 public float[] get_totalprofit() throws FileNotFoundException
 {
     float[] x=this.read_3month_checkouts();
     float[] y=this.read_total3month_expenses();
     float[] z=new float[3];
     z[0]=x[0]-y[0];
     z[1]=x[1]-y[1];
     z[2]=x[2]-y[2];
     return z;
 }
}
