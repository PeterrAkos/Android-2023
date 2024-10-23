import java.util.Base64
import kotlin.random.Random

fun main() {
    // Part 1: Basic arithmetic
    println("Part 1:")
    val total = add(2, 3)
    println("Total = $total")
    println("Total using inline calculation = ${2 + 3}")
    println()

    // Part 2: Days of the week
    println("Part 2:")
    val weekDays = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

    for (day in weekDays) {
        println(day)
    }

    weekDays.filter { it.startsWith("T") }.forEach { println(it) }
    weekDays.filter { 'e' in it }.forEach { println(it) }
    weekDays.filter { it.length == 6 }.forEach { println(it) }
    println()

    // Part 3: Prime numbers
    println("Part 3:")
    for (num in 1..100) {
        if (isPrime(num)) {
            println(num)
        }
    }
    println()

    // Part 4: Message encoding and decoding
    println("Part 4:")
    val textMessage = "This is a text"
    val encodedText = processMessage(textMessage, ::encode)
    println(encodedText)
    val decodedText = processMessage(encodedText, ::decode)
    println(decodedText)
    println()

    // Part 5: Print even numbers
    println("Part 5:")
    val numArray = intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8)
    displayEvenNumbers(numArray)
    println()

    // Part 6: Array operations
    val numberList = listOf(1, 2, 3, 4, 5)
    val doubledList = numberList.map { it * 2 }
    println("Doubled numbers: $doubledList")

    val weekDaysList = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    val uppercasedDays = weekDaysList.map { it.uppercase() }
    println("Uppercase days: $uppercasedDays")

    val firstLetters = weekDays.map { it[0].lowercaseChar() }
    println("First letter of each day: $firstLetters")

    val dayLengths = weekDays.map { it.length }
    println("Lengths of days: $dayLengths")

    val avgLength = dayLengths.average()
    println("Average length of days: $avgLength")
    println()

    // Part 7: Mutable list operations
    val mutableWeekDays = weekDays.toMutableList()
    mutableWeekDays.removeAll { 'n' in it.lowercase() }
    println("Mutable list after removing days containing 'n': $mutableWeekDays")

    for ((index, day) in mutableWeekDays.withIndex()) {
        println("Item at index $index is $day")
    }

    mutableWeekDays.sort()
    println("Sorted mutable list: $mutableWeekDays")
    println()

    // Part 8: Random array generation and analysis
    val randomNumbers = Array(10) { Random.nextInt(0, 101) }
    println("Random array elements:")
    randomNumbers.forEach { println(it) }

    val sortedNumbers = randomNumbers.sortedArray()
    println("\nArray sorted in ascending order: ${sortedNumbers.toList()}")

    val hasEven = randomNumbers.any { it % 2 == 0 }
    println("\nDoes the array contain any even numbers? $hasEven")

    val allAreEven = randomNumbers.all { it % 2 == 0 }
    println("Are all the numbers even? $allAreEven")

    val avgOfArray = randomNumbers.average()
    println("\nThe average of the array is: $avgOfArray")
}

// Function to check for prime numbers
fun isPrime(num: Int): Boolean {
    if (num < 2) return false
    for (i in 2..Math.sqrt(num.toDouble()).toInt()) {
        if (num % i == 0) return false
    }
    return true
}

// Function to display even numbers from an array
fun displayEvenNumbers(arr: IntArray) = arr.filter { it % 2 == 0 }.forEach { println(it) }

// Function to process a message using the provided function
fun processMessage(message: String, transform: (String) -> String): String {
    return transform(message)
}

// Function to encode a message to Base64
fun encode(message: String): String {
    return Base64.getEncoder().encodeToString(message.toByteArray())
}

// Function to decode a Base64 encoded message
fun decode(encoded: String): String {
    return String(Base64.getDecoder().decode(encoded))
}
