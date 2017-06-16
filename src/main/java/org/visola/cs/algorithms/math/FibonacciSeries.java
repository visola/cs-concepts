package org.visola.cs.algorithms.math;

/**
 * Operations that can be done with a Fibonacci series.
 */
public interface FibonacciSeries {

  public static final long [] FIBONACCI_NUMBERS = {
    1L, 1L, 2L, 3L, 5L, 8L, 13L, 21L, 34L, 55L, 89L, 144L, 233L, 377L, 610L,
    987L, 1597L, 2584L, 4181L, 6765L, 10946L, 17711L, 28657L, 46368L, 75025L,
    121393L, 196418L, 317811L, 514229L, 832040L, 1346269L, 2178309L, 3524578L,
    5702887L, 9227465L, 14930352L, 24157817L, 39088169L, 63245986L, 102334155L,
    165580141L, 267914296L, 433494437L, 701408733L, 1134903170L, 1836311903L,
    2971215073L, 4807526976L, 7778742049L, 12586269025L, 20365011074L,
    32951280099L, 53316291173L, 86267571272L, 139583862445L, 225851433717L,
    365435296162L, 591286729879L, 956722026041L, 1548008755920L, 2504730781961L,
    4052739537881L, 6557470319842L, 10610209857723L, 17167680177565L,
    27777890035288L, 44945570212853L, 72723460248141L, 117669030460994L,
    190392490709135L, 308061521170129L, 498454011879264L, 806515533049393L,
    1304969544928657L, 2111485077978050L, 3416454622906707L, 5527939700884757L,
    8944394323791464L, 14472334024676221L, 23416728348467685L,
    37889062373143906L, 61305790721611591L, 99194853094755497L,
    160500643816367088L, 259695496911122585L, 420196140727489673L,
    679891637638612258L, 1100087778366101931L, 1779979416004714189L,
    2880067194370816120L, 4660046610375530309L, 7540113804746346429L
  };

  public static final long [] FIBONACCI_SUM = {
    1L, 2L, 4L, 7L, 12L, 20L, 33L, 54L, 88L, 143L, 232L, 376L, 609L, 986L,
    1596L, 2583L, 4180L, 6764L, 10945L, 17710L, 28656L, 46367L, 75024L, 121392L,
    196417L, 317810L, 514228L, 832039L, 1346268L, 2178308L, 3524577L, 5702886L,
    9227464L, 14930351L, 24157816L, 39088168L, 63245985L, 102334154L, 165580140L,
    267914295L, 433494436L, 701408732L, 1134903169L, 1836311902L, 2971215072L,
    4807526975L, 7778742048L, 12586269024L, 20365011073L, 32951280098L,
    53316291172L, 86267571271L, 139583862444L, 225851433716L, 365435296161L,
    591286729878L, 956722026040L, 1548008755919L, 2504730781960L,
    4052739537880L, 6557470319841L, 10610209857722L, 17167680177564L,
    27777890035287L, 44945570212852L, 72723460248140L, 117669030460993L,
    190392490709134L, 308061521170128L, 498454011879263L, 806515533049392L,
    1304969544928656L, 2111485077978049L, 3416454622906706L, 5527939700884756L,
    8944394323791463L, 14472334024676220L, 23416728348467684L,
    37889062373143905L, 61305790721611590L, 99194853094755496L,
    160500643816367087L, 259695496911122584L, 420196140727489672L,
    679891637638612257L, 1100087778366101930L, 1779979416004714188L,
    2880067194370816119L, 4660046610375530308L, 7540113804746346428L
  };

  /**
   * Get the Nth element in a Fibonacci series.
   *
   * @param position The position of the number you want, starting at zero.
   * @return The Nth element of the Fibonacci series where F(0) = 1.
   */
  long getNumberAt(long position);

  /**
   * Sum all numbers from a Fibonacci series up to position.
   *
   * @param position The position of the number where you want the sum to stop.
   * @return The sum of all Fibonacci numbers up to <em>position</em>.
   */
  long sumUpTo(long position);

}
