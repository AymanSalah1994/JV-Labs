import java.util.StringTokenizer ; 
 class Token {

    public static void main(String[] args) {
        String sentence = "ITI is a Good , ITI is ITI , and The ITI is the ITI etc" ; 
        String word = "ITI" ;
        
        StringTokenizer stk = new StringTokenizer(sentence , word) ; 
       while(stk.hasMoreTokens())
       {
           System.out.println(stk.nextToken());
       }
    }
    
}

