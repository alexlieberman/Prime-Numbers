Prime-Numbers
=============
Finds all prime numbers up to N (maxNumber) and stores them in a boolean array at the corresponding index
 - Please ensure maxNumber is even
 
The first loop initializes the array with all potential primes and primes of the form 6K+1, 6K-1

The second loop eliminates multiples of the square of each prime and then eliminates all products of that prime by all other primes.
