function solution(arr)
{
    const answer = [arr[0]];
    let index = 0;
    
    
    for(let i = 1; i < arr.length; i++) {
        if(answer[index] === arr[i]) continue;
        
        answer.push(arr[i]);
        index++;
    }
    
    
    return answer;
}