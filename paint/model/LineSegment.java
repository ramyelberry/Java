/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Map;

/**
 *
 * @author Ramy
 */
public class LineSegment implements Shape{
  private Color c;
private Map m;
  Point p1;
  Point p2;
  public LineSegment()
  {
      
  }
  
    public void setPosition1(Point position) {
        p2=position; //To change body of generated methods, choose Tools | Templates.
    }
  public Point getPosition1() {
        return p2; //To change body of generated methods, choose Tools | Templates.
    }
@Override
    public void setPosition(Point position) {
        p1=position;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Point getPosition() {
        return p1; //To change body of generated methods, choose Tools | Templates.
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
        canvas.setColor(c);
   canvas.drawLine(p1.x, p1.y,p2.x,p2.y);
  
//To change body of generated methods, choose Tools | Templates.
    }
     @Override
    public Object clone() throws CloneNotSupportedException
    {
        return (Circle)super.clone();
        
    }
}
