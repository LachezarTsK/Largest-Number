
import kotlin.math.pow

class Solution {

    private data class Value(var value: Int) {}

    fun largestNumber(input: IntArray): String {
        val integerWrapper = createIntegerWrapperArraySortedInDecreasingOrder(input)
        return createLargestNumber(integerWrapper)
    }

    private fun createLargestNumber(integerWrapper: Array<Value?>): String {
        val largestNumber = StringBuilder()
        if (integerWrapper[0]!!.value == 0) {
            largestNumber.append(0)
            return largestNumber.toString()
        }

        for (i in integerWrapper.indices) {
            largestNumber.append(integerWrapper[i]!!.value)
        }
        return largestNumber.toString()
    }


    /*
    Even though all the primitive types in Kotlin are contained in wrapper classes
    (as opposed to Java, which has raw primitives as well as their corresponding wrapper classes), 
    in Kotlin, in order to apply custom comparators for sorting an array of primitives, 
    even if these are in wrapper classes, there is a need for yet another class that would contain 
    these wrapper classes. Thus, an array of class Value is created, which contains the integer wrapper class. 
     */
    private fun createIntegerWrapperArraySortedInDecreasingOrder(input: IntArray): Array<Value?> {
        val integerWrapper = arrayOfNulls<Value>(input.size)
        for (i in input.indices) {
            integerWrapper[i] = Value(input[i])
        }
        integerWrapper.sortWith() { first, second ->
            comparatorAppendedIntegersInDecreasingOrder(first!!.value, second!!.value)}
        return integerWrapper
    }

    private fun comparatorAppendedIntegersInDecreasingOrder(first: Int, second: Int): Int {
        return appendTwoIntegers(second, first, getNumberOfDigits(first)) -
                appendTwoIntegers(first, second, getNumberOfDigits(second))
    }

    private fun appendTwoIntegers(first: Int, second: Int, numberOfDigits: Int): Int {
        return first * (10.0).pow(numberOfDigits).toInt() + second
    }

    private fun getNumberOfDigits(value: Int): Int {
        var numberOfDigits = 0
        var value = value
        while (value > 0) {
            ++numberOfDigits
            value /= 10
        }
        return if (numberOfDigits != 0) numberOfDigits else 1
    }
}
