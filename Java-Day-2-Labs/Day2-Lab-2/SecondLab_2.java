public class SecondLab_2 {

       public static void main(String[] args) {
        String word = "ITI" ; 
        String sentence = " ITI ITI ,  ITI ,  is a Good Place , ITI is Developing "
                + ", and  If ITI you Know ITI , you Go to ITI" ;
        int counter  = 0  ; 
        String[] allWords = sentence.split(" ") ; 
        
        for (int index = 0 ; index < allWords.length ; index++)
        {
           if (word.equals(allWords[index]))
               counter++ ; 
        }
           System.out.println("The Count Of Words is : " + counter);
        
    }
    
}

