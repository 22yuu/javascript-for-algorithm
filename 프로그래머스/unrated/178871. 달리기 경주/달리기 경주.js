function solution(players, callings) {
    var answer = [];
    
    // 해시맵으로 풀어보자
    const obj = {};
    
    [...players].forEach((key, index) => obj[key] = index);
    
    for(let name of callings) {
        // find index
        const idx = obj[name]; // 불려진 이름을 가지고 등수(인덱스)를 찾음
        const otherPlayerName = players[idx - 1]; // 제껴진 사람 이름
        
        // swap
        [players[idx - 1], players[idx]] = [players[idx], players[idx - 1]];
        
        obj[name] -= 1; // 제꼈으니까 인덱스를 하나 빼줌
        obj[otherPlayerName] += 1; // 추월 당했으니까 하나 추가해줌
    }
    
    return players;
}

function findIndex(players, name) {
    let idx;
    for(let i = 0; i < players.length; i++) {
        if(players[i] === name) {
            idx = i;
            break;
        }
    }
    
    return idx;
}