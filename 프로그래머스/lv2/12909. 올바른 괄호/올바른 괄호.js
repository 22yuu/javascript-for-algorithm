function solution(s){
    var answer = true;
    let stack = [];
    
    for(let i = 0; i < s.length; i++) {
        //console.log(s[i])
        
        if(s[i] === '(') stack.push(s[i]);
        else {
            let tmp = stack.pop();
            if(tmp !== '(') return false;
        }
    }
    
    if(stack.length > 0) return false;

    return answer;
}