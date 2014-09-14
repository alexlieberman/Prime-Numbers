import java.util.*;
import java.lang.*;
import java.math.*;

public class Sieve2 {

	static int maxNumber = 10000;

	static int newFac = maxNumber/3;
        static int newFac2 = maxNumber/2;

	static int[] isPrime = new int[newFac];

	static boolean[] primeFac = new boolean[newFac2];

	static long timeStart, timeEnd, timeDifference;
	static double timeElapsed;

        static int count = 0;
        static int grow = 0;

        
        static int primeCount = 2;



        static int square = (int)Math.sqrt(maxNumber); 
        static int track1 = 2;
        static int track2 = 0;

	public static void main(String[] args) {
        
	timeStart = System.currentTimeMillis();

        isPrime[0] = 2;
        isPrime[1] = 3;
        primeFac[4] = true;
        primeFac[7] = true;
        

	for (int i = 1; i < square;) {

            grow = isPrime[i];     

            track2 = grow*grow;

	    count = (track2-1)/2;          
      
            while (count < newFac2 && count > 0)
             {
	       primeFac[count] = true;  
                count+=grow;
             }
               
	  
	  track2 = track2/2;

          for (;track1*2+1 <= maxNumber;)
           
            {if(!primeFac[track1]) 
              {isPrime[primeCount] = (track1*2)+1; primeCount++;}

	     if(track1 < track2)
               track1++;
             else
               break;

            

	}  i++;
          
	
       
        
	}

		timeEnd = System.currentTimeMillis();

		timeDifference = timeEnd - timeStart;

		timeElapsed = timeDifference / 1000.000000;


       int count2=0;
       for (int i = 0; i < newFac; i++)
	if (isPrime[i] != 0)
         {count2++; }

       System.out.print(count2 + " primes found in " + timeElapsed + " seconds.");
	        

}

}
