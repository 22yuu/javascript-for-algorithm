function solution(park, routes) {
    var answer = [];
    const direction = {
        "E": [0, 1],
        "S": [1, 0],
        "W": [0, -1],
        "N": [-1, 0]
    }
    
    const map = [];

    for(let i = 0; i < park.length; i++) {
        map[i] = park[i].split("");
    }
    
    const h = map.length;
    const w = map[0].length;
    
    for(let r = 0; r < map.length; r++) {
        
        for(let c = 0; c < map[r].length; c++) {
            if(map[r][c] === 'S') {
                let nr = r;
                let nc = c;
                
                for(let route of routes) {
                    const [dir, value] = route.split(" ");
                    let isAvaliable = true;
                    
                    let new_r = nr;
                    let new_c = nc;
                    
                    for(let i = 0; i < value; i++) {
                        const [dr, dc] = direction[dir];
                        
                        new_r = new_r + dr;
                        new_c = new_c + dc;
                        
                        if(new_r < 0 || new_c < 0 || new_r > h - 1 || new_c > w - 1 ) {
                            isAvaliable = false;
                            break;
                        }
                        
                        if(map[new_r][new_c] === 'X') {
                            isAvaliable = false;
                            break;
                        }
                    }
                    
                    if(isAvaliable) {
                        // nr, nc 업데이트
                        for(let i = 0; i < value; i++) {
                            const [dr, dc] = direction[dir];

                            nr = nr + dr;
                            nc = nc + dc;
                        }
                    }
                }
                return [nr, nc];
            }
        }
    }
    
    return answer;
}