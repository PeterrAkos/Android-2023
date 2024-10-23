package src.main

import java.time.LocalDate

data class Date(val year: Int, val month: Int, val day: Int) : Comparable<Date> {
    constructor() : this(
        LocalDate.now().year,
        LocalDate.now().monthValue,
        LocalDate.now().dayOfMonth
    )
    override fun compareTo(other: Date): Int {
        return when {
            this.year != other.year -> this.year - other.year
            this.month != other.month -> this.month - other.month
            else -> this.day - other.day
        }
    }
}