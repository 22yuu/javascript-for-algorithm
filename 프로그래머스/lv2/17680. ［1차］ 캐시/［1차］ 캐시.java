import java.util.*;

class Solution {
    
    public Queue<String> cache;
    public int CACHE_HIT = 1;
    public int CACHE_MISS = 5;
    
    public Queue<String> removeHitCache(Queue<String> que, String target) {
        Queue<String> helper = new LinkedList<>();
        
        while(!que.isEmpty()) {            
            String data = que.poll();
            
            if(!data.equals(target)) {
                helper.offer(data);    
            }
        }
        
        return helper;
    }
    
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        cache = new LinkedList<>();
        
        for(String city : cities) {
            city = city.toLowerCase();
            boolean isHit = cache.contains(city);
            
            
            if(!isHit) {
                // miss
                answer += CACHE_MISS;
                cache.offer(city);
                
                if(cache.size() > cacheSize) {
                    cache.poll();
                }
                
            } else {
                // hit
                answer += CACHE_HIT;
                cache = removeHitCache(cache, city);
                cache.offer(city);
            }
        }
        return answer;
    }   
}