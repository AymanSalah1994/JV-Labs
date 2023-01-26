interface BetterInterface {
    // This is the Interface i will Make to Do the lambda
	boolean better(String firstWord, String secondWord);
}

class StringUtils {
    public static String betterString(String s1, String s2,BetterInterface BI) {
		if (BI.better(s1, s2)) {
			System.out.println("First better");
                        return s1 ;
		} else {
			System.out.println("Second is Better");
                        return s2 ; 
		}
	}
}

public class BetterChecker {
    public static void main(String[] args) {
        String str1 = "ayman";
        String str2 = "ayman salah";
        String longer = StringUtils.betterString(str1, str2, (str_1, str_2) -> str_1.length() > str_1.length()) ; 
        System.err.println(longer);
        String firstOne = StringUtils.betterString(str1, str2, (str_1, str_2) -> true) ; 
        System.err.println(firstOne);
        String secondOne = StringUtils.betterString(str1, str2, (str_1, str_2) -> false) ; 
        System.err.println(secondOne);

        //  TODO : the indexOf() For Lambda ; 

    }
    
}




