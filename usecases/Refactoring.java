package usecases;

class Solution {

    public int solution(int[] arr) {
        int answer = 0;

        while (true) {
            boolean isChanged = false;
            answer++;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= 50 && arr[i] % 2 == 0) {
                    arr[i] /= 2;
                    isChanged = true;
                    continue;
                }
                if (arr[i] < 50 && arr[i] % 2 != 0) {
                    arr[i] = arr[i] * 2 + 1;
                    isChanged = true;
                    continue;
                }
            }
            if (!isChanged) {
                answer--;
                break;
            }
        }

        return answer;
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] { 1, 2, 3, 100, 99, 98 }));
    }
}
