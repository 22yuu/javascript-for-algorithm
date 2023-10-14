class Solution {
    public String solution(int[] food) {
        String answer = "0";
        String prev = "";
        String next = "";
        
        for(int i = 1; i < food.length; i++) {
            int fCount = food[i] / 2;
             if(fCount > 0) {
                for(int j = 0 ; j < fCount; j++) {
                    prev = prev + i;
                    next = i + next;
                }
             }
        }
        return prev + answer + next;
    }
}