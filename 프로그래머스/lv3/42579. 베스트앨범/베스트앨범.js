function solution(genres, plays) {
     
    
    /*
        "classic":[
            {id: 0, palys, 500},
            {id: 2, palys, 150},
            {id: 3, palys, 800},
        ],
        
        "pop": [
            {id: 1, plays:600},
            {id: 4, plays:2500},
        ]
    */
    const answer = [];
    const genresObj = genres.reduce((obj, genre, index) => {            
        if(obj[genre] === undefined) {
            return {...obj, [genre]:[{id: index, plays:plays[index]}]}
        }
        
        obj[genre].push({id: index, plays:plays[index]});
        
        return {...obj};
    }, {});
    
    const keys = Object.keys(genresObj);
    const orderManyPlayed = [];
    
    for(const genre of keys) {
        
        const musics = genresObj[genre];
        genresObj[genre].sort((a, b) => {
            if(a.plays < b.plays) {
                return 1;
            }else if (a.plays === b.plays) {
                return a.id - b.id;
            } else {
                return -1;
            }
        });
        let sum = 0;
        for(let i = 0; i < musics.length; i++) {
            sum += musics[i].plays;
        }
        
        orderManyPlayed.push({genre: genre, total: sum});
    }
    
    orderManyPlayed.sort((a,b) => {
        if(a.total < b.total) {
            return 1;
        } else {
            return -1;
        }
    })    
    
    orderManyPlayed.forEach((item) => {
        const genre = item.genre;
        
        if(genresObj[genre].length >= 2) {
            answer.push(genresObj[genre][0].id)
            answer.push(genresObj[genre][1].id)
        } else {
            answer.push(genresObj[genre][0].id)
        }
    })

    
    
    
    
    
    
    // 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
    
    
    // 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
    
    
    // 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
    

    return answer;
}