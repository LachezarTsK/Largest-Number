
function largestNumber(input: number[]): string {
    input.sort((first, second) => comparatorAppendedIntegersInDecreasingOrder(first, second));
    return createLargestNumber(input);
};

function createLargestNumber(input: number[]): string {
    const largestNumber = (input[0] !== 0) ? input.join("") : "0";
    return largestNumber;
}

function comparatorAppendedIntegersInDecreasingOrder(first: number, second: number): number {
    return appendTwoIntegers(second, first, getNumberOfDigits(first))
        - appendTwoIntegers(first, second, getNumberOfDigits(second));
}

function appendTwoIntegers(first: number, second: number, numberOfDigits: number): number {
    return first * Math.pow(10, numberOfDigits) + second;
}

function getNumberOfDigits(value: number): number {
    let numberOfDigits = 0;
    while (value > 0) {
        ++numberOfDigits;
        value = Math.floor(value / 10);
    }
    return numberOfDigits !== 0 ? numberOfDigits : 1;
}
