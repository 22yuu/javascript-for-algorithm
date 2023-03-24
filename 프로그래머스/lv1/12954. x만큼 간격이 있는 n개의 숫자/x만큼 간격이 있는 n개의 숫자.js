function solution(x, n) {
    var answer = new Array();
    var temp = 0;
    
    for(var i = 0; i < n; i++) {
        temp += x;
        answer.push(temp);
    }
    return answer;
}