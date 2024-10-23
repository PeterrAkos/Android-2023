package main

import java.io.File

class ItemRepository {
    private val items = mutableListOf<Item>()

    init {
        loadItemsFromFile("resources/quest.txt")
    }

    private fun loadItemsFromFile(fileName: String) {
        try {
            val lines = File(fileName).readLines()
            var index = 0

            while (index < lines.size) {
                val question = lines[index]
                val answers = mutableListOf<String>()

                // A következő négy sor tartalmazza a válaszokat
                for (i in 1..4) {
                    answers.add(lines[index + i])
                }

                // Az ötödik sor tartalmazza a helyes válasz indexét
                val correctAnswerIndex = lines[index + 5].toInt()

                // Hozzáadjuk az új kvízelemet az items listához
                items.add(Item(question, answers, correctAnswerIndex))

                // Ugorjunk a következő kérdés blokkra (kérdés + válaszok + index + ---)
                index += 7
            }
        } catch (e: Exception) {
            println("Hiba történt a fájl olvasása közben: ${e.message}")
        }
    }

    fun randomItem(): Item = items.random()

    fun save(item: Item) {
        items.add(item)
    }

    fun size(): Int = items.size

    fun getItems(): List<Item> = items
}

