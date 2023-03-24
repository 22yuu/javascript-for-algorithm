import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
//         int num = n-1;
//         double sqrt = Math.sqrt(num);
//         double fNum = Math.floor(sqrt);
        
//         // System.out.println(sqrt);
        
//         answer = sqrt - fNum == 0 ? (int)sqrt : num;
        
//         for(int i = 1; i <= n; i++) {
//             if(n % i == 1) {
//                 double sqrt = Math.sqrt(i);
//                 if(i - Math.floor(sqrt) == 0) {
//                     answer = (int)sqrt;
//                 } else {
//                     answer = i;
//                 }
                
//                 break;
//             }
//         }
        
        for(int i = 1; i <= n; i++) {
            if(n % i == 1) {
                answer = i; 
                break;
            }
        }
        
        return answer;
    }
}