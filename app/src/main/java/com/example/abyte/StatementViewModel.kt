package com.example.abyte

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.abyte.models.Datos
import com.example.abyte.models.Statement

class StatementViewModel(application: Application, private val repositoryStatement: RepositoryStatement) :
    AndroidViewModel(application) {

    val data:MutableLiveData<ArrayList<Datos>> = MutableLiveData()

    fun getData() {
        repositoryStatement.getData(object :IDatos{
            override fun datos(statmen: Statement) {
                data.value= statmen.statement
            }
        })

    }
}
