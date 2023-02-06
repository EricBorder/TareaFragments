package com.example.tareafragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.tareafragments.ui.main.MultiplicacionFragment
import com.example.tareafragments.ui.main.SumaFragment


@Suppress("DEPRECATED_IDENTITY_EQUALS")
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Instanciamos el botón de la suma y lo asociamos a su layout
        val suma: Button = findViewById(R.id.suma)
        //Instanciamos el botón de la multiplicación y lo asociamos a su layout
        val multiplicacion: Button = findViewById(R.id.multiplicacion)

        //Ponemos un escuchador al botón de la suma y le añadimos la función
        suma.setOnClickListener { replaceFragment(SumaFragment()) }
        //Ponemos un escuchador al botón de la multiplicación y le añadimos la función
        multiplicacion.setOnClickListener { replaceFragment(MultiplicacionFragment()) }


    }

    /**
     * Función que cambia de fragmentos en el layout Principal cuando se pulsa el respectivo botón
     * asociado al respectivo layout de cada Fragment
     * @param fragment
     */
    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }


}
