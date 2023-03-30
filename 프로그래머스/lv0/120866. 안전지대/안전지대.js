function solution(board) {
    let n = board.length;
    let answer = n * n; // n * n
    
    const dx = [-1, 1, 0, 0, -1, -1, 1,  1];
    const dy = [ 0, 0, 1, -1,  1, -1, 1, -1];
    
    for(let i = 0; i < n; i++) {
        for(let j = 0; j < n; j++) {
            if(board[i][j] === 1) {
                // 지뢰 발견
                answer -= 1;
                
                // 8방향 탐색
                for(let d = 0; d < 8; d++) {
                    const nx = i + dx[d];
                    const ny = j + dy[d];
                    
                    
                    if(nx < 0 || ny < 0 || nx > n-1 || ny > n-1) continue;
                    
                    if(board[nx][ny] === 0) {
                        board[nx][ny] = -1;
                        answer -= 1;
                    }
                }
            }
        }
    }
    
    // console.log(board);
    
    
    
    return answer;
}