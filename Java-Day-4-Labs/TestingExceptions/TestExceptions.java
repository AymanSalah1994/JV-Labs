public class TestExceptions {
    public static void main(String[] args) {
        ThrowsPositiveException throwObject = new ThrowsPositiveException() ; 
        // Question : Can i use three Trys and Once catch ?
        try {
            throwObject.testInput();
            System.out.println("Test 1 Pass");
        } catch (NotPositiveException npe) {
            npe.printStackTrace();
        }
                
        try {
              throwObject.testInput(7);
               System.out.println("Test 2 Pass");
        } catch (NotPositiveException npe) {
            npe.printStackTrace();
        }
                        
        try {
              throwObject.testInput(-1 , -2);
               System.out.println("Test 3 Pass");
        } catch (NotPositiveException npe) {
            npe.printStackTrace();
        }
    }
    
}

class ThrowsPositiveException
{
    // A class That Has Methods , and those methods throw my Exception 
    public void testInput() throws NotPositiveException
    {
        throw new NotPositiveException() ; 
    }
    
    public void testInput(int x) throws NotPositiveException
    {
        if (x > 0)
        {
            throw new NotPositiveException("Custom Exception msg") ; 
        }
    }
    public void testInput(int x , int y ) throws NotPositiveException
    {
        if ((x + y) > 0 )
        {
            throw new NotPositiveException("Sum Not Negative") ;
        }
    }
}

class NotPositiveException extends Exception
{
        public NotPositiveException()
        {
            super("Default Exception msg");
        }
        public NotPositiveException(String customeMessage)
        {
            super(customeMessage);
        }
} 
