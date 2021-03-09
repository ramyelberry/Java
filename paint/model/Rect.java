/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ramy
 */
public class Rect implements Shape{
private Point p;
private Color c;
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
       
   double width=m.get("width");
           double length=m.get("length");
     System.out.println("333333333333333");
        int Length= (int)length;
        int Width=(int)width;
        
        canvas.setColor(c);
   canvas.drawRect(p.x, p.y,Length,Width);
  
  
//To change body of generated methods, choose Tools | Templates.
    }
     @Override
    public Object clone() 
    { try {
        return (Rect)super.clone();
    } catch (CloneNotSupportedException ex) {
   
    }
    return null;
        
    }
}
