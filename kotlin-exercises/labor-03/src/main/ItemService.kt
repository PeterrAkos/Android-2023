package main

class ItemService(private val itemRepository: ItemRepository) {

    fun selectRandomItems(number: Int): List<Item> {
        return itemRepository.getItems().shuffled().take(number)
    }

    fun isValidQuestionCount(number: Int): Boolean {
        return number > 0 // Ensure number is positive
    }
}