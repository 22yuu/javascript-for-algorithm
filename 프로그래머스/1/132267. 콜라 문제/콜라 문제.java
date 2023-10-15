class Solution {
    public int returnCoke(int emptyBottle, int a, int b) {
        
        return (emptyBottle / a) * b;
    }
    
    public int solution(int a, int b, int n) {
        int answer = 0;
        int cokeBottle = n;
        
        while(cokeBottle >= a) {
            answer += cokeBottle / a * b;
            cokeBottle = cokeBottle / a * b + cokeBottle % a;
        }
        
        return answer;
    }
}