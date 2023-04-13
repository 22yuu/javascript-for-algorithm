function solution(array, commands) {
    var answer = [];
    
    for(let cmd of commands) {
        const [i, j , k] = cmd;
        
        const arr = array.slice(i - 1, j).sort((a,b) => a - b);
        
        answer.push(arr[k - 1]);
    }
    
    return answer;
}