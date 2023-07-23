package usecases;

import java.util.List;
import java.util.stream.IntStream;

class FunctionalProgrammingPracticeTest {
    public static void main(String[] args) {
        List<String> strings = List.of("apple", "banana", "candy", "day", "even", "forest");
        List<String> answer1 = List.of("apple", "candy", "day", "even");
        List<String> answer2 = List.of("APPLE", "BANANA", "CANDY", "DAY", "EVEN", "FOREST");
        List<Integer> answer3 = List.of(5, 6, 5, 3, 4, 6);
        List<String> answer4 = List.of("elppa", "ananab", "ydnac", "yad", "neve", "tserof");
        StringUtil stringUtil = new StringUtil();

        List<String> result1 = stringUtil.findUnderFive(strings);
        List<String> result2 = stringUtil.convertUpperCase(strings);
        List<Integer> result3 = stringUtil.getLength(strings);
        List<String> result4 = stringUtil.reverse(strings);

        System.out.println(result1.equals(answer1));
        System.out.println(result2.equals(answer2));
        System.out.println(result3.equals(answer3));
        System.out.println(result4.equals(answer4));
    }
}

class StringUtil {
    public List<String> findUnderFive(List<String> strings) {
        return strings.stream()
                .filter(string -> string.length() <= 5)
                .toList();
    }

    public List<String> reverse(List<String> strings) {
        return strings.stream()
                .map(string -> reverseString(string))
                .toList();
    }

    public List<String> convertUpperCase(List<String> strings) {
        return strings.stream()
                .map(string -> string.toUpperCase())
                .toList();
    }

    public List<Integer> getLength(List<String> strings) {
        return strings.stream()
                .map(string -> string.length())
                .toList();
    }

    private String reverseString(String string) {
        return IntStream.range(0, string.length())
                .mapToObj(index -> String.valueOf(string.charAt(string.length() - index - 1)))
                .reduce("", (x, y) -> x + y);
    }
}
