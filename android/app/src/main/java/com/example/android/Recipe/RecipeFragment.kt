package com.example.recipehub.ui

import RecipeListViewModel
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.android.R
import com.example.recipehub.repository.RecipeRepository

class RecipeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // A fragmenthez tartozó nézet (layout) inflatálása
        val view = inflater.inflate(R.layout.fragment_recipe, container, false)

        val recipeViewModel = ViewModelProvider(this).get(RecipeListViewModel::class.java)
        // A receptek adatainak lekérése a ViewModel segítségével és kiírása a Logcat-re
        //val recipes = repository.getAllRecipes(requireContext())
        val recipes = recipeViewModel.getRecipes(requireContext())
        for (recipe in recipes) {
            Log.d("RecipesFragment", "Recipe: ${recipe.name}")
            Log.d("RecipesFragment", "Description: ${recipe.description}")
            Log.d("Pause","------------------------------------------------------------")
        }


        return view
    }
}
