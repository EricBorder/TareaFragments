package com.example.tareafragments.ui.main

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModel
import com.example.tareafragments.MainActivity.Companion.REQUEST_MULTIPLICACION
import com.example.tareafragments.MainActivity.Companion.REQUEST_SUMA

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        //Variable donde se recoge la imagen en el layout
        val imageView = findViewById<ImageView>(R.id.foto)
        //Variable donde se recofe el texto en el layout
        val textView = findViewById<TextView>(R.id.texto)

        if (resultCode != Activity.RESULT_OK) return
        Log.d("asd", requestCode.toString())

        // Puedo distinguir diferentes acciones según el requestCode
        when (requestCode) {
            //Acción de la cámara
            REQUEST_MULTIPLICACION -> {
                if (data != null) {
                    Log.d("asd", "recibido")
                    //Comprobar resultado de la suma
                    var resultado1 = data.getIntExtra("suma", 0).toString()
                    if (resultado1.toInt() == (random + random2)) {
                        textView.text = "Bien " + data.getIntExtra("suma", 0).toString()
                    } else {
                        textView.text = "Mal " + data.getIntExtra("suma", 0).toString()
                    }
                };
            }
            //Acción de la suma
            REQUEST_SUMA -> {
                if (data != null) {
                    Log.d("asd", "recibido")
                    //Comprobar resultado de la suma
                    var resultado1 = data.getIntExtra("suma", 0).toString()
                    if (resultado1.toInt() == (random + random2)) {
                        textView.text = "Bien " + data.getIntExtra("suma", 0).toString()
                    } else {
                        textView.text = "Mal " + data.getIntExtra("suma", 0).toString()
                    }
                }; }

        }
    }
}