function solution(score) {
    let answer = [];
    
    const avgArray = score.map((avg) => (avg[0] + avg[1]) / 2)
    
    const copiedArray = [...avgArray].sort((a,b) => b - a);
    
    answer = avgArray.map((num) => copiedArray.indexOf(num) + 1);
    
    return answer;
}