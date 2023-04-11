function solution(sizes) {
    var answer = 0;
    let maxWidth = -Number.MAX_VALUE;
    let maxHeight = -Number.MAX_VALUE;

    // 두 수를 비교해 큰 값은 가로, 작은 값은 세로로 정렬
    for(let i = 0; i < sizes.length; i++) {
        let [width, height] = sizes[i];
        
        if(width < height) {
            let temp = sizes[i][0];
            sizes[i][0] = sizes[i][1];
            sizes[i][1] = temp;
        }
    }
    
    // console.log(sizes);
    
    // 그 후 각각의 최대값을 구해서 곱하자
    for(let i = 0; i < sizes.length; i++) {
        let [width, height] = sizes[i];
        
        maxWidth = Math.max(maxWidth, width);
        maxHeight = Math.max(maxHeight, height);
    }
    return maxWidth * maxHeight;
}