function solution(my_string, num1, num2) {
    var answer = '';
    let splitted = my_string.split("");
    
    let temp = splitted[num1];
    splitted[num1] = splitted[num2];
    splitted[num2] = temp;
    
    answer = splitted.join('');
    
    return answer;
}