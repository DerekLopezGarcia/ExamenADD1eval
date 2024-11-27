package edu.iesam.examaad1eval.features.ex2.data.local.db

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "games")
data class GameEntity(
    @PrimaryKey val id: String,
    @ColumnInfo val title: String
)

@Entity(tableName = "players")
data class PlayerEntity(
    @PrimaryKey val id: String,
    @ColumnInfo val name: String,
    @ColumnInfo val gameId: String
)

data class GameWithPlayers(
    @Embedded val game: GameEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "gameId"
    )
    val players: List<PlayerEntity>
)
