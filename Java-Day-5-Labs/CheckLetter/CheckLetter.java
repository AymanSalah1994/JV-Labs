
public class CheckLetter {
    public static void main(String[] args)
    {
        String userInput  ; 
        char eachCharacter  ; 
        boolean finalValue  = true ; 
        if (args.length != 1 )
        {
            System.out.println("Please Enter Only One Input");
        }
        
       else 
        {
	    userInput = args[0] ; 
            for (int i = 0; i < userInput.length(); i++)
            {
                 eachCharacter = userInput.charAt(i) ; 
                 finalValue = CheckLetter.checkAlpha(eachCharacter,Character::isLetter ) ;
                 if (finalValue == false)
                 {
                 System.out.println("NON-Alpha");
                     break;
                 }
            }
              if (finalValue == true)
              		System.out.println("-Alpha");
           
            
           }
    }
    
    
    public static boolean checkAlpha(Character eachCharacter , isALetterFace c)
        {
           return c.letter(eachCharacter) ; 
        }
    }
    



@FunctionalInterface
interface isALetterFace
{
    boolean letter(Character ch);
}

