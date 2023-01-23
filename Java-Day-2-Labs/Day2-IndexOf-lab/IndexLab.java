 class IndexLab {
    
        public static void main(String[] args) {
        String word = "ITI" ; 
        String sentence = " ITI ITI ITI ITIT, and  If ITI you Know ITI , you Go to" ;
        
        int counter = 0   ; 
        int startIndex = 0  ; 
        
        while (startIndex <= sentence.length())
        {
            int someIndex = sentence.indexOf(word , startIndex) ; 
            if (someIndex == -1)
                break;
            counter++ ; 
            startIndex = someIndex + 1 ; 
            
        }
            System.out.println(counter);
    }
    
}

