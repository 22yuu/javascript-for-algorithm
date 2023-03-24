import java.util.*;

class Solution {
    static int[] res = { -1 };
    static int[] lion;
    static int max = -1000;
    
    public void dfs(int[] info, int cnt, int n) {
        if(cnt == n+1) {
            int apeach_point = 0;
            int lion_point = 0;
            for(int i = 0; i <= 10; i++) {
                if(info[i] != 0 || lion[i] != 0) {
                    if(info[i] < lion[i]) 
                        lion_point += 10 - i;
                    else
                        apeach_point += 10 - i;
                }
            }
            if(lion_point > apeach_point) {
                if(lion_point - apeach_point >= max) {
                    res = lion.clone();
                    max = lion_point - apeach_point;
                } 
            }
            return;
        } // end if
        for(int j = 0; j <= 10 && lion[j] <= info[j]; j++) {
            lion[j]++;
            dfs(info, cnt + 1, n);
            lion[j]--;
        } // end for
    }
    
    public int[] solution(int n, int[] info) {
        
        /**
        1. 더 많이 맞춘 사람이 해당 점수 득점
            1-1 동일한 개수의 경우 도전자인 어피치가 득점
        2. 어피치가 화살을 다 쏜후 라이언이 쏨
        3. 라이언이 가장 큰 점수 차이로 우승하기 위해 어떤 과녁 점수에 맞혀야 하는지?
        4. 라이언이 우승할 수 없는 경우 (무조건 지거나 비기는 경우) [-1]을 리턴
        5. 라이언이 가장 큰 점수 차이로 우승할 수 있는 방법이 여러 가지 일 경우, 가장 낮은 점수를 더 많이 맞힌 경우를 리턴
        
        - 제한사항의 n의 크기를 보고 완전탐색으로, 그리고 시간 제한의 존재를 보고 백트래킹을 떠올렸다.
        - 가지치기를 하는 기준은 라이언이 임의의 점수에서 어피치에게 점수를 따내기 전 까지만 반복문을 돌리고 (lion[j] <= info[j]) 그 이상은 반복문을 진행하지 않게하였다.
        - 그리고 cnt가 n+1이 되면 점수 계산을 해주고 max값이 갱신된다면 현재 lion을 res배열에 clone해주고 끝
        */
        lion = new int[11];
        dfs(info, 1, n);
        return res;
    }
}