function solution(name, yearning, photo) {
    var answer = [];
    const obj = name.reduce((obj, key, index) => ({...obj, [key]:yearning[index]}), {});
    
    // console.log(obj);
    
    for(let arr of photo) {
        let sum = 0;
        
        for(let name of arr) {
            sum += obj[name] || 0;    
        }
        answer.push(sum);
    }
    
    return answer;
}