package edu.iesam.examaad1eval

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.examaad1eval.features.ex1.data.Ex1DataRepository
import edu.iesam.examaad1eval.features.ex1.data.MockEx1RemoteDataSource
import edu.iesam.examaad1eval.features.ex1.data.local.Ex1XmlLocalDataSource
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
        val ex1DataRepository = Ex1DataRepository(Ex1XmlLocalDataSource(this), MockEx1RemoteDataSource())
        val users = ex1DataRepository.getUsers()
        val items = ex1DataRepository.getItems()
        val services = ex1DataRepository.getServices()
        for (user in users) {
            Log.d("MainActivity", "User: $user")
        }
        for (item in items) {
            Log.d("MainActivity", "Item: $item")
        }
        for (service in services) {
            Log.d("MainActivity", "Service: $service")
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun executeExercise2(){
        //Ejecutar el ejercicio 2 desde aquí llamando al Ex2DataRepository directamente
        GlobalScope.launch {
            //llamar a Room
        }
    }
}