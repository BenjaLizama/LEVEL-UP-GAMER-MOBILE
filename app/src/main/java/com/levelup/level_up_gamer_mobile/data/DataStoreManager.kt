import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// Usa este nombre de archivo para tu DataStore (ej. "login_prefs.xml" internamente)
private const val PREFERENCES_NAME = "login_prefs"

// Esta es la propiedad de extensión que 'delega' la creación de DataStore.
// El Context lo necesita para saber dónde guardar el archivo.
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = PREFERENCES_NAME)

object LoginStateManager {

    // 1. Clave: Identificador único para el dato (tipo booleano)
    private val USER_LOGGED_IN_KEY = booleanPreferencesKey("user_logged_in")
    private val USER_ID_KEY = longPreferencesKey("user_id")

    // 2. Aquí guardaremos la única instancia de DataStore
    private lateinit var dataStore: DataStore<Preferences>

    // 3. Inicializa el DataStore. Lo llamarás solo una vez al iniciar la App.
    fun initialize(context: Context) {
        // Usamos la extensión que definimos afuera.
        dataStore = context.dataStore
    }

    // ----------------- OPERACIONES DE ESCRITURA -----------------

    // Función para guardar el estado (Logged In / Logged Out)
    suspend fun saveLoginState(isLoggedIn: Boolean) {
        // La función 'edit' nos permite modificar los datos
        dataStore.edit { preferences ->
            preferences[USER_LOGGED_IN_KEY] = isLoggedIn
        }
    }

    suspend fun saveUserId(userId: Long?) {
        dataStore.edit { preferences ->
            preferences[USER_ID_KEY] = userId?.toLong() as Long
        }
    }

    // ----------------- OPERACIONES DE LECTURA -----------------

    // Función para leer el estado como un Kotlin Flow
    val isLoggedIn: Flow<Boolean>
        get() = dataStore.data
            .map { preferences ->
                preferences[USER_LOGGED_IN_KEY] ?: false
            }

    val userId: Flow<Long>
        get() = dataStore.data
            .map { preferences ->
                preferences[USER_ID_KEY] ?: 0
            }
}
