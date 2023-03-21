function solution(k, tangerine) {
    var answer = 0;
    const obj = {};
    
    tangerine.sort((a,b) => a - b);
    tangerine.forEach((item, index) => {
        obj[item] = obj[item] + 1 || 1;
    });
    
    const values = Object.values(obj).sort((a, b) => b - a);
    
    let sum = 0;
        
    for(let i = 0; i < values.length; i++) {
        answer += 1;
        sum += values[i];
        if(sum >= k) break;
    }
    
    return answer;
}