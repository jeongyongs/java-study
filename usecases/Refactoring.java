package usecases;

class Solution {

    public int solution(int[] arr) {
        int answer = 0;

        while (true) {
            boolean isChanged = false;
            answer++;

            for (int i = 0; i < arr.length; i++) {
                isChanged = changeValue(arr, isChanged, i);
            }
            if (!isChanged) {
                answer--;
                break;
            }
        }

        return answer;
    }

    private boolean changeValue(int[] arr, boolean isChanged, int i) {
        Predicate firstCondition = value -> value >= 50 && value % 2 == 0;
        Operation firstOperation = value -> value / 2;
        Predicate secondCondition = value -> value < 50 && value % 2 != 0;
        Operation secondOperation = value -> value * 2 + 1;

        if (changeValueWithCondition(firstCondition, firstOperation, arr, i)) {
            return true;
        }
        if (changeValueWithCondition(secondCondition, secondOperation, arr, i)) {
            return true;
        }
        return isChanged;
    }

    private boolean changeValueWithCondition(Predicate predicate, Operation operation, int[] arr, int i) {
        if (predicate.test(arr[i])) {
            arr[i] = operation.operate(arr[i]);
            return true;
        }
        return false;
    }
}

interface Predicate {
    boolean test(int value);
}

interface Operation {
    int operate(int value);
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] { 1, 2, 3, 100, 99, 98 }));
    }
}
