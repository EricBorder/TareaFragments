package com.example.tareafragments
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.tareafragments.ui.main.MainViewModel
import com.example.tareafragments.ui.main.MultiplicacionFragment
import com.example.tareafragments.ui.main.SumaFragment

@Suppress("DEPRECATED_IDENTITY_EQUALS")
class MainActivity : AppCompatActivity() {

    companion object {
        //Constantes de las acciones
        const val REQUEST_MULTIPLICACION = 1
        const val REQUEST_SUMA = 2

    }
   override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_main)

       val suma: Button = findViewById(R.id.suma)
       val multiplicacion: Button = findViewById(R.id.multiplicacion)
       val random = (0..9).random()
       val random2 = (0..9).random()

       // El botón para iniciar la suma
       var botonsuma: Button = findViewById(R.id.suma)
       // Escuchador del boton de la suma
       botonsuma.setOnClickListener {
           // Creamos un intent específico que iniciará la suma
           val intento1 = Intent(this, MainViewModel::class.java)
           // Añade datos adicionales al Intent
           intento1.putExtra("NUMERO", random)
           intento1.putExtra("NUMERO2", random2)
           // Inicia la segunda actividad
           startActivityForResult(intento1, REQUEST_SUMA)
       }
       // El botón para iniciar la suma
       var botonMultiplicacion: Button = findViewById(R.id.suma)
       // Escuchador del boton de la suma
       botonMultiplicacion.setOnClickListener {
           // Creamos un intent específico que iniciará la suma
           val intento2 = Intent(this, MainViewModel::class.java)
           // Añade datos adicionales al Intent
           intento2.putExtra("NUMERO", random)
           intento2.putExtra("NUMERO2", random2)
           // Inicia la segunda actividad
           startActivityForResult(intento2, REQUEST_MULTIPLICACION)
       }

       suma.setOnClickListener { replaceFragment(SumaFragment()) }
       multiplicacion.setOnClickListener { replaceFragment(MultiplicacionFragment()) }
   }
    private fun replaceFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }



}
