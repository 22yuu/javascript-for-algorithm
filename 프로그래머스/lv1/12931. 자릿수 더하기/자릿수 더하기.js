function solution(n)
{
    var answer = 0;
    let str = n + "";
    let arr = str.split("");

    for(var i in arr) {
        answer += +arr[i];
    }
    return answer;
}