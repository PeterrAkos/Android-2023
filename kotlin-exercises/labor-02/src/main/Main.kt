package main

import src.main.Date
import java.time.DateTimeException
import java.time.LocalDate
import kotlin.random.Random

fun main(){

    val currentDate = Date()
    println(currentDate)

    val currentDate2 = Date(2024, 2, 29)
    println("Year ${currentDate2.year} is a leap year: ${currentDate2.isLeapYear()}")

    val validDate = Date(2024, 2, 29)
    val invalidDate = Date(2023, 2, 29)

    println("src.main.Date ${validDate.year}-${validDate.month}-${validDate.day} is valid: ${validDate.isValid()}")
    println("src.main.Date ${invalidDate.year}-${invalidDate.month}-${invalidDate.day} is valid: ${invalidDate.isValid()}")

    val validDates = mutableSetOf<Date>()  // Use a set to ensure uniqueness

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


fun String.nameMonogram():String {
    return this.split(" ").map {it[0]}.joinToString(" ")
}
fun List<String>.joinElements(separator:String):String = this.joinToString(separator)

fun List<String>.getLongestElement():String = this.maxByOrNull { it.length } ?: "N/A"

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
