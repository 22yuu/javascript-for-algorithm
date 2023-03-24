class Solution {
    
    public int mySolution(int n) {
        int answer = 0;
        
        for(int i = 1; i <=n; i++ ) {
            if(n%i == 0) answer += i;
        }
        return answer;
    }
    
    public int solution1(int n) {
        int answer = 0;
        
        for(int i = 1; i <=n/2; i++ ) {
            if(n%i == 0) answer += i;
        }
        return answer+n;
    }
    
    public int solution(int n) {
        return mySolution(n);
        // return solution1(n);
    }
}