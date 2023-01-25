
import java.math.BigDecimal ; 
public class ComplexRepresentation<X extends BigDecimal , Y extends BigDecimal> {

    public static void main(String[] args) {   
        BigDecimal a = new BigDecimal(2) ; 
        BigDecimal b = new BigDecimal(2) ;
        BigDecimal c = new BigDecimal(3) ; 
        BigDecimal d = new BigDecimal(3) ;
        
        ComplexNumber<BigDecimal,BigDecimal> myComplex = new ComplexNumber<>(a,b);
        ComplexNumber<BigDecimal,BigDecimal> another = new ComplexNumber<>(c,d);
        
        another.printValue();
        another.addComplex(myComplex);
        another.printValue();
    }

}



//class ComplexNumber <X extends BigDecimal , Y extends BigDecimal>
class ComplexNumber <X extends BigDecimal , Y extends BigDecimal>
{
    public X real ; 
    public Y imaginary ;
    
    ComplexNumber(X real_ ,Y imagine_ ) {
       // CTOR
       real = real_ ; 
       imaginary = imagine_ ; 
    }
    
    public void printValue()
    {
        System.out.println("Real Part : " +  this.real);
        System.out.println("Imaginary Part : " + this.imaginary);
    }
    
    
    public void  addComplex(ComplexNumber<X,Y> numberCo)
    {
    this.real.add(numberCo.real) ; 
    this.imaginary.add(numberCo.imaginary) ; 
    }
    // Too


public void  subtractComplex(ComplexNumber<X,Y> numberCo)
    {
     this.real.subtract(numberCo.real) ; 
   
    this.imaginary.subtract(numberCo.imaginary) ; 
    }
}
