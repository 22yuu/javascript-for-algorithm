function solution(s) {
    const splitted = s.split(" ").map((n) => Number(n));
    const max = Math.max(...splitted);
    const min = Math.min(...splitted);
    
    return `${min} ${max}`;
}