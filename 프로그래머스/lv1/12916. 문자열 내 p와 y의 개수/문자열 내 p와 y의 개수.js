function solution(s){
    var answer = true;
    let pCount = 0;
    let yCount = 0;
    
    s = s.toLowerCase();
    
    for(let c of s) {
        if(c === 'p') pCount += 1;
        
        if(c === 'y') yCount += 1;
    }
    

    return pCount === yCount;
}