import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class AppInitializer : KoinComponent {
    private val database by inject<Database>()

    fun initialize() {
        // Ensure tables are created
        transaction(database) {
            SchemaUtils.create(StarWarsFilms)
        }
    }
}