function solution(priorities, location) {
    let answer = 0;
    // 1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
    // 2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
    // 3. 그렇지 않으면 J를 인쇄합니다.
    
    // 우선 순위, target으로 객체로 저장한다.
    const list = priorities.map((priority, index) => ({
        target: index === location, // true or false를 가지는 불리언 타입으로 데이터를 저장
        priority: priority, // 중요도 
    }));
    
    // 저장된 데이터들을(list) 순회하면서 현재의 데이터보다 중요도가 높으면 list의 뒤로 보내고
    // 높은 중요도가 없다면 list에서 빼줘서 완료 큐에 데이터를 보관합니다.
    
    const doneQue = []; // 완료 큐
    
    while(list.length > 0) {
        
        const current = list.shift(); // 현재 데이터
        let flag = false; // 현재의 데이터보다 높은 중요도가 있는지 판별하기 위한 flag 변수
        
        for(let i = 0; i < list.length; i++) {
            
            if(list[i].priority > current.priority) {
                list.push(current);
                flag = true; // 현재의 데이터보다 높은 중요도가 있으므로 true로 변환
                break;
            }
        }
        
        if(!flag) {
            // flag가 false이므로 현재의 데이터보다 높은 중요도가 없다.
            // 그래서 완료 큐에 넣어준다.
            doneQue.push(current);
            
            // 근데 만약 현재의 데이터가 우리가 찾는 목표 값이라면?
            if(current.target) {
                answer = doneQue.length; // 목표 데이터를 이미 완료 큐에 넣었기 때문에
                // 완료 큐의 길이가 곧 인쇄된 순번이다.
            }
        }
        
        
        
    }
    
    return answer;
}