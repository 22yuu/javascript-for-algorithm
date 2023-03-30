function solution(num) {
    var answer = '';
    
    // if(num === 0) {
    //     answer="Even";
    // } else if (num % 2 == 0) {
    //     return answer="Even";
    // } else if (num % 2 == 1 || num % 2 == -1) {
    //     return answer="Odd";
    // }
    
    return num % 2 === 0 ? "Even" : "Odd";
}