
import java.util.ArrayList ; 
public class ShapesLab {
    public static void main(String[] args) {
        
        ArrayList<Rectangle> rects = new ArrayList<Rectangle>();
        ArrayList<Circle> circs = new ArrayList<Circle>();
        circs.add(new Circle()) ; 
        circs.add(new Circle()) ; 
        circs.add(new Circle()) ; 
        circs.add(new Circle()) ; 
        rects.add(new Rectangle()) ; 
        rects.add(new Rectangle()) ; 
        rects.add(new Rectangle()) ; 
        rects.add(new Rectangle()) ; 
        
        TestDraw.loopAndDraw(rects);
        TestDraw.loopAndDraw(circs);
        
    }

}

class TestDraw 
{
   public static void loopAndDraw(ArrayList<? extends shape> shapesList)
    {
        for (int i = 0; i < shapesList.size(); i++) 
        {
         shapesList.get(i).draw();
        }
    }
}


class Rectangle extends shape
{
    @Override
    void draw()
    {
        System.out.println("This is Drawn Rectangle");
    }
}

class Circle extends shape
{
    @Override
    void draw()
    {
        System.out.println("This is Drawn Circle");
    }
}

abstract class shape 
{
    abstract  void draw() ;
}
