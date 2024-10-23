package main

interface IDictionary {

    fun add(word: String): Boolean
    fun find(word: String): Boolean
    fun size(): Int

    companion object{
        const val DICTIONARY_NAME = "C:\\Users\\PakiLaptop\\Desktop\\Android-main\\Android-2023\\kotlin-exercises\\labor-02\\src\\resources\\words"
    }

}