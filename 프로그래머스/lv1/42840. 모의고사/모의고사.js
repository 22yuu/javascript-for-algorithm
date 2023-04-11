function solution(answers) {
    var answer = [];
    const patterns = {
        1: [1, 2, 3, 4, 5],
        2: [2, 1, 2, 3, 2, 4, 2, 5],
        3: [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    }
    
    const counts = {
        1: 0,
        2: 0,
        3: 0
    }
    
    for(let person = 1; person <= 3; person++) {
        // console.log(patterns[person]);
        const threshold = patterns[person].length;
        let index = 0;

        for(let i = 0; i < answers.length; i++) {
            if(index === threshold) index = 0;
            if(answers[i] === patterns[person][index++]) {
                counts[person] += 1;
            }
        }
    }
    
    const values = Object.values(counts);
    const max = Math.max(...values);
    
    for(let [key, value] of Object.entries(counts)) {    
        if(max === value) answer.push(Number(key));
    }
    
    
    
    return answer.sort((a,b) => a - b);
}