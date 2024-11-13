package com.example.recipehub.repository

import android.content.Context
import android.util.Log
import com.example.android.model.InstructionDTO
import com.example.android.model.InstructionModel
import com.example.android.model.RecipeDTO
import com.example.android.model.RecipeModel
import com.example.android.model.toModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONObject
import java.io.IOException


class RecipeRepository {

    // Beolvassa a "recipes.json" fájlt és DTO listává alakítja
    private fun readRecipesFromJson(context: Context): List<RecipeDTO> {
        val gson = Gson()
        var recipeList = listOf<RecipeDTO>()
        try {
            val inputStream = context.assets.open("more_recipe.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            val jsonString = String(buffer, Charsets.UTF_8)

            val type = object : TypeToken<List<RecipeDTO>>() {}.type
            recipeList = gson.fromJson(jsonString, type)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return recipeList
    }

    // Beolvassa az "instructions.json" fájlt és DTO listává alakítja
    private fun readInstructionsFromJson(context: Context): List<InstructionDTO> {
        val gson = Gson()
        var instructionList = listOf<InstructionDTO>()
        try {
            val inputStream = context.assets.open("instructions.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            val jsonString = String(buffer, Charsets.UTF_8)

            val jsonObject = JSONObject(jsonString)
            val instructionsArray = jsonObject.getJSONArray("instructions")
            val type = object : TypeToken<List<InstructionDTO>>() {}.type
            instructionList = gson.fromJson(instructionsArray.toString(), type)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return instructionList
    }

    // RecipeDTO listát átalakítom RecipeModel listává
    fun getAllRecipes(context: Context): List<RecipeModel> {
        return readRecipesFromJson(context).map { it.toModel() }
    }

}
