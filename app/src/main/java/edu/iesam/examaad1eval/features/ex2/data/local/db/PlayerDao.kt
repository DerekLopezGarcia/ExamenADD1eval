import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import edu.iesam.examaad1eval.features.ex2.data.local.db.PlayerEntity

@Dao
interface PlayerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlayer(player: PlayerEntity)

    @Query("SELECT * FROM players WHERE id = :id")
    suspend fun getPlayerById(id: Int): PlayerEntity?
}