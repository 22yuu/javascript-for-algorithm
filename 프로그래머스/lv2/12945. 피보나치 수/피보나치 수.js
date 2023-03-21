// 주석처리 시간초과
// function solution(n) {
//     var answer = 0;
    
//     //if(n < 2) return n;
    
//     answer = Fibonacci(n)%1234567;
//     return answer;
// }
// function Fibonacci(num) {
//     if(num < 2) return num;
//     return Fibonacci(num - 1)%1234567 + Fibonacci(num - 2)%1234567;
// }

function solution(n) {
    let answer = fibonumber(n)%1234567;
    return answer;
}

function fibonumber(v) {
    let bottom_up = [];
    bottom_up[0] = 0;
    bottom_up[1] = 1;
    bottom_up[2] = 1;
    for (let i = 3; i <= v; i++) {
        bottom_up[i] = (bottom_up[i-1]%1234567 + bottom_up[i-2]%1234567);
    }
    return bottom_up[v];
}