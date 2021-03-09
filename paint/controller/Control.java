/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.controller;

import java.awt.Graphics;
import java.util.ArrayList;
import paint.model.Shape;
import paint.model.Square;
import paint.view.view;

/**
 *
 * @author Ramy
 */
public class Control implements DrawingEngine{
    private ArrayList<Shape> shapes;
   
    
    public Control()
    {
        shapes= new ArrayList<Shape>(20);
    }
 public void refresh(Graphics canvas)
  {
   for (int i=0;i<shapes.size();i++){
    Shape s=shapes.get(i);
    s.draw(canvas);
    
  }

  }
public void addShape(Shape shape)
{
    shapes.add(shape);
  
}
public void removeShape(Shape shape)
{
    shapes.remove(shapes.size()-1);
}
public void updateShape(Shape oldShape, Shape newShape){
    
}

public Shape[] getShapes()
{
    int i=0;Shape[]v =new Shape[shapes.size()];
for(Shape s: shapes)
{
    v[i]=s;
    i++;
}
      return v;
    
}
/* limited to 20 steps. You consider these actions in
* undo & redo: addShape, removeShape, updateShape */
public void undo()
{
    
}
public void redo()
{
    
}
/* use the file extension to determine the type,
* or throw runtime exception when unexpected extension */
public void save(String path)
{
    
}
public void load(String path)
{
    
}
// *************** bonus functions ****************
/* return the classes (types) of supported shapes already exist and the
* ones that can be dynamically loaded at runtime (see Part 4) */
public java.util.List<Class<? extends Shape>> getSupportedShapes()
{
      return null;
    
}
/* add to the supported shapes the new shape class (see Part 4) */
public void installPluginShape(String jarPath)
{
    
}
public void  copy(Graphics canavas,Shape s )
{
    
}
public void move ()
{
    
}
}
