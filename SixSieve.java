import java.util.*;
import java.lang.*;
import java.math.*;

public class SixSieve {

  static int maxNumber = 1000000000;
  static boolean[] isPrime = new boolean[maxNumber];
  static int limit = (int) Math.sqrt(maxNumber);
  static long timeStart, timeEnd, timeDifference;
  static double timeElapsed;
  static int totalPrimes;

    public static void main(String[] args) {

      isPrime[2] = true;
      isPrime[3] = true;

      System.out.println("Starting Computation.");
      timeStart = System.currentTimeMillis();

      getPotentialPrimes();
      eliminateProducts();

      timeEnd = System.currentTimeMillis();
      timeDifference = timeEnd - timeStart;
      timeElapsed = timeDifference / 1000.000000;

      System.out.println("Finished.");
      System.out.println("Time elapsed: " + timeElapsed);

      totalPrimes = countPrimes(totalPrimes);
      System.out.println("Total primes: " + totalPrimes);

      queryPrint();

    }

    static void getPotentialPrimes() {

      for (int countBySix = 6, countToSkip = 2; countBySix < maxNumber;) {

        if (countToSkip == 5) {

            isPrime[(countBySix) - 1] = true;
            countToSkip++;

        } else if (countToSkip == 7) {

            isPrime[(countBySix) + 1] = true;
            countToSkip = 3;

        } else {

            isPrime[(countBySix) - 1] = true;
            isPrime[(countBySix) + 1] = true;
            countToSkip++;

        }

        countBySix += 6;

      }

    }

    static void eliminateProducts() {

      int productOfSquare;
      int possiblePrime;

      for (int primeOne = 7; primeOne * primeOne <= maxNumber; primeOne += 2) {

        if (isPrime[primeOne]) {

          if (primeOne <= limit) {

            productOfSquare = primeOne * primeOne;

            while (productOfSquare < maxNumber && productOfSquare > 0) {

              isPrime[productOfSquare] = false;
              productOfSquare += (primeOne * primeOne * 2);

            }

          }

          possiblePrime = primeOne;

          do {

          possiblePrime += 2;

          } while (!isPrime[possiblePrime]);

          while (possiblePrime * primeOne <= maxNumber) {

            isPrime[possiblePrime * primeOne] = false;

            do {

            possiblePrime += 2;

            } while (!isPrime[possiblePrime]);
          }

        }
      }

    }

    static void queryPrint() {
  
      System.out.println("Would you like to print the primes (Y/N)?");

      Scanner inputQuery = new Scanner(System.in);
      char printResponse;

      do {

        printResponse = inputQuery.next().charAt(0);
        if (printResponse == 'Y') {

          printPrimes();

        } else {

          System.out.println("Exiting program.");
          return;

        }

      } while (printResponse != 'N' || printResponse != 'N');

    }

    static void printPrimes() {

      for (int primeIndex = 0; primeIndex < maxNumber; primeIndex++) {

        if (isPrime[primeIndex]) {

          System.out.print(primeIndex + " ");

        }

      }

      return;

    }

    static int countPrimes(int countPrimes) {

      for (int primeIndex = 0; primeIndex < maxNumber; primeIndex++) {

        if (isPrime[primeIndex]) {

          countPrimes++;

        }

    }

    return countPrimes;

  }

}