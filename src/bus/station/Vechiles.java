/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.station;

/**
 *
 * @author Ramy
 */
public interface Vechiles {
    public String getmodel ();
    public void setmodel(String model);
    public void setcarno(String carno);
    public String getcarno();
    public int noofseats(); 
    public void putin();
}
