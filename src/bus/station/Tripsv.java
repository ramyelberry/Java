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
public class Tripsv {
    String From;
    String to;
    String Driver;
    int DateM;
    int DateD;
    float price;
    String Car;
    boolean ontrip;
    public Tripsv()
    {
      
       this.ontrip=true;
    }
  

    public String getCar() {
        return Car;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setFrom(String From) {
        this.From = From;
    }

    public void setDateM(int DateM) {
        this.DateM = DateM;
    }

    public String getTo() {
        return to;
    }

    public float getPrice() {
        return price;
    }

    public int getDateM() {
        return DateM;
    }

    public String getFrom() {
        return From;
    }

    public void setDriver(String Driver) {
        this.Driver = Driver;
    }

    public String getDriver() {
        return Driver;
    }

    public void setDateD(int DateD) {
        this.DateD = DateD;
    }

    public int getDateD() {
        return DateD;
    }

    public void setCar(String Car) {
        this.Car = Car;
    }
public void putin() throws IOException {
       FileWriter fw =null;
        try {
            fw = new FileWriter("D:/newfile1.txt",true);
        } catch (IOException ex) {
            Logger.getLogger(Lemozine.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedWriter  bf = new BufferedWriter(fw);
        bf.write(this.Car+","+this.Driver+","+this.DateD+","+this.price+","+this.From+","+this.to);
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
