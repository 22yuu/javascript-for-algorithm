function solution(numbers) {
    let answer = '';
    const obj = {
        zero: 0,
        one: 1,
        two: 2,
        three: 3,
        four: 4,
        five: 5,
        six: 6,
        seven: 7,
        eight: 8,
        nine: 9
    }
    
    let str = '';
    
    for(let i = 0; i <numbers.length; i++) {
        str += numbers[i];
        
        if(obj[str] !== undefined) {
            answer += obj[str];
            str = '';
        }
    }
    
    return Number(answer);
}