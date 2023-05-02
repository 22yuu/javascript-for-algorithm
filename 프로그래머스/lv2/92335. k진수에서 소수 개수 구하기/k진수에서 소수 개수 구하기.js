// 소수 판별 함수
function isPrime(num) {
    if(num === 0 || num === 1) return false;
    
    for(let i = 2; i <= Math.sqrt(num); i++) {
        if(num % i === 0) {
            return false;
        }
    }
    
    return true;
}

// 진법 변환 함수
function transform(num, k) {
    let value = '';
    
    while(num > 0) {
        
        value += num % k;
        num = Math.floor(num / k);
    }
    
    return value.split('').reverse().join('');
}

function solution(n, k) {
    var answer = 0;
    const transformed = transform(n, k);
    
    const chars = transformed.split("0");
    
    for(let i = 0; i < chars.length; i++) {
        const value = parseInt(chars[i]);
        
        if(Number.isNaN(value)) continue;    
        
        if(isPrime(value)) answer += 1;
    }
    
    return answer;
}