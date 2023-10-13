class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int wMax = Integer.MIN_VALUE;
        int wMin = Integer.MAX_VALUE;
        int hMax = Integer.MIN_VALUE;
        int hMin = Integer.MAX_VALUE;
        
        int[] wMaxCoord = new int[2];
        int[] wMinCoord = new int[2];
        int[] hMaxCoord = new int[2];
        int[] hMinCoord = new int[2];
        
        char token = '#';
        
        for(int i = 0; i < wallpaper.length; i++) {
            
            for(int j = 0; j < wallpaper[i].length(); j++) {
                if(token == wallpaper[i].charAt(j)) {
                    
                    if(wMax < j) wMax = j;
                    if(wMin > j) wMin = j;
                    if(hMax < i) hMax = i;
                    if(hMin > i) hMin = i;
                    
                }
                
            }
        }
        
        answer[0] = hMin;
        answer[1] = wMin;
        answer[2] = hMax + 1;
        answer[3] = wMax + 1;
        
        return answer;
    }
}