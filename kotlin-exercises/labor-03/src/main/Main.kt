package main

fun main() {
    val repository = ItemRepository()
    val service = ItemService(repository)
    val controller = ItemController(service)

    var numberOfQuestions: Int

    // Input validation loop
    while (true) {
        print("Hány kérdést szeretnél megválaszolni? ")
        val input = readLine()?.toIntOrNull()

        if (input != null && input > 0) {
            numberOfQuestions = input
            break // Exit the loop if the input is valid
        } else {
            println("Kérjük, írjon be egy pozitív számot!")
        }
    }

    controller.quiz(numberOfQuestions)
}
