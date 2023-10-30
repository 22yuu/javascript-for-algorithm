class Solution {
    
    public int getDivisor(int number) {
        int count = 0;
        
        for(int i = 1; i * i <= number; i++) {
            if(i * i == number) count += 1;
            else if(number % i == 0) count +=2;
        }
        
        return count;
    }
    
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for(int i = 1; i <= number; i++) {
            int knightPower = getDivisor(i);
            
            if(knightPower > limit) answer += power;
            else answer += knightPower;
        }
        
        return answer;
    }
}