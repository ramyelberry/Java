/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.model;

import java.awt.Color;
import static java.awt.Color.red;
import java.awt.Point;
import java.util.Map;
import java.awt.Graphics;
import java.util.HashMap;

/**
 *
 * @author Ramy
 */
public class Square implements Shape {

    
 private Point p;
private Color c;
double length;
private  Map<String,Double> m = new HashMap<String,Double>();
 @Override
    public void setPosition(Point position) {
        p=position;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Point getPosition() {
        return p; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setProperties(Map<String, Double> properties) {
       m.putAll(properties); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<String, Double> getProperties() {
        return m;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setColor(Color color) {
        c=color; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Color getColor() {
        return c; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setFillColor(Color color) {
       c=color; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Color getFillColor() {
        return c; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void draw(Graphics canvas) {
         length=m.get("length");
  
        int Length= (int)length; 
        canvas.setColor(c);
   canvas.drawRect(p.x, p.y,Length,Length);
  
//To change body of generated methods, choose Tools | Templates.
    }
     @Override
    public Object clone() throws CloneNotSupportedException
    {System.out.println(p);
     return (Square)super.clone();
        
    }
     public boolean contains(Point zx){
        return (p.getX() < zx.getX() &&p.getY() < zx.getY() &&
                p.getX() + length > zx.getX()  &&
           p.getY() + length > zx.getY());
    }

}
