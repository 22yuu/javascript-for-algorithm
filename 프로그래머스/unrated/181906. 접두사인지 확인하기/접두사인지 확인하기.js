function solution(my_string, is_prefix) {
    
    if(my_string[0] !== is_prefix[0] || is_prefix.length > my_string.length) return 0;
    
    const length = is_prefix.length;
    
    const slicedString = my_string.slice(0, length);
   
    return slicedString === is_prefix ? 1 : 0;
}