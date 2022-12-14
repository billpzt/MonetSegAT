package com.infnet.devandroidat.main.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.infnet.devandroidat.repository.PadariasRepository

class MainViewModel : ViewModel() {

    private var _nome: MutableLiveData<String> = MutableLiveData()
    val nome: MutableLiveData<String> = _nome

    val TAG = "ViewModel"
    lateinit var repository: PadariasRepository

    fun getCurrentUserEmail(): String {
        return repository.getCurrentUser()?.email ?: "Email não encontrado"
    }

    fun logout() {
        repository.logout()
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////

    init {
        PadariasRepository.initialize()
        repository = PadariasRepository.get()
        consultarNome()
    }

    private fun consultarNome() {
        val email = repository.getCurrentUser()?.email
        _nome.postValue(email?:"")
    }


}