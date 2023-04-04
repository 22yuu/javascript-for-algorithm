function solution(s){
    const stack = [];
    const split = s.split("");
    
    if(split[0] === ')') return false;

    for(let s of split) {
        // ')'를 만나면 pop!
        if(stack.length !== 0 && s === ')') {
            stack.pop();
            continue;
        } else if (stack.length === 0 && s === ')') {
            return false;
        }
        
        // '('일 때는 무조건 push
        stack.push(s);
        // console.log(stack);
    }

    return stack.length === 0;
}