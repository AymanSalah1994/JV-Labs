import java.util.function.Function ; 

class ConvertDegrees {
    public static void main(String[] args) {
        Integer cDegree   =  0  ; 
        if (args.length > 0 )
        {
            cDegree = Integer.parseInt(args[0]) ; 
        }
        else
        {
            System.out.println("Enter at Least One Parameter For the Degree !"); 
        }
        Double fDegree  ; 
        ConverterCtoF co = new ConverterCtoF() ; 
        fDegree = doTheConversion(cDegree , co) ; 
        System.out.println("The F Degree : " + fDegree); 
    }

    public static Double doTheConversion(Integer c , Function<Integer,Double> f)
    {
        return f.apply(c) ; 
    }
}

class ConverterCtoF implements Function<Integer, Double>
{
    @Override
    public Double apply(Integer theCdegree)
    {
        Double resultF =(theCdegree * 1.8) + 32 ; 
        return resultF ; 
    }
}
