import java.util.StringTokenizer ; 
 class IpCheck {

    public static void main(String[] args) {
        
        if (args.length > 1 )
            System.out.println("Please Only Enter One Input") ; 
        else if (args.length == 0 )
             System.out.println("Please Only Enter One Not Zero") ; 
        else 
        {
            String theIP ; 
            String limitUp = "(\\d{1,2}|(0|1)\\"+ "d{2}|2[0-4]\\d|25[0-5])";
            if (args[0].matches(limitUp + "\\." + limitUp + "\\." + limitUp + "\\." + limitUp))
            {
                System.out.println("Valid IP");
                theIP = args[0] ; 
                System.out.println(theIP);
                 StringTokenizer stk = new StringTokenizer(theIP , ".") ; 
	       while(stk.hasMoreTokens())
	       {
		   System.out.println(stk.nextToken());
	       }
            }
            else 
            {
                System.out.println("Not Valid IP");
            }
        }
    }
    
}

