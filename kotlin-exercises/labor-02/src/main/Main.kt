package main

import src.main.Date
import java.time.DateTimeException
import java.time.LocalDate
import kotlin.random.Random

fun main(){

    val dictionary: IDictionary = DictionaryProvider.createDictionary(DictionaryType.TREE_SET)

    dictionary.add("apple")
    dictionary.add("banana")
    dictionary.add("cherry")

    println("Find 'apple': ${dictionary.find("apple")}")
    println("Find 'grape': ${dictionary.find("grape")}")

    println("Dictionary size: ${dictionary.size()}")

    println("\n")

    val name = "Peter Akos"
    println(name.toMonogram())

    println("\n")

    val fruits = listOf("apple", "pear", "melon")
    println(fruits.joinWithSeparator("**"))

    println("\n")

    val cars = listOf("Opel", "Mercedes", "Audi", "Ferrari")
    println(cars.longest())

    println("\n")

    val currentDate = Date()
    println(currentDate)

    println("\n")

    val currentDate2 = Date(2024, 9, 14)
    println("Year ${currentDate2.year} is a leap year: ${currentDate2.isLeapYear()}")

    println("\n")

    val validDate = Date(2024, 2, 29)
    val invalidDate = Date(2023, 2, 29)

    println("\n")

    println("Date ${validDate.year}-${validDate.month}-${validDate.day} is valid: ${validDate.isValid()}")
    println("Date ${invalidDate.year}-${invalidDate.month}-${invalidDate.day} is valid: ${invalidDate.isValid()}")

    val validDates = mutableSetOf<Date>()

    while (validDates.size < 10) {
        val randomDate = generateRandomDate()  // Generate a random date

        if (randomDate.isValid()) {
            validDates.add(randomDate)
        } else {
            println("Invalid date: ${randomDate.year}-${randomDate.month}-${randomDate.day}")
        }
    }

    println("List of unique valid dates:")
    validDates.forEach { date ->
        println("${date.year}-${date.month}-${date.day}")
    }

    val sortedDates = validDates.sorted()

    val reversedDates = sortedDates.reversed()

    println("List of unique valid dates (sorted):")
    sortedDates.forEach { date ->
        println("${date.year}-${date.month}-${date.day}")
    }
    println("List of unique valid dates (reversed):")
    reversedDates.forEach { date ->
        println("${date.year}-${date.month}-${date.day}")
    }

    val customComparator = Comparator<Date> { date1, date2 ->

        val isDate1Even = date1.day % 2 == 0
        val isDate2Even = date2.day % 2 == 0

        when {
            isDate1Even && !isDate2Even -> -1
            !isDate1Even && isDate2Even -> 1
            else -> date1.day - date2.day
        }
    }

    val sortedDates2 = validDates.sortedWith(customComparator)
    println("List of unique valid dates (sorted by custom comparator):")
    sortedDates2.forEach { date ->
        println("${date.year}-${date.month}-${date.day}")
    }
}


fun String.toMonogram():String {
    return this.split(" ").map {it[0]}.joinToString(" ")
}
fun List<String>.joinWithSeparator(separator:String):String = this.joinToString(separator)

fun List<String>.longest():String = this.maxByOrNull { it.length } ?: "N/A"

fun Date.isLeapYear(): Boolean {
    return (this.year % 4 == 0 && this.year % 100 != 0) || (this.year % 400 == 0)
}

fun Date.isValid(): Boolean {
    return try {
        LocalDate.of(this.year, this.month, this.day)
        true
    } catch (e: DateTimeException) {
        false
    }
}

fun generateRandomDate(): Date {
    val year = Random.nextInt(800, 2600)
    val month = Random.nextInt(1, 13)
    val day = Random.nextInt(1, 32)
    return Date(year, month, day)
}
