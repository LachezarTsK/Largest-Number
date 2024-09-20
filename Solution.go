
package main

import (
    "fmt"
    "math"
    "sort"
    "strings"
)

func largestNumber(input []int) string {
    sort.Slice(input, func(i, j int) bool { return comparatorAppendedIntegersInDecreasingOrder(input[i], input[j]) })
    return createLargestNumber(input)
}

func createLargestNumber(input []int) string {
    largestNumber := strings.Builder{}
    if input[0] == 0 {
        largestNumber.WriteString(fmt.Sprint(0))
        return largestNumber.String()
    }

    for i := range input {
        largestNumber.WriteString(fmt.Sprint(input[i]))
    }
    return largestNumber.String()
}

func comparatorAppendedIntegersInDecreasingOrder(first int, second int) bool {
    return appendTwoIntegers(second, first, getNumberOfDigits(first)) <
            appendTwoIntegers(first, second, getNumberOfDigits(second))
}

func appendTwoIntegers(first int, second int, numberOfDigits int) int {
    return first*int(math.Pow(10.0, float64(numberOfDigits))) + second
}

func getNumberOfDigits(value int) int {
    numberOfDigits := 0
    for value > 0 {
        numberOfDigits++
        value /= 10
    }
    return Ternary((numberOfDigits != 0), numberOfDigits, 1)
}

func Ternary[T any](condition bool, first T, second T) T {
    if condition {
        return first
    }
    return second
}
