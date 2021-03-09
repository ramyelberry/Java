/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.model;

import java.awt.Color;
import static java.awt.Color.black;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import static javafx.scene.input.KeyCode.K;
import static javafx.scene.input.KeyCode.V;

/**
 *
 * @author Ramy
 */
public class Circle implements Shape{
private Point p;
private Color c;
private  Map<String,Double> m = new HashMap<String,Double>();
private String r="radius";

public Circle() {
   
}
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
        c=black; //To change body of generated methods, choose Tools | Templates.
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
           System.out.println( getProperties());
        double radius=m.get("radius");
    
        int Radius= (int)radius;
        canvas.setColor(c);
   canvas.drawOval(p.x, p.y, Radius,Radius);

//To change body of generated methods, choose Tools | Templates.
    }
     @Override
    public Object clone() throws CloneNotSupportedException
    {
       Circle circle = (Circle) super.clone();
 
        circle.p = (Point) p.clone();
 
        return circle;
        
    }
}
