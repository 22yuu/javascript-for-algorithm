import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        int cardIdx1 = 0;
        int cardIdx2 = 0;
        
        for(int i = 0; i < goal.length; i++) {
            String word = goal[i];
            
            if(Arrays.asList(cards1).contains(word)) {
                int idx = Arrays.asList(cards1).indexOf(word);
                
                if(idx != cardIdx1) {
                    answer = "No";
                }
                cardIdx1++;
            } else if (Arrays.asList(cards2).contains(word)) {
                int idx = Arrays.asList(cards2).indexOf(word);
                if(idx != cardIdx2) {
                    answer = "No";
                }
                cardIdx2++;
            }
            
        }
        return answer;
    }
}