function solution(progresses, speeds) {
    if(progresses.length <= 1) return [progresses.length];
    /*
    const answer = [];
    // 기능은 진도가 100%일 때 서비스에 반영할 수 있음
    // 각 기능의 개발 속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있음
    // 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포
    
    // progressess 배포 되어야 하는 작업의 진도가 순서대로 나열된 배열
    // speeds 각 작업의 스피드
    
    // 남은 작업량을 구한 후 speed를 나눠서 배포까지 몇일 걸리는지를 구함
    const days = progresses.map((progress, index) => Math.ceil((100 - progress) / speeds[index]));
    
    console.log(days);
    let stack = [];
    
    for(let i = 0; i < days.length; i++) {
        
        // 스택이 비어있으면?
        if(stack.length === 0) {
            stack.push(days[i]);
            continue;
        } else if(stack[0] >= days[i]) {
            stack.push(days[i]);
        } else {
            answer.push(stack.length); // [7, 3] -> [2]
            stack = [days[i]]; // [7, 3] -> [9]
        }
    }
    
    // 스택이 비어 있지 않으면?
    if(stack !== 0) {
        answer.push(stack.length); // [9] -> [2, 1];
    }
    
    // 배포마다 몇 개의 기능이 배포되는지?
    return answer;
    */
    
    // 다른 풀이 방식
    const answer = [0]; // 배포된 기능 수를 카운트를 해서 저장해줄 거에요.
    const days = []; // 배포 일수를 계산해서 저장할 배열
    let max = null; // 최대 값 저장하기 위한 변수
    
    for(let i = 0, j = 0; i < progresses.length; i++) {
        days[i] = Math.ceil((100 - progresses[i]) / speeds[i]); // 완료일을 구해준다.
        
        if(max === null) { // 첫 번째 max값을 저장하기 위해서 
            max = days[i]; // max = 7;
            answer[j] += 1; // answer[0] = answer[0] + 1; -> 0 + 1 = 1
            continue;
        }
        
        if(days[i] <= max) { // 9 <= 7
            answer[j] += 1 // answer[0] = answer[0] + 1; -> 1 + 1 = 2;
        } else { 
            max = days[i]; // max = 9;
            answer[++j] = 1; // 전위증감 answer[1] = 1;
        }
    }
    
    // [2, 1]
    return answer;
}