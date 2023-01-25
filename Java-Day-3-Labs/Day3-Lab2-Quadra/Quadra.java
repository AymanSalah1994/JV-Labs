import java.util.function.Function;

public class Quadra {
    public static void main(String[] args) {
    Cof c = new Cof() ; 
 	if (args.length != 3)
 	{
        System.out.println("Please Only Three Numbers  !");
        return ;
 	}
 	else 
 	{
		c.a = Integer.parseInt(args[0]) ; 
		c.b = Integer.parseInt(args[1])  ; 
		c.c = Integer.parseInt(args[2])  ; 
 	}
        Root r  ; 
        EquationSolver es = new EquationSolver() ; 
        r =finalSolver(c, es) ; 
        if (r != null)
        {
            System.out.println(r.r1);
            System.out.println(r.r2);
        }
        else
        {
            System.out.println("Imaginary !");
        }
    }
    
    public static Root finalSolver(Cof ff , Function<Cof, Root> fun)
    {
        return fun.apply(ff) ; 
    }
}

class EquationSolver implements Function<Cof, Root>
{
    @Override
    public Root apply(Cof f)
     {
        double criticalPart = (f.b * f.b) - (4 * f.a * f.c)  ; 
        if (criticalPart < 0)
        {
            return null; 
        }
        else
        {
            Root r = new Root() ;
            r.r1 = (((-1.0)*f.b) - Math.sqrt(criticalPart) )  / (2 * f.a) ;
            r.r2 = (((-1.0)*f.b) + Math.sqrt(criticalPart ))  / (2 * f.a) ; 
            return r ;
        }
    }
}

class Cof
{
    public int a ; 
    public int b ; 
    public int c ; 
}

class Root
{
    public double r1  ; 
    public double r2  ;
}
