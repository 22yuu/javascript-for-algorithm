function solution(t, p) {
    var answer = 0;
    const length = p.length;
    const array = [];
    
    for(let i = 0; i < t.length - length + 1; i++) {
        let str = t[i];
        for(let j = i + 1; j < i + length; j++) {
            str += t[j];
        }
        
        array.push(Number(str));
    }
    
    for(let num of array) {
        if(Number(p) >= num) {
            answer += 1;
        }
    }
    
    return answer;
}