package com.srb.moviez.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.srb.moviez.data.MoviesListItem


class MainActivityViewModel(app : Application) : AndroidViewModel(app) {

    var allUsers : MutableLiveData<List<MoviesListItem>> = MutableLiveData()


    fun getAllUserObservers() : MutableLiveData<List<MoviesListItem>>{
            return allUsers
    }

//
//    fun getAllData() {
//
//        val userDao  = RoomAppDb.getAppDatabase((getApplication()))!!.userDao()
//        val list = userDao!!.getAllUserData()
//
//        allUsers = list
//
//       // allUsers.postValue(list)
//    }
//
//    fun insertUserData(entity: MoviesListItem){
//
//        val userDao  = RoomAppDb.getAppDatabase((getApplication()))?.userDao()
//        userDao?.insertData(entity)
//        getAllData()
//    }
//
//    fun updateUserData(entity: MoviesListItem){
//
//        val userDao  = RoomAppDb.getAppDatabase((getApplication()))?.userDao()
//        userDao?.updateUser(entity)
//        getAllData()
//    }
//
//    fun deleteUserData(entity: MoviesListItem){
//
//        val userDao  = RoomAppDb.getAppDatabase((getApplication()))?.userDao()
//        userDao?.deleteData(entity)
//        getAllData()
//    }
//

}