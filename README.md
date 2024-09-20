# Largest-Number
Challenge at LeetCode.com. Tags: Math, String, Greedy, Sorting.

The purpose of this solution is to demonstrate an approach without using strings: either for creating a new array where the original integers are converted to strings or for the comparator, when sorting the original array of integers. 

As of September 2024, the input value range for this problem is 0 <= nums[i] <= 1E9 (10 to the power of 9), therefore the maximum value of appending two maximum input values is 10000000001000000000, which is well within the maximum value of double. Therefore the original array of integers can be sorted without converting the original array to strings of integers or using strings in the comparator. The comparator just compares two concatenated, by math tools, doubles (as opposed to comparing two concatenated strings, made from the original integers). 

And since the input values are guaranteed to be integers, again as of September 2024, the doubles in the comparator are compared as they are, without more sophisticated tools for comparing two doubles, when the doubles are not guaranteed to have only integer values.
