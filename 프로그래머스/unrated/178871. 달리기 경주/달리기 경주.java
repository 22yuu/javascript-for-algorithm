import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        
        HashMap<String, Integer> mapPlayer = new HashMap<>();
        
        // init Hash Map
        for(int i = 0; i < players.length; i++) {
            mapPlayer.put(players[i], i);
        }
        
        
        for(int i = 0; i < callings.length; i++) {
           
            int currentRank = mapPlayer.get(callings[i]);
            String currentPlayerName = callings[i];
            
            
            // 바로 앞 플레이어
            String frontPlayer = players[currentRank - 1];
            
            // swap array
            String temp = players[currentRank - 1];
            players[currentRank - 1] = players[currentRank];
            players[currentRank] = temp;
            
            mapPlayer.put(currentPlayerName, currentRank - 1);
            mapPlayer.put(frontPlayer, currentRank);
        }
        
        return players;
    }
}