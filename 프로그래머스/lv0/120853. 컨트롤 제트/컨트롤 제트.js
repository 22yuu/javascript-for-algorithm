function solution(s) {
    var answer = 0;
    const splitted = s.split(" ");
    
    for(let i = 0; i < splitted.length; i++) {
        if(splitted[i] === 'Z') {
            answer -= Number(splitted[i - 1]);
        } else {
            answer += Number(splitted[i]);
        }
    }
    return answer;
}