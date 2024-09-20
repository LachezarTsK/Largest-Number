
import java.util.Arrays;

public class Solution {

    public String largestNumber(int[] input) {
        Integer[] integerWrapper = createIntegerWrapperArraySortedInDecreasingOrder(input);
        return createLargestNumber(integerWrapper);
    }

    private String createLargestNumber(Integer[] integerWrapper) {
        StringBuilder largestNumber = new StringBuilder();
        if (integerWrapper[0] == 0) {
            largestNumber.append(0);
            return largestNumber.toString();
        }

        for (int i = 0; i < integerWrapper.length; ++i) {
            largestNumber.append(integerWrapper[i]);
        }
        return largestNumber.toString();
    }

    private Integer[] createIntegerWrapperArraySortedInDecreasingOrder(int[] input) {
        // Alternatively:
        // Integer[] integerWrapper = Arrays.stream(input).boxed().toArray(Integer[]::new);
        Integer[] integerWrapper = new Integer[input.length];
        for (int i = 0; i < input.length; ++i) {
            integerWrapper[i] = input[i];
        }
        Arrays.sort(integerWrapper, (first, second) -> comparatorAppendedIntegersInDecreasingOrder(first, second));
        return integerWrapper;
    }

    private int comparatorAppendedIntegersInDecreasingOrder(int first, int second) {
        return appendTwoIntegers(second, first, getNumberOfDigits(first))
                - appendTwoIntegers(first, second, getNumberOfDigits(second));
    }

    private int appendTwoIntegers(int first, int second, int numberOfDigits) {
        return first * (int) Math.pow(10, numberOfDigits) + second;
    }

    private int getNumberOfDigits(int value) {
        int numberOfDigits = 0;
        while (value > 0) {
            ++numberOfDigits;
            value /= 10;
        }
        return numberOfDigits != 0 ? numberOfDigits : 1;
    }
}
