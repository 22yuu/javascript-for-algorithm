function solution(clothes) {
    var answer = 1;
    const obj = {};
    
    for(let i = 0; i < clothes.length; i++) {
        const [item, gear] = clothes[i];
        
        obj[gear] = obj[gear] + 1 || 1;
    }
    
    
    for(let [key, value] of Object.entries(obj)) {
        answer *= (value + 1)
    }
    
    return answer - 1;
}