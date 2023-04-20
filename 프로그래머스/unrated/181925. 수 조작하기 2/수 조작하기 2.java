import java.util.*;


class Solution {
    
    public Map<String, Integer> hm;
    
    public String solution(int[] numLog) {
        String answer = "";
        hm = new HashMap<>();
        
        hm.put("w", 1);
        hm.put("s", -1);
        hm.put("d", 10);
        hm.put("a", -10);
        
        for(int i = 1; i < numLog.length; i++) {
            int prev = numLog[i - 1];
            int curr = numLog[i];
            
            for(Map.Entry<String, Integer> entry : hm.entrySet()) {
                int res = prev + entry.getValue();
                
                if(res == curr) {
                    answer += entry.getKey();
                    break;
                }
            }
            
        }
        
        return answer;
    }
}