function solution(numLog) {
    var answer = '';
    const order = {
        'w': 1,
        's': -1,
        'd': 10,
        'a': -10
    }
    
    for(let i = 1; i < numLog.length; i++) {
        const prev = numLog[i - 1];
        const curr = numLog[i];
        
        for(let [key, value] of Object.entries(order)) {
            const res = prev + value;
            
            if(res === curr) {
                answer += key;
                break;
            }
        }
    }
    
    return answer;
}