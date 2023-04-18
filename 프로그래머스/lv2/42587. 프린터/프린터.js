function solution(priorities, location) {
    const list = priorities.map((item, index) => ({
        target: index === location,
        priority: item,
    }));
    
    // console.log(list);
    let count = 0;
    let que = []; // 완료된 것들 
    let answer = 0;
    
    while(list.length > 0) {
        const current = list.shift();
        
        let flag = false;
        
        for(let i = 0; i < list.length; i++) {
            if(list[i].priority > current.priority) {
                list.push(current);
                count = 0;
                flag = true;
                break; // for문 탈출
            }
        }
        
        if(!flag) {
            que.push(current);
        }
        
        if(current.target) {
            answer = que.length;
        }
    }
    
    return answer;
}