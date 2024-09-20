
#include <span>
#include <cmath>
#include <vector>
#include <string>
using namespace std;

/*
The code will run faster with ios::sync_with_stdio(0).
However, this should not be used in production code and interactive problems.
In this particular problem, it is ok to apply ios::sync_with_stdio(0).

Many of the top-ranked C++ solutions for time on leetcode apply this trick,
so, for a fairer assessment of the time percentile of my code
you could outcomment the lambda expression below for a faster run.
*/

/*
const static auto speedup = [] {
    ios::sync_with_stdio(0);
    return nullptr;
}();
*/

class Solution {

public:
    string largestNumber(vector<int>& input) const {
    const auto comparatorAppendedIntegersInDecreasingOrder = [this](int first, int second) {
        return appendTwoIntegers(second, first, getNumberOfDigits(first))
            < appendTwoIntegers(first, second, getNumberOfDigits(second)); };

    ranges::sort(input, comparatorAppendedIntegersInDecreasingOrder);
    return createLargestNumber(input);
    }

private:
    string createLargestNumber(span<const int> input) const {
        string largestNumber;
        if (input[0] == 0) {
            largestNumber.append(to_string(0));
            return largestNumber;
        }

        for (int i = 0; i < input.size(); ++i) {
            largestNumber.append(to_string(input[i]));
        }
        return largestNumber;
    }

    double appendTwoIntegers(int first, int second, int numberOfDigits) const {
        return first * (pow(10, numberOfDigits)) + second;
    }

    int getNumberOfDigits(int value) const {
        int numberOfDigits = 0;
        while (value > 0) {
            ++numberOfDigits;
            value /= 10;
        }
        return numberOfDigits != 0 ? numberOfDigits : 1;
    }
};
