import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

private val Context.dataStore by preferencesDataStore(name = "settings")

class SettingsRepository(context: Context) {
    private val dataStore = context.dataStore

    private val CHECKBOX_KEY = booleanPreferencesKey("checkbox_key")

    val checkboxFlow: Flow<Boolean> = dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map { preferences ->
            preferences[CHECKBOX_KEY] ?: false
        }

    suspend fun saveCheckboxState(isChecked: Boolean) {
        dataStore.edit { preferences ->
            preferences[CHECKBOX_KEY] = isChecked
        }
    }
}
