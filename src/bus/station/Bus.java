/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.station;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ramy
 */
public class Bus implements Vechiles {
String Type,model,carno;
int noseats;
boolean x=false;
public Bus ( int seats)
{
 Type="Bus";
 noseats=seats;
}
    @Override
    public String getmodel() {
    return this.model;}

    @Override
    public void setmodel(String model) 
    {
       this.model=model;
    }

    @Override
    public void setcarno(String carno)
    {
        this.carno=carno;
    }

    @Override
    public String getcarno() {
    return this.carno;
    }

   

    @Override
    public int noofseats(){
        return noseats;
    }

    @Override
    public void putin() {
          FileWriter fw =null;
        try {
            fw = new FileWriter("D:/newfile.txt",true);
        } catch (IOException ex) {
            Logger.getLogger(Lemozine.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedWriter  bf = new BufferedWriter(fw);
        try {
            bf.newLine();
        } catch (IOException ex) {
            Logger.getLogger(Lemozine.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            bf.write(this.Type+","+this.carno+","+this.model+","+this.noseats+x);
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
