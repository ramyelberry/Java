/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.station;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ramy
 */
public class Driver {
    String name;
    int ID;
  float salary;
  boolean ontrip;
   public Driver()
   {
     this.ontrip=false;
     
   }

    public  float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }
public void putin() throws IOException {
       FileWriter fw =null;
        try {
            fw = new FileWriter("D:/newfile2.txt",true);
        } catch (IOException ex) {
            Logger.getLogger(Lemozine.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedWriter  bf = new BufferedWriter(fw);
        bf.write(this.name+","+this.ID+","+this.salary+","+this.ontrip);
        try {
            bf.newLine();
        } catch (IOException ex) {
            Logger.getLogger(Lemozine.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            bf.close();
        } catch (IOException ex) {
            Logger.getLogger(Lemozine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
