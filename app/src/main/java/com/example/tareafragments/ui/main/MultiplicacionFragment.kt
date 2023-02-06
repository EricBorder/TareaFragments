package com.example.tareafragments.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.tareafragments.R


class MultiplicacionFragment : Fragment() {

    companion object {
        fun newInstance() = MultiplicacionFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
        //Instanciamos ViewModel que usaremos para llamar a nuestra clase ViewModel
        val miModelo by viewModels<MainViewModel>()

        //Observamos el cambio en el random
        miModelo.liveRandom.observe(
            this,
            Observer(
                fun(random: Int) {
                    var tvRandom: TextView? = view?.findViewById(R.id.textRandom1)
                    tvRandom?.setText("$random")

                }
            )

        )
        //Observamos el cambio en el random2
        miModelo.liveRandom2.observe(
            this,
            Observer(
                fun(random2: Int) {
                    var tvRandom2: TextView? = view?.findViewById(R.id.textRandom2)
                    tvRandom2?.setText("$random2")

                }
            )

        )
        //Observamos el cambio en el resultado
        miModelo.liveResultado.observe(
            this,
            Observer(
                fun(resultado: Int) {
                    var tvResultado: TextView? = view?.findViewById(R.id.textResultado)
                    tvResultado?.setText("$resultado")

                }
            )
        )

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //Instanciamos variable view en el fragmento de la multiplicación
        val view: View = inflater.inflate(R.layout.fragment_multiplicacion, container, false)
        //Instanciamos variable del botón de la multiplicación y asociamos a su layout del fragment
        val botonMulti: Button? = view.findViewById(R.id.multiplicacion)
        //Instanciamos variable del textView del resultado y asociamos a su layout del fragment
        val resultadoText: TextView? = view.findViewById(R.id.textResultado)

        //Ponemos un escuchador al botón y llamamos a la función de multiplicar del viewModel
        botonMulti?.setOnClickListener {
            viewModel.hacerMultiplicacion()
            //Ponemos resultado de la función en su respectivo textView
            resultadoText?.text = viewModel.resultado.toString()
        }
        //Devolvemos la vista
        return view

    }

}