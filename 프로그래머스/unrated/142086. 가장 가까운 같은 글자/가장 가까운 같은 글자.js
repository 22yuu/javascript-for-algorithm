function solution(s) {
    var answer = [];
    const split = s.split("");
    const obj = {};
    
    for(let i = 0; i < split.length; i++) {
        if(obj[split[i]] === undefined) {
            obj[split[i]] = i;
            answer[i] = -1;
            continue;
        }
        
        // obj안에 있을 경우
        answer[i] = i - obj[split[i]];
        obj[split[i]] = i;
    }
    
    return answer;
}