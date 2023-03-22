/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String[] inputs = br.readLine().split(" ");
			int P = Integer.parseInt(inputs[0]); // A사 1L당 요금
			int Q = Integer.parseInt(inputs[1]); // B사 R리터 이하 기본요금
			int R = Integer.parseInt(inputs[2]); // B사 R리터 한계선
			int S = Integer.parseInt(inputs[3]); // B사 R리터 초과 당 1L 요금
			int W = Integer.parseInt(inputs[4]); // 종민이가 한달간 사용한 수도의 양
			
			int A_value = P*W; // A사 비용
			int B_value = W <= R ? Q : Q + ((W-R)*S); // B사 비용 W < R 이면 R리터 이하이므로 기본요금 Q : 초과하면 기본요금 Q에서 1L당 S 요금을 지불
			
			if(A_value > B_value) {
				System.out.printf("#%d %d\n", test_case, B_value);
			} else {
				System.out.printf("#%d %d\n", test_case, A_value);
			}
		}
		
	}
}