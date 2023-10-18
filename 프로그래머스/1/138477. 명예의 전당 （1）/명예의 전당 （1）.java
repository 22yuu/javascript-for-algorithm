import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        List<Integer> rankList = new ArrayList<>();
        int[] answer = new int[score.length];
        

        for(int i = 0; i < score.length; i++) {
            
            // list가 비었을 때
            if(rankList.isEmpty()) {
                rankList.add(score[i]);
                answer[i] = score[i];
                continue;
            }
            
            // list의 크기가 k보다 작을 때
            if(rankList.size() < k) {
                rankList.add(score[i]);
                Collections.sort(rankList, Collections.reverseOrder());
                answer[i] = rankList.get(rankList.size() - 1);
            } else if(rankList.size() == k) {
                int value = rankList.get(k - 1);
                
                if(value > score[i]) {
                    answer[i] = value;
                    continue;
                } else {
                    rankList.remove(k - 1);
                    rankList.add(score[i]);
                    Collections.sort(rankList, Collections.reverseOrder());
                    answer[i] = rankList.get(k - 1);
                }
            }
            
        }
        
        return answer;
    }
}