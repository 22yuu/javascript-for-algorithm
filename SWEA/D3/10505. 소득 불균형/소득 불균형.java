import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = Integer.parseInt(br.readLine());
            String[] inputs = br.readLine().split(" ");
            int[] numArray = new int[inputs.length];
			int avg = 0;
            int sum = 0;
            int count = 0;
            
            for(int i = 0; i < inputs.length; i++) {
                numArray[i] = Integer.parseInt(inputs[i]);
            }
            
			// 1. 평균을 구함
            for(int i = 0; i < numArray.length; i++) {
            	    sum += numArray[i];
            }
            
            avg = sum / n;
            
            // 2.  n명의 사람의 소득이 주어졌을 때 이 중 평균 이하의 소득을 가진 사람들의 수를 출력해야 한다.
            
            for(int i = 0; i < numArray.length; i++) {
             	if(avg >= numArray[i]) count++;   
            }
            
            
			System.out.println("#" + test_case + " " + count);
            
		}
	}
}