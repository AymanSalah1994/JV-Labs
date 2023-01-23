
 class FirstLab {

    public static void main(String[] args) {
        
        int[] thousand = new int[1000] ; 
        for (int index = 0 ; index < 1000 ; index++)
        {
            int randomNumber = 777 + (int)(Math.random() * 100);
            thousand[index] = randomNumber ; 
        }
        
    
    int max = thousand[0] ; 
    int min = thousand[0] ; 
    long linearStartTime = System.nanoTime(); 
        for (int index = 0 ; index < 1000 ; index++)
        {
            if (thousand[index] > max)
                max = thousand[index] ; 
            
            if (thousand[index] < min )
                min = thousand[index] ; 
            
        }
        System.out.println("Max : " + max);
        System.out.println("Min : " + min);
        long linearEndTime = System.nanoTime(); 
        System.out.println("Total Nano seconds : " + (linearEndTime - linearStartTime )) ; 
        // Linear is Ok 
     

     int biMax = 1000 ; 
     int biMin = 1  ; 
     int start = 0  ; 
     int end = 999 ; 
     int middle ; 
 
     
     long biStartTime = System.nanoTime(); 
    while (start <= end )
    {
        middle = (start + end ) / 2  ; 
        
       if (thousand[middle] == biMin)
       {
           System.out.println("The index is : " + middle);
           break ; 
       }
       
       else 
       {
           if (thousand[middle] > biMin)
            {
                end = middle - 1  ; 
                
            }
           else 
               // else if Max is Bigger Than middle 
           {
               start = middle + 1  ; 
           }
       }
    }
    long biEndTime = System.nanoTime(); 
    
    System.out.println("Total Nano seconds : " + (biEndTime - biStartTime )) ; 
    
   }
    //  Above is  Main
 
    
}
