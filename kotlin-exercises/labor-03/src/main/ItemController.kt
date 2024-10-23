package main

class ItemController(private val itemService: ItemService) {

    fun quiz(numberOfQuestions: Int) {
        val selectedItems = itemService.selectRandomItems(numberOfQuestions)
        var correctAnswers = 0

        for ((index, item) in selectedItems.withIndex()) {
            println("Kérdés ${index + 1}: ${item.question}")
            for ((i, answer) in item.answers.withIndex()) {
                println("${i + 1}. $answer")
            }

            print("Válassz egy lehetőséget (1-${item.answers.size}): ")
            val userAnswer = readLine()?.toIntOrNull()

            if (userAnswer != null && userAnswer - 1 == item.correct) {
                correctAnswers++
                println("Helyes válasz!")
            } else {
                println("Rossz válasz. A helyes válasz: ${item.answers[item.correct]}")
            }
        }

        println("Eredmény: $correctAnswers/${selectedItems.size}")
    }
}