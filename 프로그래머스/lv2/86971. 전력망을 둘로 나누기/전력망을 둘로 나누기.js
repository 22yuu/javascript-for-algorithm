// 전선을 잘라서 망을 구성하는 노드의 수의 차가 가장 최소인 값이 비슷한 망을 구성한다고 할 수 있다
// 그럼 전선을 어떻게 잘라야 할까? -> 방문을 안하고 다음으로 넘어감
// 1) 순차적으로 차례대로 방문하면서 자를 전선의 노드는 방문하지 않는 것으로 전선을 자름
// 2) 노드를 전달 인자로 넘겨 전달 인자를 제외한 모든 노드를 방문하면서 전력망을 형성
//    2-1) 이 때 visited 배열을 통해 방문을 체크
//    2-2) 현재 자를 전선 노드를 제외한 모든 전선을 방문
//    2-3) 루프를 한 번 돌고 난 후 망 카운트
//    2-4) visited 배열을 다시 false로 하고 다음 전선을 자름(1번 부터 다시)

function solution(n, wires) {
    var answer = Number.MAX_VALUE;
    const graph = new Array(n+1).fill(0);
    let visited = new Array(n+1).fill(false);
    
    // init graph
    for(let i = 1; i <= n; i++) {
        graph[i] = new Array(n+1).fill(0);
    }
    
    const dfs = (start, cut) => {
        // console.log(start + " ");
        
        
        for(let i = 1; i <= n; i++) {
            if(i === cut || i === start) {
                continue;
            }
            
            if((graph[start][i] === 1 && !visited[i])) {
                visited[i] = true;
                dfs(i, cut);
            }
        }
    }
    
    for(let node of wires) {
        const [x, y] = node;
        
        graph[x][y] = 1;
        graph[y][x] = 1;
    }

    for(let i = 1; i <= n; i++) {
        dfs(1, i);
        // console.log(visited);
        let falseCount = 0;
        let trueCount = 0;
        
        for(let j = 1; j <= n; j++) {
            if(visited[j]) {
                trueCount += 1;
                continue;
            }
            
            falseCount += 1;
        }
        
        // console.log(`${trueCount} / ${falseCount}`);
        
        const diff = Math.abs(trueCount - falseCount);
        
        answer = Math.min(answer, diff);
        
        visited = new Array(n+1).fill(false);
    }
    
    
    return answer;
}
