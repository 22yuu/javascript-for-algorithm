function solution(n) {
    var answer = 0;
    let x = 1;
    
    while(n >= x) {
        if(n % x === 1) {
            answer = x;
            break;
        }
        x++;
    }
    return answer;
}