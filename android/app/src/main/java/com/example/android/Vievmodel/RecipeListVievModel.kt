import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.model.InstructionModel
import com.example.android.model.RecipeModel
import com.example.recipehub.repository.RecipeRepository

//kapcsolatot biztosít a repository és a UI között
class RecipeListViewModel : ViewModel() {

    // A repository példányosítása, amely az adatok lekéréséért felelős
    private val repository = RecipeRepository()

    // Egy függvény, amely lekéri az összes receptet a repository-ból  és egy RecipeModel típusú lista formájában adja vissza az adatokat.
    fun getRecipes(context: Context): List<RecipeModel> {
        return repository.getAllRecipes(context)
    }

    // Az instrukciókat tároló MutableLiveData, amely LiveData-ként is elérhető a UI számára
    private val _instructionModels = MutableLiveData<List<InstructionModel>>()

    // LiveData-változó külsőleg is elérhetővé tétele, automatikusan értesíti a UI-t, ha új adatok állnak rendelkezésre.
    val instructionModels: LiveData<List<InstructionModel>> = _instructionModels
}
