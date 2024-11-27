package edu.iesam.examaad1eval

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.examaad1eval.features.ex2.data.Ex2DataRepository
import edu.iesam.examaad1eval.features.ex2.data.local.db.Ex2DbLocalDataSource
import edu.iesam.examaad1eval.features.ex2.data.remote.MockEx2RemoteDataSource
import edu.iesam.examaad1eval.features.ex2.domain.Ex2Repository
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        executeExercise1()
        executeExercise2()
    }

    private fun executeExercise1(){
        //Ejecutar el ejercicio 1 desde aquí llamando al Ex1DataRepository directamente
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun executeExercise2(){
        val localDataSource = Ex2DbLocalDataSource(this)
        val remoteDataSource = MockEx2RemoteDataSource()
        val repository = Ex2DataRepository(localDataSource, remoteDataSource)
        //Ejecutar el ejercicio 2 desde aquí llamando al Ex2DataRepository directamente
        GlobalScope.launch {
            //llamar a Room
            val games = repository.getGames()
            games.forEach {
                Log.d("Game", it.toString())
            }
        }
    }
}