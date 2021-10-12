package com.amirdora.daggerhiltdependencyinjection

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amirdora.daggerhiltdependencyinjection.db.RoomRepository
import com.amirdora.daggerhiltdependencyinjection.db.UserEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repository: RoomRepository) :
    ViewModel() {

    var userData: MutableLiveData<List<UserEntity>> = MutableLiveData()

    init {
        loadRecords()
    }

    fun loadRecords() {
        val list = repository.getRecords()

        userData.postValue(list)
    }

    fun insertRecord(userEntity: UserEntity) {
        repository.insertRecord(userEntity)
    }

}