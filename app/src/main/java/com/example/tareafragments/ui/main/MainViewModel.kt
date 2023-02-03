package com.example.tareafragments.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class MainViewModel(application: Application) : AndroidViewModel(application) {
    // TODO: Implement the ViewModel

    var random = (0..9).random()
    var random2 = (0..9).random()
    var resultado : Int = 0

    var liveRandom = MutableLiveData<Int>()
    var liveRandom2 = MutableLiveData<Int>()
    var liveResultado = MutableLiveData<Int>()

    init {
        liveRandom.value = random
    }

    init {
        liveRandom2.value = random2
    }
    init {
        liveResultado.value = resultado
    }

    fun hacerSuma(){
        resultado = random + random2
    }
    fun hacerMultiplicacion(){

        resultado = random * random2

    }

}