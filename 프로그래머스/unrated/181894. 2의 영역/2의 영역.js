function solution(arr) {
    if(arr.indexOf(2) === -1) return [-1];
    
    var answer = [2];
    let start = -1;
    let end = -1;
    let isStart = false;
    let sum = 0;
    let min = Number.MAX_VALUE;
    let resIndex = [0, 0];
    
    for(let i = 0; i < arr.length; i++) {

        if(arr[i] == 2 && !isStart) {
            isStart = true;
            start = i;
        } else if(arr[i] == 2 && isStart) {
            end = i;
            sum += arr[i];
            
//             if(min > sum) {
//                 min = sum;
//                 resIndex[0] = start;
//                 resIndex[1] = end + 1;
//                 sum = 0;
//             }
            
            // console.log(`${start} / ${end}`)
            // console.log(sum);
        }
        
        
        if(isStart) {
            sum += arr[i];
        }
    }
    
    // console.log(`${resIndex[0]} / ${resIndex[1]} `)
    if(end !== -1) {
        return arr.slice(start, end+1);
    }
    
    return answer;
}