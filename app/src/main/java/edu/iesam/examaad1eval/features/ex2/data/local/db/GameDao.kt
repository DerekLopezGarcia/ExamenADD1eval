package edu.iesam.examaad1eval.features.ex2.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface GameDao {
    @Insert
    suspend fun insertGame(game: GameEntity)

    @Insert
    suspend fun insertPlayers(players: List<PlayerEntity>)

    @Transaction
    @Query("SELECT * FROM games")
    suspend fun getGamesWithPlayers(): List<GameWithPlayers>
}