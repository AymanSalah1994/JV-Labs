class ThirdLab 
{
	static public void main(  String inputs[]  )
	{
		if (inputs.length > 2 )
			System.out.println("Please Only Enter Two Inputs  First is Number and the Second is a String Or Whatever ") ; 
		
		if (inputs.length == 0 )
			System.out.println("Please Enter Two Inputs , You Did Not Enter anything" ) ; 
		else 
			{
				//Do the Parsing 
				//If the Inut is Number Then Loop Using it  << how to Check if It is a Numer ?????
				// java.lang.NumberFormatException ???????????????????????????? if I Enter String 
				//if it is Not a Number Then Cancel and Print it 
				
				
				if (inputs[0].matches("\\d+"))
				{
					int theFirstArg = Integer.parseInt(inputs[0]);
					for (int index = 0  ; index < theFirstArg ; index++)
						{
							System.out.println(inputs[1]) ; 
						}
				}
				
				else 
				{
				System.out.println("First Argument Must Be a Number "); 
				}
			}
	}
}
