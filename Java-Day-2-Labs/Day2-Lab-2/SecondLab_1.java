public class SecondLab_1 {

    public static void main(String[] args) {
        String word = "ITI" ; 
        String sentence = "ITI is a Good Place , ITI is Developing "
                + ", and  If ITI you Know ITI , you Go to" ;
        int counter  = 0  ; 
        int start  = 0  ; 
        int end = start + 3 ; 
        while (end <= sentence.length())
        {
            //substring(int beginIndex, int endIndex)
            if (word.equals(sentence.substring(start, end)) )
            {
                counter++ ; 
                // index of todo 
            }
            start++ ; 
            end = start + 3  ; 
        }
        System.out.println("The Number is : " + counter);
    }
}

