package concurrency.threadsafe.confinement;

import java.math.BigInteger;
import java.util.HashMap;

public class UnsafePrime {
    // Hash map is not thread safe in this case
    // If multiple threads are trying to do put at the same time, then this map could be corrupted
    private static HashMap<Integer, Boolean> cache = new HashMap<>();

    public static boolean isPrime(int number) {
        // Using memoization technique
        if (cache.containsKey(number)) {
            return cache.get(number);
        }

        boolean answer = BigInteger.valueOf(number).isProbablePrime(100);
        cache.put(number, answer);
        return answer;
    }
}
