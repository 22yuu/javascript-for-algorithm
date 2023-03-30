function solution(arr)
{
    var answer = [];
    const stack = [];
    
    for(let n of arr) {
        if(stack.length === 0) {
            stack.push(n);
            continue;
        }
        
        const peek = stack[stack.length - 1];
        
        if(n === peek) continue;
        else {
            stack.push(n);
        }
    }
    
    
    return stack;
}