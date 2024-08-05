import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import com.example.api_bkl.RetrofitInstance
import com.example.api_bkl.moviejson

class MovieViewModel : ViewModel() {
    private val _movieSources = mutableStateOf<List<moviejson>>(emptyList())
    val movieSources: State<List<moviejson>> = _movieSources

    init {
        fetchMovieSources()
    }

    private fun fetchMovieSources() {
        viewModelScope.launch {
            try {
                val sources = RetrofitInstance.api.getMovieSources()
                _movieSources.value = sources
            } catch (e: Exception) {

            }
        }
    }
}
