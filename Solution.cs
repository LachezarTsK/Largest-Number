
using System;

public class Solution
{
    public string LargestNumber(int[] input)
    {
        Array.Sort(input, (first, second) => ComparatorAppendedIntegersInDecreasingOrder(first, second));
        return CreateLargestNumber(input);
    }

    private String CreateLargestNumber(int[] input)
    {
        StringBuilder largestNumber = new StringBuilder();
        if (input[0] == 0)
        {
            largestNumber.Append(0);
            return largestNumber.ToString();
        }

        for (int i = 0; i < input.Length; ++i)
        {
            largestNumber.Append(input[i]);
        }
        return largestNumber.ToString();
    }

    private int ComparatorAppendedIntegersInDecreasingOrder(int first, int second)
    {
        return AppendTwoIntegers(second, first, GetNumberOfDigits(first))
            .CompareTo(AppendTwoIntegers(first, second, GetNumberOfDigits(second)));
    }

    private double AppendTwoIntegers(int first, int second, int numberOfDigits)
    {
        return first * Math.Pow(10, numberOfDigits) + second;
    }

    private int GetNumberOfDigits(int value)
    {
        int numberOfDigits = 0;
        while (value > 0)
        {
            ++numberOfDigits;
            value /= 10;
        }
        return numberOfDigits != 0 ? numberOfDigits : 1;
    }
}
