function solution(arr, k) {
    return arr.map((num) => {
        if(k % 2 == 0) return num + k;
        else return num * k;
    })
}