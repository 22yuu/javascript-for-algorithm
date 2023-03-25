function solution(number) {
    var answer = 0;
    const visited = new Array(number.length).fill(false);
    
    const recrusion = (idx, value, depth) => {
        if(depth === 3) {
            if(value === 0) {
                answer += 1;
            }
            
            return;
        }
        
        for(let i = idx+1; i < number.length; i++) {
            visited[i] = true;
            recrusion(i, value + number[i], depth + 1);
            visited[i] = false;
        }
    }
    
    
    for(let i = 0; i < number.length; i++) {
        recrusion(i, number[i], 1);
    }
    
    return answer;
}