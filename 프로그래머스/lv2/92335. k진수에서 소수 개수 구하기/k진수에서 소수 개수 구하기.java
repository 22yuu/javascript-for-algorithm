import java.util.*;
import java.math.BigInteger;

class Solution {
    
    
    public boolean isPrime(BigInteger n) {
        
        long num = n.longValue();
        
        if(num <= 1) return false;
        
        for( long i = 2; i <= Math.sqrt(num); i++) {
          
          if( num % i == 0) {
              return false;
          }
      }
      return true;

    }
    
    public int solution(int n, int k) {
        int answer = 0;
        String[] nums = Integer.toString(n,k).split("0");
        
        for(String num : nums) {
            if(num.equals("")) {
                // System.out.println("1");
                continue;
            }
            // if(isPrime(Integer.parseInt(num))) answer++;
            if(isPrime(new BigInteger(num))) answer++;

        }
        return answer;
    }
}