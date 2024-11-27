package edu.iesam.examaad1eval.features.ex2.data.local.db

import android.content.Context
import androidx.room.Room
import edu.iesam.examaad1eval.core.data.db.AppDatabase
import edu.iesam.examaad1eval.features.ex2.domain.Game
import edu.iesam.examaad1eval.features.ex2.domain.Player

class Ex2DbLocalDataSource(context: Context) {

    private val db = Room.databaseBuilder(
        context.applicationContext,
        AppDatabase::class.java, "ex2-database"
    ).fallbackToDestructiveMigration().build()

    private val gameDao = db.gameDao()


    suspend fun saveGame(game: Game) {
        val gameEntity = GameEntity(game.id, game.title)
        val playerEntities = game.player.map { PlayerEntity(it.id, it.name, game.id) }
        gameDao.insertGame(gameEntity)
        gameDao.insertPlayers(playerEntities)
    }

    suspend fun getGames(): List<Game> {
        return gameDao.getGamesWithPlayers().map { gameWithPlayers ->
            Game(
                gameWithPlayers.game.id,
                gameWithPlayers.game.title,
                gameWithPlayers.players.map { Player(it.id, it.name) }
            )
        }
    }
    suspend fun saveGames(games: List<Game>) {
        games.forEach { game ->
            saveGame(game)
        }
    }
}