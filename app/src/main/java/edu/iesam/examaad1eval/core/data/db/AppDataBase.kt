package edu.iesam.examaad1eval.core.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.iesam.examaad1eval.features.ex2.data.local.db.GameDao
import edu.iesam.examaad1eval.features.ex2.data.local.db.GameEntity
import edu.iesam.examaad1eval.features.ex2.data.local.db.PlayerEntity

@Database(entities = [GameEntity::class, PlayerEntity::class], version = 3)
abstract class AppDatabase : RoomDatabase() {
    abstract fun gameDao(): GameDao
}