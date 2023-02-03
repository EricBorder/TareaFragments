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

       val suma: Button = findViewById(R.id.suma)
       val multiplicacion: Button = findViewById(R.id.multiplicacion)

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
