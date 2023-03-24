function solution(n) {
    
    var answer = []
    
    do{
        answer.push(n%10);
        n = Math.floor(n/10);
    } while(n > 0);
    
    return answer;
}