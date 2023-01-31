package com.example.tareafragments.ui.main

import android.app.Activity
import android.app.Application
import android.content.Intent
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import com.example.tareafragments.MainActivity.Companion.REQUEST_MULTIPLICACION
import com.example.tareafragments.MainActivity.Companion.REQUEST_SUMA

class MainViewModel(application: Application) : AndroidViewModel(application) {
    // TODO: Implement the ViewModel

    var random = (0..9).random()
    var random2 = (0..9).random()

    var liveRandom = MutableLiveData<Int>()
    var liveRandom2 = MutableLiveData<Int>()

    init {
        liveRandom.value = random
    }

    init {
        liveRandom2.value = random2
    }

    //Variable donde se recoge la imagen en el layout
    val textView1: TextView? = null
    //Variable donde se recofe el texto en el layout
    val textView2: TextView? = null


/*fun onFragments(requestCode:Int,resultCode: Int, data: Intent?){
    if (resultCode != Activity.RESULT_OK) return
    Log.d("asd", requestCode.toString())

    // Puedo distinguir diferentes acciones según el requestCode
    when (requestCode) {
        //Acción de la multiplicacion
        REQUEST_MULTIPLICACION -> {
            if (data != null) {
                Log.d("asd", "recibido")
                //Comprobar resultado de la multiplicacion
                var resultado1 = data.getIntExtra("multiplicacion", 0).toString()
                if (resultado1.toInt() == (random * random2)) {
                    textView2?.text ?: ("Bien " + data.getIntExtra("multiplicacion", 0).toString())
                } else {
                    textView2?.text ?: ("Mal " + data.getIntExtra("multiplicacion", 0).toString())
                }
            };
        }
        //Acción de la suma
        REQUEST_SUMA -> {
            if (data != null) {
                Log.d("asd", "recibido")
                //Comprobar resultado de la suma
                var resultado2 = data.getIntExtra("suma", 0).toString()
                if (resultado2.toInt() == (random + random2)) {
                    textView1?.text ?: ("Bien " + data.getIntExtra("suma", 0).toString())
                } else {
                    textView1?.text ?: ("Mal " + data.getIntExtra("suma", 0).toString())
                }
            }; }


    }
}*/
    fun hacerSuma(){
    var resultado: Int
        resultado = random + random2
    }
    fun hacerMultiplicacion(){
        var resultado2: Int
        resultado2 = random * random2
    }

}