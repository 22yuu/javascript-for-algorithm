function solution(n, computers) {
    var answer = 0;
    const visited = new Array(n).fill(false);
    
    const dfs = (index) => {
        
        if(visited[index] || index === n) {
            return;
        }
        
        visited[index] = true;
        
        for(let i = 0; i < computers[index].length; i++) {
            
            if(index === i) continue;
            
            if(!visited[i] && computers[index][i] === 1) {
                dfs(i);
            }
        }
    }
    
    for(let i = 0; i < n; i++) {
        
        if(!visited[i]) {
            dfs(i);
            answer += 1;
        }
    }
    
    return answer;
}