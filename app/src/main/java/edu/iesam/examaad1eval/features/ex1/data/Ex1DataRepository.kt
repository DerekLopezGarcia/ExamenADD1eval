package edu.iesam.examaad1eval.features.ex1.data

import edu.iesam.examaad1eval.features.ex1.data.local.Ex1XmlLocalDataSource
import edu.iesam.examaad1eval.features.ex1.domain.Ex1Repository
import edu.iesam.examaad1eval.features.ex1.domain.Item
import edu.iesam.examaad1eval.features.ex1.domain.Services
import edu.iesam.examaad1eval.features.ex1.domain.User

class Ex1DataRepository(
    private val xmlLocalDataSource: Ex1XmlLocalDataSource,
    private val mockRemoteDataSource: MockEx1RemoteDataSource
) :
    Ex1Repository {
    override fun getItems(): List<Item> {
        val localItems = xmlLocalDataSource.getItems()
        if (localItems.isNotEmpty()) {
            return localItems
        } else {
            val remoteItems = mockRemoteDataSource.getItems()
            xmlLocalDataSource.saveItems(remoteItems)
            return remoteItems
        }
    }

    override fun getServices(): List<Services> {
        val localServices = xmlLocalDataSource.getServices()
        if (localServices.isNotEmpty()) {
            return localServices
        } else {
            val remoteServices = mockRemoteDataSource.getServices()
            xmlLocalDataSource.saveServices(remoteServices)
            return remoteServices
        }
    }

    override fun getUsers(): List<User> {
        val localUsers = xmlLocalDataSource.getUsers()
        if (localUsers.isNotEmpty()) {
            return localUsers
        } else {
            val remoteUsers = mockRemoteDataSource.getUsers()
            xmlLocalDataSource.saveUsers(remoteUsers)
            return remoteUsers
        }
    }
}