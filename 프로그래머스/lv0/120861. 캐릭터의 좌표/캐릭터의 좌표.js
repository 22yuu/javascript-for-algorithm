function solution(keyinput, board) {
    var answer = [0, 0];
    const obj = {
        up: [0, 1],
        down: [0, -1],
        left: [-1, 0],
        right: [1, 0]
    }
    const minX = -Math.floor(board[0] / 2);
    const maxX = Math.floor(board[0] / 2);
    const minY = -Math.floor(board[1] / 2);
    const maxY = Math.floor(board[1] / 2);
    
    for(let cmd of keyinput) {
        const [x, y] = obj[cmd]; // 비구조화 할당
        
        const nx = answer[0] + x;
        const ny = answer[1] + y;
        
        // 범위를 벗어날 경우 무시
        if(nx < minX || ny < minY || nx > maxX || ny > maxY) continue;
        
        answer[0] = nx;
        answer[1] = ny;
    }
    
    return answer;
}