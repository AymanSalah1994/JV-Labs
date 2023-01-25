
import java.math.BigDecimal ; 
public class ComplexRepresentation{
//<X extends BigDecimal , Y extends BigDecimal> 
    public static void main(String[] args) {   
        BigDecimal a = new BigDecimal(2) ; 
        BigDecimal b = new BigDecimal(2) ;
        BigDecimal c = new BigDecimal(3) ; 
        BigDecimal d = new BigDecimal(3) ;
        ComplexNumber<BigDecimal,BigDecimal> myComplex = new ComplexNumber<>(a,b);
        ComplexNumber<BigDecimal,BigDecimal> another = new ComplexNumber<>(c,d);
        ComplexNumber<BigDecimal,BigDecimal> result = myComplex.subtractComplex(another) ; 
        result.printValue() ; 
    }
}


//class ComplexNumber <X extends BigDecimal , Y extends BigDecimal>
class ComplexNumber <T extends BigDecimal , R extends BigDecimal>
{
    public T real ; 
    public R imaginary ;
    ComplexNumber(T real_ ,R imagine_ ) {
       // CTOR
       real = real_ ; 
       imaginary = imagine_ ; 
    }
    
    public void printValue()
    {
        System.out.println("Real Part : " +  this.real);
        System.out.println("Imaginary Part : " + this.imaginary);
    }
    
    
    public ComplexNumber<T, R>  addComplex(ComplexNumber<T, R> numberCo)
    {
    return new ComplexNumber<T, R>( (T)this.real.add(numberCo.real) , (R)this.imaginary.add(numberCo.imaginary) )  ; 
    }

public ComplexNumber<T,R>  subtractComplex(ComplexNumber<T,R> numberCo)
    {
    return new ComplexNumber<T, R>( (T)this.real.subtract(numberCo.real) , (R)this.imaginary.subtract(numberCo.imaginary) )  ; 
    }
}
