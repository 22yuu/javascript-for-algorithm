function solution(str1, str2) {
    var answer = 0;
    // 두 집합 A, B 사이틔 자카드 유사도(J(A,B)) = 두 집합의 교집합 크기 / 두 집합의 합집합 크기
    // 두 집합 모두 공집합일 경우 유사도는 1이다.
    
    // 중복을 허용하는 다중집합에 대해서 확장할 수 있음
    // 두 다중 집합의 교집합은 min() / 합집합은 max()
    const pattern = /[^a-zA-Z]/g;
    
    // str1 = str1.replace(pattern, "");
    // str2 = str2.replace(pattern, "");

    const splitString = (str) => {
        
        const arr = [];
        for(let i = 0; i < str.length - 1; i++) {
            const s = `${str[i]}${str[i+1]}`;
            
            if(s.replace(pattern, "").length <= 1) continue;
            
            arr.push(s);
        }
        
        return arr;
    }
    
    const A = splitString(str1.toUpperCase());
    const B = splitString(str2.toUpperCase());
    
    const objA = {};
    [...A].forEach((key) => objA[key] = objA[key] + 1 || 1);
    console.log(objA);
    
    const objB = {};
    [...B].forEach((key) => objB[key] = objB[key] + 1 || 1);
    console.log(objB);
    
    const keysA = Object.keys(objA);
    const keysB = Object.keys(objB);
    
    if(keysA.length === 0 && keysB.length === 0) {
        return 1 * 65536;
    }
    
    const intersection = [];
    const union = [];
    
    // 교집합
    for(let key of keysA) {
        if(objB[key] !== undefined) {
            const len = Math.min(objA[key], objB[key]);
            for(let i = 0; i < len; i++) intersection.push(key);
        }
    }
    console.log(intersection);
    
    // 합집합
    for(let key of keysA) {
        const temp = objB[key] || 0;
        
        const len = Math.max(objA[key], temp);
        for(let i = 0; i < len; i++) union.push(key);
    }
    
    for(let key of keysB) {
        if(union.includes(key)) continue;
        
        for(let i = 0; i < objB[key]; i++) union.push(key);
    }
    console.log(union);
    console.log(union.length);
    
    
    const unionObj = {};
    console.log(unionObj);
    keysB.forEach((key) => unionObj[key] = unionObj[key] + objB[key] || objB[key]);
    console.log(unionObj);
    
    const unionKeys = Object.keys(unionObj);
    
    const unionCount = unionKeys.reduce((prev, curr) => prev + unionObj[curr], 0);
    console.log(intersection.length);
    console.log(unionCount);
    
    answer = Math.floor((intersection.length / union.length ) * 65536);
    
    return answer;
}
