class Solution {
    public int solution(String my_string, String is_prefix) {
        
        if(my_string.charAt(0) != is_prefix.charAt(0) || is_prefix.length() > my_string.length()) return 0;
        
        String slicedString = my_string.substring(0, is_prefix.length());
        
        return slicedString.matches(is_prefix) ? 1 : 0;
    }
}