function solution(numlist, n) {
    let answer = [];
    let distObj = {};
    const distance = numlist.map((num) => Math.abs(n - num));
    
    // console.log(distance);
    
    answer = numlist.map((num, index) => [num, distance[index]]).sort((a, b) => {
        if(a[1] - b[1] < 0) {
            return -1
        } else if (a[1] - b[1] > 0) {
            return 1
        } else if (a[1] === b[1]) { 
            if(a[0] > b[0]) {
                return -1;
            } else {
                return 1;
            }
        }
    }).map((arr) => arr[0]);
    
    // console.log(answer)

    
    return answer;
}