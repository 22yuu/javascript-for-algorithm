function solution(numbers) {
    var answer = '';
    
    let newArr = numbers.map((ele) => String(ele));
    answer = newArr.sort((a,b) => (b+a) - (a+b)).join('');
    
    return answer[0] === '0' ? '0' : answer;
}