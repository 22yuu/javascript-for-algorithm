function solution(arr) {
  let answer = 0;

  arr.map((n) => (answer += n));

  answer = answer / arr.length;
  return answer;
}
