function solution(n) {
    var answer = 0;
    let index = 0;
    let operand = 1;
    while(index < n) {
        
        if(operand % 3 === 0 || String(operand).includes(3)) {
            operand++;
            continue;
        } else {
            answer = operand;
        }
        
        // console.log(`${index} : ${operand} / ${answer} `);
        
        index++;
        operand++;
        
    }
    
    
    return answer;
}