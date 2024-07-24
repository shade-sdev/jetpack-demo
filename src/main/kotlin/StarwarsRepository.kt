import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class StarwarsRepository : KoinComponent {

    private val db: Database by inject()

    fun findAll(): List<StarWarsFilm> {
        return transaction(db) {
            StarWarsFilm.all().toList()
        }
    }

}