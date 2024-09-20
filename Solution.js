
/**
 * @param {number[]} input
 * @return {string}
 */
var largestNumber = function (input) {
    input.sort((first, second) => comparatorAppendedIntegersInDecreasingOrder(first, second));
    return createLargestNumber(input);
};

/**
 * @param {number[]} input
 * @return {string}
 */
function createLargestNumber(input) {
    const largestNumber = (input[0] !== 0) ? input.join("") : "0";
    return largestNumber;
}

/**
 * @param {number} first
 * @param {number} second
 * @return {number}
 */
function comparatorAppendedIntegersInDecreasingOrder(first, second) {
    return appendTwoIntegers(second, first, getNumberOfDigits(first))
            - appendTwoIntegers(first, second, getNumberOfDigits(second));
}

/**
 * @param {number} first
 * @param {number} second
 * @param {number} numberOfDigits
 * @return {number}
 */
function appendTwoIntegers(first, second, numberOfDigits) {
    return first * Math.pow(10, numberOfDigits) + second;
}

/**
 * @param {number} value
 * @return {number}
 */
function getNumberOfDigits(value) {
    let numberOfDigits = 0;
    while (value > 0) {
        ++numberOfDigits;
        value = Math.floor(value / 10);
    }
    return numberOfDigits !== 0 ? numberOfDigits : 1;
}
